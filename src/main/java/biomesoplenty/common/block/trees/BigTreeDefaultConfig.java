/*******************************************************************************
 * Copyright 2014-2019, the Biomes O' Plenty Team
 *
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 *
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/
package biomesoplenty.common.block.trees;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.sapling.LargeTreeSaplingGenerator;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.Random;

import org.jetbrains.annotations.Nullable;

public abstract class BigTreeDefaultConfig extends LargeTreeSaplingGenerator
{
    @Override
    @Nullable
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random random, boolean hasFlowers)
    {
        return null;
    }

    @Override
    @Nullable
    protected ConfiguredFeature<TreeFeatureConfig, ?> getLargeTreeFeature(Random random)
    {
        return null;
    }

    protected abstract Feature<? extends TreeFeatureConfig> getFeature(Random random);
    protected abstract Feature<? extends TreeFeatureConfig> getBigFeature(Random random);

    @Override
    public boolean generate(ServerWorld world, ChunkGenerator generator, BlockPos pos, BlockState state, Random random)
    {
        for (int i = 0; i >= -1; --i)
        {
            for (int j = 0; j >= -1; --j)
            {
                if (canGenerateLargeTree(state, world, pos, i, j))
                {
                    return this.generateLargeTree(world, generator, pos, state, random, i, j);
                }
            }
        }

        Feature<TreeFeatureConfig> feature = (Feature<TreeFeatureConfig>)this.getFeature(random);

        if (feature == null)
        {
            return false;
        }
        else
        {
            world.setBlockState(pos, Blocks.AIR.getDefaultState(), 4);
            if (feature.generate(new FeatureContext<TreeFeatureConfig>(world, generator, random, pos, ConfiguredFeatures.OAK.getConfig())))
            {
                return true;
            }
            else
            {
                world.setBlockState(pos, state, 4);
                return false;
            }
        }
    }

    @Override
    public boolean generateLargeTree(ServerWorld world, ChunkGenerator generator, BlockPos pos, BlockState state, Random random, int x, int z)
    {
        Feature<TreeFeatureConfig> feature = (Feature<TreeFeatureConfig>)this.getBigFeature(random);
        if (feature == null)
        {
            return false;
        }
        else
        {
            BlockState blockstate = Blocks.AIR.getDefaultState();
            world.setBlockState(pos.add(x, 0, z), blockstate, 4);
            world.setBlockState(pos.add(x + 1, 0, z), blockstate, 4);
            world.setBlockState(pos.add(x, 0, z + 1), blockstate, 4);
            world.setBlockState(pos.add(x + 1, 0, z + 1), blockstate, 4);
            if (feature.generate(new FeatureContext<TreeFeatureConfig>(world, generator, random, pos.add(x, 0, z), ConfiguredFeatures.OAK.getConfig())))
            {
                return true;
            }
            else
            {
                world.setBlockState(pos.add(x, 0, z), state, 4);
                world.setBlockState(pos.add(x + 1, 0, z), state, 4);
                world.setBlockState(pos.add(x, 0, z + 1), state, 4);
                world.setBlockState(pos.add(x + 1, 0, z + 1), state, 4);
                return false;
            }
        }
    }

}
