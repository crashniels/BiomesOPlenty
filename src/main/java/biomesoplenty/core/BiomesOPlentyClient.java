package biomesoplenty.core;

import biomesoplenty.init.ModBlocks;
import net.fabricmc.api.ClientModInitializer;

public class BiomesOPlentyClient implements ClientModInitializer{

    @Override
    public void onInitializeClient() {
        // TODO Auto-generated method stub
        ModBlocks.renderBlockStuff();
    }
    
}
