package biomesoplenty.client.renderer;

import biomesoplenty.common.entity.item.BoatEntityBOP;
import biomesoplenty.core.BiomesOPlenty;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.util.Identifier;

public class EntityModelLayersBOP extends EntityModelLayers {
    
    private static EntityModelLayer createBOP(String id, String layer) {
        return new EntityModelLayer(new Identifier(BiomesOPlenty.MOD_ID, id), layer);
    }
    
    public static EntityModelLayer createBoatBOP(BoatEntityBOP.BoatModel type) {
        return createBOP("boat/" + type.getName(), "main");
    }

}
