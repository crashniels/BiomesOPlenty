/*******************************************************************************
 * Copyright 2014-2019, the Biomes O' Plenty Team
 *
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 *
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/
package biomesoplenty.common.block;

import biomesoplenty.api.block.BOPBlocks;
import biomesoplenty.common.world.gen.feature.BOPFeatures;
import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.gen.feature.*;

import java.util.Random;

public class MushroomBlockBOP extends MushroomBlock
{
    public MushroomBlockBOP(Settings properties)
    {
        super(properties);
    }
    
    @Override
    public boolean canPlaceAt(BlockState state, WorldView worldIn, BlockPos pos)
    {
        Block ground = worldIn.getBlockState(pos.down()).getBlock();
        BlockState BlockState = worldIn.getBlockState(pos.down());

        return BlockState.canPlaceAt(worldIn, pos.down()/*, Direction.UP, this*/);
    }

    public boolean trySpawningBigMushroom(ServerWorld world, BlockPos p_226940_2_, BlockState p_226940_3_, Random p_226940_4_)
    {
        world.removeBlock(p_226940_2_, false);
        ConfiguredFeature<DefaultFeatureConfig, ?> configuredfeature;
        if (this == BOPBlocks.glowshroom)
        {
            configuredfeature = BOPFeatures.HUGE_GLOWSHROOM.configure(FeatureConfig.DEFAULT);
        }
        else
        {
            if (this != BOPBlocks.toadstool)
            {
                world.setBlockState(p_226940_2_, p_226940_3_, 3);
                return false;
            }

            configuredfeature = BOPFeatures.HUGE_TOADSTOOL.configure(FeatureConfig.DEFAULT);
        }

        if (configuredfeature.generate(world, world.getChunkManager().getChunkGenerator(), p_226940_4_, p_226940_2_))
        {
            return true;
        }
        else
        {
            world.setBlockState(p_226940_2_, p_226940_3_, 3);
            return false;
        }
    }

    public boolean isFertilizable(BlockView worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return true;
    }

    public boolean isBonemealSuccess(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return (double)rand.nextFloat() < 0.4D;
    }

    public void performBonemeal(ServerWorld p_225535_1_, Random p_225535_2_, BlockPos p_225535_3_, BlockState p_225535_4_) {
        this.trySpawningBigMushroom(p_225535_1_, p_225535_3_, p_225535_4_, p_225535_2_);
    }

    public boolean hasPostProcess(BlockState state, BlockView worldIn, BlockPos pos) {
        return true;
    }
}
