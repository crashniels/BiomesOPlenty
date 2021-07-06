package biomesoplenty.common.block.trees;

import biomesoplenty.common.world.gen.feature.BOPFeatures;
import net.minecraft.world.gen.feature.*;

import java.util.Random;

public class RedwoodTree extends BigTreeDefaultConfig
{
   @Override
   protected Feature<? extends TreeFeatureConfig> getFeature(Random random)
   {
      return BOPFeatures.REDWOOD_TREE;
   }

   @Override
   protected Feature<? extends TreeFeatureConfig> getBigFeature(Random random)
   {
      return BOPFeatures.REDWOOD_TREE_MEDIUM;
   }
}