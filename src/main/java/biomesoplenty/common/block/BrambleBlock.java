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
import net.minecraft.block.ConnectingBlock;
import net.minecraft.block.AbstractBlock.Settings;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class BrambleBlock extends ConnectingBlock
{
    public BrambleBlock(Settings builder)
    {
        super(0.25F, builder);
        this.setDefaultState(this.stateManager.getDefaultState().with(NORTH, Boolean.valueOf(false)).with(EAST, Boolean.valueOf(false)).with(SOUTH, Boolean.valueOf(false)).with(WEST, Boolean.valueOf(false)).with(UP, Boolean.valueOf(false)).with(DOWN, Boolean.valueOf(false)));
    }
    
    @Override
    public BlockState getPlacementState(ItemPlacementContext context)
    {
        return this.makeConnections(context.getWorld(), context.getBlockPos());
    }

    public BlockState makeConnections(BlockView reader, BlockPos pos)
    {
        BlockState block = reader.getBlockState(pos.down());
        BlockState block1 = reader.getBlockState(pos.up());
        BlockState block2 = reader.getBlockState(pos.north());
        BlockState block3 = reader.getBlockState(pos.east());
        BlockState block4 = reader.getBlockState(pos.south());
        BlockState block5 = reader.getBlockState(pos.west());
        return this.getDefaultState()
        		.with(DOWN, Boolean.valueOf(block.getBlock() == this || Block.isShapeFullCube(block.getCollisionShape(reader, pos.down()))))
        		.with(UP, Boolean.valueOf(block1.getBlock() == this || Block.isShapeFullCube(block1.getCollisionShape(reader, pos.up()))))
        		.with(NORTH, Boolean.valueOf(block2.getBlock() == this || Block.isShapeFullCube(block2.getCollisionShape(reader, pos.north()))))
        		.with(EAST, Boolean.valueOf(block3.getBlock() == this || Block.isShapeFullCube(block3.getCollisionShape(reader, pos.east()))))
        		.with(SOUTH, Boolean.valueOf(block4.getBlock() == this || Block.isShapeFullCube(block4.getCollisionShape(reader, pos.south()))))
        		.with(WEST, Boolean.valueOf(block5.getBlock() == this || Block.isShapeFullCube(block5.getCollisionShape(reader, pos.west()))));
    }

     @Override
     public BlockState getStateForNeighborUpdate(BlockState stateIn, Direction facing, BlockState facingState, WorldAccess worldIn, BlockPos currentPos, BlockPos facingPos)
     {
    	Block block = facingState.getBlock();
     	boolean flag = block == this || Block.isShapeFullCube(facingState.getCollisionShape(worldIn, facingPos));
     	return stateIn.with(FACING_PROPERTIES.get(facing), Boolean.valueOf(flag));
     }

     @Override
     protected void appendProperties(StateManager.Builder<Block, BlockState> builder)
     {
        builder.add(NORTH, EAST, SOUTH, WEST, UP, DOWN);
     }
}
