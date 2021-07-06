/*******************************************************************************
 * Copyright 2014-2019, the Biomes O' Plenty Team
 *
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 *
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/
package biomesoplenty.common.block;

import net.minecraft.block.TallFlowerBlock;
import net.minecraft.util.math.BlockPos;

public class TallFlowerBlockBOP extends TallFlowerBlock
{
    public TallFlowerBlockBOP(Settings properties)
    {
        super(properties);
    }

    //Find alternative to Forge stuff
    /*
    @Override
    public PlantType getPlantType(IBlockReader world, BlockPos pos)
    {
        return PlantType.PLAINS;
    }
    */
}
