/*******************************************************************************
 * Copyright 2014-2019, the Biomes O' Plenty Team
 *
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 *
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/
package biomesoplenty.common.block;

import com.google.common.jimfs.PathType;

import biomesoplenty.api.block.BOPBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractSkullBlock;
import net.minecraft.block.BarrelBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

public class NetherCrystalBlock extends HorizontalFacingBlock
{
    protected static final VoxelShape FLOOR_AABB = Block.createCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);
    protected static final VoxelShape CEILING_AABB = Block.createCuboidShape(2.0D, 3.0D, 2.0D, 14.0D, 16.0D, 14.0D);
    protected static final VoxelShape NORTH_AABB = Block.createCuboidShape(2.0D, 2.0D, 3.0D, 14.0D, 14.0D, 16.0D);
    protected static final VoxelShape SOUTH_AABB = Block.createCuboidShape(2.0D, 2.0D, 0.0D, 14.0D, 14.0D, 13.0D);
    protected static final VoxelShape EAST_AABB = Block.createCuboidShape(0.0D, 2.0D, 2.0D, 13.0D, 14.0D, 14.0D);
    protected static final VoxelShape WEST_AABB = Block.createCuboidShape(3.0D, 2.0D, 2.0D, 16.0D, 14.0D, 14.0D);

    public NetherCrystalBlock(FabricBlockSettings properties)
    {
        super(properties);
        this.appendProperties(this.stateManager.getStates().setValue(FACE, AttachFace.FLOOR).setValue(FACING, Direction.NORTH));
    }

    protected static boolean mayPlaceOn(BlockState state, BlockView worldIn, BlockPos pos) {
        Block block = state.getBlock();
        return block == Blocks.NETHERRACK || block == Blocks.NETHER_QUARTZ_ORE || block == Blocks.BLACKSTONE || block == BOPBlocks.nether_crystal_block;
    }

    @Override
    public boolean canSurvive(BlockState state, WorldView worldIn, BlockPos pos) {
        return canAttach(worldIn, pos, getConnectedDirection(state).getOpposite());
    }

    public static boolean canAttach(WorldView p_220185_0_, BlockPos p_220185_1_, Direction p_220185_2_) {
        BlockPos blockpos = p_220185_1_.relative(p_220185_2_);
        return mayPlaceOn(p_220185_0_.getBlockState(blockpos), p_220185_0_, blockpos);
    }

    public VoxelShape getShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction direction = state.get(FACING);
        switch(state.get(FACE))
        {
            case FLOOR:
                return FLOOR_AABB;
            case WALL:
                switch(direction)
                {
                    case EAST:
                        return EAST_AABB;
                    case WEST:
                        return WEST_AABB;
                    case SOUTH:
                        return SOUTH_AABB;
                    case NORTH:
                    default:
                        return NORTH_AABB;
                }
            case CEILING:
            default:
                return CEILING_AABB;
        }
    }

    @Override
    public boolean propagatesSkylightDown(BlockState state, BlockView reader, BlockPos pos) {
        return state.getFluidState().isEmpty();
    }

    @Override
    public boolean canPathfindThrough(BlockState state, BlockView worldIn, BlockPos pos, NavigationType type) {
        return type == NavigationType.AIR && !this.collidable ? true : super.canPathfindThrough(state, worldIn, pos, type);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builderIn) {
        builderIn.add(FACING, FACE);
    }
}
