package biomesoplenty.common.entity.item;

import biomesoplenty.api.block.BOPBlocks;
import biomesoplenty.api.item.BOPItems;
import biomesoplenty.init.ModEntities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.math.Vector3d;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.network.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

import java.util.Arrays;
import java.util.function.Supplier;

public class BoatEntityBOP extends BoatEntity {
    private double fallVelocity;
    private Object location;
    private static final TrackedData<Integer> BOAT_TYPE_BOP;

    public BoatEntityBOP(EntityType<? extends BoatEntityBOP> type, World world) {
        super(type, world);
    }

    public BoatEntityBOP(World world, double x, double y, double z) {
        super(ModEntities.boat, world);
        setPos(x, y, z);
        setVelocity(Vec3d.ZERO);
        this.prevX = x;
        this.prevY = y;
        this.prevZ = z;
    }
    
    @Override
    public Packet<?> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }

    @Override
    protected void writeCustomDataToNbt(NbtCompound nbt) {
        nbt.putString("model", getModel().getName());
    }

    @Override
    protected void readCustomDataFromNbt(NbtCompound nbt) {
        if (nbt.contains("model", NbtElement.STRING_TYPE)) {
            this.dataTracker.set(BOAT_TYPE_BOP, BoatModel.byName(nbt.getString("model")).ordinal());
        }
    }

    @Override
    protected void fall(double y, boolean onGround, BlockState state, BlockPos pos) {
        this.fallVelocity = getVelocity().y;
        if (!hasVehicle()) {
            if (onGround) {
                if (this.fallDistance > 3f) {
                    if (this.location != BoatEntity.Location.ON_LAND) {
                        this.fallDistance = 0f;
                        return;
                    }
                    handleFallDamage(this.fallDistance, 1f, DamageSource.FALL);
                    if (!this.world.isClient && !this.isRemoved()) {
                        this.kill();
                        if (this.world.getGameRules().getBoolean(GameRules.DO_ENTITY_DROPS)) {
                            for (int i = 0; i < 3; ++i) {
                                dropItem(getModel().getPlanks());
                            }
                            for (int j = 0; j < 2; ++j) {
                                dropItem(Items.STICK);
                            }
                        }
                    }
                }
                this.fallDistance = 0f;
            } else if (!this.world.getFluidState(this.getBlockPos().down()).isIn(FluidTags.WATER) && y < 0d) {
                this.fallDistance = (float) ((double) this.fallDistance - y);
            }
        }
    }

    @Override
    public Item asItem() {
        switch (BoatModel.byId(this.dataTracker.get(BOAT_TYPE_BOP))) {
            case FIR:
                return BOPItems.fir_boat;
            case REDWOOD:
                return BOPItems.redwood_boat;
            case CHERRY:
                return BOPItems.cherry_boat;
            case MAHOGANY:
                return BOPItems.mahogany_boat;
            case JACARANDA:
                return BOPItems.jacaranda_boat;
            case PALM:
                return BOPItems.palm_boat;
            case WILLOW:
                return BOPItems.willow_boat;
            case DEAD:
                return BOPItems.dead_boat;
            case MAGIC:
                return BOPItems.magic_boat;
            case UMBRAN:
                return BOPItems.umbran_boat;
            case HELLBARK:
                return BOPItems.hellbark_boat;
        }
        return Items.OAK_BOAT;
    }

    public BoatEntityBOP setBoatType(BoatEntityBOP.BoatModel type) {
        this.dataTracker.set(BOAT_TYPE_BOP, type.ordinal());
        return this;
    }

    public BoatModel getModel() {
        return BoatModel.byId(this.dataTracker.get(BOAT_TYPE_BOP));
    }

    @Deprecated
    @Override
    public void setBoatType(Type vanillaType) {
    }

    @Deprecated
    @Override
    public Type getBoatType() {
        return Type.OAK;
    }

    protected void initDataTracker() {
        if (this.dataTracker != null) {
            this.dataTracker.startTracking(BOAT_TYPE_BOP, BoatModel.FIR.ordinal());
            super.initDataTracker();
        } 
    }
    
    static {
        BOAT_TYPE_BOP = DataTracker.registerData(BoatEntityBOP.class, TrackedDataHandlerRegistry.INTEGER);
    }

    public static enum BoatModel {
        FIR("fir", () -> BOPBlocks.fir_planks),
        REDWOOD("redwood", () -> BOPBlocks.redwood_planks),
        CHERRY("cherry", () -> BOPBlocks.cherry_planks),
        MAHOGANY("mahogany", () -> BOPBlocks.mahogany_planks),
        JACARANDA("jacaranda", () -> BOPBlocks.jacaranda_planks),
        PALM("palm", () -> BOPBlocks.palm_planks),
        WILLOW("willow", () -> BOPBlocks.willow_planks),
        DEAD("dead", () -> BOPBlocks.dead_planks),
        MAGIC("magic", () -> BOPBlocks.magic_planks),
        UMBRAN("umbran", () -> BOPBlocks.umbran_planks),
        HELLBARK("hellbark", () -> BOPBlocks.hellbark_planks);

        private final String name;
        private final Supplier<Block> supplierPlanks;

        BoatModel(String name, Supplier<Block> supplierPlanks) {
            this.name = name;
            this.supplierPlanks = supplierPlanks;
        }

        public String getName() {
            return this.name;
        }

        public Block getPlanks() {
            return this.supplierPlanks.get();
        }

        public String toString() {
            return this.name;
        }

        public static BoatModel byId(int id) {
            BoatModel[] type = values();
            return type[id < 0 || id >= type.length ? 0 : id];
        }

        public static BoatModel byName(String aName) {
            BoatModel[] type = values();
            return Arrays.stream(type).filter(t -> t.getName().equals(aName)).findFirst().orElse(type[0]);
        }
    }
}
