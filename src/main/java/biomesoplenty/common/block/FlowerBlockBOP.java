/*******************************************************************************
 * Copyright 2014-2019, the Biomes O' Plenty Team
 *
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 *
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/
package biomesoplenty.common.block;

import biomesoplenty.api.block.BOPBlocks;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.potion.Potions;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

import java.util.Random;

public class FlowerBlockBOP extends FlowerBlock
{
	protected static final VoxelShape NORMAL = Block.createCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 10.0D, 11.0D);
	protected static final VoxelShape LARGE = Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 14.0D, 15.0D);
    private final StatusEffect stewEffect;
    private final int stewEffectDuration;
	
    public FlowerBlockBOP(StatusEffect p_i49984_1_, int effectDuration, AbstractBlock.Settings properties)
    {
        super(p_i49984_1_, 0, properties);
        this.stewEffect = p_i49984_1_;
        if (p_i49984_1_.isInstant()) {
            this.stewEffectDuration = effectDuration;
        } else {
            this.stewEffectDuration = effectDuration * 20;
        }
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView worldIn, BlockPos pos, ShapeContext selectionContext)
    {
    	Block block = state.getBlock();
        
        if (block == BOPBlocks.lavender || block == BOPBlocks.pink_hibiscus)
        {
        	return LARGE;
        }
        
        return NORMAL;
    }
    
    @Override
    public boolean canPlaceAt(BlockState state, WorldView worldIn, BlockPos pos)
    {
        Block ground = worldIn.getBlockState(pos.down()).getBlock();

        if (this == BOPBlocks.wildflower)
        {
            return ground == Blocks.SAND || ground == Blocks.RED_SAND || ground == BOPBlocks.white_sand || ground == BOPBlocks.orange_sand || ground == BOPBlocks.black_sand || super.canPlaceAt(state, worldIn, pos);
        }
        if (this == BOPBlocks.burning_blossom)
        {
            return ground == Blocks.NETHERRACK || ground == Blocks.SOUL_SAND ||  ground == Blocks.SOUL_SOIL ||  ground == Blocks.CRIMSON_NYLIUM ||  ground == Blocks.WARPED_NYLIUM || super.canPlaceAt(state, worldIn, pos);
        }

        return super.canPlaceAt(state, worldIn, pos);
    }
    
    @Override
    public void onEntityCollision(BlockState stateIn, World worldIn, BlockPos pos, Entity entityIn)
    {
    	Block block = stateIn.getBlock();
    	
    	if (entityIn instanceof LivingEntity)
    	{
	    	if (block == BOPBlocks.burning_blossom)
	    	{
	    		(entityIn).setOnFireFor(1);
	    	}
    	}
    }
    
    @Override
    @Environment(EnvType.CLIENT)
    public void randomDisplayTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand)
    {
       super.randomDisplayTick(stateIn, worldIn, pos, rand);
       Block block = stateIn.getBlock();
       
       if (block == BOPBlocks.burning_blossom)
       {
	       if (rand.nextInt(8) == 0)
	       {
	    	   worldIn.addParticle(ParticleTypes.FLAME, (double)(pos.getX() + 0.5D + ((rand.nextDouble() - rand.nextDouble()) / 4.0D)), (double)(pos.getY() + 0.75D), (double)(pos.getZ() + 0.5D + ((rand.nextDouble() - rand.nextDouble()) / 4.0D)), 0.0D, 0.0D, 0.0D);
	       }
	       if (rand.nextInt(4) == 0)
	       {
	    	   worldIn.addParticle(ParticleTypes.SMOKE, (double)(pos.getX() + 0.5D + ((rand.nextDouble() - rand.nextDouble()) / 4.0D)), (double)(pos.getY() + 0.75D), (double)(pos.getZ() + 0.5D + ((rand.nextDouble() - rand.nextDouble()) / 4.0D)), 0.0D, 0.0D, 0.0D);
	       }
	   }
    }

    @Override
    public StatusEffect getEffectInStew() {
        return this.stewEffect;
    }

    @Override
    public int getEffectInStewDuration() {
        return this.stewEffectDuration;
    }
}
