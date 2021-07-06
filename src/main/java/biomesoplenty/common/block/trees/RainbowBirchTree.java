package biomesoplenty.common.block.trees;

import biomesoplenty.common.world.gen.feature.BOPFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

import java.util.Random;

public class RainbowBirchTree extends TreeDefaultConfig
{
   @Override
   protected Feature<? extends TreeFeatureConfig> getFeature(Random random)
   {
      return (random.nextInt(10) == 0 ? BOPFeatures.BIG_RAINBOW_BIRCH_TREE : BOPFeatures.RAINBOW_BIRCH_TREE);
   }
}