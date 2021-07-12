/*******************************************************************************
 * Copyright 2014-2020, the Biomes O' Plenty Team
 *
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 *
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/
package biomesoplenty.common.world.gen.surfacebuilders;

import biomesoplenty.api.block.BOPBlocks;
import biomesoplenty.core.BiomesOPlenty;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceConfig;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

public class BOPSurfaceBuilders
{
    /*
    public static final SurfaceConfig BLACKSTONE_SURFACE = new TernarySurfaceConfig(Blocks.BLACKSTONE.getDefaultState(), Blocks.BLACKSTONE.getDefaultState(), Blocks.BLACKSTONE.getDefaultState());
    public static final SurfaceConfig BASALT_SURFACE = new TernarySurfaceConfig(Blocks.BASALT.getDefaultState(), Blocks.BASALT.getDefaultState(), Blocks.GRAVEL.getDefaultState());
    public static final SurfaceConfig TERRACOTTA_SURFACE = new TernarySurfaceConfig(Blocks.TERRACOTTA.getDefaultState(), Blocks.TERRACOTTA.getDefaultState(), Blocks.GRAVEL.getDefaultState());
    public static final SurfaceConfig DIORITE_SURFACE = new TernarySurfaceConfig(Blocks.DIORITE.getDefaultState(), Blocks.DIORITE.getDefaultState(), Blocks.DIORITE.getDefaultState());
    public static final SurfaceConfig MAGMA_SURFACE = new TernarySurfaceConfig(Blocks.MAGMA_BLOCK.getDefaultState(), Blocks.MAGMA_BLOCK.getDefaultState(), Blocks.BASALT.getDefaultState());
    public static final SurfaceConfig SNOW_SNOW_GRAVEL_SURFACE = new TernarySurfaceConfig(Blocks.SNOW_BLOCK.getDefaultState(), Blocks.SNOW_BLOCK.getDefaultState(), Blocks.GRAVEL.getDefaultState());
    public static final SurfaceConfig MUD_SURFACE = new TernarySurfaceConfig(BOPBlocks.mud.getDefaultState(), BOPBlocks.mud.getDefaultState(), BOPBlocks.mud.getDefaultState());
    */
    public static final SurfaceConfig WHITE_SAND_SURFACE = new TernarySurfaceConfig(BOPBlocks.white_sand.getDefaultState(), BOPBlocks.white_sand.getDefaultState(), BOPBlocks.white_sand.getDefaultState());
    /*
    public static final SurfaceConfig ORANGE_SAND_SURFACE = new TernarySurfaceConfig(BOPBlocks.orange_sand.getDefaultState(), BOPBlocks.orange_sand.getDefaultState(), BOPBlocks.orange_sand.getDefaultState());
    public static final SurfaceConfig ORANGE_SANDSTONE_SURFACE = new TernarySurfaceConfig(BOPBlocks.orange_sandstone.getDefaultState(), BOPBlocks.orange_sandstone.getDefaultState(), BOPBlocks.orange_sandstone.getDefaultState());
    public static final SurfaceConfig BLACK_SAND_SURFACE = new TernarySurfaceConfig(BOPBlocks.black_sand.getDefaultState(), BOPBlocks.black_sand.getDefaultState(), BOPBlocks.black_sand.getDefaultState());
    public static final SurfaceConfig DRIED_SALT_SURFACE = new TernarySurfaceConfig(BOPBlocks.dried_salt.getDefaultState(), BOPBlocks.dried_salt.getDefaultState(), BOPBlocks.dried_salt.getDefaultState());
    public static final SurfaceConfig ORIGIN_GRASS_SURFACE = new TernarySurfaceConfig(BOPBlocks.origin_grass_block.getDefaultState(), Blocks.DIRT.getDefaultState(), Blocks.GRAVEL.getDefaultState());
    public static final SurfaceConfig BASIN_SURFACE = new TernarySurfaceConfig(Blocks.AIR.getDefaultState(), Blocks.STONE.getDefaultState(), Blocks.GRAVEL.getDefaultState());

    public static final SurfaceBuilder<SurfaceConfig> DRYLAND = register("dryland", new DrylandSurfaceBuilder(SurfaceBuilderConfig.CODEC.stable()));
    public static final SurfaceBuilder<SurfaceConfig> HIGHLAND_CRAG = register("highland_crag", new HighlandCragSurfaceBuilder(SurfaceBuilderConfig.CODEC.stable()));
    public static final SurfaceBuilder<SurfaceConfig> EXPOSED_STONE = register("exposed_stone", new ExposedStoneSurfaceBuilder(SurfaceBuilderConfig.CODEC.stable()));
    public static final SurfaceBuilder<SurfaceConfig> TERRACOTTA = register("terracotta", new TerracottaSurfaceBuilder(SurfaceBuilderConfig.CODEC.stable()));
    public static final SurfaceBuilder<SurfaceConfig> MARSH = register("marsh", new MarshSurfaceBuilder(SurfaceBuilderConfig.CODEC.stable()));
    public static final SurfaceBuilder<SurfaceConfig> MANGROVE = register("mangrove", new MangroveSurfaceBuilder(SurfaceBuilderConfig.CODEC.stable()));
    public static final SurfaceBuilder<SurfaceConfig> PODZOL = register("podzol", new PodzolSurfaceBuilder(SurfaceBuilderConfig.CODEC.stable()));
    public static final SurfaceBuilder<SurfaceConfig> VOLCANO = register("volcano", new VolcanoSurfaceBuilder(SurfaceBuilderConfig.CODEC.stable()));
    public static final SurfaceBuilder<SurfaceConfig> DEEP_TOP_LAYER = register("deep_top_layer", new DeepTopLayerSurfaceBuilder(SurfaceBuilderConfig.CODEC.stable()));
    public static final SurfaceBuilder<SurfaceConfig> ORANGE_SANDSTONE = register("orange_sandstone", new OrangeSandstoneSurfaceBuilder(SurfaceBuilderConfig.CODEC.stable()));
    public static final SurfaceBuilder<SurfaceConfig> LUSH_SAVANNA = register("lush_savanna", new LushSavannaSurfaceBuilder(SurfaceBuilderConfig.CODEC.stable()));
    public static final SurfaceBuilder<SurfaceConfig> WITHERED_ABYSS = register("withered_abyss", new WitheredAbyssSurfaceBuilder(SurfaceBuilderConfig.CODEC.stable()));
    public static final SurfaceBuilder<SurfaceConfig> FLESH = register("flesh", new FleshSurfaceBuilder(SurfaceBuilderConfig.CODEC.stable()));
    public static final SurfaceBuilder<SurfaceConfig> ORIGIN_VALLEY = register("origin_valley", new OriginValleySurfaceBuilder(SurfaceBuilderConfig.CODEC.stable()));
    */
    public static final SurfaceBuilder<TernarySurfaceConfig> TROPICS = register("tropics", new TropicsSurfaceBuilder(TernarySurfaceConfig.CODEC.stable()));
    /*
    public static final SurfaceBuilder<SurfaceConfig> LUSH_DESERT = register("lush_desert", new LushDesertSurfaceBuilder(SurfaceBuilderConfig.CODEC.stable()));
    public static final SurfaceBuilder<SurfaceConfig> BLACK_SAND = register("black_sand", new BlackSandSurfaceBuilder(SurfaceBuilderConfig.CODEC.stable()));
    public static final SurfaceBuilder<SurfaceConfig> COLD_DESERT = register("cold_desert", new ColdDesertSurfaceBuilder(SurfaceBuilderConfig.CODEC.stable()));
    */

    private static <C extends SurfaceConfig, F extends SurfaceBuilder<C>> F register(String key, F builder)
    {
        return Registry.register(Registry.SURFACE_BUILDER, new Identifier(BiomesOPlenty.MOD_ID, key), builder);
    }
}
