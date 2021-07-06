/*******************************************************************************
 * Copyright 2014-2019, the Biomes O' Plenty Team
 *
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 *
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/
package biomesoplenty.common.util.block;

import net.minecraft.block.BlockState;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.Heightmap;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkStatus;

import java.util.Collection;

public class BlockUtil
{
    // Given a blockstate for some block which has an axis orientation (such as logs), try to determine the axis property
    public static Property getAxisProperty(BlockState log)
    {
        for (Property property : log.getProperties())
        {
            Collection allowedValues = property.getValues();
            if (allowedValues.contains(Direction.Axis.X) && allowedValues.contains(Direction.Axis.Y) && allowedValues.contains(Direction.Axis.Z))
            {
                return property;
            }
        }
        return null;
    }

    public static BlockPos getTopSolidOrLiquidBlock(World world, int x, int z)
    {
        Chunk chunk = world.getChunk(x >> 4, z >> 4, ChunkStatus.FULL);
        return new BlockPos(x, chunk.sampleHeightmap(Heightmap.Type.MOTION_BLOCKING, x & 15, z & 15), z);
    }
}
