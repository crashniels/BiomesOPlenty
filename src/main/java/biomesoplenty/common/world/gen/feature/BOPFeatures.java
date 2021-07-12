/*******************************************************************************
 * Copyright 2014-2019, the Biomes O' Plenty Team
 *
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 *
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/
package biomesoplenty.common.world.gen.feature;

import biomesoplenty.api.block.BOPBlocks;
import biomesoplenty.common.world.gen.feature.tree.*;
import biomesoplenty.core.BiomesOPlenty;
import com.google.common.collect.ImmutableSet;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.SaplingBlock;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placer.SimpleBlockPlacer;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;

public class BOPFeatures
{
	//Standard Trees
	public static final Feature<TreeFeatureConfig> ORIGIN_TREE = register("origin_tree", new BasicTreeFeature.Builder().leaves(BOPBlocks.origin_leaves.getDefaultState()).minHeight(5).maxHeight(8).create());
	public static final Feature<TreeFeatureConfig> FLOWERING_OAK_TREE = register("flowering_oak_tree", new BasicTreeFeature.Builder().altLeaves(BOPBlocks.flowering_oak_leaves.getDefaultState()).create());
	public static final Feature<TreeFeatureConfig> RAINBOW_BIRCH_TREE = register("rainbow_birch_tree", new BasicTreeFeature.Builder().log(Blocks.BIRCH_LOG.getDefaultState()).leaves(BOPBlocks.rainbow_birch_leaves.getDefaultState()).create());
	public static final Feature<TreeFeatureConfig> YELLOW_AUTUMN_TREE = register("yellow_autumn_tree", new BasicTreeFeature.Builder().log(Blocks.BIRCH_LOG.getDefaultState()).leaves(BOPBlocks.yellow_autumn_leaves.getDefaultState()).minHeight(5).maxHeight(8).create());
	public static final Feature<TreeFeatureConfig> ORANGE_AUTUMN_TREE = register("orange_autumn_tree", new BasicTreeFeature.Builder().log(Blocks.DARK_OAK_LOG.getDefaultState()).leaves(BOPBlocks.orange_autumn_leaves.getDefaultState()).minHeight(5).maxHeight(8).create());
	public static final Feature<TreeFeatureConfig> MAPLE_TREE = register("maple_tree", new BasicTreeFeature.Builder().leaves(BOPBlocks.maple_leaves.getDefaultState()).minHeight(5).maxHeight(10).create());
	public static final Feature<TreeFeatureConfig> PINK_CHERRY_TREE = register("pink_cherry_tree", new BasicTreeFeature.Builder().log(BOPBlocks.cherry_log.getDefaultState()).leaves(BOPBlocks.pink_cherry_leaves.getDefaultState()).create());
	public static final Feature<TreeFeatureConfig> WHITE_CHERRY_TREE = register("white_cherry_tree", new BasicTreeFeature.Builder().log(BOPBlocks.cherry_log.getDefaultState()).leaves(BOPBlocks.white_cherry_leaves.getDefaultState()).create());
	public static final Feature<TreeFeatureConfig> JACARANDA_TREE = register("jacaranda_tree", new BasicTreeFeature.Builder().log(BOPBlocks.jacaranda_log.getDefaultState()).leaves(BOPBlocks.jacaranda_leaves.getDefaultState()).create());
	public static final Feature<TreeFeatureConfig> SMALL_DEAD_TREE = register("small_dead_tree", new BasicTreeFeature.Builder().log(BOPBlocks.dead_log.getDefaultState()).leaves(BOPBlocks.dead_leaves.getDefaultState()).create());
	public static final Feature<TreeFeatureConfig> MAGIC_TREE = register("magic_tree", new PoplarTreeFeature.Builder().log(BOPBlocks.magic_log.getDefaultState()).leaves(BOPBlocks.magic_leaves.getDefaultState()).minHeight(8).maxHeight(12).create());
	
	//Big Trees
	public static final Feature<TreeFeatureConfig> BIG_OAK_TREE = register("big_oak_tree", new BigTreeFeature.Builder().create());
	public static final Feature<TreeFeatureConfig> BIG_ORIGIN_TREE = register("big_origin_tree", new BigTreeFeature.Builder().leaves(BOPBlocks.origin_leaves.getDefaultState()).create());
	public static final Feature<TreeFeatureConfig> BIG_FLOWERING_OAK_TREE = register("big_flowering_oak_tree", new BigTreeFeature.Builder().altLeaves(BOPBlocks.flowering_oak_leaves.getDefaultState()).create());
	public static final Feature<TreeFeatureConfig> BIG_RAINBOW_BIRCH_TREE = register("big_rainbow_birch_tree", new BigTreeFeature.Builder().log(Blocks.BIRCH_LOG.getDefaultState()).leaves(BOPBlocks.rainbow_birch_leaves.getDefaultState()).create());
	public static final Feature<TreeFeatureConfig> BIG_YELLOW_AUTUMN_TREE = register("big_yellow_autumn_tree", new BigTreeFeature.Builder().log(Blocks.BIRCH_LOG.getDefaultState()).leaves(BOPBlocks.yellow_autumn_leaves.getDefaultState()).create());
	public static final Feature<TreeFeatureConfig> BIG_ORANGE_AUTUMN_TREE = register("big_orange_autumn_tree", new BigTreeFeature.Builder().log(Blocks.DARK_OAK_LOG.getDefaultState()).leaves(BOPBlocks.orange_autumn_leaves.getDefaultState()).create());
	public static final Feature<TreeFeatureConfig> BIG_MAPLE_TREE = register("big_maple_tree", new BigTreeFeature.Builder().leaves(BOPBlocks.maple_leaves.getDefaultState()).create());
	public static final Feature<TreeFeatureConfig> BIG_PINK_CHERRY_TREE = register("big_pink_cherry_tree", new BigTreeFeature.Builder().log(BOPBlocks.cherry_log.getDefaultState()).leaves(BOPBlocks.pink_cherry_leaves.getDefaultState()).create());
	public static final Feature<TreeFeatureConfig> BIG_WHITE_CHERRY_TREE = register("big_white_cherry_tree", new BigTreeFeature.Builder().log(BOPBlocks.cherry_log.getDefaultState()).leaves(BOPBlocks.white_cherry_leaves.getDefaultState()).create());
	public static final Feature<TreeFeatureConfig> BIG_JACARANDA_TREE = register("big_jacaranda_tree", new BigTreeFeature.Builder().log(BOPBlocks.jacaranda_log.getDefaultState()).leaves(BOPBlocks.jacaranda_leaves.getDefaultState()).create());
	public static final Feature<TreeFeatureConfig> BIG_MAGIC_TREE = register("big_magic_tree", new PoplarTreeFeature.Builder().log(BOPBlocks.magic_log.getDefaultState()).leaves(BOPBlocks.magic_leaves.getDefaultState()).minHeight(16).maxHeight(20).create());

	public static final Feature<TreeFeatureConfig> GIANT_TREE = register("giant_tree", new BigTreeFeature.Builder().log(Blocks.DARK_OAK_LOG.getDefaultState()).leaves(Blocks.DARK_OAK_LEAVES.getDefaultState().with(LeavesBlock.PERSISTENT, true)).minHeight(15).maxHeight(20).trunkWidth(4).create());

	//Conifer Trees
	public static final Feature<TreeFeatureConfig> TALL_SPRUCE_TREE = register("tall_spruce_tree", new TaigaTreeFeature.Builder().log(Blocks.SPRUCE_LOG.getDefaultState()).leaves(Blocks.SPRUCE_LEAVES.getDefaultState()).maxHeight(13).create());
	public static final Feature<TreeFeatureConfig> ALPS_SPRUCE_TREE = register("alps_spruce_tree", new TaigaTreeFeature.Builder().placeOn((world, pos) -> world.getBlockState(pos).getBlock() == Blocks.STONE).log(Blocks.SPRUCE_LOG.getDefaultState()).leaves(Blocks.SPRUCE_LEAVES.getDefaultState()).maxHeight(13).create());
	public static final Feature<TreeFeatureConfig> FIR_TREE_SMALL = register("fir_tree_small", new TaigaTreeFeature.Builder().log(BOPBlocks.fir_log.getDefaultState()).leaves(BOPBlocks.fir_leaves.getDefaultState()).minHeight(5).maxHeight(11).create());
	public static final Feature<TreeFeatureConfig> FIR_TREE = register("fir_tree", new TaigaTreeFeature.Builder().log(BOPBlocks.fir_log.getDefaultState()).leaves(BOPBlocks.fir_leaves.getDefaultState()).minHeight(5).maxHeight(28).create());
	public static final Feature<TreeFeatureConfig> FIR_TREE_LARGE = register("fir_tree_large", new TaigaTreeFeature.Builder().log(BOPBlocks.fir_log.getDefaultState()).leaves(BOPBlocks.fir_leaves.getDefaultState()).minHeight(20).maxHeight(40).trunkWidth(2).create());
	public static final Feature<TreeFeatureConfig> UMBRAN_TREE = register("umbran_tree", new TaigaTreeFeature.Builder().log(BOPBlocks.umbran_log.getDefaultState()).leaves(BOPBlocks.umbran_leaves.getDefaultState()).maxHeight(20).create());
	public static final Feature<TreeFeatureConfig> TALL_UMBRAN_TREE = register("tall_umbran_tree", new TaigaTreeFeature.Builder().log(BOPBlocks.umbran_log.getDefaultState()).leaves(BOPBlocks.umbran_leaves.getDefaultState()).minHeight(20).maxHeight(30).trunkWidth(2).create());

	//Poplar Trees
	public static final Feature<TreeFeatureConfig> SPRUCE_POPLAR = register("spruce_poplar", new PoplarTreeFeature.Builder().log(Blocks.SPRUCE_LOG.getDefaultState()).leaves(Blocks.SPRUCE_LEAVES.getDefaultState()).create());
	public static final Feature<TreeFeatureConfig> DARK_OAK_POPLAR = register("dark_oak_poplar", new PoplarTreeFeature.Builder().log(Blocks.DARK_OAK_LOG.getDefaultState()).leaves(Blocks.DARK_OAK_LEAVES.getDefaultState()).create());

	//Swamp Trees
	public static final Feature<TreeFeatureConfig> CYPRESS_TREE = register("cypress_tree", new CypressTreeFeature.Builder().create());
	public static final Feature<TreeFeatureConfig> CYPRESS_TREE_MEDIUM = register("cypress_tree_medium", new CypressTreeFeature.Builder().minHeight(15).maxHeight(25).trunkWidth(2).create());
	public static final Feature<TreeFeatureConfig> TALL_SWAMP_TREE = register("tall_swamp_tree", new BasicTreeFeature.Builder().vine(Blocks.VINE.getDefaultState()).minHeight(8).maxHeight(12).maxLeavesRadius(2).leavesOffset(0).create());
	public static final Feature<TreeFeatureConfig> WILLOW_TREE = register("willow_tree", new BasicTreeFeature.Builder().log(BOPBlocks.willow_log.getDefaultState()).leaves(BOPBlocks.willow_leaves.getDefaultState()).vine(BOPBlocks.willow_vine.getDefaultState()).minHeight(6).maxHeight(10).maxLeavesRadius(2).leavesOffset(0).create());

	//Sparse Trees
	public static final Feature<TreeFeatureConfig> SPARSE_ACACIA_TREE = register("sparse_acacia_tree", new BigTreeFeature.Builder().placeOn((world, pos) -> world.getBlockState(pos).getBlock() == BOPBlocks.orange_sand).log(Blocks.ACACIA_LOG.getDefaultState()).leaves(Blocks.ACACIA_LEAVES.getDefaultState()).maxHeight(8).foliageHeight(1).create());
	public static final Feature<TreeFeatureConfig> SPARSE_OAK_TREE = register("sparse_oak_tree", new BigTreeFeature.Builder().maxHeight(10).foliageHeight(2).create());
	public static final Feature<TreeFeatureConfig> DYING_TREE = register("dying_tree", new BigTreeFeature.Builder().log(BOPBlocks.dead_log.getDefaultState()).leaves(BOPBlocks.dead_leaves.getDefaultState()).maxHeight(10).foliageHeight(2).create());
	public static final Feature<TreeFeatureConfig> DYING_TREE_WASTELAND = register("dying_tree_wasteland", new BigTreeFeature.Builder().placeOn((world, pos) -> world.getBlockState(pos).getBlock() == BOPBlocks.dried_salt).log(BOPBlocks.dead_log.getDefaultState()).leaves(BOPBlocks.dead_leaves.getDefaultState()).maxHeight(10).foliageHeight(1).create());

	//Bushes/Twiglets
	public static final Feature<TreeFeatureConfig> BUSH = register("bush", new BushTreeFeature.Builder().create());
	public static final Feature<TreeFeatureConfig> SPRUCE_BUSH = register("spruce_bush", new BushTreeFeature.Builder().log(Blocks.SPRUCE_LOG.getDefaultState()).leaves(Blocks.SPRUCE_LEAVES.getDefaultState()).create());
	public static final Feature<TreeFeatureConfig> ACACIA_BUSH = register("acacia_bush", new BushTreeFeature.Builder().placeOn((world, pos) -> world.getBlockState(pos).getBlock() == BOPBlocks.orange_sand).log(Blocks.ACACIA_LOG.getDefaultState()).leaves(Blocks.ACACIA_LEAVES.getDefaultState()).create());
	public static final Feature<TreeFeatureConfig> FLOWERING_BUSH = register("flowering_bush", new BushTreeFeature.Builder().altLeaves(BOPBlocks.flowering_oak_leaves.getDefaultState()).create());
	public static final Feature<TreeFeatureConfig> HELLBARK_TREE = register("hellbark_tree", new BushTreeFeature.Builder().placeOn((world, pos) -> world.getBlockState(pos).getBlock() == Blocks.NETHERRACK /*|| world.getBlockState(pos).canSustainPlant(world, pos, Direction.UP, (SaplingBlock)Blocks.OAK_SAPLING)*/).log(BOPBlocks.hellbark_log.getDefaultState()).leaves(BOPBlocks.hellbark_leaves.getDefaultState()).create());

	public static final Feature<TreeFeatureConfig> TWIGLET_TREE = register("twiglet_tree", new TwigletTreeFeature.Builder().minHeight(1).maxHeight(2).create());
	public static final Feature<TreeFeatureConfig> TALL_TWIGLET_TREE = register("tall_twiglet_tree", new TwigletTreeFeature.Builder().minHeight(2).maxHeight(4).create());
	public static final Feature<TreeFeatureConfig> SPRUCE_TWIGLET_TREE = register("spruce_twiglet_tree", new TwigletTreeFeature.Builder().log(Blocks.SPRUCE_LOG.getDefaultState()).leaves(Blocks.SPRUCE_LEAVES.getDefaultState()).minHeight(1).maxHeight(2).create());
	public static final Feature<TreeFeatureConfig> JUNGLE_TWIGLET_TREE = register("jungle_twiglet_tree", new TwigletTreeFeature.Builder().log(Blocks.JUNGLE_LOG.getDefaultState()).leaves(Blocks.JUNGLE_LEAVES.getDefaultState()).minHeight(1).maxHeight(2).trunkFruit(Blocks.COCOA.getDefaultState()).create());
	public static final Feature<TreeFeatureConfig> DARK_OAK_TWIGLET_TREE = register("dark_oak_twiglet_tree", new TwigletTreeFeature.Builder().log(Blocks.DARK_OAK_LOG.getDefaultState()).leaves(Blocks.DARK_OAK_LEAVES.getDefaultState()).minHeight(1).maxHeight(2).create());
	public static final Feature<TreeFeatureConfig> ACACIA_TWIGLET_TREE = register("acacia_twiglet_tree", new TwigletTreeFeature.Builder().placeOn((world, pos) -> world.getBlockState(pos).getBlock() == Blocks.RED_SAND).log(Blocks.ACACIA_LOG.getDefaultState()).leaves(Blocks.ACACIA_LEAVES.getDefaultState()).create());
	public static final Feature<TreeFeatureConfig> ACACIA_TWIGLET_SMALL = register("acacia_twiglet_small", new TwigletTreeFeature.Builder().placeOn((world, pos) -> world.getBlockState(pos).getBlock() == Blocks.SAND || world.getBlockState(pos).getBlock() == BOPBlocks.orange_sand).log(Blocks.ACACIA_LOG.getDefaultState()).leaves(Blocks.ACACIA_LEAVES.getDefaultState()).minHeight(1).maxHeight(2).create());
	public static final Feature<TreeFeatureConfig> ACACIA_TWIGLET = register("acacia_twiglet", new TwigletTreeFeature.Builder().log(Blocks.ACACIA_LOG.getDefaultState()).leaves(Blocks.ACACIA_LEAVES.getDefaultState()).minHeight(1).maxHeight(2).create());
	public static final Feature<TreeFeatureConfig> MAPLE_TWIGLET_TREE = register("maple_twiglet_tree", new TwigletTreeFeature.Builder().minHeight(1).maxHeight(2).leaves(BOPBlocks.maple_leaves.getDefaultState()).create());
	public static final Feature<TreeFeatureConfig> DEAD_TWIGLET_TREE_SMALL = register("dead_twiglet_tree_small", new TwigletTreeFeature.Builder().minHeight(1).maxHeight(1).leaves(BOPBlocks.dead_leaves.getDefaultState()).log(BOPBlocks.dead_log.getDefaultState()).create());
	public static final Feature<TreeFeatureConfig> DEAD_TWIGLET_TREE = register("dead_twiglet_tree", new TwigletTreeFeature.Builder().trunkFruit(BOPBlocks.dead_branch.getDefaultState()).leafChance(0.05F, 0.25F).leaves(BOPBlocks.dead_leaves.getDefaultState()).log(BOPBlocks.dead_log.getDefaultState()).minHeight(6).maxHeight(10).create());
	public static final Feature<TreeFeatureConfig> DEAD_TWIGLET_TREE_TALL = register("dead_twiglet_tree_tall", new TwigletTreeFeature.Builder().trunkFruit(BOPBlocks.dead_branch.getDefaultState()).leafChance(0.15F, 0.6F).leaves(BOPBlocks.dead_leaves.getDefaultState()).log(BOPBlocks.dead_log.getDefaultState()).minHeight(12).maxHeight(18).create());
	public static final Feature<TreeFeatureConfig> TWIGLET_TREE_VOLCANO = register("twiglet_tree_volcano", new TwigletTreeFeature.Builder().placeOn((world, pos) -> world.getBlockState(pos).getBlock() == BOPBlocks.black_sand).log(Blocks.DARK_OAK_LOG.getDefaultState()).leaves(Blocks.DARK_OAK_LEAVES.getDefaultState()).minHeight(1).maxHeight(2).create());
	public static final Feature<TreeFeatureConfig> BIG_HELLBARK_TREE = register("big_hellbark_tree", new TwigletTreeFeature.Builder().placeOn((world, pos) -> world.getBlockState(pos).getBlock() == Blocks.NETHERRACK /*|| world.getBlockState(pos).canSustainPlant(world, pos, Direction.UP, (SaplingBlock)Blocks.OAK_SAPLING)*/).log(BOPBlocks.hellbark_log.getDefaultState()).leaves(BOPBlocks.hellbark_leaves.getDefaultState()).minHeight(3).maxHeight(7).create());

	//Special Trees
	public static final Feature<TreeFeatureConfig> REDWOOD_TREE = register("redwood_tree", new RedwoodTreeFeature.Builder().create());
	public static final Feature<TreeFeatureConfig> REDWOOD_TREE_MEDIUM = register("redwood_tree_medium", new RedwoodTreeFeature.Builder().minHeight(25).maxHeight(40).trunkWidth(2).create());
	public static final Feature<TreeFeatureConfig> REDWOOD_TREE_LARGE = register("redwood_tree_large", new RedwoodTreeFeature.Builder().minHeight(45).maxHeight(60).trunkWidth(3).create());
	public static final Feature<TreeFeatureConfig> MAHOGANY_TREE = register("mahogany_tree", new MahoganyTreeFeature.Builder().create());
	public static final Feature<TreeFeatureConfig> PALM_TREE = register("palm_tree", new PalmTreeFeature.Builder().create());
	public static final Feature<TreeFeatureConfig> DEAD_TREE = register("dead_tree", new TwigletTreeFeature.Builder().trunkFruit(BOPBlocks.dead_branch.getDefaultState()).leafChance(0.0F, 0.0F).leaves(Blocks.AIR.getDefaultState()).log(BOPBlocks.dead_log.getDefaultState()).minHeight(6).maxHeight(10).create());
	public static final Feature<TreeFeatureConfig> TALL_DEAD_TREE = register("tall_dead_tree", new TwigletTreeFeature.Builder().trunkFruit(BOPBlocks.dead_branch.getDefaultState()).leafChance(0.0F, 0.0F).leaves(Blocks.AIR.getDefaultState()).log(BOPBlocks.dead_log.getDefaultState()).minHeight(8).maxHeight(12).create());
	public static final Feature<TreeFeatureConfig> DEAD_TREE_WASTELAND = register("dead_tree_wasteland", new TwigletTreeFeature.Builder().placeOn((world, pos) -> world.getBlockState(pos).getBlock() == BOPBlocks.dried_salt).trunkFruit(BOPBlocks.dead_branch.getDefaultState()).leafChance(0.0F, 0.0F).leaves(Blocks.AIR.getDefaultState()).log(BOPBlocks.dead_log.getDefaultState()).minHeight(6).maxHeight(10).create());
	public static final Feature<TreeFeatureConfig> BURNT_TREE = register("burnt_tree", new TwigletTreeFeature.Builder().leafChance(0.0F, 0.0F).leaves(Blocks.AIR.getDefaultState()).log(BOPBlocks.stripped_hellbark_log.getDefaultState()).minHeight(3).maxHeight(5).create());

	/////////////////////////////////////////////////////////////////////////////////
	/*
	//Features
	public static final Feature<DefaultFeatureConfig> BIG_PUMPKIN = register("big_pumpkin", new BigPumpkinFeature(DefaultFeatureConfig.CODEC.stable()));
	public static final Feature<DefaultFeatureConfig> BLACK_SAND_SPLATTER = register("black_sand_splatter", new BlackSandSplatterFeature(DefaultFeatureConfig.CODEC.stable()));
	public static final Feature<DefaultFeatureConfig> BONE_SPINE = register("bone_spine", new BoneSpineFeature(DefaultFeatureConfig.CODEC.stable()));
	public static final Feature<DefaultFeatureConfig> BRAMBLE = register("bramble", new BrambleFeature(DefaultFeatureConfig.CODEC.stable()));
	public static final Feature<DefaultFeatureConfig> CRAG_SPLATTER = register("crag_splatter", new CragSplatterFeature(DefaultFeatureConfig.CODEC.stable()));
	public static final Feature<DefaultFeatureConfig> DEEP_BAYOU_VINES = register("deep_bayou_vines", new DeepBayouVinesFeature(DefaultFeatureConfig.CODEC.stable()));
	public static final Feature<DefaultFeatureConfig> FERN = register("fern", new FernFeature(DefaultFeatureConfig.CODEC.stable()));
	public static final Feature<DefaultFeatureConfig> FERN_GRASS = register("fern_grass", new FernGrassFeature(DefaultFeatureConfig.CODEC.stable()));
	public static final Feature<DefaultFeatureConfig> FLESH_TENDON = register("flesh_tendon", new FleshTendonFeature(DefaultFeatureConfig.CODEC.stable()));
	public static final Feature<DefaultFeatureConfig> GRASS_SPLATTER = register("grass_splatter", new GrassSplatterFeature(DefaultFeatureConfig.CODEC.stable()));
	public static final Feature<DefaultFeatureConfig> HUGE_CLOVER = register("huge_clover", new HugeCloverFeature(DefaultFeatureConfig.CODEC.stable()));
	public static final Feature<DefaultFeatureConfig> HUGE_GLOWSHROOM = register("huge_glowshroom", new HugeGlowshroomFeature(DefaultFeatureConfig.CODEC.stable()));
	public static final Feature<DefaultFeatureConfig> HUGE_TOADSTOOL = register("huge_toadstool", new HugeToadstoolFeature(DefaultFeatureConfig.CODEC.stable()));
	public static final Feature<DefaultFeatureConfig> LARGE_CRYSTAL = register("large_crystal", new LargeCrystalFeature(DefaultFeatureConfig.CODEC.stable()));
	public static final Feature<DefaultFeatureConfig> MANGROVE = register("mangrove", new MangroveFeature(DefaultFeatureConfig.CODEC.stable()));
	public static final Feature<DefaultFeatureConfig> MYCELIUM_SPLATTER = register("mycelium_splatter", new MyceliumSplatterFeature(DefaultFeatureConfig.CODEC.stable()));
	public static final Feature<DefaultFeatureConfig> NETHER_VINES = register("nether_vines", new NetherVinesFeature(DefaultFeatureConfig.CODEC.stable()));
	public static final Feature<DefaultFeatureConfig> OBSIDIAN_SPLATTER = register("obsidian_splatter", new ObsidianSplatterFeature(DefaultFeatureConfig.CODEC.stable()));
	public static final Feature<DefaultFeatureConfig> RAINFOREST_CLIFFS_VINES = register("rainforest_cliffs_vines", new RainforestCliffsVinesFeature(DefaultFeatureConfig.CODEC.stable()));
	public static final Feature<DefaultFeatureConfig> PODZOL_SPLATTER = register("podzol_splatter", new PodzolSplatterFeature(DefaultFeatureConfig.CODEC.stable()));
	public static final Feature<DefaultFeatureConfig> PUMPKIN_PATCH = register("pumpkin_patch", new PumpkinPatchFeature(DefaultFeatureConfig.CODEC.stable()));
	public static final Feature<BlockClusterFeatureConfig> RANDOM_PATCH_ABOVE_GROUND = register("random_patch_above_ground", new RandomPatchAboveGroundFeature(BlockClusterFeatureConfig.CODEC));
	public static final Feature<DefaultFeatureConfig> SCATTERED_ROCKS = register("scattered_rocks", new ScatteredRocksFeature(DefaultFeatureConfig.CODEC.stable()));
	public static final Feature<DefaultFeatureConfig> SCRUB = register("scrub", new ScrubFeature(DefaultFeatureConfig.CODEC.stable()));
	public static final Feature<DefaultFeatureConfig> SHORT_BAMBOO = register("short_bamboo", new ShortBambooFeature(DefaultFeatureConfig.CODEC.stable()));
	public static final Feature<DefaultFeatureConfig> SMALL_BROWN_MUSHROOM = register("small_brown_mushroom", new SmallBrownMushroomFeature(DefaultFeatureConfig.CODEC.stable()));
	public static final Feature<DefaultFeatureConfig> SMALL_CRYSTAL = register("small_crystal", new SmallCrystalFeature(DefaultFeatureConfig.CODEC.stable()));
	public static final Feature<DefaultFeatureConfig> SMALL_GLOWSHROOM = register("small_glowshroom", new SmallGlowshroomFeature(DefaultFeatureConfig.CODEC.stable()));
	public static final Feature<DefaultFeatureConfig> SMALL_RED_MUSHROOM = register("small_red_mushroom", new SmallRedMushroomFeature(DefaultFeatureConfig.CODEC.stable()));
	public static final Feature<DefaultFeatureConfig> SMALL_TOADSTOOL = register("small_toadstool", new SmallToadstoolFeature(DefaultFeatureConfig.CODEC.stable()));
	public static final Feature<DefaultFeatureConfig> STANDARD_GRASS = register("standard_grass", new StandardGrassFeature(DefaultFeatureConfig.CODEC.stable()));
	public static final Feature<DefaultFeatureConfig> WASTELAND_GRASS = register("wasteland_grass", new WastelandGrassFeature(DefaultFeatureConfig.CODEC.stable()));
	*/
	//Flowers
	public static final RandomPatchFeatureConfig CHERRY_BLOSSOM_GROVE_FLOWER_CONFIG = (new RandomPatchFeatureConfig.Builder((new WeightedBlockStateProvider()).add(BOPBlocks.pink_daffodil.getDefaultState(), 1).add(Blocks.LILY_OF_THE_VALLEY.getDefaultState(), 1), SimpleBlockPlacer.INSTANCE)).tries(64).build();
	public static final RandomPatchFeatureConfig CONIFEROUS_FOREST_FLOWER_CONFIG = (new RandomPatchFeatureConfig.Builder((new WeightedBlockStateProvider()).add(Blocks.CORNFLOWER.getDefaultState(), 1).add(Blocks.OXEYE_DAISY.getDefaultState(), 1).add(Blocks.POPPY.getDefaultState(), 1).add(Blocks.DANDELION.getDefaultState(), 1), SimpleBlockPlacer.INSTANCE)).tries(64).build();
	public static final RandomPatchFeatureConfig EXTENDED_FLOWER_CONFIG = (new RandomPatchFeatureConfig.Builder((new WeightedBlockStateProvider()).add(Blocks.OXEYE_DAISY.getDefaultState(), 1).add(Blocks.POPPY.getDefaultState(), 1).add(Blocks.DANDELION.getDefaultState(), 1), SimpleBlockPlacer.INSTANCE)).tries(64).build();
	public static final RandomPatchFeatureConfig FLOWER_MEADOW_FLOWER_CONFIG = (new RandomPatchFeatureConfig.Builder((new WeightedBlockStateProvider()).add(Blocks.PINK_TULIP.getDefaultState(), 1).add(Blocks.RED_TULIP.getDefaultState(), 1).add(Blocks.WHITE_TULIP.getDefaultState(), 1).add(Blocks.ORANGE_TULIP.getDefaultState(), 1), SimpleBlockPlacer.INSTANCE)).tries(64).build();
	public static final RandomPatchFeatureConfig MEADOW_FLOWER_CONFIG = (new RandomPatchFeatureConfig.Builder((new WeightedBlockStateProvider()).add(Blocks.LILY_OF_THE_VALLEY.getDefaultState(), 1).add(Blocks.AZURE_BLUET.getDefaultState(), 1).add(Blocks.POPPY.getDefaultState(), 1).add(Blocks.DANDELION.getDefaultState(), 1), SimpleBlockPlacer.INSTANCE)).tries(64).build();
	public static final RandomPatchFeatureConfig MOOR_FLOWER_CONFIG = (new RandomPatchFeatureConfig.Builder((new WeightedBlockStateProvider()).add(Blocks.ALLIUM.getDefaultState(), 1).add(BOPBlocks.violet.getDefaultState(), 1), SimpleBlockPlacer.INSTANCE)).tries(64).build();
	public static final RandomPatchFeatureConfig MYSTIC_GROVE_FLOWER_CONFIG = (new RandomPatchFeatureConfig.Builder((new WeightedBlockStateProvider()).add(BOPBlocks.glowflower.getDefaultState(), 1).add(BOPBlocks.pink_daffodil.getDefaultState(), 1).add(Blocks.LILY_OF_THE_VALLEY.getDefaultState(), 1).add(Blocks.AZURE_BLUET.getDefaultState(), 1).add(Blocks.ALLIUM.getDefaultState(), 1), SimpleBlockPlacer.INSTANCE)).tries(64).build();
	public static final RandomPatchFeatureConfig ORIGIN_VALLEY_FLOWER_CONFIG = (new RandomPatchFeatureConfig.Builder((new WeightedBlockStateProvider()).add(BOPBlocks.rose.getDefaultState(), 6).add(Blocks.DANDELION.getDefaultState(), 4), SimpleBlockPlacer.INSTANCE)).tries(64).build();
	public static final RandomPatchFeatureConfig RAINBOW_HILLS_FLOWER_CONFIG = (new RandomPatchFeatureConfig.Builder((new WeightedBlockStateProvider()).add(BOPBlocks.orange_cosmos.getDefaultState(), 1).add(BOPBlocks.pink_daffodil.getDefaultState(), 1).add(Blocks.LILY_OF_THE_VALLEY.getDefaultState(), 1).add(Blocks.AZURE_BLUET.getDefaultState(), 1).add(Blocks.ALLIUM.getDefaultState(), 1).add(Blocks.CORNFLOWER.getDefaultState(), 1).add(Blocks.POPPY.getDefaultState(), 1).add(Blocks.DANDELION.getDefaultState(), 1).add(Blocks.BLUE_ORCHID.getDefaultState(), 1).add(Blocks.PINK_TULIP.getDefaultState(), 1).add(Blocks.RED_TULIP.getDefaultState(), 1).add(Blocks.WHITE_TULIP.getDefaultState(), 1).add(Blocks.ORANGE_TULIP.getDefaultState(), 1), SimpleBlockPlacer.INSTANCE)).tries(64).build();
	public static final RandomPatchFeatureConfig RAINFOREST_FLOWER_CONFIG = (new RandomPatchFeatureConfig.Builder((new WeightedBlockStateProvider()).add(BOPBlocks.orange_cosmos.getDefaultState(), 1).add(Blocks.POPPY.getDefaultState(), 1).add(Blocks.DANDELION.getDefaultState(), 1), SimpleBlockPlacer.INSTANCE)).tries(64).build();
	public static final RandomPatchFeatureConfig SNOWY_FLOWER_CONFIG = (new RandomPatchFeatureConfig.Builder((new WeightedBlockStateProvider()).add(BOPBlocks.violet.getDefaultState(), 1).add(Blocks.POPPY.getDefaultState(), 1).add(Blocks.DANDELION.getDefaultState(), 1), SimpleBlockPlacer.INSTANCE)).tries(64).build();
	public static final RandomPatchFeatureConfig TROPICS_FLOWER_CONFIG = new RandomPatchFeatureConfig.Builder(new WeightedBlockStateProvider().addState(BOPBlocks.pink_hibiscus.getDefaultState(), 1).addState(Blocks.POPPY.getDefaultState(), 1).addState(Blocks.DANDELION.getDefaultState(), 1), SimpleBlockPlacer.INSTANCE).tries(64).build();
	public static final RandomPatchFeatureConfig WETLAND_FLOWER_CONFIG = (new RandomPatchFeatureConfig.Builder((new WeightedBlockStateProvider()).add(Blocks.BLUE_ORCHID.getDefaultState(), 1).add(Blocks.POPPY.getDefaultState(), 1).add(Blocks.DANDELION.getDefaultState(), 1), SimpleBlockPlacer.INSTANCE)).tries(64).build();

	//Other
	public static final LiquidsConfig VOLCANO_SPRING_CONFIG = new LiquidsConfig(Fluids.LAVA.defaultFluidState(), true, 4, 1, ImmutableSet.of(Blocks.BASALT, Blocks.MAGMA_BLOCK, BOPBlocks.black_sand, BOPBlocks.black_sandstone, Blocks.STONE, Blocks.GRANITE, Blocks.DIORITE, Blocks.ANDESITE));
	public static final LiquidsConfig WATER_SPRING_EXTRA_CONFIG = new LiquidsConfig(Fluids.WATER.defaultFluidState(), true, 4, 1, ImmutableSet.of(Blocks.DIRT, Blocks.TERRACOTTA, Blocks.STONE, Blocks.GRANITE, Blocks.DIORITE, Blocks.ANDESITE, BOPBlocks.orange_sandstone));
	
	private static <C extends FeatureConfig, F extends Feature<C>> F register(String key, F value)
	{
		return Registry.register(Registry.FEATURE, new Identifier(BiomesOPlenty.MOD_ID, key), value);
	}
}
