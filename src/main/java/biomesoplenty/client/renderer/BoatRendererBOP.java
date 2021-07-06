package biomesoplenty.client.renderer;

import biomesoplenty.common.entity.item.BoatEntityBOP;
import biomesoplenty.common.entity.item.BoatEntityBOP.BoatModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

import static biomesoplenty.core.BiomesOPlenty.MOD_ID;

@Environment(EnvType.CLIENT)
public class BoatRendererBOP extends EntityRenderer<BoatEntityBOP> {
    protected final BoatModel model = new BoatModel();

    public BoatRendererBOP(EntityRendererManager renderer) {
        super(renderer);
        this.shadowRadius = 0.8f;
    }

    @Override
    public void render(BoatEntityBOP entity, float entityYaw, float partialTicks, MatrixStack matrixStack, IRenderTypeBuffer renderTypeBuffer, int light) {
        matrixStack.pushPose();
        matrixStack.translate(0d, 0.375d, 0d);
        matrixStack.mulPose(Vector3f.YP.rotationDegrees(180f - entityYaw));
        float f = (float) entity.getHurtTime() - partialTicks;
        float f1 = entity.getDamage() - partialTicks;
        if (f1 < 0f) {
            f1 = 0f;
        }
        if (f > 0f) {
            matrixStack.mulPose(Vector3f.XP.rotationDegrees(MathHelper.sin(f) * f * f1 / 10f * (float) entity.getHurtDir()));
        }
        float f2 = entity.getBubbleAngle(partialTicks);
        if (!MathHelper.equal(f2, 0f)) {
            matrixStack.mulPose(new Quaternion(new Vector3f(1f, 0f, 1f), entity.getBubbleAngle(partialTicks), true));
        }
        matrixStack.scale(-1f, -1f, 1f);
        matrixStack.mulPose(Vector3f.YP.rotationDegrees(90.0F));
        this.model.setupAnim(entity, partialTicks, 0f, -0.1f, 0f, 0f);
        IVertexBuilder ivertexbuilder = renderTypeBuffer.getBuffer(this.model.renderType(this.getTextureLocation(entity)));
        this.model.renderToBuffer(matrixStack, ivertexbuilder, light, OverlayTexture.NO_OVERLAY, 1f, 1f, 1f, 1f);
        if (!entity.isUnderWater()) {
            IVertexBuilder ivertexbuilder1 = renderTypeBuffer.getBuffer(RenderType.waterMask());
            this.model.waterPatch().render(matrixStack, ivertexbuilder1, light, OverlayTexture.NO_OVERLAY);
        }
        matrixStack.popPose();
        super.render(entity, entityYaw, partialTicks, matrixStack, renderTypeBuffer, light);
    }

    @Override
    public Identifier getTextureLocation(BoatEntityBOP entity) {
        return BOAT_TEXTURE_LOCATIONS[entity.getModel().ordinal()];
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
