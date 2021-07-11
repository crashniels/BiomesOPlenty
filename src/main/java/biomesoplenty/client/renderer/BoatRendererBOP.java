package biomesoplenty.client.renderer;

import biomesoplenty.common.entity.item.BoatEntityBOP;
import biomesoplenty.common.entity.item.BoatEntityBOP.BoatModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.BoatEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Quaternion;
import net.minecraft.util.math.Vec3f;
import java.util.stream.Stream;
import com.google.common.collect.ImmutableMap;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.block.*;
import biomesoplenty.client.renderer.EntityModelLayersBOP;

import static biomesoplenty.core.BiomesOPlenty.MOD_ID;

import java.util.Map;

import com.mojang.datafixers.util.Pair;

@Environment(EnvType.CLIENT)
public class BoatRendererBOP extends EntityRenderer<BoatEntityBOP> {
    private final Map<BoatEntityBOP.BoatModel, Pair<Identifier, BoatEntityModel>> texturesAndModels;

    public BoatRendererBOP(EntityRendererFactory.Context renderer) {
        super(renderer);
        this.shadowRadius = 0.8f;
        this.texturesAndModels = (Map)Stream.of(BoatEntityBOP.BoatModel.values()).collect(ImmutableMap.toImmutableMap((type) -> {
            return type;
         }, (type) -> {
            return Pair.of(new Identifier(MOD_ID, "textures/entity/boat/" + type.getName() + ".png"), new BoatEntityModel(renderer.getPart(EntityModelLayersBOP.createBoatBOP(type))));
         }));
    }

    @Override
    public void render(BoatEntityBOP entity, float entityYaw, float partialTicks, MatrixStack matrixStack, VertexConsumerProvider renderTypeBuffer, int light) {
        matrixStack.push();
        matrixStack.translate(0d, 0.375d, 0d);
        matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(180f - entityYaw));
        float f = (float) entity.getDamageWobbleTicks() - partialTicks;
        float f1 = entity.getDamageWobbleTicks() - partialTicks;
        if (f1 < 0f) {
            f1 = 0f;
        }
        if (f > 0f) {
            matrixStack.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(MathHelper.sin(f) * f * f1 / 10f * (float) entity.getDamageWobbleSide()));
        }
        float f2 = entity.interpolateBubbleWobble(partialTicks);
        if (!MathHelper.approximatelyEquals(f2, 0f)) {
            matrixStack.multiply(new Quaternion(new Vec3f(1f, 0f, 1f), entity.interpolateBubbleWobble(partialTicks), true));
        }

        Pair<Identifier, BoatEntityModel> pair = (Pair)this.texturesAndModels.get(entity.getModel());
        Identifier identifier = (Identifier)pair.getFirst();
        BoatEntityModel boatEntityModel = (BoatEntityModel)pair.getSecond();
        matrixStack.scale(-1f, -1f, 1f);
        matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(90.0F));
        boatEntityModel.setAngles(entity, partialTicks, 0f, -0.1f, 0f, 0f);
        VertexConsumer ivertexbuilder = renderTypeBuffer.getBuffer(boatEntityModel.getLayer(identifier));
        boatEntityModel.render(matrixStack, ivertexbuilder, light, OverlayTexture.DEFAULT_UV, 1f, 1f, 1f, 1f);
        if (!entity.isSubmergedInWater()) {
            VertexConsumer ivertexbuilder1 = renderTypeBuffer.getBuffer(RenderLayer.getWaterMask());
            boatEntityModel.getWaterPatch().render(matrixStack, ivertexbuilder1, light, OverlayTexture.DEFAULT_UV);
        }
        matrixStack.pop();
        super.render(entity, entityYaw, partialTicks, matrixStack, renderTypeBuffer, light);
    }

    @Override
    public Identifier getTexture(BoatEntityBOP entity) {
        //return BOAT_TEXTURE_LOCATIONS[entity.getModel().ordinal()];
        return (Identifier)((Pair)this.texturesAndModels.get(entity.getBoatType())).getFirst();
    }

    private static final Identifier[] BOAT_TEXTURE_LOCATIONS = new Identifier[] {
            new Identifier(MOD_ID, "textures/entity/boat/fir.png"),
            new Identifier(MOD_ID, "textures/entity/boat/redwood.png"),
            new Identifier(MOD_ID, "textures/entity/boat/cherry.png"),
            new Identifier(MOD_ID, "textures/entity/boat/mahogany.png"),
            new Identifier(MOD_ID, "textures/entity/boat/jacaranda.png"),
            new Identifier(MOD_ID, "textures/entity/boat/palm.png"),
            new Identifier(MOD_ID, "textures/entity/boat/willow.png"),
            new Identifier(MOD_ID, "textures/entity/boat/dead.png"),
            new Identifier(MOD_ID, "textures/entity/boat/magic.png"),
            new Identifier(MOD_ID, "textures/entity/boat/umbran.png"),
            new Identifier(MOD_ID, "textures/entity/boat/hellbark.png")
    };
}
