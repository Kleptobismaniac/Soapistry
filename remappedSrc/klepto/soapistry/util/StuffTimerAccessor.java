package klepto.soapistry.util;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.item.ItemStack;



public interface StuffTimerAccessor {
    void setTimer(long timerTicks, int level);
    //int setDurability(ItemStack stack);
    //ItemStack setItemStack(ItemStack itemStack);
    //ItemStack setStack(ItemStack stack);
    boolean setRegistered(boolean registered);
    boolean getRegistered();

}
