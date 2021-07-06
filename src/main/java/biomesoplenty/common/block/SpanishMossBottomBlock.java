/*******************************************************************************
 * Copyright 2014-2019, the Biomes O' Plenty Team
 *
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 *
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/
package biomesoplenty.common.block;

import biomesoplenty.api.block.BOPBlocks;
import net.minecraft.block.*;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.WorldView;

import java.util.Random;

public class SpanishMossBottomBlock extends AbstractPlantStemBlock {
    protected static final VoxelShape SHAPE = Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

    public SpanishMossBottomBlock(AbstractBlock.Settings p_i241194_1_) {
        super(p_i241194_1_, Direction.DOWN, SHAPE, false, 0.01D);
    }

    protected int getGrowthLength(Random p_230332_1_) {
        return VineLogic.getGrowthLength(p_230332_1_);
    }

    protected Block getPlant() {
        return BOPBlocks.spanish_moss_plant;
    }

    protected boolean chooseStemState(BlockState p_230334_1_) {
        return VineLogic.isValidForWeepingStem(p_230334_1_);
    }

    @Override
    public boolean canPlaceAt(BlockState p_196260_1_, WorldView p_196260_2_, BlockPos p_196260_3_) {
        BlockPos blockpos = p_196260_3_.offset(this.growthDirection.getOpposite());
        BlockState blockstate = p_196260_2_.getBlockState(blockpos);
        Block block = blockstate.getBlock();
        if (!this.canAttachTo(blockstate)) {
            return false;
        } else {
            return block == this.getStem() || block == this.getPlant() || blockstate.isIn(BlockTags.LEAVES) || blockstate.isIn(BlockTags.LOGS);
        }
    }

}
