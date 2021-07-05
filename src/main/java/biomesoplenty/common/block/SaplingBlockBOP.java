/*******************************************************************************
 * Copyright 2014-2019, the Biomes O' Plenty Team
 *
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 *
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/
package biomesoplenty.common.block;

import java.util.Random;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class SaplingBlockBOP extends SaplingBlock
{
   public static final IntProperty STAGE = Properties.STAGE;
   public static final VoxelShape SHAPE = Block.createCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 12.0D, 14.0D);
   private final SaplingGenerator tree;

   public SaplingBlockBOP(SaplingGenerator tree, AbstractBlock.Settings properties)
   {
      super(tree, properties);
      this.tree = tree;
      this.setDefaultState(this.getStateManager().getDefaultState().with(STAGE, Integer.valueOf(0)));
   }

   @Override
   public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context)
   {
      return SHAPE;
   }

   @Override
   public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random)
   {
      super.randomTick(state, world, pos, random);
      if (!world.isNearOccupiedPointOfInterest(pos, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light
      if (world.getLightLevel(pos.up()) >= 9 && random.nextInt(7) == 0) {
         this.grow(world, random, pos, state);
      }

   }

   @Override
   public void grow(ServerWorld world, Random rand, BlockPos pos, BlockState state)
   {
      if (state.get(STAGE) == 0)
      {
         world.setBlockState(pos, state.cycle(STAGE), 4);
      }
      else
      {
         //if (!net.minecraftforge.event.ForgeEventFactory.saplingGrowTree(world, rand, pos)) return;
         this.tree.generate(world, world.getChunkManager().getChunkGenerator(), pos, state, rand);
      }

   }

   /**
    * Whether this IGrowable can grow
    */
   @Override
   public boolean isFertilizable(BlockView worldIn, BlockPos pos, BlockState state, boolean isClient)
   {
      return true;
   }

   @Override
   public boolean canGrow(World worldIn, Random rand, BlockPos pos, BlockState state)
   {
      return (double)worldIn.random.nextFloat() < 0.45D;
   }

   @Override
   public void generate(ServerWorld world, BlockPos pos, BlockState state, Random rand)
   {
      this.grow(world, rand, pos, state);
   }
   
   //Broken
   /*
   public boolean canSurvive(BlockState state, WorldView worldIn, BlockPos pos)
   {
       Block ground = worldIn.getBlockState(pos.down()).getBlock();

       if (this == BOPBlocks.palm_sapling)
       {
           return ground == BOPBlocks.white_sand || ground == BOPBlocks.orange_sand || ground == BOPBlocks.black_sand || ground == Blocks.RED_SAND || ground == Blocks.SAND || super.canSurvive(state, worldIn, pos);
       }
       if (this == BOPBlocks.hellbark_sapling)
       {
           return ground == Blocks.NETHERRACK || super.canSurvive(state, worldIn, pos);
       }

       return super.canSurvive(state, worldIn, pos);
   }
   */

   @Override
   public void appendProperties(StateManager.Builder<Block, BlockState> builder)
   {
      builder.add(STAGE);
   }
}
