/*******************************************************************************
 * Copyright 2014-2019, the Biomes O' Plenty Team
 *
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 *
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/
package biomesoplenty.common.block;

import net.minecraft.block.AbstractFurnaceBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalFacingBlock;
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

public class HugeCloverPetalBlock extends HorizontalFacingBlock
{
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
    public static final VoxelShape SHAPE = Block.createCuboidShape(0.0D, 13.0D, 0.0D, 16.0D, 15.0D, 16.0D);

    public HugeCloverPetalBlock(Settings properties)
    {
        super(properties);
        this.setDefaultState(this.getDefaultState().with(FACING, Direction.NORTH));
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView worldIn, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    public BlockState updateShape(BlockState p_196271_1_, Direction p_196271_2_, BlockState p_196271_3_, World p_196271_4_, BlockPos p_196271_5_, BlockPos p_196271_6_) {
        return !p_196271_1_.canPlaceAt(p_196271_4_, p_196271_5_) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(p_196271_1_, p_196271_2_, p_196271_3_, p_196271_4_, p_196271_5_, p_196271_6_);
    }

    protected boolean mayPlaceOn(BlockState p_200014_1_, BlockView p_200014_2_, BlockPos p_200014_3_) {
        return p_200014_1_.isOf(Blocks.GRASS_BLOCK) || p_200014_1_.isOf(Blocks.DIRT) || p_200014_1_.isOf(Blocks.COARSE_DIRT) || p_200014_1_.isOf(Blocks.PODZOL) || p_200014_1_.isOf(Blocks.FARMLAND);
    }

    /*
    @Override
    public boolean canPlantOnTop(BlockState p_196260_1_, WorldView p_196260_2_, BlockPos p_196260_3_) {
        BlockPos blockpos = p_196260_3_.below();
        if (p_196260_1_.getBlock() == this) //Forge: This function is called during world gen and placement, before this block is set, so if we are not 'here' then assume it's the pre-check.
            return p_196260_2_.getBlockState(blockpos).canSustainPlant(p_196260_2_, blockpos, Direction.UP, this);
        return this.mayPlaceOn(p_196260_2_.getBlockState(blockpos), p_196260_2_, blockpos);
    }

    
    @Override
    public PlantType getPlantType(IBlockReader world, BlockPos pos)
    {
        return PlantType.PLAINS;
    }
    

    @Override
    public BlockState getPlant(IBlockReader world, BlockPos pos) {
        BlockState state = world.getBlockState(pos);
        if (state.getBlock() != this) return getDefaultState();
        return state;
    }
    */

    public BlockState getPlacementState(ItemPlacementContext p_196258_1_) {
        return this.getDefaultState().with(FACING, p_196258_1_.getPlayerFacing().getOpposite());
    }
}
