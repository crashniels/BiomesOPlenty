/*******************************************************************************
 * Copyright 2014-2019, the Biomes O' Plenty Team
 *
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 *
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/
package biomesoplenty.common.block;

import biomesoplenty.api.block.BOPBlocks;
import biomesoplenty.common.world.gen.feature.BOPConfiguredFeatures;
import biomesoplenty.common.world.gen.feature.BOPFeatures;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.stat.Stats;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.FeatureConfig;

import java.util.Random;

import org.jetbrains.annotations.Nullable;

public class FoliageBlockBOP extends DeadBushBlock implements Fertilizable
{
	protected static final VoxelShape NORMAL = Block.createCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);
	protected static final VoxelShape SHORT = Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 7.0D, 15.0D);
	
    public FoliageBlockBOP(Settings properties)
    {
        super(properties);
    }
    
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView worldIn, BlockPos pos, ShapeContext selectionContext)
    {
    	Block block = state.getBlock();
        
        if (block == BOPBlocks.desert_grass || block == BOPBlocks.clover)
        {
        	return SHORT;
        }
        
        return NORMAL;
    }
    
    @Override
    public void afterBreak(World worldIn, PlayerEntity player, BlockPos pos, BlockState state, @Nullable BlockEntity te, ItemStack stack)
    {
        if (!worldIn.isClient && stack.getItem() == Items.SHEARS)
        {
           player.incrementStat(Stats.MINED.getOrCreateStat(this));
           player.addExhaustion(0.005F);
           Block.dropStack(worldIn, pos, new ItemStack(this));
        }
        else
        {
           super.afterBreak(worldIn, player, pos, state, te, stack);
        }
     }
    
    public java.util.List<ItemStack> onSheared(ItemStack item, World world, BlockPos pos, int fortune)
    {
       world.setBlockState(pos, Blocks.AIR.getDefaultState(), 11);
       return java.util.Arrays.asList(new ItemStack(this));
    }
    
    @Override
    public boolean canPlantOnTop(BlockState state, BlockView worldIn, BlockPos pos)
    {
        BlockState groundState = worldIn.getBlockState(pos.down());
        Block ground = groundState.getBlock();

        if (this == BOPBlocks.sprout)
        {
            return groundState.isSideSolidFullSquare(worldIn, pos.down(), Direction.UP) || super.canPlantOnTop(state, worldIn, pos);
        }
        if (this == BOPBlocks.dune_grass)
        {
            return ground == Blocks.SAND || ground == Blocks.RED_SAND || ground == BOPBlocks.white_sand || ground == BOPBlocks.orange_sand || ground == BOPBlocks.black_sand;
        }
        if (this == BOPBlocks.desert_grass || this == BOPBlocks.dead_grass)
        {
            return ground == BOPBlocks.dried_salt || ground == Blocks.GRAVEL || ground == Blocks.SAND || ground == Blocks.RED_SAND || ground == BOPBlocks.white_sand || ground == BOPBlocks.orange_sand || ground == BOPBlocks.black_sand || ground == Blocks.NETHERRACK || super.canPlantOnTop(state, worldIn, pos);
        }

        return super.canPlantOnTop(state, worldIn, pos);
    }
    
    @Override
    public Block.OffsetType getOffsetType()
    {
        return Block.OffsetType.XYZ;
    }
    
    /*
    @Override
    public PlantType getPlantType(IBlockReader world, BlockPos pos)
    {
    	return PlantType.PLAINS;
    }
    */

    @Override
    public boolean isFertilizable(BlockView worldIn, BlockPos pos, BlockState state, boolean isClient)
    {
        Block block = state.getBlock();

        if (block == BOPBlocks.clover)
        {
            return true;
        }

        return false;
    }

    @Override
    public boolean canGrow(World worldIn, Random rand, BlockPos pos, BlockState state)
    {
        Block block = state.getBlock();

        if (block == BOPBlocks.clover) { return (double)rand.nextFloat() < 0.4D; }

        return false;
    }

    @Override
    public void grow(ServerWorld world, Random rand, BlockPos pos, BlockState state)
    {
        Block block = state.getBlock();

        if (block == BOPBlocks.clover) { this.growHugeClover(world, rand, pos, state); }
    }

    public boolean growHugeClover(ServerWorld world, Random rand, BlockPos pos, BlockState state)
    {
        world.removeBlock(pos, false);
        ConfiguredFeature<DefaultFeatureConfig, ?> configuredfeature = BOPFeatures.HUGE_CLOVER.configure(FeatureConfig.DEFAULT);

        if (configuredfeature.generate(world, world.getChunkManager().getChunkGenerator(), rand, pos))
        {
            return true;
        }
        else
        {
            world.setBlockState(pos, state);
            return false;
        }
    }
}
