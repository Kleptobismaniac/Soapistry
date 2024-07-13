package klepto.soapistry.mixin.animation;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


import klepto.soapistry.registry.item.ModItems;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Arm;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;

@Mixin(HeldItemRenderer.class)
public class HeldItemRendererMixin{

    @Shadow
    protected MinecraftClient client;

    /*
    @Shadow
    private void applyEatOrDrinkTransformation(MatrixStack matrices, float tickDelta, Arm arm, ItemStack stack) {}
    
    
    @Shadow
    public void renderItem(LivingEntity entity, ItemStack stack, ModelTransformationMode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {}
    */
    


    //TODO Create Soapy Animation
    @Inject(method = "renderFirstPersonItem", at = @At("TAIL"), cancellable = true)
    private void renderFirstPersonItem(AbstractClientPlayerEntity player, float tickDelta, float pitch, Hand hand, float swingProgress, ItemStack item, float equipProgress, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, CallbackInfo info) {
        if (item.isOf(ModItems.SOAP)) {
            boolean bl = hand == Hand.MAIN_HAND;
            Arm arm = bl ? player.getMainArm() : player.getMainArm().getOpposite();
            
            if(player.isUsingItem() && player.getItemUseTimeLeft() > 0 && player.getActiveHand() == hand ){
                this.applySoapTransformation(matrices, tickDelta, arm, item);
            }
        }
    }   

    public void applySoapTransformation(MatrixStack matrices, float tickDelta, Arm arm, ItemStack stack) {
        float f = (float)this.client.player.getItemUseTimeLeft() - tickDelta + 1.0F;
        float g = f / (float)stack.getMaxUseTime();
        float h;
        if (g < 0.8F) {
           h = MathHelper.abs(MathHelper.cos(f / 4.0F * 3.1415927F) * 0.1F);
           matrices.translate(0.0F, h, 0.0F);
        }
  
        h = 1.0F - (float)Math.pow((double)g, 27.0);
        int i = arm == Arm.RIGHT ? 1 : -1;
        matrices.translate(h * 0.6F * (float)i, h * -0.5F, h * 0.0F);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees((float)i * h * 90.0F));
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(h * 10.0F));
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees((float)i * h * 30.0F));
     }
}