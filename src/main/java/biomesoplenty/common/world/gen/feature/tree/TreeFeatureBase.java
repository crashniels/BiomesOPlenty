/*******************************************************************************
 * Copyright 2014-2019, the Biomes O' Plenty Team
 *
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 *
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/
package biomesoplenty.common.world.gen.feature.tree;

import biomesoplenty.api.block.BOPBlocks;
import biomesoplenty.common.util.block.BlockUtil;
import biomesoplenty.common.util.block.IBlockPosQuery;
import net.minecraft.block.*;
import net.minecraft.state.property.Property;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

import java.util.Random;
import java.util.Set;
import java.util.function.BiConsumer;
import net.minecraft.block.sapling.SaplingGenerator;

public abstract class TreeFeatureBase extends TreeFeature
{
    protected static abstract class BuilderBase<T extends BuilderBase, F extends TreeFeatureBase>
    {
        protected IBlockPosQuery placeOn;
        protected IBlockPosQuery replace;
        protected BlockState log;
        protected BlockState leaves;
        protected BlockState vine;
        protected BlockState hanging;
        protected BlockState trunkFruit;
        protected BlockState altLeaves;
        protected int minHeight;
        protected int maxHeight;

        public BuilderBase()
        {
            this.placeOn = (world, pos) -> world.getBlockState(pos).canPlaceAt(world, pos/*, Direction.UP, (SaplingBlock)Blocks.OAK_SAPLING*/);
            this.replace = (world, pos) -> world.getBlockState(pos).canPlaceAt(world, pos) || world.getBlockState(pos).getBlock().equals(BlockTags.SAPLINGS) || world.getBlockState(pos).getBlock() == Blocks.VINE || world.getBlockState(pos).getBlock() == BOPBlocks.willow_vine || world.getBlockState(pos).getBlock() == BOPBlocks.dead_branch || world.getBlockState(pos).getBlock() instanceof DeadBushBlock;
            this.log = Blocks.OAK_LOG.getDefaultState();
            this.leaves = Blocks.OAK_LEAVES.getDefaultState();
            this.vine = Blocks.AIR.getDefaultState();
            this.hanging = Blocks.AIR.getDefaultState();
            this.trunkFruit = Blocks.AIR.getDefaultState();
            this.altLeaves = Blocks.AIR.getDefaultState();
        }

        public T placeOn(IBlockPosQuery a) {this.placeOn = a; return (T)this;}

        public T replace(IBlockPosQuery a) {this.replace = a; return (T)this;}

        public T log(BlockState a) {this.log = a; return (T)this;}

        public T leaves(BlockState a) {this.leaves = a; return (T)this;}

        public T vine(BlockState a)
        {
            this.vine = a;
            return (T)this;
        }
        public T hanging(BlockState a)
        {
            this.hanging = a;
            return (T)this;
        }
        public T trunkFruit(BlockState a)
        {
            this.trunkFruit = a;
            return (T)this;
        }

        public T altLeaves(BlockState a) {this.altLeaves = a; return (T)this;}

        public T minHeight(int a) {this.minHeight = a; return (T)this;}
        public T maxHeight(int a) {this.maxHeight = a; return (T)this;}

        abstract F create();
    }

    protected final IBlockPosQuery placeOn;
    protected final IBlockPosQuery replace;

    protected final BlockState log;
    protected final BlockState leaves;
    protected final BlockState altLeaves;
    protected final BlockState vine;
    protected final BlockState hanging;
    protected final BlockState trunkFruit;

    protected final int minHeight;
    protected final int maxHeight;

    protected Property logAxisProperty;

    protected TreeFeatureBase(IBlockPosQuery placeOn, IBlockPosQuery replace, BlockState log, BlockState leaves, BlockState altLeaves, BlockState vine, BlockState hanging, BlockState trunkFruit, int minHeight, int maxHeight)
    {
        super(TreeFeatureConfig.CODEC.stable());

        this.placeOn = placeOn;
        this.replace = replace;
        this.log = log;
        this.leaves = leaves;
        this.logAxisProperty = BlockUtil.getAxisProperty(log);
        this.altLeaves = altLeaves;
        this.vine = vine;
        this.hanging = hanging;
        this.trunkFruit = trunkFruit;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
    }

    public boolean placeLeaves(World world, BlockPos pos, Set<BlockPos> changedBlocks, Box boundingBox)
    {
        if (this.replace.matches(world, pos))
        {
            this.placeBlock(world, pos, this.leaves, changedBlocks, boundingBox);
            return true;
        }
        return false;
    }

    public boolean placeLog(World world, BlockPos pos, Set<BlockPos> changedBlocks, Box boundingBox)
    {
        return this.placeLog(world, pos, null, changedBlocks, boundingBox);
    }

    public boolean placeLog(World world, BlockPos pos, Direction.Axis axis, Set<BlockPos> changedBlocks, Box boundingBox)
    {
        BlockState directedLog = (axis != null && this.logAxisProperty != null) ? this.log.with(this.logAxisProperty, axis) : this.log;
        if (this.replace.matches(world, pos))
        {
            // Logs must be added to the "changedBlocks" so that the leaves have their distance property updated,
            // preventing incorrect decay
            this.placeBlock(world, pos, directedLog, changedBlocks, boundingBox);
            return true;
        }
        return false;
    }

    public boolean setVine(World world, Random rand, BlockPos pos, Direction side, int length)
    {
        BlockState vineState = this.vine.getBlock() instanceof VineBlock ? this.vine.with(VineBlock.NORTH, Boolean.valueOf(side == Direction.NORTH)).with(VineBlock.EAST, Boolean.valueOf(side == Direction.EAST)).with(VineBlock.SOUTH, Boolean.valueOf(side == Direction.SOUTH)).with(VineBlock.WEST, Boolean.valueOf(side == Direction.WEST)) : this.vine;
        boolean setOne = false;
        while (world.getBlockState(pos).getBlock().isTranslucent(world.getBlockState(pos), world, pos) && length > 0 && rand.nextInt(12) > 0)
        {
            setBlockState(world, pos, vineState);
            setOne = true;
            length--;
            pos = pos.down();
        }
        return setOne;
    }

    public boolean setHanging(World world, BlockPos pos)
    {
        if (this.replace.matches(world, pos))
        {
            setBlockState(world, pos, this.hanging);
        }
        return false;
    }

    public boolean setTrunkFruit(World world, BlockPos pos)
    {
        if (this.trunkFruit == null) {return false;}
        if (this.replace.matches(world, pos))
        {
            setBlockState(world, pos, this.trunkFruit);
        }
        return false;
    }

    public boolean setAltLeaves(World world, BlockPos pos, Set<BlockPos> changedBlocks, Box boundingBox)
    {
        if (this.replace.matches(world, pos))
        {
            this.placeBlock(world, pos, this.altLeaves, changedBlocks, boundingBox);
            return true;
        }
        return false;
    }

    @Override
    protected boolean generate(StructureWorldAccess world, Random random, BlockPos pos, BiConsumer<BlockPos, BlockState> trunkReplacer, BiConsumer<BlockPos, BlockState> foliageReplacer, TreeFeatureConfig config) 
    {
        return place(trunkReplacer, foliageReplacer, (World)world, random, pos);
    }

    protected boolean place(BiConsumer<BlockPos, BlockState> changedLogs, BiConsumer<BlockPos, BlockState> changedLeaves, World world, Random rand, BlockPos position)
    {
        return false;
    }

    protected boolean placeBlock(World world, BlockPos pos, BlockState state, Set<BlockPos> changedBlocks, Box boundingBox)
    {
        if (!isAir(world, pos))
        {
            return false;
        }
        else
        {
            setBlock(world, pos, state, boundingBox);
            changedBlocks.add(pos.toImmutable());
            return true;
        }
    }

    protected static void setBlock(WorldView world, BlockPos pos, BlockState state, Box boundingBox)
    {
        setBlock(world, pos, state, boundingBox);
        //boundingBox.intersects(new Box(pos, pos));
    }
}
