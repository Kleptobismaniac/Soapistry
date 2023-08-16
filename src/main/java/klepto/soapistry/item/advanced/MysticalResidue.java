package klepto.soapistry.item.advanced;

import java.util.Map;
import java.util.Random;

import net.minecraft.client.MinecraftClient;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtList;
import net.minecraft.registry.Registries;
import net.minecraft.screen.slot.Slot;
import net.minecraft.server.integrated.IntegratedServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ClickType;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class MysticalResidue extends Item{
    public static IntegratedServer server;
    Random random = new Random();


    public MysticalResidue(Settings settings) {
        super(settings);
    }

    public boolean hasGlint(ItemStack stack) {
        return true;
     }
    
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(world instanceof ServerWorld && user.getOffHandStack().isEmpty()){
            destroyItem(user.getMainHandStack());
        }
        return TypedActionResult.success(user.getMainHandStack());
    } 

    @Override
    public boolean onStackClicked(ItemStack stack, Slot slot, ClickType clickType, PlayerEntity player){
        //stack is the item thats currently held on the cursor, itemStack is the stack thats being clicked by the item
        //Ex. Holding glass bottle = stack, clicking cooked beef with glass bottle = itemStack
        ItemStack itemStack = slot.getStack();
        server = MinecraftClient.getInstance().getServer();
            if (clickType != ClickType.RIGHT){
                return false;
            } else {
                if(itemStack.hasEnchantments()) {
                    NbtList enchants = itemStack.getEnchantments();
                    Map<Enchantment, Integer> enchantmentList = EnchantmentHelper.fromNbt(enchants);
                    int rand = random.nextInt(enchants.size());

                    for (int i = 0; i < enchants.size(); i++){
                        if (i == rand) {
                            Identifier level = EnchantmentHelper.getIdFromNbt(enchants.getCompound(rand));
                            System.out.println(enchants.getCompound(rand));
                            int lvl = EnchantmentHelper.getLevelFromNbt(enchants.getCompound(rand));
                            if (lvl < 10){
                            enchantmentList.replace(Registries.ENCHANTMENT.get(level), lvl + 1);
                            }
                        }
                    }
                    EnchantmentHelper.set(enchantmentList, itemStack);
                    stack.decrement(1);
                }
            }
        return true;
    }

    

    public void destroyItem(ItemStack stack){
        if (stack.getDamage() < stack.getMaxDamage()){
            stack.setDamage(stack.getDamage() + 1);
        } else if (stack.getDamage() == stack.getMaxDamage()){
            stack.decrement(1);
        }
    }

    
}
