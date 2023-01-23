package klepto.soapistry.mixin.glass_bottle;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BundleItem;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.ClickType;

@Mixin(BundleItem.class)
public interface GlassBottleAccessor {
    @Invoker("onStackClicked")
    public boolean onStackClicked(ItemStack stack, Slot slot, ClickType clickType, PlayerEntity player);
}
