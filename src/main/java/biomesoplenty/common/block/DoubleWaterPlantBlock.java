/*******************************************************************************
 * Copyright 2014-2019, the Biomes O' Plenty Team
 *
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 *
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/
package biomesoplenty.common.block;

import org.jetbrains.annotations.Nullable;

import biomesoplenty.core.BiomesOPlenty;
import net.minecraft.block.*;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.entity.LivingEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class DoubleWaterPlantBlock extends PlantBlock implements Waterloggable
{
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    public DoubleWaterPlantBlock(Settings properties)
    {
        super(properties);
        this.setDefaultState(this.getStateManager().getDefaultState().with(Properties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER).with(WATERLOGGED, Boolean.valueOf(true)));
    }

    @Nullable
    public BlockState getPlacementState(ItemPlacementContext context) {
        FluidState ifluidstate = context.getWorld().getFluidState(context.getBlockPos());
        BlockPos blockpos = context.getBlockPos();
        return blockpos.getY() < 255 && context.getWorld().getBlockState(blockpos.up()).canReplace(context) ? this.getDefaultState().with(WATERLOGGED, Boolean.valueOf(ifluidstate.isIn(FluidTags.WATER) && ifluidstate.getLevel() == 8)) : null;
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState stateIn, Direction facing, BlockState facingState, WorldAccess worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (stateIn.get(WATERLOGGED)) {
            worldIn.getFluidTickScheduler().schedule(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
        }

        return facing == Direction.DOWN && !this.canPlaceAt(stateIn, worldIn, currentPos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    @Override
    public void onPlaced(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
        worldIn.setBlockState(pos.up(), this.getDefaultState().with(Properties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER).with(WATERLOGGED, false), 3);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView worldIn, BlockPos pos)
    {
        if (state.get(Properties.DOUBLE_BLOCK_HALF) != DoubleBlockHalf.UPPER)
        {
            BlockPos posBelow = pos.down();
            BlockState existingState = worldIn.getBlockState(pos);
            Block existingBlock = existingState.getBlock();
            return (existingBlock == this || existingState.getMaterial() == Material.WATER) && this.isExposed(worldIn, pos.up()) && worldIn.getBlockState(posBelow).isSideSolidFullSquare(worldIn, posBelow, Direction.UP);
        }
        else
        {
            BlockState blockstate = worldIn.getBlockState(pos.down());
            if (state.getBlock() != this) return worldIn.isAir(pos); // This function is called during world gen and placement, before this block is set, so if we are not 'here' then assume it's the pre-check.
            return this.isExposed(worldIn, pos) && blockstate.getBlock() == this && blockstate.get(Properties.DOUBLE_BLOCK_HALF) == DoubleBlockHalf.LOWER && blockstate.get(WATERLOGGED);
        }
    }

    /*
    @Override
    public void placeAt(IWorld worldIn, BlockPos pos, int flags) {
        worldIn.setBlock(pos, this.getDefaultState().setValue(Properties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER).setValue(WATERLOGGED, true), flags);
        worldIn.setBlock(pos.above(), this.getDefaultState().setValue(Properties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER).setValue(WATERLOGGED, false), flags);
    }

    @Override
    public PlantType getPlantType(IBlockReader world, BlockPos pos)
    {
        return PlantType.PLAINS;
    }
    */

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, Properties.DOUBLE_BLOCK_HALF);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    protected boolean isExposed(WorldView world, BlockPos pos)
    {
        BlockState state = world.getBlockState(pos);
        return state.getBlock() == this ? !state.get(WATERLOGGED) : world.isAir(pos);
    }
}
