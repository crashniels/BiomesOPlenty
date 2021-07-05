/*******************************************************************************
 * Copyright 2014-2019, the Biomes O' Plenty Team
 *
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 *
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/
package biomesoplenty.api.biome;

import biomesoplenty.core.BiomesOPlenty;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;

public class BOPBiomes
{
    public static RegistryKey<Biome> alps = register("alps");
    public static RegistryKey<Biome> alps_foothills = register("alps_foothills");
    public static RegistryKey<Biome> bamboo_blossom_grove = register("bamboo_blossom_grove");
    public static RegistryKey<Biome> bayou = register("bayou");
    public static RegistryKey<Biome> bayou_mangrove = register("bayou_mangrove");
    public static RegistryKey<Biome> burnt_forest = register("burnt_forest");
    public static RegistryKey<Biome> cherry_blossom_grove = register("cherry_blossom_grove");
    public static RegistryKey<Biome> cold_desert = register("cold_desert");
    public static RegistryKey<Biome> coniferous_forest = register("coniferous_forest");
    public static RegistryKey<Biome> coniferous_lakes = register("coniferous_lakes");
    public static RegistryKey<Biome> dead_forest = register("dead_forest");
    public static RegistryKey<Biome> deep_bayou = register("deep_bayou");
    public static RegistryKey<Biome> dense_marsh = register("dense_marsh");
    public static RegistryKey<Biome> dense_woodland = register("dense_woodland");
    public static RegistryKey<Biome> dryland = register("dryland");
    public static RegistryKey<Biome> dry_boneyard = register("dry_boneyard");
    public static RegistryKey<Biome> fir_clearing = register("fir_clearing");
    public static RegistryKey<Biome> flower_meadow = register("flower_meadow");
    public static RegistryKey<Biome> fungal_field = register("fungal_field");
    public static RegistryKey<Biome> fungal_jungle = register("fungal_jungle");
    public static RegistryKey<Biome> golden_prairie = register("golden_prairie");
    public static RegistryKey<Biome> grassland = register("grassland");
    public static RegistryKey<Biome> grassland_clover_patch = register("grassland_clover_patch");
    public static RegistryKey<Biome> gravel_beach = register("gravel_beach");
    public static RegistryKey<Biome> grove = register("grove");
    public static RegistryKey<Biome> grove_clearing = register("grove_clearing");
    public static RegistryKey<Biome> grove_lakes = register("grove_lakes");
    public static RegistryKey<Biome> highland = register("highland");
    public static RegistryKey<Biome> highland_crag = register("highland_crag");
    public static RegistryKey<Biome> highland_moor = register("highland_moor");
    public static RegistryKey<Biome> jade_cliffs = register("jade_cliffs");
    public static RegistryKey<Biome> lavender_field = register("lavender_field");
    public static RegistryKey<Biome> lavender_forest = register("lavender_forest");
    public static RegistryKey<Biome> lush_desert = register("lush_desert");
    public static RegistryKey<Biome> lush_savanna = register("lush_savanna");
    public static RegistryKey<Biome> marsh = register("marsh");
    public static RegistryKey<Biome> meadow = register("meadow");
    public static RegistryKey<Biome> meadow_forest = register("meadow_forest");
    public static RegistryKey<Biome> muskeg = register("muskeg");
    public static RegistryKey<Biome> mystic_grove = register("mystic_grove");
    public static RegistryKey<Biome> mystic_plains = register("mystic_plains");
    public static RegistryKey<Biome> ominous_woods = register("ominous_woods");
    public static RegistryKey<Biome> ominous_mire = register("ominous_mire");
    public static RegistryKey<Biome> orchard = register("orchard");
    public static RegistryKey<Biome> origin_valley = register("origin_valley");
    public static RegistryKey<Biome> prairie = register("prairie");
    public static RegistryKey<Biome> rainbow_hills = register("rainbow_hills");
    public static RegistryKey<Biome> rainforest = register("rainforest");
    public static RegistryKey<Biome> rainforest_cliffs = register("rainforest_cliffs");
    public static RegistryKey<Biome> rainforest_floodplain = register("rainforest_floodplain");
    public static RegistryKey<Biome> redwood_forest = register("redwood_forest");
    public static RegistryKey<Biome> redwood_forest_edge = register("redwood_forest_edge");
    public static RegistryKey<Biome> redwood_hills = register("redwood_hills");
    public static RegistryKey<Biome> scrubland = register("scrubland");
    public static RegistryKey<Biome> seasonal_forest = register("seasonal_forest");
    public static RegistryKey<Biome> seasonal_orchard = register("seasonal_orchard");
    public static RegistryKey<Biome> seasonal_pumpkin_patch = register("seasonal_pumpkin_patch");
    public static RegistryKey<Biome> shroomy_wetland = register("shroomy_wetland");
    public static RegistryKey<Biome> shrubland = register("shrubland");
    public static RegistryKey<Biome> shrubland_hills = register("shrubland_hills");
    public static RegistryKey<Biome> snowy_coniferous_forest = register("snowy_coniferous_forest");
    public static RegistryKey<Biome> snowy_fir_clearing = register("snowy_fir_clearing");
    public static RegistryKey<Biome> snowy_maple_forest = register("snowy_maple_forest");
    public static RegistryKey<Biome> tall_dead_forest = register("tall_dead_forest");
    public static RegistryKey<Biome> tropic_beach = register("tropic_beach");
    public static RegistryKey<Biome> tropics = register("tropics");
    public static RegistryKey<Biome> tundra = register("tundra");
    public static RegistryKey<Biome> tundra_basin = register("tundra_basin");
    public static RegistryKey<Biome> tundra_bog = register("tundra_bog");
    public static RegistryKey<Biome> volcanic_plains = register("volcanic_plains");
    public static RegistryKey<Biome> volcano = register("volcano");
    public static RegistryKey<Biome> wasteland = register("wasteland");
    public static RegistryKey<Biome> wetland = register("wetland");
    public static RegistryKey<Biome> wetland_forest = register("wetland_forest");
    public static RegistryKey<Biome> wooded_scrubland = register("wooded_scrubland");
    public static RegistryKey<Biome> woodland = register("woodland");

    public static RegistryKey<Biome> crystalline_chasm = register("crystalline_chasm");
    public static RegistryKey<Biome> undergrowth = register("undergrowth");
    public static RegistryKey<Biome> visceral_heap = register("visceral_heap");
    public static RegistryKey<Biome> withered_abyss = register("withered_abyss");

    private static RegistryKey<Biome> register(String name)
    {
        return RegistryKey.of(Registry.BIOME_KEY, new Identifier(BiomesOPlenty.MOD_ID, name));
    }
}
