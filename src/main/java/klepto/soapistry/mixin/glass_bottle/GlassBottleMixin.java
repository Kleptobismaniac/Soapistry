package klepto.soapistry.mixin.glass_bottle;

import org.spongepowered.asm.mixin.Mixin;

import klepto.soapistry.item.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.GlassBottleItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.slot.Slot;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ClickType;
import net.minecraft.world.World;

@Mixin(GlassBottleItem.class)
public class GlassBottleMixin extends Item implements GlassBottleAccessor{

    private int timesClicked;
    
    public GlassBottleMixin(Settings settings) {
        super(settings);
    }

    @Override
    public boolean onStackClicked(ItemStack stack, Slot slot, ClickType clickType, PlayerEntity player){
        //stack is the item thats currently held on the cursor, itemStack is the stack thats being clicked by the item
        //Ex. Holding glass bottle = stack, clicking cooked beef with glass bottle = itemStack
        World world = player.getWorld();
        Item[] itemsList = {Items.COOKED_BEEF, Items.COOKED_CHICKEN, Items.COOKED_MUTTON, Items.COOKED_PORKCHOP, Items.COOKED_RABBIT, Items.COOKED_SALMON};

        ItemStack itemStack = slot.getStack();
        if(timesClicked < 3){
            if (clickType != ClickType.RIGHT || slot.getStack().isEmpty()){
                return false;
            } else {
                for (Item items : itemsList){
                    if (itemStack.isOf(items)) {
                        player.giveItemStack(ModItems.BOTTLE_OF_FAT.getDefaultStack());
                        stack.decrement(1);
                        //TODO Replace sounds with customs
                        world.playSound(player, player.getBlockPos(), SoundEvents.BLOCK_HONEY_BLOCK_PLACE, SoundCategory.PLAYERS);
                        timesClicked++;
                        return true;
                    }
                }
            } 
        } else if (timesClicked == 3){
            player.giveItemStack(ModItems.BOTTLE_OF_FAT.getDefaultStack());
            itemStack.decrement(1);
            player.giveItemStack(Items.BONE.getDefaultStack());
            timesClicked = 0;
            
        }
        return true;
    }
}
