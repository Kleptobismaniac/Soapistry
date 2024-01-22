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
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ClickType;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import klepto.soapistry.item.ItemHandler;


public class MysticalResidue extends ItemHandler{
    public static IntegratedServer server;
    Random random = new Random();


    public MysticalResidue(Settings settings) {
        super(settings);
    }

    public boolean hasGlint(ItemStack stack) {
        return true;
     }

    @Override
    public boolean onStackClicked(ItemStack stack, Slot slot, ClickType clickType, PlayerEntity player){
        //stack is the item thats currently held on the cursor, itemStack is the stack thats being clicked by the item
        //Ex. Holding glass bottle = stack, clicking cooked beef with glass bottle = itemStack
        ItemStack itemStack = slot.getStack();
        World world = player.getWorld();
        server = MinecraftClient.getInstance().getServer();
            if (clickType != ClickType.RIGHT || slot.getStack().isEmpty()){
                return false;
            } else {
                if(itemStack.hasEnchantments()) {
                    NbtList enchants = itemStack.getEnchantments();
                    Map<Enchantment, Integer> enchantmentList = EnchantmentHelper.fromNbt(enchants);
                    int rand = random.nextInt(enchants.size());
                    int randChance = random.nextInt(9);

                    for (int i = 0; i < enchants.size(); i++){
                        if (i == rand ) {
                            Identifier level = EnchantmentHelper.getIdFromNbt(enchants.getCompound(rand));
                            System.out.println(enchants.getCompound(rand));
                            int lvl = EnchantmentHelper.getLevelFromNbt(enchants.getCompound(rand));
                            if (lvl < 10){
                            enchantmentList.replace(Registries.ENCHANTMENT.get(level), lvl + 1);
                            }
                        }
                    }
                    if (randChance == 0){
                        EnchantmentHelper.set(enchantmentList, itemStack);
                        world.playSound(player, player.getBlockPos(), SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.PLAYERS);
                        world.playSound(player, player.getBlockPos(), SoundEvents.BLOCK_AMETHYST_BLOCK_BREAK, SoundCategory.PLAYERS, 0.5f, 0.5f);

                    } else {
                        world.playSound(player, player.getBlockPos(), SoundEvents.BLOCK_CALCITE_BREAK, SoundCategory.BLOCKS);
                        world.playSound(player, player.getBlockPos(), SoundEvents.BLOCK_NETHERITE_BLOCK_STEP, SoundCategory.BLOCKS);
                        world.playSound(player, player.getBlockPos(), SoundEvents.ENTITY_ENDER_EYE_DEATH, SoundCategory.BLOCKS);
                    }
                    destroyItem(stack, player, true);
                }
                return true;
                
            }
    }
    
}
