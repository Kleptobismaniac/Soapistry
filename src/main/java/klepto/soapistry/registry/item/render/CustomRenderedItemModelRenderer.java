/*package klepto.soapistry.registry.item.render;


import net.minecraft.client.MinecraftClient;

import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry.DynamicItemRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.client.render.*;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;

public abstract class CustomRenderedItemModelRenderer implements DynamicItemRenderer {

    //render(ItemStack stack, ModelTransformationMode mode, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay);

	@Override
	public void render(ItemStack stack, ModelTransformationMode transformType, MatrixStack ms, VertexConsumerProvider buffer, int light, int overlay) {
		if(!(MinecraftClient.getInstance()
				.getItemRenderer()
				.getModel(stack, null, null, 0) instanceof CustomRenderedItemModel)) return; // insure we are only casting CustomRenderedItemModel incase another mod's messes with models
		CustomRenderedItemModel mainModel = (CustomRenderedItemModel) MinecraftClient.getInstance()
			.getItemRenderer()
			.getModel(stack, null, null, 0);
		PartialItemModelRenderer renderer = PartialItemModelRenderer.of(stack, transformType, ms, buffer, overlay);

		ms.push();
		ms.translate(0.5F, 0.5F, 0.5F);
		render(stack, mainModel, renderer, transformType, ms, buffer, light, overlay);
		ms.pop();
	}

    protected abstract void render(ItemStack stack, CustomRenderedItemModel model, PartialItemModelRenderer renderer, ModelTransformationMode transformType,
    MatrixStack ms, VertexConsumerProvider buffer, int light, int overlay);
    /*public void render(ItemStack stack, ModelTransformationMode mode, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay){
        if(!(MinecraftClient.getInstance()
				.getItemRenderer()
				.getModel(stack, null, null, 0) instanceof CustomRenderedItemModel)) return; // insure we are only casting CustomRenderedItemModel incase another mod's messes with models
		CustomRenderedItemModel mainModel = (CustomRenderedItemModel) MinecraftClient.getInstance()
			.getItemRenderer()
			.getModel(stack, null, null, 0);
		PartialItemModelRenderer renderer = PartialItemModelRenderer.of(stack, mode, matrices, buffer, overlay);

		matrices.push();
		matrices.translate(0.5F, 0.5F, 0.5F);
		render(stack, mainModel, renderer, mode, matrices,  light, overlay);
		matrices.pop();
    }

	}*/