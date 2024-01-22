package klepto.soapistry.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemHandler extends Item{

    public ItemHandler(Settings settings) {
        super(settings);
        //TODO Auto-generated constructor stub
    }
    
    public void destroyItem(ItemStack stack, PlayerEntity player, Boolean breakFully){
        if (!player.isCreative()){
            if(!breakFully){
                if (stack.getDamage() < stack.getMaxDamage()){
                    stack.setDamage(stack.getDamage() + 1);
                } else if (stack.getDamage() == stack.getMaxDamage()){
                    stack.decrement(1);
                }
            } else {
                stack.decrement(1);
            }
        }
    }
}
