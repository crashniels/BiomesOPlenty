package biomesoplenty.core;

import biomesoplenty.client.renderer.BoatRendererBOP;
import biomesoplenty.client.renderer.EntityModelLayersBOP;
import biomesoplenty.common.entity.item.BoatEntityBOP;
import biomesoplenty.init.ModBiomes;
import biomesoplenty.init.ModBlocks;
import biomesoplenty.init.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.BoatEntityModel;

public class BiomesOPlentyClient implements ClientModInitializer{

    @Override
    public void onInitializeClient() {
        ModBlocks.renderBlockStuff();
        ClientProxy.init();
        EntityRendererRegistry.INSTANCE.register(ModEntities.boat, BoatRendererBOP::new);
        registerBoatEntityModels();
        //ModBiomes.clientSetup();
    }

    private void registerBoatEntityModels() {
        //taken straight from vanilla in EntityModels.class
        BoatEntityBOP.BoatModel[] var20 = BoatEntityBOP.BoatModel.values();
        int var21 = var20.length;

        for(int var22 = 0; var22 < var21; ++var22) {
            BoatEntityBOP.BoatModel type = var20[var22];
            //builder.put(EntityModelLayersBOP.createBoatBOP(type), texturedModelData19);
            EntityModelLayerRegistry.registerModelLayer(EntityModelLayersBOP.createBoatBOP(type), BoatEntityModel::getTexturedModelData);
         }
    }
    
}
