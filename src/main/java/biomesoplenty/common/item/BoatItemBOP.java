package biomesoplenty.common.item;

import biomesoplenty.common.entity.item.BoatEntityBOP;
import biomesoplenty.common.entity.item.BoatEntityBOP.BoatModel;
import biomesoplenty.common.util.inventory.ItemGroupBOP;
import net.minecraft.block.DispenserBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

import java.util.List;
import java.util.function.Predicate;

public class BoatItemBOP extends Item {
    private static final Predicate<Entity> ENTITY_PREDICATE = EntityPredicates.EXCEPT_SPECTATOR.and(Entity::isPlayer);
    private final BoatModel model;

    public BoatItemBOP(BoatModel model) {
        super(new Item.Settings().maxCount(1).group(ItemGroupBOP.ItemGroupBOP));
        this.model = model;
        DispenserBlock.registerBehavior(this, new DispenserBoatBehaviorBOP(model));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack heldItem = player.getMainHandStack();
        HitResult result = raycast(world, player, RaycastContext.FluidHandling.ANY);
        if (result.getType() == HitResult.Type.MISS) {
            return TypedActionResult.pass(heldItem);
        } else {
            Vec3d vector3d = player.getRotationVec(1f);
            List<Entity> entities = world.getOtherEntities(player, player.getBoundingBox().stretch(vector3d.multiply(5d)).expand(1d), ENTITY_PREDICATE);
            if (!entities.isEmpty()) {
                Vec3d vector3d1 = player.getEyePos();
                for (Entity entity : entities) {
                    Box bounds = entity.getBoundingBox().expand((double) entity.getTargetingMargin());
                    if (bounds.contains(vector3d1)) {
                        return TypedActionResult.success(heldItem);
                    }
                }
            }
            if (result.getType() == HitResult.Type.BLOCK) {
                BoatEntityBOP boat = new BoatEntityBOP(world, result.getPos().x, result.getPos().y, result.getPos().z).setBoatType(this.model);
                boat.horizontalSpeed = player.horizontalSpeed;
                if (!world.isSpaceEmpty(boat, boat.getBoundingBox().expand(-0.1d))) {
                    return TypedActionResult.fail(heldItem);
                } else {
                    if (!world.isClient()) {
                        world.spawnEntity(boat);
                        if (!player.getAbilities().creativeMode) {
                            heldItem.decrement(1);
                        }
                    }
                    player.incrementStat(Stats.USED.getOrCreateStat(this));
                    return TypedActionResult.success(heldItem, world.isClient());
                }
            } else {
                return TypedActionResult.pass(heldItem);
            }
        }
    }
}
