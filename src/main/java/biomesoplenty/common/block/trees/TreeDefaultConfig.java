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
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.Random;

import org.jetbrains.annotations.Nullable;

public abstract class TreeDefaultConfig extends SaplingGenerator
{
    @Override
    @Nullable
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random random, boolean hasFlowers)
    {
        return null;
    }

    protected abstract Feature<? extends TreeFeatureConfig> getFeature(Random random);

    @Override
    public boolean generate(ServerWorld world, ChunkGenerator generator, BlockPos pos, BlockState state, Random random)
    {
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
}
