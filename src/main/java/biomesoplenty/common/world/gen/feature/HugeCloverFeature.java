package biomesoplenty.common.world.gen.feature;

import biomesoplenty.api.block.BOPBlocks;
import biomesoplenty.common.util.block.IBlockPosQuery;
import com.ibm.icu.impl.CalendarAstronomer;
import com.mojang.serialization.Codec;
import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.Random;

public class HugeCloverFeature extends Feature<DefaultFeatureConfig>
{
    protected IBlockPosQuery placeOn = (world, pos) -> world.getBlockState(pos).getBlock() == Blocks.GRASS_BLOCK;
    protected IBlockPosQuery replace = (world, pos) -> world.getBlockState(pos).canPlaceAt(world, pos) || world.getBlockState(pos).getBlock() instanceof DeadBushBlock;

    public HugeCloverFeature(Codec<DefaultFeatureConfig> deserializer)
    {
        super(deserializer);
    }

    @Override
    public boolean place(ISeedReader world, ChunkGenerator chunkGenerator, Random rand, BlockPos startPos, DefaultFeatureConfig config)
    {
        while (startPos.getY() > 1 && this.replace.matches(world, startPos)) {startPos = startPos.below();}

        if (!this.placeOn.matches(world, startPos))
        {
            // Abandon if we can't place the tree on this block
            return false;
        }

        if (!this.checkSpace(world, startPos.up()))
        {
            // Abandon if there isn't enough room
            return false;
        }

        BlockPos pos = startPos.up();

        this.setBlock(world, pos, BOPBlocks.huge_clover_petal.getDefaultState().with(HorizontalFacingBlock.FACING, Direction.NORTH));
        this.setBlock(world, pos.south(), BOPBlocks.huge_clover_petal.getDefaultState().with(HorizontalFacingBlock.FACING, Direction.WEST));
        this.setBlock(world, pos.east(), BOPBlocks.huge_clover_petal.getDefaultState().with(HorizontalFacingBlock.FACING, Direction.EAST));
        this.setBlock(world, pos.south().east(), BOPBlocks.huge_clover_petal.getDefaultState().with(HorizontalFacingBlock.FACING, Direction.SOUTH));

        return true;
    }

    public boolean setBlock(World world, BlockPos pos, BlockState state)
    {
        if (this.replace.matches(world, pos))
        {
            super.setBlockState(world, pos, state);
            return true;
        }
        return false;
    }

    public boolean checkSpace(World world, BlockPos pos)
    {
        for (int x = 0; x <= 1; x++)
        {
            for (int z = 0; z <= 1; z++)
            {
                BlockPos pos1 = pos.add(x, 0, z);
                if (pos1.getY() >= 255 || !this.replace.matches(world, pos1) || !this.placeOn.matches(world, pos1.below()))
                {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        // TODO Auto-generated method stub
        return false;
    }
}