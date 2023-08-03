/*package klepto.soapistry.mixin.tooltips;
 package klepto.soapistry.mixin.tooltips;
 import java.util.List;
 import org.spongepowered.asm.mixin.Mixin;
 import org.spongepowered.asm.mixin.injection.At;
 import org.spongepowered.asm.mixin.injection.Inject;
 import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
 import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
 import klepto.soapistry.item.ModItems;
 import klepto.soapistry.item.advanced.Soap;
 import klepto.soapistry.util.StuffTimerAccessor;
 import net.minecraft.client.font.MultilineText.Line;
 import net.minecraft.client.item.TooltipContext;
 import net.minecraft.entity.player.PlayerEntity;
 import net.minecraft.item.ItemStack;
 import net.minecraft.item.Items;
 import net.minecraft.screen.slot.Slot;
 import net.minecraft.text.TranslatableTextContent;
 import net.minecraft.util.ClickType;
 import net.minecraft.util.Formatting;
 import net.minecraft.text.MutableText;
 import net.minecraft.text.Text;
 @Mixin(ItemStack.class)
 public class TooltipMixin implements StuffTimerAccessor{
  
     @Inject(method = "getTooltip", at = @At("HEAD"), cancellable = true)
     public void addTooltipLines(List<Text> lines, CallbackInfoReturnable<List<Text>> callbackInfo) {
         if (Soap.server != null && ((StuffTimerAccessor) Soap.server).getRegistered()){
             //if (player.getInventory().contains(ModItems.SOAP.getDefaultStack())){
                 System.out.println("THERE IS SOAP HERE");
                 lines.add(Text.literal("------------------------"));
                 lines.add(Text.literal("Cleanliness 1").formatted(Formatting.LIGHT_PURPLE));
          
         }
         //player.currentScreenHandler.getCursorStack();
     }
     @Override
     public void setTimer(long timerTicks, int level) {
         // TODO Auto-generated method stub
      
     }
     @Override
     public boolean setRegistered(boolean registered) {
         // TODO Auto-generated method stub
         return false;
     }
     @Override
     public boolean getRegistered() {
         // TODO Auto-generated method stub
         return false;
     }
 }*/