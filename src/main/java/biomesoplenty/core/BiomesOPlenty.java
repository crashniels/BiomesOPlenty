/*******************************************************************************
 * Copyright 2014-2019, the Biomes O' Plenty Team
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * 
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package biomesoplenty.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import biomesoplenty.init.ModBiomes;
import biomesoplenty.init.ModBlocks;
import biomesoplenty.init.ModEntities;
import biomesoplenty.init.ModItems;
import biomesoplenty.init.ModPaintings;
import biomesoplenty.init.ModSounds;
import biomesoplenty.init.ModVanillaCompat;
import net.fabricmc.api.ModInitializer;

public class BiomesOPlenty implements ModInitializer
{
    public static final String MOD_ID = "biomesoplenty";

    public static BiomesOPlenty instance;
    
    public static Logger logger = LogManager.getLogger(MOD_ID);

    public BiomesOPlenty()
    {
    	instance = this;
    }

    @Override
    public void onInitialize() {
        ModPaintings.registerPaintingMotives();
        ModSounds.registerSounds();
        ModItems.registerItems();
        ModBlocks.registerBlocks();
        ModVanillaCompat.setup();
        ModEntities.registerEntities();
        //ModBiomes.setup();
        ModBiomes.registerBiomes();
        //ModConfig.setup();
    }
}
