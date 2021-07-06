package biomesoplenty.common.block.trees;

import biomesoplenty.common.world.gen.feature.BOPFeatures;
import net.minecraft.world.gen.feature.*;

import java.util.Random;

public class UmbranTree extends BigTreeDefaultConfig
{
   @Override
   protected Feature<? extends TreeFeatureConfig> getFeature(Random random)
   {
      return BOPFeatures.UMBRAN_TREE;
   }

   @Override
   protected Feature<? extends TreeFeatureConfig> getBigFeature(Random random)
   {
      return BOPFeatures.TALL_UMBRAN_TREE;
   }
}