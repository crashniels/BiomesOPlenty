/*******************************************************************************
 * Copyright 2014-2019, the Biomes O' Plenty Team
 *
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 *
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/
package biomesoplenty.common.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PlantBlock;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;

public class DoublePlantBlockBOP extends PlantBlock
{
    public DoublePlantBlockBOP(AbstractBlock.Settings properties)
    {
        super(properties);
        this.setDefaultState(this.getStateManager().getDefaultState().with(Properties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER));
    }

    /*
    @Override
    public PlantType getPlantType(IBlockReader world, BlockPos pos)
    {
        return PlantType.PLAINS;
    }
    */

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(Properties.DOUBLE_BLOCK_HALF);
    }
}
