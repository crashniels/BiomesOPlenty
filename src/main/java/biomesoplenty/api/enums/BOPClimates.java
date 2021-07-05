/*******************************************************************************
 * Copyright 2014-2019, the Biomes O' Plenty Team
 *
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 *
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/
package biomesoplenty.api.enums;

import biomesoplenty.api.biome.BOPBiomes;
import biomesoplenty.common.util.biome.BiomeUtil;
import biomesoplenty.init.ModBiomes;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.ChunkRandom;
import net.minecraft.world.gen.WorldGenRandom;
import net.fabricmc.fabric.api.biome.v1.OverworldClimate;
import net.fabricmc.fabric.api.biome.v1.BiomeModification;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

public enum BOPClimates
{
    ICE_CAP (OverworldClimate.SNOWY),
    TUNDRA (OverworldClimate.SNOWY),
    WET_BOREAL (OverworldClimate.COOL),
    DRY_BOREAL (OverworldClimate.COOL),
    WET_TEMPERATE (OverworldClimate.COOL),
    DRY_TEMPERATE (OverworldClimate.TEMPERATE),
    COOL_TEMPERATE (OverworldClimate.COOL),
    WARM_TEMPERATE (OverworldClimate.TEMPERATE),
    SUBTROPICAL (OverworldClimate.TEMPERATE),
    TROPICAL (OverworldClimate.DRY),
    MEDITERRANEAN (OverworldClimate.TEMPERATE),
    SAVANNA (OverworldClimate.DRY),
    HOT_DESERT (OverworldClimate.DRY),
    WASTELAND (null),
    NETHER (null);

    public final OverworldClimate biomeType;
    private int totalBiomesWeight;
    private int totalIslandBiomesWeight;

    private ArrayList<WeightedBiomeEntry> landBiomes = Lists.newArrayList();
    private ArrayList<WeightedBiomeEntry> islandBiomes = Lists.newArrayList();

    BOPClimates(OverworldClimate biomeType)
    {
        this.biomeType = biomeType;
    }

    public BOPClimates addBiome(int weight, RegistryKey<Biome> biome)
    {
        return this.addBiome(new WeightedBiomeEntry(weight, biome));
    }

    public BOPClimates addBiome(WeightedBiomeEntry biomeEntry)
    {
        this.totalBiomesWeight += biomeEntry.weight;
        this.landBiomes.add(biomeEntry);
        return this;
    }

    public BOPClimates addIslandBiome(int weight, RegistryKey<Biome> biome)
    {
        return this.addIslandBiome(new WeightedBiomeEntry(weight, biome));
    }

    public BOPClimates addIslandBiome(WeightedBiomeEntry biomeEntry)
    {
        this.totalIslandBiomesWeight += biomeEntry.weight;
        this.islandBiomes.add(biomeEntry);
        return this;
    }

    public RegistryKey<Biome> getRandomBiome(ChunkRandom context, RegistryKey<Biome> fallback)
    {
        if (this.totalBiomesWeight == 0)
            return fallback;

        int weight = context.next(this.totalBiomesWeight);
        Iterator<WeightedBiomeEntry> iterator = this.landBiomes.iterator();
        WeightedBiomeEntry item;
        do
        {
            item = iterator.next();
            weight -= item.weight;
        }
        while (weight >= 0);
        return item.biome;
    }

    public RegistryKey<Biome> getRandomIslandBiome(ChunkRandom context, RegistryKey<Biome> fallback)
    {
        if (this.totalIslandBiomesWeight == 0)
            return fallback;

        int weight = context.next(this.totalIslandBiomesWeight);
        Iterator<WeightedBiomeEntry> iterator = this.islandBiomes.iterator();
        WeightedBiomeEntry item;
        do
        {
            item = iterator.next();
            weight -= item.weight;
        }
        while (weight >= 0);
        return item.biome;
    }

    public RegistryKey<Biome> getRandomOceanBiome(ChunkRandom context, boolean deep)
    {
        return (deep ? BiomeKeys.DEEP_OCEAN : BiomeKeys.OCEAN);
    }

    public ImmutableList<WeightedBiomeEntry> getLandBiomes()
    {
        return this.landBiomes.isEmpty() ? ImmutableList.of(this.getDefaultWeightedBiomeEntry()) : ImmutableList.copyOf(this.landBiomes);
    }

    public ImmutableList<WeightedBiomeEntry> getIslandBiomes()
    {
        return this.islandBiomes.isEmpty() ? ImmutableList.of(this.getDefaultWeightedBiomeEntry()) : ImmutableList.copyOf(this.islandBiomes);
    }

    private WeightedBiomeEntry getDefaultWeightedBiomeEntry()
    {
        return new WeightedBiomeEntry(100, BiomeKeys.OCEAN);
    }

    private static BOPClimates[] values = BOPClimates.values();

    public static BOPClimates lookup(int i) {return values[i];}

    // map temperature and rainfall to climates
    // temperature values from 0 (cold) to 8 (hot) and rainfall values from 0 (wet) to 11 (dry), index is (temperatureValue * 12) + rainfallValue
    // we will contrive to make any combination equally likely, so the overall rarity of each climate is in proportion to the number of times it appears in the array
    private static final BOPClimates[] climateMapping = new BOPClimates[]
    {
        TUNDRA,		    TUNDRA,			ICE_CAP,		ICE_CAP,		ICE_CAP,		ICE_CAP,		ICE_CAP,		ICE_CAP,		ICE_CAP,		ICE_CAP,		TUNDRA,			TUNDRA,
    	WET_BOREAL,		WET_BOREAL,		TUNDRA,			TUNDRA,			TUNDRA,			TUNDRA,			TUNDRA,			TUNDRA,			TUNDRA,			TUNDRA,			DRY_BOREAL,		DRY_BOREAL,
        WET_BOREAL,	    WET_BOREAL,		WET_BOREAL,		WET_BOREAL,		WET_BOREAL,		WET_BOREAL,		DRY_BOREAL,		DRY_BOREAL,		DRY_BOREAL,		DRY_BOREAL,		DRY_BOREAL,		DRY_BOREAL,
    	WET_TEMPERATE,	WET_TEMPERATE,	WET_TEMPERATE,	COOL_TEMPERATE,	COOL_TEMPERATE,	COOL_TEMPERATE,	COOL_TEMPERATE,	COOL_TEMPERATE,	COOL_TEMPERATE,	DRY_TEMPERATE,	DRY_TEMPERATE,	DRY_TEMPERATE,
    	WET_TEMPERATE,	WET_TEMPERATE,	WET_TEMPERATE,	COOL_TEMPERATE,	COOL_TEMPERATE,	COOL_TEMPERATE,	COOL_TEMPERATE,	COOL_TEMPERATE,	COOL_TEMPERATE,	DRY_TEMPERATE,	DRY_TEMPERATE,	DRY_TEMPERATE,
    	SUBTROPICAL,	SUBTROPICAL,	WET_TEMPERATE,	WARM_TEMPERATE, WARM_TEMPERATE,	WARM_TEMPERATE,	WARM_TEMPERATE,	WARM_TEMPERATE,	WARM_TEMPERATE,	DRY_TEMPERATE,	SAVANNA,		SAVANNA,
        SUBTROPICAL,	SUBTROPICAL,	SUBTROPICAL,	WARM_TEMPERATE,	WARM_TEMPERATE,	WARM_TEMPERATE,	WARM_TEMPERATE,	WARM_TEMPERATE,	WARM_TEMPERATE,	SAVANNA,		SAVANNA,		SAVANNA,
    	TROPICAL,		TROPICAL,		SUBTROPICAL,	SUBTROPICAL,	MEDITERRANEAN,	MEDITERRANEAN,	MEDITERRANEAN,	MEDITERRANEAN,	SAVANNA,		SAVANNA,		HOT_DESERT,		HOT_DESERT,
    	TROPICAL,		TROPICAL,		SUBTROPICAL,	SUBTROPICAL,	MEDITERRANEAN,	MEDITERRANEAN,	MEDITERRANEAN,	MEDITERRANEAN,	SAVANNA,		SAVANNA,		HOT_DESERT,		HOT_DESERT
    };

    public static int[] getClimateMappingInts()
    {
        // 9 temperature values, 12 rainfall values, 12 * 9 = 108
        int[] out = new int[108];
        for (int i = 0; i < 108; i++)
        {
            out[i] = climateMapping[i].ordinal();
        }
        return out;
    }

    public static ImmutableSet<RegistryKey<Biome>> getOverworldBiomes()
    {
        Set<RegistryKey<Biome>> set = Sets.newHashSet();

        for (BOPClimates climate : BOPClimates.values())
        {
            if (climate == BOPClimates.NETHER)
            {
                continue;
            }

            set.addAll(climate.getLandBiomes().stream().map(weightedBiomeEntry -> weightedBiomeEntry.biome).collect(Collectors.toSet()));
            set.addAll(climate.getIslandBiomes().stream().map(weightedBiomeEntry -> weightedBiomeEntry.biome).collect(Collectors.toSet()));
        }

        ModBiomes.subBiomes.values().forEach(weightedSubBiome -> set.add(weightedSubBiome.biome));
        return ImmutableSet.copyOf(set);
    }

    public static class WeightedBiomeEntry
    {
        public final int weight;
        public final RegistryKey<Biome> biome;

        public WeightedBiomeEntry(int weight, RegistryKey<Biome> biome)
        {
            this.weight = weight;
            this.biome = biome;
        }
    }

    // for debugging purposes
    public static void printWeights()
    {
        for (BOPClimates climate : BOPClimates.values())
        {
            for (WeightedBiomeEntry entry : climate.landBiomes)
            {
                System.out.println(climate.name()+" "+entry.biome.getValue()+" "+entry.weight);
            }
        }
    }

}
