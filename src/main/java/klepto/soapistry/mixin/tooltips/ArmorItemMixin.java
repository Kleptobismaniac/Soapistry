/*package klepto.soapistry.mixin.tooltips;

import java.util.List;

import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;

import com.mojang.authlib.minecraft.client.MinecraftClient;

import klepto.soapistry.item.ModItems;
import klepto.soapistry.item.advanced.Soap;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Equipment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.screen.slot.Slot;
import net.minecraft.text.Text;
import net.minecraft.util.ClickType;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

@Mixin(ArmorItem.class)
public class ArmorItemMixin extends Item implements Equipment {

    private ItemStack armorItem;

    
    
    
    public ArmorItemMixin(Settings settings) {
        super(settings);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        if (Soap.clicked){
            tooltip.add(Text.literal("Cleanliness 1").formatted(Formatting.byColorIndex(6)));
        }
        
    }

    /*@Override
    public boolean onStackClicked(ItemStack stack, Slot slot, ClickType clickType, PlayerEntity player){
        //stack is the item thats currently held on the cursor, itemStack is the stack thats being clicked by the item
        //Ex. Holding glass bottle = stack, clicking cooked beef with glass bottle = itemStack
        ItemStack itemStack = slot.getStack();
        
            if (clickType != ClickType.RIGHT){
                return false;
            } else if(stack.isOf(ModItems.SOAP) && itemStack.isOf(Items.DIAMOND_BOOTS)){
                //int durability = itemStack.getDamage();
                //timerID = itemStack.getName().toString();
                //timer.setRegistered(true);
                
                armorItem = stack;
                System.out.println(armorItem);
                clicked = true;
                return true;
            }
        return true;
    }
    

    @Override
    public EquipmentSlot getSlotType() {
        // TODO Auto-generated method stub
        return null;
    }

    

    
}
*/