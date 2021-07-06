package biomesoplenty.common.block.trees;

import biomesoplenty.common.world.gen.feature.BOPFeatures;
import net.minecraft.world.gen.feature.*;

import java.util.Random;

public class JacarandaTree extends TreeDefaultConfig
{
   @Override
   protected Feature<? extends TreeFeatureConfig> getFeature(Random random)
   {
      return (random.nextInt(10) == 0 ? BOPFeatures.BIG_JACARANDA_TREE : BOPFeatures.JACARANDA_TREE);
   }
}