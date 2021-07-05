/*******************************************************************************
 * Copyright 2014-2019, the Biomes O' Plenty Team
 *
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 *
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/
package biomesoplenty.init;

import biomesoplenty.common.block.*;
import biomesoplenty.common.block.trees.*;
import biomesoplenty.common.util.inventory.ItemGroupBOP;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.fabricmc.fabric.impl.client.indigo.renderer.IndigoRenderer;
import net.minecraft.block.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderLayers;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static biomesoplenty.api.block.BOPBlocks.*;

public class ModBlocks
{
    public static void registerBlocks()
    {
        //Terrain
    	white_sand = registerBlock(new SandBlockBOP(0xF3F1E4, FabricBlockSettings.of(Material.AGGREGATE, MapColor.WHITE).strength(0.5F).sounds(BlockSoundGroup.SAND).breakByTool(FabricToolTags.SHOVELS, 0)), "white_sand");
    	white_sandstone = registerBlock(new Block(AbstractBlock.Settings.of(Material.STONE, MapColor.WHITE).strength(0.8F)), "white_sandstone");
        white_sandstone_stairs = registerBlock(new StairsBlockBOP(white_sandstone.getDefaultState(), Block.Settings.copy(white_sandstone)), "white_sandstone_stairs");
    	white_sandstone_slab = registerBlock(new SlabBlock(Block.Settings.copy(white_sandstone)), "white_sandstone_slab");
        white_sandstone_wall = registerBlock(new WallBlock(Block.Settings.copy(white_sandstone)),"white_sandstone_wall");
        smooth_white_sandstone = registerBlock(new Block(AbstractBlock.Settings.of(Material.STONE, MapColor.WHITE).strength(2.0F, 6.0F)), "smooth_white_sandstone");
        smooth_white_sandstone_stairs = registerBlock(new StairsBlockBOP(white_sandstone.getDefaultState(), Block.Settings.copy(smooth_white_sandstone)), "smooth_white_sandstone_stairs");
        smooth_white_sandstone_slab = registerBlock(new SlabBlock(Block.Settings.copy(smooth_white_sandstone)), "smooth_white_sandstone_slab");
    	cut_white_sandstone = registerBlock(new Block(AbstractBlock.Settings.of(Material.STONE, MapColor.WHITE).strength(0.8F)), "cut_white_sandstone");
        cut_white_sandstone_slab = registerBlock(new SlabBlock(Block.Settings.copy(cut_white_sandstone)), "cut_white_sandstone_slab");
        chiseled_white_sandstone = registerBlock(new Block(AbstractBlock.Settings.of(Material.STONE, MapColor.WHITE).strength(0.8F)), "chiseled_white_sandstone");

        orange_sand = registerBlock(new SandBlockBOP(0xCC9A61, FabricBlockSettings.of(Material.AGGREGATE, MapColor.ORANGE).strength(0.5F).sounds(BlockSoundGroup.SAND).breakByTool(FabricToolTags.SHOVELS, 0)), "orange_sand");
        orange_sandstone = registerBlock(new Block(AbstractBlock.Settings.of(Material.STONE, MapColor.ORANGE).strength(0.8F)), "orange_sandstone");
        orange_sandstone_stairs = registerBlock(new StairsBlockBOP(orange_sandstone.getDefaultState(), Block.Settings.copy(orange_sandstone)), "orange_sandstone_stairs");
        orange_sandstone_slab = registerBlock(new SlabBlock(Block.Settings.copy(orange_sandstone)), "orange_sandstone_slab");
        orange_sandstone_wall = registerBlock(new WallBlock(Block.Settings.copy(orange_sandstone)),"orange_sandstone_wall");
        smooth_orange_sandstone = registerBlock(new Block(AbstractBlock.Settings.of(Material.STONE, MapColor.ORANGE).strength(2.0F, 6.0F)), "smooth_orange_sandstone");
        smooth_orange_sandstone_stairs = registerBlock(new StairsBlockBOP(orange_sandstone.getDefaultState(), Block.Settings.copy(smooth_orange_sandstone)), "smooth_orange_sandstone_stairs");
        smooth_orange_sandstone_slab = registerBlock(new SlabBlock(Block.Settings.copy(smooth_orange_sandstone)), "smooth_orange_sandstone_slab");
        cut_orange_sandstone = registerBlock(new Block(AbstractBlock.Settings.of(Material.STONE, MapColor.ORANGE).strength(0.8F)), "cut_orange_sandstone");
        cut_orange_sandstone_slab = registerBlock(new SlabBlock(Block.Settings.copy(cut_orange_sandstone)), "cut_orange_sandstone_slab");
        chiseled_orange_sandstone = registerBlock(new Block(AbstractBlock.Settings.of(Material.STONE, MapColor.ORANGE).strength(0.8F)), "chiseled_orange_sandstone");
        
        black_sand = registerBlock(new SandBlockBOP(0x2D2C2F, FabricBlockSettings.of(Material.AGGREGATE, MapColor.BLACK).strength(0.5F).sounds(BlockSoundGroup.SAND).breakByTool(FabricToolTags.SHOVELS, 0)), "black_sand");
        black_sandstone = registerBlock(new Block(AbstractBlock.Settings.of(Material.STONE, MapColor.BLACK).strength(0.8F)), "black_sandstone");
        black_sandstone_stairs = registerBlock(new StairsBlockBOP(black_sandstone.getDefaultState(), Block.Settings.copy(black_sandstone)), "black_sandstone_stairs");
        black_sandstone_slab = registerBlock(new SlabBlock(Block.Settings.copy(black_sandstone)), "black_sandstone_slab");
        black_sandstone_wall = registerBlock(new WallBlock(Block.Settings.copy(black_sandstone)),"black_sandstone_wall");
        smooth_black_sandstone = registerBlock(new Block(AbstractBlock.Settings.of(Material.STONE, MapColor.BLACK).strength(2.0F, 6.0F)), "smooth_black_sandstone");
        smooth_black_sandstone_stairs = registerBlock(new StairsBlockBOP(black_sandstone.getDefaultState(), Block.Settings.copy(smooth_black_sandstone)), "smooth_black_sandstone_stairs");
        smooth_black_sandstone_slab = registerBlock(new SlabBlock(Block.Settings.copy(smooth_black_sandstone)), "smooth_black_sandstone_slab");
        cut_black_sandstone = registerBlock(new Block(AbstractBlock.Settings.of(Material.STONE, MapColor.BLACK).strength(0.8F)), "cut_black_sandstone");
        cut_black_sandstone_slab = registerBlock(new SlabBlock(Block.Settings.copy(cut_black_sandstone)), "cut_black_sandstone_slab");
        chiseled_black_sandstone = registerBlock(new Block(AbstractBlock.Settings.of(Material.STONE, MapColor.BLACK).strength(0.8F)), "chiseled_black_sandstone");

        mud = registerBlock(new MudBlock(FabricBlockSettings.of(Material.SOIL, MapColor.TERRACOTTA_BROWN).strength(0.6F).breakByTool(FabricToolTags.SHOVELS, 0).sounds(new BlockSoundGroup(1.0F, 0.5F, SoundEvents.BLOCK_SLIME_BLOCK_BREAK, SoundEvents.BLOCK_SLIME_BLOCK_STEP, SoundEvents.BLOCK_SLIME_BLOCK_PLACE, SoundEvents.BLOCK_SLIME_BLOCK_HIT, SoundEvents.BLOCK_SLIME_BLOCK_FALL))), "mud");
        mud_bricks = registerBlock(new Block(AbstractBlock.Settings.of(Material.STONE, MapColor.TERRACOTTA_BROWN).strength(1.0F)), "mud_bricks");
        mud_brick_stairs = registerBlock(new StairsBlockBOP(mud_bricks.getDefaultState(), Block.Settings.copy(mud_bricks)), "mud_brick_stairs");
        mud_brick_slab = registerBlock(new SlabBlock(Block.Settings.copy(mud_bricks)), "mud_brick_slab");
        mud_brick_wall = registerBlock(new WallBlock(Block.Settings.copy(mud_bricks)),"mud_brick_wall");

        origin_grass_block = registerBlock(new GrassBlock(FabricBlockSettings.of(Material.SOLID_ORGANIC).ticksRandomly().strength(0.6F).sounds(BlockSoundGroup.GRASS).breakByTool(FabricToolTags.SHOVELS, 0)), "origin_grass_block");
        dried_salt = registerBlock(new DriedSaltBlock(FabricBlockSettings.of(Material.STONE, MapColor.OAK_TAN).strength(1.0F).breakByTool(FabricToolTags.PICKAXES, 0).sounds(new BlockSoundGroup(1.0F, 0.5F, SoundEvents.BLOCK_GRAVEL_BREAK, SoundEvents.BLOCK_GRAVEL_STEP, SoundEvents.BLOCK_GRAVEL_PLACE, SoundEvents.BLOCK_GRAVEL_HIT, SoundEvents.BLOCK_GRAVEL_FALL))), "dried_salt");
        flesh = registerBlock(new FleshBlock(FabricBlockSettings.of(Material.SPONGE, MapColor.TERRACOTTA_RED).strength(0.4F).breakByTool(FabricToolTags.AXES, 0).sounds(new BlockSoundGroup(1.0F, 0.5F, SoundEvents.BLOCK_CORAL_BLOCK_BREAK, SoundEvents.BLOCK_CORAL_BLOCK_STEP, SoundEvents.BLOCK_CORAL_BLOCK_PLACE, SoundEvents.BLOCK_CORAL_BLOCK_HIT, SoundEvents.BLOCK_CORAL_BLOCK_FALL))), "flesh");

        nether_crystal_block = registerBlock(new Block(FabricBlockSettings.of(Material.GLASS, MapColor.DARK_CRIMSON).strength(0.4F).breakByTool(FabricToolTags.PICKAXES, 0).sounds(new BlockSoundGroup(1.0F, 0.75F, SoundEvents.BLOCK_GLASS_BREAK, SoundEvents.BLOCK_GLASS_STEP, SoundEvents.BLOCK_GLASS_PLACE, SoundEvents.BLOCK_GLASS_HIT, SoundEvents.BLOCK_GLASS_FALL)).lightLevel((state) -> 10)), "nether_crystal_block");
        //nether_crystal = registerBlock(new NetherCrystalBlock(FabricBlockSettings.of(Material.GLASS, MapColor.DARK_CRIMSON).noCollision().strength(0.3F).breakByTool(FabricToolTags.PICKAXES, 0).sounds(new BlockSoundGroup(1.0F, 0.75F, SoundEvents.BLOCK_GLASS_BREAK, SoundEvents.BLOCK_GLASS_STEP, SoundEvents.BLOCK_GLASS_PLACE, SoundEvents.BLOCK_GLASS_HIT, SoundEvents.BLOCK_GLASS_FALL)).lightLevel((state) -> 8)), "nether_crystal");

        toadstool_block = registerBlock(new MushroomBlock(AbstractBlock.Settings.of(Material.WOOD, MapColor.ORANGE).strength(0.2F).sounds(BlockSoundGroup.WOOD)), "toadstool_block");
        glowshroom_block = registerBlock(new MushroomBlock(AbstractBlock.Settings.of(Material.WOOD, MapColor.DIAMOND_BLUE).strength(0.2F).sounds(BlockSoundGroup.WOOD).luminance((state) -> 10)), "glowshroom_block");
        /*
        //Trees
        origin_sapling = registerBlock(new SaplingBlockBOP(new OriginTree(), AbstractBlock.Settings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS)), "origin_sapling");
        origin_leaves = registerBlock(new LeavesBlock(AbstractBlock.Settings.of(Material.LEAVES, MapColor.EMERALD).strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).noOcclusion()), "origin_leaves");
        flowering_oak_sapling = registerBlock(new SaplingBlockBOP(new FloweringOakTree(), AbstractBlock.Settings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS)), "flowering_oak_sapling");
        flowering_oak_leaves = registerBlock(new LeavesBlock(AbstractBlock.Settings.of(Material.LEAVES).strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).noOcclusion()), "flowering_oak_leaves");
        rainbow_birch_sapling = registerBlock(new SaplingBlockBOP(new RainbowBirchTree(), AbstractBlock.Settings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS)), "rainbow_birch_sapling");
        rainbow_birch_leaves = registerBlock(new LeavesBlock(AbstractBlock.Settings.of(Material.LEAVES).strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).noOcclusion()), "rainbow_birch_leaves");
        yellow_autumn_sapling = registerBlock(new SaplingBlockBOP(new YellowAutumnTree(), AbstractBlock.Settings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS)), "yellow_autumn_sapling");
        yellow_autumn_leaves = registerBlock(new LeavesBlock(AbstractBlock.Settings.of(Material.LEAVES, MapColor.TERRACOTTA_YELLOW).strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).noOcclusion()), "yellow_autumn_leaves");
        orange_autumn_sapling = registerBlock(new SaplingBlockBOP(new OrangeAutumnTree(), AbstractBlock.Settings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS)), "orange_autumn_sapling");
        orange_autumn_leaves = registerBlock(new LeavesBlock(AbstractBlock.Settings.of(Material.LEAVES, MapColor.TERRACOTTA_ORANGE).strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).noOcclusion()), "orange_autumn_leaves");
        maple_sapling = registerBlock(new SaplingBlockBOP(new MapleTree(), AbstractBlock.Settings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS)), "maple_sapling");
        maple_leaves = registerBlock(new LeavesBlock(AbstractBlock.Settings.of(Material.LEAVES, MapColor.COLOR_RED).strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).noOcclusion()), "maple_leaves");
        
        fir_sapling = registerBlock(new SaplingBlockBOP(new FirTree(), AbstractBlock.Settings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS)), "fir_sapling");
        fir_leaves = registerBlock(new LeavesBlock(AbstractBlock.Settings.of(Material.LEAVES).strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).noOcclusion()), "fir_leaves");
        fir_log = registerBlock(Blocks.log(MapColor.TERRACOTTA_WHITE, MapColor.TERRACOTTA_LIGHT_GRAY), "fir_log");
        fir_wood = registerBlock(new RotatedPillarBlock(AbstractBlock.Settings.of(Material.WOOD, MapColor.TERRACOTTA_WHITE).strength(2.0F).sounds(BlockSoundGroup.WOOD)), "fir_wood");
        stripped_fir_log = registerBlock(Blocks.log(MapColor.TERRACOTTA_WHITE, MapColor.TERRACOTTA_WHITE), "stripped_fir_log");
        stripped_fir_wood = registerBlock(new RotatedPillarBlock(AbstractBlock.Settings.of(Material.WOOD, MapColor.TERRACOTTA_WHITE).strength(2.0F).sounds(BlockSoundGroup.WOOD)), "stripped_fir_wood");
        fir_planks = registerBlock(new Block(AbstractBlock.Settings.of(Material.WOOD, MapColor.TERRACOTTA_WHITE).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)), "fir_planks");
        fir_stairs = registerBlock(new StairsBlockBOP(fir_planks.getDefaultState(), Block.Settings.copy(fir_planks)), "fir_stairs");
        fir_slab = registerBlock(new SlabBlock(AbstractBlock.Settings.of(Material.WOOD, MapColor.TERRACOTTA_WHITE).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)), "fir_slab");
        fir_fence = registerBlock(new FenceBlock(AbstractBlock.Settings.of(Material.WOOD, fir_planks.defaultMapColor()).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)), "fir_fence");
        fir_fence_gate = registerBlock(new FenceGateBlock(AbstractBlock.Settings.of(Material.WOOD, fir_planks.defaultMapColor()).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)), "fir_fence_gate");
        fir_door = registerBlock(new DoorBlock(AbstractBlock.Settings.of(Material.WOOD, fir_planks.defaultMapColor()).strength(3.0F).sounds(BlockSoundGroup.WOOD).noOcclusion()), "fir_door");
        fir_trapdoor = registerBlock(new TrapDoorBlock(AbstractBlock.Settings.of(Material.WOOD, MapColor.TERRACOTTA_WHITE).strength(3.0F).sounds(BlockSoundGroup.WOOD).noOcclusion()), "fir_trapdoor");
        fir_pressure_plate = registerBlock(new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, AbstractBlock.Settings.of(Material.WOOD, fir_planks.defaultMapColor()).noCollission().strength(0.5F).sounds(BlockSoundGroup.WOOD)), "fir_pressure_plate");
        fir_button = registerBlock(new WoodButtonBlock(AbstractBlock.Settings.of(Material.DECORATION).noCollision().strength(0.5F).sounds(BlockSoundGroup.WOOD)), "fir_button");
        
        redwood_sapling = registerBlock(new SaplingBlockBOP(new RedwoodTree(), AbstractBlock.Settings.of(Material.PLANT).noCollission().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS)), "redwood_sapling");
        redwood_leaves = registerBlock(new LeavesBlock(AbstractBlock.Settings.of(Material.LEAVES).strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).noOcclusion()), "redwood_leaves");
        redwood_log = registerBlock(Blocks.log(MapColor.TERRACOTTA_ORANGE, MapColor.TERRACOTTA_ORANGE), "redwood_log");
        redwood_wood = registerBlock(new RotatedPillarBlock(AbstractBlock.Settings.of(Material.WOOD, MapColor.TERRACOTTA_ORANGE).strength(2.0F).sounds(BlockSoundGroup.WOOD)), "redwood_wood");
        stripped_redwood_log = registerBlock(Blocks.log(MapColor.TERRACOTTA_ORANGE, MapColor.TERRACOTTA_ORANGE), "stripped_redwood_log");
        stripped_redwood_wood = registerBlock(new RotatedPillarBlock(AbstractBlock.Settings.of(Material.WOOD, MapColor.TERRACOTTA_ORANGE).strength(2.0F).sounds(BlockSoundGroup.WOOD)), "stripped_redwood_wood");
        redwood_planks = registerBlock(new Block(AbstractBlock.Settings.of(Material.WOOD, MapColor.TERRACOTTA_ORANGE).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)), "redwood_planks");
        redwood_stairs = registerBlock(new StairsBlockBOP(redwood_planks.getDefaultState(), Block.Settings.copy(redwood_planks)), "redwood_stairs");
        redwood_slab = registerBlock(new SlabBlock(AbstractBlock.Settings.of(Material.WOOD, MapColor.TERRACOTTA_ORANGE).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)), "redwood_slab");
        redwood_fence = registerBlock(new FenceBlock(AbstractBlock.Settings.of(Material.WOOD, redwood_planks.defaultMapColor()).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)), "redwood_fence");
        redwood_fence_gate = registerBlock(new FenceGateBlock(AbstractBlock.Settings.of(Material.WOOD, redwood_planks.defaultMapColor()).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)), "redwood_fence_gate");
        redwood_door = registerBlock(new DoorBlock(AbstractBlock.Settings.of(Material.WOOD, redwood_planks.defaultMapColor()).strength(3.0F).sounds(BlockSoundGroup.WOOD).noOcclusion()), "redwood_door");
        redwood_trapdoor = registerBlock(new TrapDoorBlock(AbstractBlock.Settings.of(Material.WOOD, MapColor.TERRACOTTA_ORANGE).strength(3.0F).sounds(BlockSoundGroup.WOOD).noOcclusion()), "redwood_trapdoor");
        redwood_pressure_plate = registerBlock(new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, AbstractBlock.Settings.of(Material.WOOD, redwood_planks.defaultMapColor()).noCollission().strength(0.5F).sounds(BlockSoundGroup.WOOD)), "redwood_pressure_plate");
        redwood_button = registerBlock(new WoodButtonBlock(AbstractBlock.Settings.of(Material.DECORATION).noCollission().strength(0.5F).sounds(BlockSoundGroup.WOOD)), "redwood_button");
        
        white_cherry_sapling = registerBlock(new SaplingBlockBOP(new WhiteCherryTree(), AbstractBlock.Settings.of(Material.PLANT).noCollission().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS)), "white_cherry_sapling");
        white_cherry_leaves = registerBlock(new LeavesBlock(AbstractBlock.Settings.of(Material.LEAVES, MapColor.SNOW).strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).noOcclusion()), "white_cherry_leaves");
        pink_cherry_sapling = registerBlock(new SaplingBlockBOP(new PinkCherryTree(), AbstractBlock.Settings.of(Material.PLANT).noCollission().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS)), "pink_cherry_sapling");
        pink_cherry_leaves = registerBlock(new LeavesBlock(AbstractBlock.Settings.of(Material.LEAVES, MapColor.COLOR_PINK).strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).noOcclusion()), "pink_cherry_leaves");
        cherry_log = registerBlock(Blocks.log(MapColor.COLOR_RED, MapColor.TERRACOTTA_RED), "cherry_log");
        cherry_wood = registerBlock(new RotatedPillarBlock(AbstractBlock.Settings.of(Material.WOOD, MapColor.COLOR_RED).strength(2.0F).sounds(BlockSoundGroup.WOOD)), "cherry_wood");
        stripped_cherry_log = registerBlock(Blocks.log(MapColor.COLOR_RED, MapColor.COLOR_RED), "stripped_cherry_log");
        stripped_cherry_wood = registerBlock(new RotatedPillarBlock(AbstractBlock.Settings.of(Material.WOOD, MapColor.COLOR_RED).strength(2.0F).sounds(BlockSoundGroup.WOOD)), "stripped_cherry_wood");
        cherry_planks = registerBlock(new Block(AbstractBlock.Settings.of(Material.WOOD, MapColor.COLOR_RED).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)), "cherry_planks");
        cherry_stairs = registerBlock(new StairsBlockBOP(cherry_planks.getDefaultState(), Block.Settings.copy(cherry_planks)), "cherry_stairs");
        cherry_slab = registerBlock(new SlabBlock(AbstractBlock.Settings.of(Material.WOOD, MapColor.COLOR_RED).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)), "cherry_slab");
        cherry_fence = registerBlock(new FenceBlock(AbstractBlock.Settings.of(Material.WOOD, cherry_planks.defaultMapColor()).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)), "cherry_fence");
        cherry_fence_gate = registerBlock(new FenceGateBlock(AbstractBlock.Settings.of(Material.WOOD, cherry_planks.defaultMapColor()).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)), "cherry_fence_gate");
        cherry_door = registerBlock(new DoorBlock(AbstractBlock.Settings.of(Material.WOOD, cherry_planks.defaultMapColor()).strength(3.0F).sounds(BlockSoundGroup.WOOD).noOcclusion()), "cherry_door");
        cherry_trapdoor = registerBlock(new TrapDoorBlock(AbstractBlock.Settings.of(Material.WOOD, MapColor.COLOR_RED).strength(3.0F).sounds(BlockSoundGroup.WOOD).noOcclusion()), "cherry_trapdoor");
        cherry_pressure_plate = registerBlock(new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, AbstractBlock.Settings.of(Material.WOOD, cherry_planks.defaultMapColor()).noCollission().strength(0.5F).sounds(BlockSoundGroup.WOOD)), "cherry_pressure_plate");
        cherry_button = registerBlock(new WoodButtonBlock(AbstractBlock.Settings.of(Material.DECORATION).noCollission().strength(0.5F).sounds(BlockSoundGroup.WOOD)), "cherry_button");
        
        mahogany_sapling = registerBlock(new SaplingBlockBOP(new MahoganyTree(), AbstractBlock.Settings.of(Material.PLANT).noCollission().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS)), "mahogany_sapling");
        mahogany_leaves = registerBlock(new LeavesBlock(AbstractBlock.Settings.of(Material.LEAVES).strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).noOcclusion()), "mahogany_leaves");
        mahogany_log = registerBlock(Blocks.log(MapColor.TERRACOTTA_PINK, MapColor.DIRT), "mahogany_log");
        mahogany_wood = registerBlock(new RotatedPillarBlock(AbstractBlock.Settings.of(Material.WOOD, MapColor.TERRACOTTA_PINK).strength(2.0F).sounds(BlockSoundGroup.WOOD)), "mahogany_wood");
        stripped_mahogany_log = registerBlock(Blocks.log(MapColor.TERRACOTTA_PINK, MapColor.TERRACOTTA_PINK), "stripped_mahogany_log");
        stripped_mahogany_wood = registerBlock(new RotatedPillarBlock(AbstractBlock.Settings.of(Material.WOOD, MapColor.TERRACOTTA_PINK).strength(2.0F).sounds(BlockSoundGroup.WOOD)), "stripped_mahogany_wood");
        mahogany_planks = registerBlock(new Block(AbstractBlock.Settings.of(Material.WOOD, MapColor.TERRACOTTA_PINK).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)), "mahogany_planks");
        mahogany_stairs = registerBlock(new StairsBlockBOP(mahogany_planks.getDefaultState(), Block.Settings.copy(mahogany_planks)), "mahogany_stairs");
        mahogany_slab = registerBlock(new SlabBlock(AbstractBlock.Settings.of(Material.WOOD, MapColor.TERRACOTTA_PINK).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)), "mahogany_slab");
        mahogany_fence = registerBlock(new FenceBlock(AbstractBlock.Settings.of(Material.WOOD, mahogany_planks.defaultMapColor()).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)), "mahogany_fence");
        mahogany_fence_gate = registerBlock(new FenceGateBlock(AbstractBlock.Settings.of(Material.WOOD, mahogany_planks.defaultMapColor()).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)), "mahogany_fence_gate");
        mahogany_door = registerBlock(new DoorBlock(AbstractBlock.Settings.of(Material.WOOD, mahogany_planks.defaultMapColor()).strength(3.0F).sounds(BlockSoundGroup.WOOD).noOcclusion()), "mahogany_door");
        mahogany_trapdoor = registerBlock(new TrapDoorBlock(AbstractBlock.Settings.of(Material.WOOD, MapColor.TERRACOTTA_PINK).strength(3.0F).sounds(BlockSoundGroup.WOOD).noOcclusion()), "mahogany_trapdoor");
        mahogany_pressure_plate = registerBlock(new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, AbstractBlock.Settings.of(Material.WOOD, mahogany_planks.defaultMapColor()).noCollission().strength(0.5F).sounds(BlockSoundGroup.WOOD)), "mahogany_pressure_plate");
        mahogany_button = registerBlock(new WoodButtonBlock(AbstractBlock.Settings.of(Material.DECORATION).noCollission().strength(0.5F).sounds(BlockSoundGroup.WOOD)), "mahogany_button");
        
        jacaranda_sapling = registerBlock(new SaplingBlockBOP(new JacarandaTree(), AbstractBlock.Settings.of(Material.PLANT).noCollission().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS)), "jacaranda_sapling");
        jacaranda_leaves = registerBlock(new LeavesBlock(AbstractBlock.Settings.of(Material.LEAVES, MapColor.COLOR_PURPLE).strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).noOcclusion()), "jacaranda_leaves");
        jacaranda_log = registerBlock(Blocks.log(MapColor.TERRACOTTA_WHITE, MapColor.TERRACOTTA_LIGHT_GRAY), "jacaranda_log");
        jacaranda_wood = registerBlock(new RotatedPillarBlock(AbstractBlock.Settings.of(Material.WOOD, MapColor.TERRACOTTA_WHITE).strength(2.0F).sounds(BlockSoundGroup.WOOD)), "jacaranda_wood");
        stripped_jacaranda_log = registerBlock(Blocks.log(MapColor.TERRACOTTA_WHITE, MapColor.TERRACOTTA_WHITE), "stripped_jacaranda_log");
        stripped_jacaranda_wood = registerBlock(new RotatedPillarBlock(AbstractBlock.Settings.of(Material.WOOD, MapColor.TERRACOTTA_WHITE).strength(2.0F).sounds(BlockSoundGroup.WOOD)), "stripped_jacaranda_wood");
        jacaranda_planks = registerBlock(new Block(AbstractBlock.Settings.of(Material.WOOD, MapColor.TERRACOTTA_WHITE).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)), "jacaranda_planks");
        jacaranda_stairs = registerBlock(new StairsBlockBOP(jacaranda_planks.getDefaultState(), Block.Settings.copy(jacaranda_planks)), "jacaranda_stairs");
        jacaranda_slab = registerBlock(new SlabBlock(AbstractBlock.Settings.of(Material.WOOD, MapColor.TERRACOTTA_WHITE).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)), "jacaranda_slab");
        jacaranda_fence = registerBlock(new FenceBlock(AbstractBlock.Settings.of(Material.WOOD, jacaranda_planks.defaultMapColor()).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)), "jacaranda_fence");
        jacaranda_fence_gate = registerBlock(new FenceGateBlock(AbstractBlock.Settings.of(Material.WOOD, jacaranda_planks.defaultMapColor()).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)), "jacaranda_fence_gate");
        jacaranda_door = registerBlock(new DoorBlock(AbstractBlock.Settings.of(Material.WOOD, jacaranda_planks.defaultMapColor()).strength(3.0F).sounds(BlockSoundGroup.WOOD).noOcclusion()), "jacaranda_door");
        jacaranda_trapdoor = registerBlock(new TrapDoorBlock(AbstractBlock.Settings.of(Material.WOOD, MapColor.TERRACOTTA_WHITE).strength(3.0F).sounds(BlockSoundGroup.WOOD).noOcclusion()), "jacaranda_trapdoor");
        jacaranda_pressure_plate = registerBlock(new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, AbstractBlock.Settings.of(Material.WOOD, jacaranda_planks.defaultMapColor()).noCollission().strength(0.5F).sounds(BlockSoundGroup.WOOD)), "jacaranda_pressure_plate");
        jacaranda_button = registerBlock(new WoodButtonBlock(AbstractBlock.Settings.of(Material.DECORATION).noCollission().strength(0.5F).sounds(BlockSoundGroup.WOOD)), "jacaranda_button");
        
        palm_sapling = registerBlock(new SaplingBlockBOP(new PalmTree(), AbstractBlock.Settings.of(Material.PLANT).noCollission().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS)), "palm_sapling");
        palm_leaves = registerBlock(new LeavesBlock(AbstractBlock.Settings.of(Material.LEAVES).strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).noOcclusion()), "palm_leaves");
        palm_log = registerBlock(Blocks.log(MapColor.TERRACOTTA_YELLOW, MapColor.PODZOL), "palm_log");
        palm_wood = registerBlock(new RotatedPillarBlock(AbstractBlock.Settings.of(Material.WOOD, MapColor.TERRACOTTA_YELLOW).strength(2.0F).sounds(BlockSoundGroup.WOOD)), "palm_wood");
        stripped_palm_log = registerBlock(Blocks.log(MapColor.TERRACOTTA_YELLOW, MapColor.TERRACOTTA_YELLOW), "stripped_palm_log");
        stripped_palm_wood = registerBlock(new RotatedPillarBlock(AbstractBlock.Settings.of(Material.WOOD, MapColor.TERRACOTTA_YELLOW).strength(2.0F).sounds(BlockSoundGroup.WOOD)), "stripped_palm_wood");
        palm_planks = registerBlock(new Block(AbstractBlock.Settings.of(Material.WOOD, MapColor.TERRACOTTA_YELLOW).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)), "palm_planks");
        palm_stairs = registerBlock(new StairsBlockBOP(palm_planks.getDefaultState(), Block.Settings.copy(palm_planks)), "palm_stairs");
        palm_slab = registerBlock(new SlabBlock(AbstractBlock.Settings.of(Material.WOOD, MapColor.TERRACOTTA_YELLOW).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)), "palm_slab");
        palm_fence = registerBlock(new FenceBlock(AbstractBlock.Settings.of(Material.WOOD, palm_planks.defaultMapColor()).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)), "palm_fence");
        palm_fence_gate = registerBlock(new FenceGateBlock(AbstractBlock.Settings.of(Material.WOOD, palm_planks.defaultMapColor()).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)), "palm_fence_gate");
        palm_door = registerBlock(new DoorBlock(AbstractBlock.Settings.of(Material.WOOD, palm_planks.defaultMapColor()).strength(3.0F).sounds(BlockSoundGroup.WOOD).noOcclusion()), "palm_door");
        palm_trapdoor = registerBlock(new TrapDoorBlock(AbstractBlock.Settings.of(Material.WOOD, MapColor.TERRACOTTA_YELLOW).strength(3.0F).sounds(BlockSoundGroup.WOOD).noOcclusion()), "palm_trapdoor");
        palm_pressure_plate = registerBlock(new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, AbstractBlock.Settings.of(Material.WOOD, palm_planks.defaultMapColor()).noCollission().strength(0.5F).sounds(BlockSoundGroup.WOOD)), "palm_pressure_plate");
        palm_button = registerBlock(new WoodButtonBlock(AbstractBlock.Settings.of(Material.DECORATION).noCollission().strength(0.5F).sounds(BlockSoundGroup.WOOD)), "palm_button");
        
        willow_sapling = registerBlock(new SaplingBlockBOP(new WillowTree(), AbstractBlock.Settings.of(Material.PLANT).noCollission().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS)), "willow_sapling");
        willow_leaves = registerBlock(new LeavesBlock(AbstractBlock.Settings.of(Material.LEAVES).strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).noOcclusion()), "willow_leaves");
        willow_log = registerBlock(Blocks.log(MapColor.TERRACOTTA_LIGHT_GREEN, MapColor.TERRACOTTA_LIGHT_GREEN), "willow_log");
        willow_wood = registerBlock(new RotatedPillarBlock(AbstractBlock.Settings.of(Material.WOOD, MapColor.TERRACOTTA_LIGHT_GREEN).strength(2.0F).sounds(BlockSoundGroup.WOOD)), "willow_wood");
        stripped_willow_log = registerBlock(Blocks.log(MapColor.TERRACOTTA_LIGHT_GREEN, MapColor.TERRACOTTA_LIGHT_GREEN), "stripped_willow_log");
        stripped_willow_wood = registerBlock(new RotatedPillarBlock(AbstractBlock.Settings.of(Material.WOOD, MapColor.TERRACOTTA_LIGHT_GREEN).strength(2.0F).sounds(BlockSoundGroup.WOOD)), "stripped_willow_wood");
        willow_planks = registerBlock(new Block(AbstractBlock.Settings.of(Material.WOOD, MapColor.TERRACOTTA_LIGHT_GREEN).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)), "willow_planks");
        willow_stairs = registerBlock(new StairsBlockBOP(willow_planks.getDefaultState(), Block.Settings.copy(willow_planks)), "willow_stairs");
        willow_slab = registerBlock(new SlabBlock(AbstractBlock.Settings.of(Material.WOOD, MapColor.TERRACOTTA_LIGHT_GREEN).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)), "willow_slab");
        willow_fence = registerBlock(new FenceBlock(AbstractBlock.Settings.of(Material.WOOD, willow_planks.defaultMapColor()).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)), "willow_fence");
        willow_fence_gate = registerBlock(new FenceGateBlock(AbstractBlock.Settings.of(Material.WOOD, willow_planks.defaultMapColor()).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)), "willow_fence_gate");
        willow_door = registerBlock(new DoorBlock(AbstractBlock.Settings.of(Material.WOOD, willow_planks.defaultMapColor()).strength(3.0F).sounds(BlockSoundGroup.WOOD).noOcclusion()), "willow_door");
        willow_trapdoor = registerBlock(new TrapDoorBlock(AbstractBlock.Settings.of(Material.WOOD, MapColor.TERRACOTTA_LIGHT_GREEN).strength(3.0F).sounds(BlockSoundGroup.WOOD).noOcclusion()), "willow_trapdoor");
        willow_pressure_plate = registerBlock(new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, AbstractBlock.Settings.of(Material.WOOD, willow_planks.defaultMapColor()).noCollission().strength(0.5F).sounds(BlockSoundGroup.WOOD)), "willow_pressure_plate");
        willow_button = registerBlock(new WoodButtonBlock(AbstractBlock.Settings.of(Material.DECORATION).noCollission().strength(0.5F).sounds(BlockSoundGroup.WOOD)), "willow_button");
        
        dead_sapling = registerBlock(new SaplingBlockBOP(new DeadTree(), AbstractBlock.Settings.of(Material.PLANT).noCollission().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS)), "dead_sapling");
        dead_leaves = registerBlock(new LeavesBlock(AbstractBlock.Settings.of(Material.LEAVES, MapColor.WOOD).strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).noOcclusion()), "dead_leaves");
        dead_log = registerBlock(Blocks.log(MapColor.STONE, MapColor.COLOR_GRAY), "dead_log");
        dead_wood = registerBlock(new RotatedPillarBlock(AbstractBlock.Settings.of(Material.WOOD, MapColor.STONE).strength(2.0F).sounds(BlockSoundGroup.WOOD)), "dead_wood");
        stripped_dead_log = registerBlock(Blocks.log(MapColor.STONE, MapColor.STONE), "stripped_dead_log");
        stripped_dead_wood = registerBlock(new RotatedPillarBlock(AbstractBlock.Settings.of(Material.WOOD, MapColor.STONE).strength(2.0F).sounds(BlockSoundGroup.WOOD)), "stripped_dead_wood");
        dead_planks = registerBlock(new Block(AbstractBlock.Settings.of(Material.WOOD, MapColor.STONE).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)), "dead_planks");
        dead_stairs = registerBlock(new StairsBlockBOP(dead_planks.getDefaultState(), Block.Settings.copy(dead_planks)), "dead_stairs");
        dead_slab = registerBlock(new SlabBlock(AbstractBlock.Settings.of(Material.WOOD, MapColor.STONE).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)), "dead_slab");
        dead_fence = registerBlock(new FenceBlock(AbstractBlock.Settings.of(Material.WOOD, dead_planks.defaultMapColor()).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)), "dead_fence");
        dead_fence_gate = registerBlock(new FenceGateBlock(AbstractBlock.Settings.of(Material.WOOD, dead_planks.defaultMapColor()).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)), "dead_fence_gate");
        dead_door = registerBlock(new DoorBlock(AbstractBlock.Settings.of(Material.WOOD, dead_planks.defaultMapColor()).strength(3.0F).sounds(BlockSoundGroup.WOOD).noOcclusion()), "dead_door");
        dead_trapdoor = registerBlock(new TrapDoorBlock(AbstractBlock.Settings.of(Material.WOOD, MapColor.STONE).strength(3.0F).sounds(BlockSoundGroup.WOOD).noOcclusion()), "dead_trapdoor");
        dead_pressure_plate = registerBlock(new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, AbstractBlock.Settings.of(Material.WOOD, dead_planks.defaultMapColor()).noCollission().strength(0.5F).sounds(BlockSoundGroup.WOOD)), "dead_pressure_plate");
        dead_button = registerBlock(new WoodButtonBlock(AbstractBlock.Settings.of(Material.DECORATION).noCollission().strength(0.5F).sounds(BlockSoundGroup.WOOD)), "dead_button");
        
        magic_sapling = registerBlock(new SaplingBlockBOP(new MagicTree(), AbstractBlock.Settings.of(Material.PLANT).noCollission().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS)), "magic_sapling");
        magic_leaves = registerBlock(new LeavesBlock(AbstractBlock.Settings.of(Material.LEAVES, MapColor.COLOR_CYAN).strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).noOcclusion()), "magic_leaves");
        magic_log = registerBlock(Blocks.log(MapColor.COLOR_BLUE, MapColor.TERRACOTTA_LIGHT_BLUE), "magic_log");
        magic_wood = registerBlock(new RotatedPillarBlock(AbstractBlock.Settings.of(Material.WOOD, MapColor.COLOR_BLUE).strength(2.0F).sounds(BlockSoundGroup.WOOD)), "magic_wood");
        stripped_magic_log = registerBlock(Blocks.log(MapColor.COLOR_BLUE, MapColor.COLOR_BLUE), "stripped_magic_log");
        stripped_magic_wood = registerBlock(new RotatedPillarBlock(AbstractBlock.Settings.of(Material.WOOD, MapColor.COLOR_BLUE).strength(2.0F).sounds(BlockSoundGroup.WOOD)), "stripped_magic_wood");
        magic_planks = registerBlock(new Block(AbstractBlock.Settings.of(Material.WOOD, MapColor.COLOR_BLUE).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)), "magic_planks");
        magic_stairs = registerBlock(new StairsBlockBOP(magic_planks.getDefaultState(), Block.Settings.copy(magic_planks)), "magic_stairs");
        magic_slab = registerBlock(new SlabBlock(AbstractBlock.Settings.of(Material.WOOD, MapColor.COLOR_BLUE).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)), "magic_slab");
        magic_fence = registerBlock(new FenceBlock(AbstractBlock.Settings.of(Material.WOOD, magic_planks.defaultMapColor()).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)), "magic_fence");
        magic_fence_gate = registerBlock(new FenceGateBlock(AbstractBlock.Settings.of(Material.WOOD, magic_planks.defaultMapColor()).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)), "magic_fence_gate");
        magic_door = registerBlock(new DoorBlock(AbstractBlock.Settings.of(Material.WOOD, magic_planks.defaultMapColor()).strength(3.0F).sounds(BlockSoundGroup.WOOD).noOcclusion()), "magic_door");
        magic_trapdoor = registerBlock(new TrapDoorBlock(AbstractBlock.Settings.of(Material.WOOD, MapColor.COLOR_BLUE).strength(3.0F).sounds(BlockSoundGroup.WOOD).noOcclusion()), "magic_trapdoor");
        magic_pressure_plate = registerBlock(new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, AbstractBlock.Settings.of(Material.WOOD, magic_planks.defaultMapColor()).noCollission().strength(0.5F).sounds(BlockSoundGroup.WOOD)), "magic_pressure_plate");
        magic_button = registerBlock(new WoodButtonBlock(AbstractBlock.Settings.of(Material.DECORATION).noCollission().strength(0.5F).sounds(BlockSoundGroup.WOOD)), "magic_button");
        
        umbran_sapling = registerBlock(new SaplingBlockBOP(new UmbranTree(), AbstractBlock.Settings.of(Material.PLANT).noCollission().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS)), "umbran_sapling");
        umbran_leaves = registerBlock(new LeavesBlock(AbstractBlock.Settings.of(Material.LEAVES, MapColor.TERRACOTTA_BLUE).strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).noOcclusion()), "umbran_leaves");
        umbran_log = registerBlock(Blocks.log(MapColor.TERRACOTTA_BLUE, MapColor.TERRACOTTA_BLUE), "umbran_log");
        umbran_wood = registerBlock(new RotatedPillarBlock(AbstractBlock.Settings.of(Material.WOOD, MapColor.TERRACOTTA_BLUE).strength(2.0F).sounds(BlockSoundGroup.WOOD)), "umbran_wood");
        stripped_umbran_log = registerBlock(Blocks.log(MapColor.TERRACOTTA_BLUE, MapColor.TERRACOTTA_BLUE), "stripped_umbran_log");
        stripped_umbran_wood = registerBlock(new RotatedPillarBlock(AbstractBlock.Settings.of(Material.WOOD, MapColor.TERRACOTTA_BLUE).strength(2.0F).sounds(BlockSoundGroup.WOOD)), "stripped_umbran_wood");
        umbran_planks = registerBlock(new Block(AbstractBlock.Settings.of(Material.WOOD, MapColor.TERRACOTTA_BLUE).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)), "umbran_planks");
        umbran_stairs = registerBlock(new StairsBlockBOP(umbran_planks.getDefaultState(), Block.Settings.copy(umbran_planks)), "umbran_stairs");
        umbran_slab = registerBlock(new SlabBlock(AbstractBlock.Settings.of(Material.WOOD, MapColor.TERRACOTTA_BLUE).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)), "umbran_slab");
        umbran_fence = registerBlock(new FenceBlock(AbstractBlock.Settings.of(Material.WOOD, umbran_planks.defaultMapColor()).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)), "umbran_fence");
        umbran_fence_gate = registerBlock(new FenceGateBlock(AbstractBlock.Settings.of(Material.WOOD, umbran_planks.defaultMapColor()).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)), "umbran_fence_gate");
        umbran_door = registerBlock(new DoorBlock(AbstractBlock.Settings.of(Material.WOOD, umbran_planks.defaultMapColor()).strength(3.0F).sounds(BlockSoundGroup.WOOD).noOcclusion()), "umbran_door");
        umbran_trapdoor = registerBlock(new TrapDoorBlock(AbstractBlock.Settings.of(Material.WOOD, MapColor.TERRACOTTA_BLUE).strength(3.0F).sounds(BlockSoundGroup.WOOD).noOcclusion()), "umbran_trapdoor");
        umbran_pressure_plate = registerBlock(new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, AbstractBlock.Settings.of(Material.WOOD, umbran_planks.defaultMapColor()).noCollission().strength(0.5F).sounds(BlockSoundGroup.WOOD)), "umbran_pressure_plate");
        umbran_button = registerBlock(new WoodButtonBlock(AbstractBlock.Settings.of(Material.DECORATION).noCollission().strength(0.5F).sounds(BlockSoundGroup.WOOD)), "umbran_button");
        
        hellbark_sapling = registerBlock(new SaplingBlockBOP(new HellbarkTree(), AbstractBlock.Settings.of(Material.PLANT).noCollission().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS)), "hellbark_sapling");
        hellbark_leaves = registerBlock(new LeavesBlock(AbstractBlock.Settings.of(Material.LEAVES, MapColor.TERRACOTTA_PURPLE).strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).noOcclusion()), "hellbark_leaves");
        hellbark_log = registerBlock(Blocks.log(MapColor.TERRACOTTA_GRAY, MapColor.COLOR_LIGHT_GRAY), "hellbark_log");
        hellbark_wood = registerBlock(new RotatedPillarBlock(AbstractBlock.Settings.of(Material.WOOD, MapColor.TERRACOTTA_GRAY).strength(2.0F).sounds(BlockSoundGroup.WOOD)), "hellbark_wood");
        stripped_hellbark_log = registerBlock(Blocks.log(MapColor.TERRACOTTA_GRAY, MapColor.TERRACOTTA_GRAY), "stripped_hellbark_log");
        stripped_hellbark_wood = registerBlock(new RotatedPillarBlock(AbstractBlock.Settings.of(Material.WOOD, MapColor.TERRACOTTA_GRAY).strength(2.0F).sounds(BlockSoundGroup.WOOD)), "stripped_hellbark_wood");
        hellbark_planks = registerBlock(new Block(AbstractBlock.Settings.of(Material.WOOD, MapColor.TERRACOTTA_GRAY).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)), "hellbark_planks");
        hellbark_stairs = registerBlock(new StairsBlockBOP(hellbark_planks.getDefaultState(), Block.Settings.copy(hellbark_planks)), "hellbark_stairs");
        hellbark_slab = registerBlock(new SlabBlock(AbstractBlock.Settings.of(Material.WOOD, MapColor.TERRACOTTA_GRAY).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)), "hellbark_slab");
        hellbark_fence = registerBlock(new FenceBlock(AbstractBlock.Settings.of(Material.WOOD, hellbark_planks.defaultMapColor()).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)), "hellbark_fence");
        hellbark_fence_gate = registerBlock(new FenceGateBlock(AbstractBlock.Settings.of(Material.WOOD, hellbark_planks.defaultMapColor()).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)), "hellbark_fence_gate");
        hellbark_door = registerBlock(new DoorBlock(AbstractBlock.Settings.of(Material.WOOD, hellbark_planks.defaultMapColor()).strength(3.0F).sounds(BlockSoundGroup.WOOD).noOcclusion()), "hellbark_door");
        hellbark_trapdoor = registerBlock(new TrapDoorBlock(AbstractBlock.Settings.of(Material.WOOD, MapColor.TERRACOTTA_GRAY).strength(3.0F).sounds(BlockSoundGroup.WOOD).noOcclusion()), "hellbark_trapdoor");
        hellbark_pressure_plate = registerBlock(new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, AbstractBlock.Settings.of(Material.WOOD, hellbark_planks.defaultMapColor()).noCollission().strength(0.5F).sounds(BlockSoundGroup.WOOD)), "hellbark_pressure_plate");
        hellbark_button = registerBlock(new WoodButtonBlock(AbstractBlock.Settings.of(Material.DECORATION).noCollission().strength(0.5F).sounds(BlockSoundGroup.WOOD)), "hellbark_button");

        //Flowers
        rose = registerBlock(new FlowerBlockBOP(Effects.MOVEMENT_SPEED, 7, AbstractBlock.Settings.of(Material.PLANT).noCollission().breakInstantly().sounds(BlockSoundGroup.GRASS)), "rose");
        violet = registerBlock(new FlowerBlockBOP(Effects.CONFUSION, 10, AbstractBlock.Settings.of(Material.PLANT).noCollission().breakInstantly().sounds(BlockSoundGroup.GRASS)), "violet");
        lavender = registerBlock(new FlowerBlockBOP(Effects.HEALTH_BOOST, 5, AbstractBlock.Settings.of(Material.PLANT, MapColor.COLOR_MAGENTA).noCollission().breakInstantly().sounds(BlockSoundGroup.GRASS)), "lavender");
        wildflower = registerBlock(new FlowerBlockBOP(Effects.HUNGER, 10, AbstractBlock.Settings.of(Material.PLANT).noCollission().breakInstantly().sounds(BlockSoundGroup.GRASS)), "wildflower");
        orange_cosmos = registerBlock(new FlowerBlockBOP(Effects.ABSORPTION, 7, AbstractBlock.Settings.of(Material.PLANT).noCollission().breakInstantly().sounds(BlockSoundGroup.GRASS)), "orange_cosmos");
        pink_daffodil = registerBlock(new FlowerBlockBOP(Effects.INVISIBILITY, 7, AbstractBlock.Settings.of(Material.PLANT).noCollission().breakInstantly().sounds(BlockSoundGroup.GRASS)), "pink_daffodil");
        pink_hibiscus = registerBlock(new FlowerBlockBOP(Effects.REGENERATION, 5, AbstractBlock.Settings.of(Material.PLANT).noCollission().breakInstantly().sounds(BlockSoundGroup.GRASS)), "pink_hibiscus");
        glowflower = registerBlock(new FlowerBlockBOP(Effects.GLOWING, 10, AbstractBlock.Settings.of(Material.PLANT).noCollission().breakInstantly().sounds(BlockSoundGroup.GRASS).lightLevel((state) -> 9)), "glowflower");
        wilted_lily = registerBlock(new FlowerBlockBOP(Effects.UNLUCK, 5, AbstractBlock.Settings.of(Material.PLANT).noCollission().breakInstantly().sounds(BlockSoundGroup.GRASS)), "wilted_lily");
        burning_blossom = registerBlock(new FlowerBlockBOP(Effects.FIRE_RESISTANCE, 7, AbstractBlock.Settings.of(Material.PLANT).noCollission().breakInstantly().sounds(BlockSoundGroup.GRASS).lightLevel((state) -> 7)), "burning_blossom");

        //Tall Flowers
        blue_hydrangea = registerBlock(new TallFlowerBlockBOP(AbstractBlock.Settings.of(Material.PLANT).noCollission().breakInstantly().sounds(BlockSoundGroup.GRASS)), "blue_hydrangea");
        goldenrod = registerBlock(new TallFlowerBlockBOP(AbstractBlock.Settings.of(Material.PLANT).noCollission().breakInstantly().sounds(BlockSoundGroup.GRASS)), "goldenrod");

        //Vines
        willow_vine = registerBlock(new VineBlock(AbstractBlock.Settings.of(Material.REPLACEABLE_PLANT).ticksRandomly().noCollission().strength(0.2F).sounds(BlockSoundGroup.GRASS)), "willow_vine");
        spanish_moss = registerBlock(new SpanishMossBottomBlock(AbstractBlock.Settings.of(Material.REPLACEABLE_PLANT).ticksRandomly().noCollission().breakInstantly().sounds(BlockSoundGroup.GRASS)), "spanish_moss");
        spanish_moss_plant = registerBlockNoGroup(new SpanishMossBlock(AbstractBlock.Settings.of(Material.REPLACEABLE_PLANT).noCollission().breakInstantly().sounds(BlockSoundGroup.GRASS)), "spanish_moss_plant");

        //Plants
        sprout = registerBlock(new FoliageBlockBOP(AbstractBlock.Settings.of(Material.REPLACEABLE_PLANT).noCollission().breakInstantly().sounds(BlockSoundGroup.GRASS)), "sprout");
        bush = registerBlock(new FoliageBlockBOP(AbstractBlock.Settings.of(Material.REPLACEABLE_PLANT).noCollission().breakInstantly().sounds(BlockSoundGroup.GRASS)), "bush");
        clover = registerBlock(new FoliageBlockBOP(AbstractBlock.Settings.of(Material.REPLACEABLE_PLANT).noCollission().breakInstantly().sounds(BlockSoundGroup.GRASS)), "clover");
        huge_clover_petal = registerBlock(new HugeCloverPetalBlock(AbstractBlock.Settings.of(Material.PLANT).strength(0.2F).sounds(BlockSoundGroup.GRASS)), "huge_clover_petal");
        dune_grass = registerBlock(new FoliageBlockBOP(AbstractBlock.Settings.of(Material.REPLACEABLE_PLANT, MapColor.TERRACOTTA_LIGHT_GREEN).noCollission().breakInstantly().sounds(BlockSoundGroup.GRASS)), "dune_grass");
        desert_grass = registerBlock(new FoliageBlockBOP(AbstractBlock.Settings.of(Material.REPLACEABLE_PLANT, MapColor.TERRACOTTA_ORANGE).noCollission().breakInstantly().sounds(BlockSoundGroup.GRASS)), "desert_grass");
        dead_grass = registerBlock(new FoliageBlockBOP(AbstractBlock.Settings.of(Material.REPLACEABLE_PLANT, MapColor.WOOD).noCollission().breakInstantly().sounds(BlockSoundGroup.GRASS)), "dead_grass");

        //Tall Plants
        cattail = registerBlock(new DoubleWatersidePlantBlock(AbstractBlock.Settings.of(Material.PLANT, MapColor.DIRT).noCollission().breakInstantly().sounds(BlockSoundGroup.GRASS)), "cattail");
        barley = registerBlock(new DoublePlantBlockBOP(AbstractBlock.Settings.of(Material.PLANT, MapColor.TERRACOTTA_YELLOW).noCollission().breakInstantly().sounds(BlockSoundGroup.GRASS)), "barley");
        reed = registerBlock(new DoubleWaterPlantBlock(AbstractBlock.Settings.of(Material.REPLACEABLE_WATER_PLANT, MapColor.DIRT).noCollission().breakInstantly().sounds(BlockSoundGroup.GRASS)), "reed");
        watergrass = registerBlock(new DoubleWaterPlantBlock(AbstractBlock.Settings.of(Material.REPLACEABLE_WATER_PLANT).noCollission().breakInstantly().sounds(BlockSoundGroup.GRASS)), "watergrass");
        mangrove_root = registerBlock(new DoubleWaterPlantBlock(AbstractBlock.Settings.of(Material.WATER_PLANT, MapColor.TERRACOTTA_WHITE).noCollission().strength(1.0F, 1.5F).sounds(BlockSoundGroup.WOOD)), "mangrove_root");

        dead_branch = registerBlock(new DeadBranchBlock(AbstractBlock.Settings.of(Material.WOOD, MapColor.COLOR_GRAY).noCollission().breakInstantly().sounds(BlockSoundGroup.WOOD)), "dead_branch");
        bramble = registerBlock(new BrambleBlock(AbstractBlock.Settings.of(Material.PLANT, MapColor.NETHER).strength(0.4F).harvestLevel(0).harvestTool(ToolType.AXE).sounds(BlockSoundGroup.WOOD)), "bramble");
        toadstool = registerBlock(new MushroomBlockBOP(AbstractBlock.Settings.of(Material.PLANT, MapColor.ORANGE).noCollission().breakInstantly().sounds(BlockSoundGroup.GRASS)), "toadstool");
        glowshroom = registerBlock(new MushroomBlockBOP(AbstractBlock.Settings.of(Material.PLANT, MapColor.DIAMOND).noCollission().breakInstantly().sounds(BlockSoundGroup.GRASS).lightLevel((state) -> 6)), "glowshroom");

        //Potted Plants
        potted_origin_sapling = registerBlockNoGroup(new FlowerPotBlock(origin_sapling, AbstractBlock.Settings.of(Material.DECORATION).breakInstantly()), "potted_origin_sapling");
        potted_flowering_oak_sapling = registerBlockNoGroup(new FlowerPotBlock(flowering_oak_sapling, AbstractBlock.Settings.of(Material.DECORATION).breakInstantly()), "potted_flowering_oak_sapling");
        potted_rainbow_birch_sapling = registerBlockNoGroup(new FlowerPotBlock(rainbow_birch_sapling, AbstractBlock.Settings.of(Material.DECORATION).breakInstantly()), "potted_rainbow_birch_sapling");
        potted_yellow_autumn_sapling = registerBlockNoGroup(new FlowerPotBlock(yellow_autumn_sapling, AbstractBlock.Settings.of(Material.DECORATION).breakInstantly()), "potted_yellow_autumn_sapling");
        potted_orange_autumn_sapling = registerBlockNoGroup(new FlowerPotBlock(orange_autumn_sapling, AbstractBlock.Settings.of(Material.DECORATION).breakInstantly()), "potted_orange_autumn_sapling");
        potted_maple_sapling = registerBlockNoGroup(new FlowerPotBlock(maple_sapling, AbstractBlock.Settings.of(Material.DECORATION).breakInstantly()), "potted_maple_sapling");
        potted_fir_sapling = registerBlockNoGroup(new FlowerPotBlock(fir_sapling, AbstractBlock.Settings.of(Material.DECORATION).breakInstantly()), "potted_fir_sapling");
        potted_redwood_sapling = registerBlockNoGroup(new FlowerPotBlock(redwood_sapling, AbstractBlock.Settings.of(Material.DECORATION).breakInstantly()), "potted_redwood_sapling");
        potted_white_cherry_sapling = registerBlockNoGroup(new FlowerPotBlock(white_cherry_sapling, AbstractBlock.Settings.of(Material.DECORATION).breakInstantly()), "potted_white_cherry_sapling");
        potted_pink_cherry_sapling = registerBlockNoGroup(new FlowerPotBlock(pink_cherry_sapling, AbstractBlock.Settings.of(Material.DECORATION).breakInstantly()), "potted_pink_cherry_sapling");
        potted_mahogany_sapling = registerBlockNoGroup(new FlowerPotBlock(mahogany_sapling, AbstractBlock.Settings.of(Material.DECORATION).breakInstantly()), "potted_mahogany_sapling");
        potted_jacaranda_sapling = registerBlockNoGroup(new FlowerPotBlock(jacaranda_sapling, AbstractBlock.Settings.of(Material.DECORATION).breakInstantly()), "potted_jacaranda_sapling");
        potted_palm_sapling = registerBlockNoGroup(new FlowerPotBlock(palm_sapling, AbstractBlock.Settings.of(Material.DECORATION).breakInstantly()), "potted_palm_sapling");
        potted_willow_sapling = registerBlockNoGroup(new FlowerPotBlock(willow_sapling, AbstractBlock.Settings.of(Material.DECORATION).breakInstantly()), "potted_willow_sapling");
        potted_dead_sapling = registerBlockNoGroup(new FlowerPotBlock(dead_sapling, AbstractBlock.Settings.of(Material.DECORATION).breakInstantly()), "potted_dead_sapling");
        potted_magic_sapling = registerBlockNoGroup(new FlowerPotBlock(magic_sapling, AbstractBlock.Settings.of(Material.DECORATION).breakInstantly()), "potted_magic_sapling");
        potted_umbran_sapling = registerBlockNoGroup(new FlowerPotBlock(umbran_sapling, AbstractBlock.Settings.of(Material.DECORATION).breakInstantly()), "potted_umbran_sapling");
        potted_hellbark_sapling = registerBlockNoGroup(new FlowerPotBlock(hellbark_sapling, AbstractBlock.Settings.of(Material.DECORATION).breakInstantly()), "potted_hellbark_sapling");
        potted_rose = registerBlockNoGroup(new FlowerPotBlock(rose, AbstractBlock.Settings.of(Material.DECORATION).breakInstantly()), "potted_rose");
        potted_violet = registerBlockNoGroup(new FlowerPotBlock(violet, AbstractBlock.Settings.of(Material.DECORATION).breakInstantly()), "potted_violet");
        potted_lavender = registerBlockNoGroup(new FlowerPotBlock(lavender, AbstractBlock.Settings.of(Material.DECORATION).breakInstantly()), "potted_lavender");
        potted_wildflower = registerBlockNoGroup(new FlowerPotBlock(wildflower, AbstractBlock.Settings.of(Material.DECORATION).breakInstantly()), "potted_wildflower");
        potted_orange_cosmos = registerBlockNoGroup(new FlowerPotBlock(orange_cosmos, AbstractBlock.Settings.of(Material.DECORATION).breakInstantly()), "potted_orange_cosmos");
        potted_pink_daffodil = registerBlockNoGroup(new FlowerPotBlock(pink_daffodil, AbstractBlock.Settings.of(Material.DECORATION).breakInstantly()), "potted_pink_daffodil");
        potted_pink_hibiscus = registerBlockNoGroup(new FlowerPotBlock(pink_hibiscus, AbstractBlock.Settings.of(Material.DECORATION).breakInstantly()), "potted_pink_hibiscus");
        potted_glowflower = registerBlockNoGroup(new FlowerPotBlock(glowflower, AbstractBlock.Settings.of(Material.DECORATION).breakInstantly().lightLevel((state) -> 9)), "potted_glowflower");
        potted_wilted_lily = registerBlockNoGroup(new FlowerPotBlock(wilted_lily, AbstractBlock.Settings.of(Material.DECORATION).breakInstantly()), "potted_wilted_lily");
        potted_burning_blossom = registerBlockNoGroup(new FlowerPotBlock(burning_blossom, AbstractBlock.Settings.of(Material.DECORATION).breakInstantly().lightLevel((state) -> 7)), "potted_burning_blossom");
        potted_sprout = registerBlockNoGroup(new FlowerPotBlock(sprout, AbstractBlock.Settings.of(Material.DECORATION).breakInstantly()), "potted_sprout");
        potted_clover = registerBlockNoGroup(new FlowerPotBlock(clover, AbstractBlock.Settings.of(Material.DECORATION).breakInstantly()), "potted_clover");
        potted_toadstool = registerBlockNoGroup(new FlowerPotBlock(toadstool, AbstractBlock.Settings.of(Material.DECORATION).breakInstantly()), "potted_toadstool");
        potted_glowshroom = registerBlockNoGroup(new FlowerPotBlock(glowshroom, AbstractBlock.Settings.of(Material.DECORATION).breakInstantly().lightLevel((state) -> 6)), "potted_glowshroom");
        */
    }

    @Environment(EnvType.CLIENT)    
    public void renderBlockStuff()
        {
            RenderLayer transparentRenderType = RenderLayer.getCutoutMipped();
            RenderLayer cutoutRenderType = RenderLayer.getCutout();
            RenderLayer translucentRenderType = RenderLayer.getTranslucent();

            IndigoRenderer(origin_leaves, transparentRenderType);
            RenderTypeLookup.setRenderLayer(flowering_oak_leaves, transparentRenderType);
            RenderTypeLookup.setRenderLayer(rainbow_birch_leaves, transparentRenderType);
            RenderTypeLookup.setRenderLayer(yellow_autumn_leaves, transparentRenderType);
            RenderTypeLookup.setRenderLayer(orange_autumn_leaves, transparentRenderType);
            RenderTypeLookup.setRenderLayer(maple_leaves, transparentRenderType);
            RenderTypeLookup.setRenderLayer(fir_leaves, transparentRenderType);
            RenderTypeLookup.setRenderLayer(redwood_leaves, transparentRenderType);
            RenderTypeLookup.setRenderLayer(white_cherry_leaves, transparentRenderType);
            RenderTypeLookup.setRenderLayer(pink_cherry_leaves, transparentRenderType);
            RenderTypeLookup.setRenderLayer(mahogany_leaves, transparentRenderType);
            RenderTypeLookup.setRenderLayer(jacaranda_leaves, transparentRenderType);
            RenderTypeLookup.setRenderLayer(palm_leaves, transparentRenderType);
            RenderTypeLookup.setRenderLayer(willow_leaves, transparentRenderType);
            RenderTypeLookup.setRenderLayer(dead_leaves, transparentRenderType);
            RenderTypeLookup.setRenderLayer(magic_leaves, transparentRenderType);
            RenderTypeLookup.setRenderLayer(umbran_leaves, transparentRenderType);
            RenderTypeLookup.setRenderLayer(hellbark_leaves, transparentRenderType);

            RenderTypeLookup.setRenderLayer(nether_crystal, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(origin_sapling, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(flowering_oak_sapling, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(rainbow_birch_sapling, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(yellow_autumn_sapling, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(orange_autumn_sapling, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(maple_sapling, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(fir_sapling, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(redwood_sapling, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(white_cherry_sapling, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(pink_cherry_sapling, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(mahogany_sapling, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(jacaranda_sapling, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(palm_sapling, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(willow_sapling, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(dead_sapling, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(magic_sapling, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(umbran_sapling, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(hellbark_sapling, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(rose, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(violet, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(lavender, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(wildflower, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(orange_cosmos, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(pink_daffodil, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(pink_hibiscus, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(glowflower, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(wilted_lily, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(burning_blossom, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(blue_hydrangea, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(goldenrod, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(willow_vine, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(spanish_moss, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(spanish_moss_plant, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(sprout, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(bush, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(clover, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(huge_clover_petal, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(dune_grass, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(desert_grass, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(dead_grass, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(cattail, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(barley, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(reed, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(watergrass, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(mangrove_root, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(dead_branch, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(bramble, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(toadstool, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(glowshroom, cutoutRenderType);

            RenderTypeLookup.setRenderLayer(potted_origin_sapling, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(potted_flowering_oak_sapling, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(potted_rainbow_birch_sapling, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(potted_yellow_autumn_sapling, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(potted_orange_autumn_sapling, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(potted_maple_sapling, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(potted_fir_sapling, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(potted_redwood_sapling, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(potted_white_cherry_sapling, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(potted_pink_cherry_sapling, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(potted_mahogany_sapling, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(potted_jacaranda_sapling, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(potted_palm_sapling, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(potted_willow_sapling, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(potted_dead_sapling, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(potted_magic_sapling, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(potted_umbran_sapling, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(potted_hellbark_sapling, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(potted_rose, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(potted_violet, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(potted_lavender, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(potted_wildflower, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(potted_orange_cosmos, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(potted_pink_daffodil, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(potted_pink_hibiscus, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(potted_glowflower, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(potted_wilted_lily, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(potted_burning_blossom, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(potted_sprout, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(potted_clover, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(potted_toadstool, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(potted_glowshroom, cutoutRenderType);

            RenderTypeLookup.setRenderLayer(fir_door, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(redwood_door, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(cherry_door, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(mahogany_door, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(jacaranda_door, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(palm_door, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(willow_door, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(dead_door, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(magic_door, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(umbran_door, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(hellbark_door, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(fir_trapdoor, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(redwood_trapdoor, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(cherry_trapdoor, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(mahogany_trapdoor, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(jacaranda_trapdoor, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(palm_trapdoor, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(willow_trapdoor, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(dead_trapdoor, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(magic_trapdoor, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(umbran_trapdoor, cutoutRenderType);
            RenderTypeLookup.setRenderLayer(hellbark_trapdoor, cutoutRenderType);
        }

    public static Block registerBlock(Block block, String name)
    {
        BlockItem itemBlock = new BlockItem(block, new Item.Settings().group(ItemGroupBOP.ItemGroupBOP));
               Registry.register(Registry.ITEM,  new Identifier("biomesoplenty", name), itemBlock);
        return Registry.register(Registry.BLOCK, new Identifier("biomesoplenty", name), block);
    }

    public static Block registerBlockNoGroup(Block block, String name)
    {
        BlockItem itemBlock = new BlockItem(block, new Item.Settings().group(null));
               Registry.register(Registry.ITEM,  new Identifier("biomesoplenty", name), itemBlock);
        return Registry.register(Registry.BLOCK, new Identifier("biomesoplenty", name), block);
    }
    
    public static Block registerBlock(Block block, BlockItem itemBlock, String name) {
        if (itemBlock != null) {
            Registry.register(Registry.ITEM,  new Identifier("biomesoplenty", name), itemBlock);
            Registry.register(Registry.BLOCK, new Identifier("biomesoplenty", name), block);
        }

        return block;
    }
}
