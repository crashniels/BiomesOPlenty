package biomesoplenty.common.item;

import biomesoplenty.common.entity.item.BoatEntityBOP;
import biomesoplenty.common.entity.item.BoatEntityBOP.BoatModel;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.DispenserBehavior;
import net.minecraft.block.dispenser.ItemDispenserBehavior;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class DispenserBoatBehaviorBOP extends ItemDispenserBehavior {
    private final ItemDispenserBehavior defaultDispenseItemBehavior = new ItemDispenserBehavior();
    private final BoatModel model;

    public DispenserBoatBehaviorBOP(BoatModel model) {
        this.model = model;
    }

    @Override
    public ItemStack dispenseSilently(BlockPointer source, ItemStack stack) {
        Direction direction = source.getBlockState().get(DispenserBlock.FACING);
        World world = source.getWorld();
        double d0 = source.getX() + (double) ((float) direction.getOffsetX() * 1.125f);
        double d1 = source.getY() + (double) ((float) direction.getOffsetY() * 1.125f);
        double d2 = source.getZ() + (double) ((float) direction.getOffsetZ() * 1.125f);
        BlockPos blockpos = source.getPos().offset(direction);
        double d3;
        /*
        if (world.getFluidState(blockpos).of(FluidTags.WATER)) {
            d3 = 1d;
        } else {
            if (!world.getBlockState(blockpos).isAir() || !world.getFluidState(blockpos.down()).is(FluidTags.WATER)) {
                return this.defaultDispenseItemBehavior.dispense(source, stack);
            }
            d3 = 0d;
        }
        */
        BoatEntityBOP boat = new BoatEntityBOP(world, d0, d1 + d3, d2).withModel(this.model);
        boat.horizontalSpeed = direction.asRotation();
        world.spawnEntity(boat);
        stack.decrement(1);
        return stack;
    }
}
