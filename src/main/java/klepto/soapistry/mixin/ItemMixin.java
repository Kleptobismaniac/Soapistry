/* 
package klepto.soapistry.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import klepto.soapistry.registry.item.ModItems;
import klepto.soapistry.registry.item.advanced.soap_variants.Soap;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

@Mixin(Item.class)
public class ItemMixin {
    

    @Inject(method = "getMaxUseTime", at = @At("TAIL"))
    public int getMaxUseTime(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (stack.isOf(ModItems.SOAP)) {
            return 7200;
        } else {
          return 0;  
        }
        
    }
}
*/