/*******************************************************************************
 * Copyright 2014-2019, the Biomes O' Plenty Team
 *
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 *
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/
package biomesoplenty.common.world;

import biomesoplenty.api.enums.BOPClimates;
import biomesoplenty.common.util.biome.BiomeUtil;
import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.util.dynamic.RegistryLookupCodec;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.source.BiomeSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BOPBiomeProvider extends BiomeSource
{
    public static final Codec<BOPBiomeProvider> CODEC = RecordCodecBuilder.create((builder) ->
    {
        return builder.group(
            Codec.LONG.fieldOf("seed").stable().forGetter((biomeProvider) -> biomeProvider.seed),
            RegistryLookupCodec.of(Registry.BIOME_KEY).forGetter((biomeProvider) -> biomeProvider.biomes)
        ).apply(builder, builder.stable(BOPBiomeProvider::new));
    });

    private static final List<RegistryKey<Biome>> VANILLA_POSSIBLE_BIOMES = ImmutableList.of(BiomeKeys.OCEAN, BiomeKeys.PLAINS, BiomeKeys.DESERT, BiomeKeys.MOUNTAINS, BiomeKeys.FOREST, BiomeKeys.TAIGA, BiomeKeys.SWAMP, BiomeKeys.RIVER, BiomeKeys.FROZEN_OCEAN, BiomeKeys.FROZEN_RIVER, BiomeKeys.SNOWY_TUNDRA, BiomeKeys.SNOWY_MOUNTAINS, BiomeKeys.MUSHROOM_FIELDS, BiomeKeys.MUSHROOM_FIELD_SHORE, BiomeKeys.BEACH, BiomeKeys.DESERT_HILLS, BiomeKeys.WOODED_HILLS, BiomeKeys.TAIGA_HILLS, BiomeKeys.MOUNTAIN_EDGE, BiomeKeys.JUNGLE, BiomeKeys.JUNGLE_HILLS, BiomeKeys.JUNGLE_EDGE, BiomeKeys.DEEP_OCEAN, BiomeKeys.STONE_SHORE, BiomeKeys.SNOWY_BEACH, BiomeKeys.BIRCH_FOREST, BiomeKeys.BIRCH_FOREST_HILLS, BiomeKeys.DARK_FOREST, BiomeKeys.SNOWY_TAIGA, BiomeKeys.SNOWY_TAIGA_HILLS, BiomeKeys.GIANT_TREE_TAIGA, BiomeKeys.GIANT_TREE_TAIGA_HILLS, BiomeKeys.WOODED_MOUNTAINS, BiomeKeys.SAVANNA, BiomeKeys.SAVANNA_PLATEAU, BiomeKeys.BADLANDS, BiomeKeys.WOODED_BADLANDS_PLATEAU, BiomeKeys.BADLANDS_PLATEAU, BiomeKeys.WARM_OCEAN, BiomeKeys.LUKEWARM_OCEAN, BiomeKeys.COLD_OCEAN, BiomeKeys.DEEP_WARM_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN, BiomeKeys.DEEP_COLD_OCEAN, BiomeKeys.DEEP_FROZEN_OCEAN, BiomeKeys.SUNFLOWER_PLAINS, BiomeKeys.DESERT_LAKES, BiomeKeys.GRAVELLY_MOUNTAINS, BiomeKeys.FLOWER_FOREST, BiomeKeys.TAIGA_MOUNTAINS, BiomeKeys.SWAMP_HILLS, BiomeKeys.ICE_SPIKES, BiomeKeys.MODIFIED_JUNGLE, BiomeKeys.MODIFIED_JUNGLE_EDGE, BiomeKeys.TALL_BIRCH_FOREST, BiomeKeys.TALL_BIRCH_HILLS, BiomeKeys.DARK_FOREST_HILLS, BiomeKeys.SNOWY_TAIGA_MOUNTAINS, BiomeKeys.GIANT_SPRUCE_TAIGA, BiomeKeys.GIANT_SPRUCE_TAIGA_HILLS, BiomeKeys.MODIFIED_GRAVELLY_MOUNTAINS, BiomeKeys.SHATTERED_SAVANNA, BiomeKeys.SHATTERED_SAVANNA_PLATEAU, BiomeKeys.ERODED_BADLANDS, BiomeKeys.MODIFIED_WOODED_BADLANDS_PLATEAU, BiomeKeys.MODIFIED_BADLANDS_PLATEAU);

    private final long seed;
    private final Layer noiseBiomeLayer;
    private final Registry<Biome> biomes;

    public BOPBiomeProvider(long seed, Registry<Biome> biomes)
    {
        super(Stream.concat(VANILLA_POSSIBLE_BIOMES.stream(), BOPClimates.getOverworldBiomes().stream()).map(biomes::get).collect(Collectors.toList()));
        this.seed = seed;
        this.noiseBiomeLayer = BOPLayerUtil.createGenLayers(seed, new BOPOverworldGenSettings());
        this.biomes = biomes;
    }

    @Override
    protected Codec<? extends BiomeSource> getCodec()
    {
        return CODEC;
    }

    @Override
    public BiomeSource withSeed(long seed)
    {
        return new BOPBiomeProvider(seed, this.biomes);
    }

    @Override
    public Biome getBiomeForNoiseGen(int x, int y, int z)
    {
        return this.noiseBiomeLayer.get(this.biomes, x, z);
    }
}