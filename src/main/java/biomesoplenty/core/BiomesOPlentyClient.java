package biomesoplenty.core;

import biomesoplenty.init.ModBiomes;
import biomesoplenty.init.ModBlocks;
import net.fabricmc.api.ClientModInitializer;

public class BiomesOPlentyClient implements ClientModInitializer{

    @Override
    public void onInitializeClient() {
        ModBlocks.renderBlockStuff();
        ClientProxy.init();
        //Register Entity renderer idk
        //ModBiomes.clientSetup();

    }
    
}
