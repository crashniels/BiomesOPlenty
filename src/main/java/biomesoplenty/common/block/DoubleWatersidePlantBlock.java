/*******************************************************************************
 * Copyright 2014-2019, the Biomes O' Plenty Team
 *
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 *
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/
package biomesoplenty.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.fluid.FluidState;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldView;

import java.util.Iterator;

public class DoubleWatersidePlantBlock extends DoublePlantBlockBOP
{
    public DoubleWatersidePlantBlock(Settings properties)
    {
        super(properties);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(Properties.DOUBLE_BLOCK_HALF);
    }
    
    /*
    @Override
    public PlantType getPlantType(IBlockReader world, BlockPos pos)
    {
    	return PlantType.BEACH;
    }
    */

    @Override
    public boolean canPlaceAt(BlockState state, WorldView worldReader, BlockPos pos)
    {
        if (state.getBlock() != this) return super.canPlaceAt(state, worldReader, pos);
        if (state.get(Properties.DOUBLE_BLOCK_HALF) != DoubleBlockHalf.UPPER)
        {
            BlockState soil = worldReader.getBlockState(pos.down());
            if (soil.canPlaceAt(worldReader, pos.down()/*, Direction.UP, this*/))
            {
                BlockPos blockpos = pos.down();
                Iterator var7 = Direction.Type.HORIZONTAL.iterator();

                BlockState BlockState;
                FluidState ifluidstate;
                do {
                    if (!var7.hasNext()) {
                        return false;
                    }

                    Direction dir = (Direction)var7.next();
                    BlockState = worldReader.getBlockState(blockpos.offset(dir));
                    ifluidstate = worldReader.getFluidState(blockpos.offset(dir));
                } while(!ifluidstate.isIn(FluidTags.WATER) && BlockState.getBlock() != Blocks.FROSTED_ICE);

                return true;
            }
        }
        else
        {
           BlockState below = worldReader.getBlockState(pos.down());
           return below.getBlock() == this && below.get(Properties.DOUBLE_BLOCK_HALF) == DoubleBlockHalf.LOWER;
        }
        
        return false;
    }

}
