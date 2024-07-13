/*package klepto.soapistry.registry.item.render;

import java.util.Random;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.scoreboard.ScoreboardCriterion.RenderType;
import net.minecraft.util.math.Direction;



public class PartialItemModelRenderer {

	private static final PartialItemModelRenderer INSTANCE = new PartialItemModelRenderer();

	private final Random random = new Random();

	private ItemStack stack;
	private ModelTransformationMode transformType;
	private MatrixStack ms;
	private VertexConsumerProvider buffer;
	private int overlay;

	public static PartialItemModelRenderer of(ItemStack stack, ModelTransformationMode transformType,
    MatrixStack ms, VertexConsumerProvider buffer, int overlay) {
		PartialItemModelRenderer instance = INSTANCE;
		instance.stack = stack;
		instance.transformType = transformType;
		instance.ms = ms;
		instance.buffer = buffer;
		instance.overlay = overlay;
		return instance;
	}

	

	public void render(BakedModel model, RenderType type, int light) {
		if (stack.isEmpty())
			return;

		ms.push();
		ms.translate(-0.5D, -0.5D, -0.5D);

		
		ms.pop();
	}

	private void renderBakedItemModel(BakedModel model, int light, MatrixStack ms, VertexConsumer buffer) {
		ItemRenderer ir = MinecraftClient.getInstance()
			.getItemRenderer();
//		IModelData data = EmptyModelData.INSTANCE;

		
	}

}*/