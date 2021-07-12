/*******************************************************************************
 * Copyright 2014-2020, the Biomes O' Plenty Team
 *
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 *
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/
package biomesoplenty.common.world.gen.surfacebuilders;

import org.apache.logging.log4j.Level;

import biomesoplenty.core.BiomesOPlenty;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceConfig;

public class BOPConfiguredSurfaceBuilders
{
    /*
    public static final ConfiguredSurfaceBuilder<SurfaceConfig> DEEP_SNOW = register("deep_snow", new ConfiguredSurfaceBuilder(BOPSurfaceBuilders.DEEP_TOP_LAYER, BOPSurfaceBuilders.SNOW_SNOW_GRAVEL_SURFACE));
    public static final ConfiguredSurfaceBuilder<SurfaceConfig> ALPS_FOOTHILLS = register("alps_foothills", new ConfiguredSurfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.CONFIG_STONE));
    */
    public static final ConfiguredSurfaceBuilder<SurfaceConfig> GRAVEL_FULL = register("gravel_full", new ConfiguredSurfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRAVEL_CONFIG));
    /*
    public static final ConfiguredSurfaceBuilder<SurfaceConfig> COLD_DESERT = register("cold_desert", new ConfiguredSurfaceBuilder(BOPSurfaceBuilders.COLD_DESERT, SurfaceBuilder.CONFIG_GRAVEL));
    public static final ConfiguredSurfaceBuilder<SurfaceConfig> EXPOSED_STONE = register("exposed_stone", new ConfiguredSurfaceBuilder(BOPSurfaceBuilders.EXPOSED_STONE, SurfaceBuilder.CONFIG_GRASS));
    public static final ConfiguredSurfaceBuilder<SurfaceConfig> DRYLAND = register("dryland", new ConfiguredSurfaceBuilder(BOPSurfaceBuilders.DRYLAND, SurfaceBuilder.CONFIG_GRASS));
    public static final ConfiguredSurfaceBuilder<SurfaceConfig> MANGROVE = register("mangrove", new ConfiguredSurfaceBuilder(BOPSurfaceBuilders.MANGROVE, BOPSurfaceBuilders.MUD_SURFACE));
    public static final ConfiguredSurfaceBuilder<SurfaceConfig> PODZOL_MIXED = register("podzol_mixed", new ConfiguredSurfaceBuilder(BOPSurfaceBuilders.PODZOL, SurfaceBuilder.CONFIG_GRASS));
    public static final ConfiguredSurfaceBuilder<SurfaceConfig> PODZOL_FULL = register("podzol_full", new ConfiguredSurfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.CONFIG_PODZOL));
    public static final ConfiguredSurfaceBuilder<SurfaceConfig> LUSH_DESERT = register("lush_desert", new ConfiguredSurfaceBuilder(BOPSurfaceBuilders.LUSH_DESERT, BOPSurfaceBuilders.ORANGE_SAND_SURFACE));
    public static final ConfiguredSurfaceBuilder<SurfaceConfig> LUSH_SAVANNA = register("lush_savanna", new ConfiguredSurfaceBuilder(BOPSurfaceBuilders.LUSH_SAVANNA, SurfaceBuilder.CONFIG_GRASS));
    public static final ConfiguredSurfaceBuilder<SurfaceConfig> HIGHLAND_CRAG = register("highland_crag", new ConfiguredSurfaceBuilder(BOPSurfaceBuilders.HIGHLAND_CRAG, SurfaceBuilder.CONFIG_STONE));
    public static final ConfiguredSurfaceBuilder<SurfaceConfig> MARSH = register("marsh", new ConfiguredSurfaceBuilder(BOPSurfaceBuilders.MARSH, SurfaceBuilder.CONFIG_GRASS));
    public static final ConfiguredSurfaceBuilder<SurfaceConfig> VOLCANO = register("volcano", new ConfiguredSurfaceBuilder(BOPSurfaceBuilders.VOLCANO, BOPSurfaceBuilders.BASALT_SURFACE));
    public static final ConfiguredSurfaceBuilder<SurfaceConfig> VOLCANIC_PLAINS = register("volcanic_plains", new ConfiguredSurfaceBuilder(BOPSurfaceBuilders.BLACK_SAND, BOPSurfaceBuilders.BLACK_SAND_SURFACE));
    public static final ConfiguredSurfaceBuilder<SurfaceConfig> GROVE_LAKES = register("grove_lakes", new ConfiguredSurfaceBuilder(BOPSurfaceBuilders.DEEP_TOP_LAYER, BOPSurfaceBuilders.DIORITE_SURFACE));
    public static final ConfiguredSurfaceBuilder<SurfaceConfig> DEEP_GRASS = register("deep_grass", new ConfiguredSurfaceBuilder(BOPSurfaceBuilders.DEEP_TOP_LAYER, SurfaceBuilder.CONFIG_GRASS));
    public static final ConfiguredSurfaceBuilder<SurfaceConfig> RAINFOREST_CLIFFS = register("rainforest_cliffs", new ConfiguredSurfaceBuilder(BOPSurfaceBuilders.TERRACOTTA, SurfaceBuilder.CONFIG_GRASS));
    public static final ConfiguredSurfaceBuilder<SurfaceConfig> STONE_BASIN = register("stone_basin", new ConfiguredSurfaceBuilder(SurfaceBuilder.DEFAULT, BOPSurfaceBuilders.BASIN_SURFACE));
    public static final ConfiguredSurfaceBuilder<SurfaceConfig> ORIGIN_VALLEY = register("origin_valley", new ConfiguredSurfaceBuilder(BOPSurfaceBuilders.ORIGIN_VALLEY, BOPSurfaceBuilders.ORIGIN_GRASS_SURFACE));
    */
    public static final ConfiguredSurfaceBuilder<SurfaceConfig> TROPIC_BEACH = register("tropic_beach", new ConfiguredSurfaceBuilder(BOPSurfaceBuilders.TROPICS, BOPSurfaceBuilders.WHITE_SAND_SURFACE));
    /*
    public static final ConfiguredSurfaceBuilder<SurfaceConfig> TROPICS = register("tropics", new ConfiguredSurfaceBuilder(BOPSurfaceBuilders.TROPICS, SurfaceBuilder.CONFIG_GRASS));
    public static final ConfiguredSurfaceBuilder<SurfaceConfig> VISCERAL_HEAP = register("visceral_heap", new ConfiguredSurfaceBuilder(BOPSurfaceBuilders.FLESH, SurfaceBuilder.CONFIG_HELL));
    public static final ConfiguredSurfaceBuilder<SurfaceConfig> WASTELAND = register("wasteland", new ConfiguredSurfaceBuilder(SurfaceBuilder.DEFAULT, BOPSurfaceBuilders.DRIED_SALT_SURFACE));
    public static final ConfiguredSurfaceBuilder<SurfaceConfig> WITHERED_ABYSS = register("withered_abyss", new ConfiguredSurfaceBuilder(BOPSurfaceBuilders.WITHERED_ABYSS, BOPSurfaceBuilders.BLACKSTONE_SURFACE));
    */

    private static <C extends SurfaceConfig, F extends ConfiguredSurfaceBuilder<C>> F register(String key, F builder)
    {
        return Registry.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER, new Identifier(BiomesOPlenty.MOD_ID, key), builder);
    }
}
