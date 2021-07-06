/*******************************************************************************
 * Copyright 2014-2019, the Biomes O' Plenty Team
 *
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 *
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/
package biomesoplenty.common.block;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import org.jetbrains.annotations.Nullable;

import biomesoplenty.api.block.BOPBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class DeadBranchBlock extends Block
{
    public static final DirectionProperty FACING = Properties.FACING;
    private static final Map<Direction, VoxelShape> SHAPES = Maps.newEnumMap(ImmutableMap.of(Direction.NORTH, Block.createCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 16.0D), Direction.SOUTH, Block.createCuboidShape(4.0D, 0.0D, 0.0D, 12.0D, 16.0D, 12.0D), Direction.WEST, Block.createCuboidShape(4.0D, 0.0D, 4.0D, 16.0D, 16.0D, 12.0D), Direction.EAST, Block.createCuboidShape(0.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D)));

    public DeadBranchBlock(Settings properties)
    {
        super(properties);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH));
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView worldIn, BlockPos pos, ShapeContext context) {
        return SHAPES.get(state.get(FACING));
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    /**
     * Update the provided state given the provided neighbor facing and neighbor state, returning a new state.
     * For example, fences make their connections to the passed in state if possible, and wet concrete powder immediately
     * returns its solidified counterpart.
     * Note that this method should ideally consider only the specific face passed in.
     */
    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, World worldIn, BlockPos currentPos, BlockPos facingPos)
    {
        return facing.getOpposite() == stateIn.get(FACING) && !stateIn.canPlaceAt(worldIn, currentPos) ? Blocks.AIR.getDefaultState() : stateIn;
    }

    public boolean canPlantOnTop(BlockState state, BlockView worldIn, BlockPos pos) {
        Direction direction = state.get(FACING);
        BlockPos blockpos = pos.offset(direction.getOpposite());
        BlockState blockstate = worldIn.getBlockState(blockpos);
        return blockstate.getBlock() == BOPBlocks.dead_log || blockstate.getBlock() == BOPBlocks.dead_wood;
    }

    @Nullable
    public BlockState getStateForPlacement(ItemPlacementContext context) {
        BlockState blockstate = super.getPlacementState(context);
        WorldView iworldreader = context.getWorld();
        BlockPos blockpos = context.getBlockPos();
        Direction[] adirection = context.getPlacementDirections();

        for(Direction direction : adirection) {
            if (direction.getAxis().isHorizontal()) {
                blockstate = blockstate.with(FACING, direction.getOpposite());
                if (blockstate.canPlaceAt(iworldreader, blockpos)) {
                    return blockstate;
                }
            }
        }

        return null;
    }
}
