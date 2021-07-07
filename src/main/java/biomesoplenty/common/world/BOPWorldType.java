/*******************************************************************************
 * Copyright 2014-2020, the Biomes O' Plenty Team
 *
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 *
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/
package biomesoplenty.common.world;

import net.minecraft.client.render.SkyProperties.Overworld;
import net.minecraft.client.world.GeneratorType;
import net.minecraft.util.registry.DynamicRegistryManager;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.GeneratorOptions;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorSettings;
import net.minecraft.world.gen.chunk.NoiseChunkGenerator;
import net.minecraftforge.common.world.ForgeWorldType;

public class BOPWorldType extends GeneratorType
{
    public BOPWorldType()
    {
        super(null);
    }

    @Override
    public ChunkGenerator getChunkGenerator(Registry<Biome> biomeRegistry, Registry<ChunkGeneratorSettings> dimensionSettingsRegistry, long seed)
    {
        return new NoiseChunkGenerator(new BOPBiomeProvider(seed, biomeRegistry), seed, () -> dimensionSettingsRegistry.getOrThrow(DimensionSettings.OVERWORLD));
    }

    @Override
    public GeneratorOptions createDefaultOptions(DynamicRegistryManager.Impl dynamicRegistries, long seed, boolean generateFeatures, boolean generateBonusChest)
    {
        Registry<Biome> biomeRegistry = dynamicRegistries.get(Registry.BIOME_KEY);
        Registry<ChunkGeneratorSettings> dimensionSettingsRegistry = dynamicRegistries.get(Registry.CHUNK_GENERATOR_SETTINGS_KEY);
        Registry<DimensionType> dimensionTypeRegistry = dynamicRegistries.get(Registry.DIMENSION_TYPE_KEY);

        return new GeneratorOptions(seed, generateFeatures, generateBonusChest, GeneratorOptions.withOverworld(dimensionTypeRegistry, BOPDimensionType.bopDimensions(biomeRegistry, dimensionSettingsRegistry, seed), createChunkGenerator(biomeRegistry, dimensionSettingsRegistry, seed)));
    }
}
