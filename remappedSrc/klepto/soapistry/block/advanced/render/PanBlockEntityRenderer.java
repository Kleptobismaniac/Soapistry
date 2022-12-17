package klepto.soapistry.block.advanced.render;

import klepto.soapistry.block.entity.PanBlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3f;
import net.minecraft.client.render.model.json.ModelTransformation;

//@Environment(EnvType.CLIENT)
public class PanBlockEntityRenderer implements BlockEntityRenderer<PanBlockEntity> {

    public PanBlockEntityRenderer(BlockEntityRendererFactory.Context context) {

    }


    @Override
    public void render(PanBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light,
    int overlay) {  

        ItemStack stack = entity.getStack(0);
        
        matrices.push();
        double offset = Math.sin((entity.getWorld().getTime() + tickDelta) / 8.0) / 4.0;
        // Move the item
        matrices.translate(0.5, 1.25 + offset, 0.5);
 
        // Rotate the item
        matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion((entity.getWorld().getTime() + tickDelta) * 4));

        MinecraftClient.getInstance().getItemRenderer().renderItem(stack, ModelTransformation.Mode.GROUND, light, overlay, matrices, vertexConsumers, 0);
 
        // Mandatory call after GL calls
        matrices.pop();

        int lightAbove = WorldRenderer.getLightmapCoordinates(entity.getWorld(), entity.getPos().up());
        MinecraftClient.getInstance().getItemRenderer().renderItem(stack, ModelTransformation.Mode.GROUND, lightAbove, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, 0);
    }
}