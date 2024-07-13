/*package klepto.soapistry.registry.item.render;

import org.joml.Vector3f;


import klepto.soapistry.registry.item.ModItems;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.mixin.client.indigo.renderer.ItemRendererMixin;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;

public class SoapItemRenderer extends CustomRenderedItemModelRenderer {

    /*public static void registerItemRenderers() {
        EntityRendererRegistry.register(TropicaEntities.COCONUT, FlyingItemEntityRenderer::new);
    }	
	//public void render(ItemStack stack, ModelTransformationMode transformType, MatrixStack ms, VertexConsumerProvider buffer, int light, int overlay) {
	public static float getPartialTicks() {
		MinecraftClient mc = MinecraftClient.getInstance();
		return 100f;
		//(mc.isPaused() ? MinecraftClient.getRenderPartialTicksPaused(mc) : mc.getFramebuffer());
	}

	@Override
	protected void render(ItemStack stack, CustomRenderedItemModel model, PartialItemModelRenderer renderer,
	ModelTransformationMode transformType, MatrixStack ms, VertexConsumerProvider buffer, int light, int overlay) {
		ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();
		PlayerEntity player = MinecraftClient.getInstance().player;
		float partialTicks = 100;

		boolean leftHand = transformType == ModelTransformationMode.FIRST_PERSON_LEFT_HAND;
		boolean firstPerson = leftHand || transformType == ModelTransformationMode.FIRST_PERSON_RIGHT_HAND;

		//boolean jeiMode = tag.contains("JEI");

		ms.push();

		//if (tag.contains("Polishing")) {
        if (((PlayerEntity)player).getActiveItem().isOf(ModItems.SOAP)) {    
			ms.push();

			if (transformType == ModelTransformationMode.GUI) {
				ms.translate(0.0F, .2f, 1.0F);
				ms.scale(.75f, .75f, .75f);
			} else {
				int modifier = leftHand ? -1 : 1;
				//ms.mulPose(Vector3f.YP.rotationDegrees(modifier * 40));
			}

			// Reverse bobbing
			float time = 100f;
			if (time / (float) stack.getMaxUseTime() < 0.8F) {
				float bobbing = (float)(-Math.abs(Math.cos(time / 4.0F * (float) Math.PI) * 0.1F));

				if (transformType == ModelTransformationMode.GUI)
					ms.translate(bobbing, bobbing, 0.0F);
				else
					ms.translate(0.0f, bobbing, 0.0F);
			}

			itemRenderer.renderItem(stack, ModelTransformationMode.NONE, light, overlay, ms, buffer, player.getWorld(), 0);

			ms.pop();
		}

		if (firstPerson) {
			int itemInUseCount = player.getItemUseTimeLeft();
			if (itemInUseCount > 0) {
				int modifier = leftHand ? -1 : 1;
				ms.translate(modifier * .5f, 0, -.25f);
				//ms.mulPose(Vec3d.getZ().rotationDegrees(modifier * 40));
				//ms.mulPose(Vector3f.XP.rotationDegrees(modifier * 10));
				//ms.mulPose(Vector3f.YP.rotationDegrees(modifier * 90));
			}
		}

		itemRenderer.renderItem(stack, ModelTransformationMode.NONE, false, ms, buffer, light, overlay, model.getOriginalModel());

		ms.pop();
	}

}
*/