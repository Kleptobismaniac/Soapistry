package klepto.soapistry.registry.item.advanced;

import java.util.Map;
import java.util.Random;

import klepto.soapistry.registry.item.handlers.ItemHandler;
import klepto.soapistry.registry.sound.ModSounds;
import net.minecraft.client.MinecraftClient;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtList;
import net.minecraft.registry.Registries;
import net.minecraft.screen.slot.Slot;
import net.minecraft.server.integrated.IntegratedServer;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ClickType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


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
        BlockPos pos = player.getBlockPos();
        server = MinecraftClient.getInstance().getServer();
            if (clickType != ClickType.RIGHT || slot.getStack().isEmpty()){
                return false;
            } else {
                if(itemStack.hasEnchantments()) {
                    NbtList enchants = itemStack.getEnchantments();
                    Map<Enchantment, Integer> enchantmentList = EnchantmentHelper.fromNbt(enchants);
                    //rand is the chance that the Mystical Residue will upgrade the enchantment
                    int rand = random.nextInt(enchants.size());
                    //randChance is the chance that the Mystical Residue will break
                    int randChance = random.nextInt(2);
                    for (int i = 0; i < enchants.size(); i++){
                        if (i == rand ) {
                            Identifier level = EnchantmentHelper.getIdFromNbt(enchants.getCompound(rand));
                            int lvl = EnchantmentHelper.getLevelFromNbt(enchants.getCompound(rand));
                            if (lvl < 10 && randChance == 0){
                            enchantmentList.replace(Registries.ENCHANTMENT.get(level), lvl + 1);
                            world.playSound(null, pos, ModSounds.MYSTICAL_RESIDUE_SUCCESS, SoundCategory.NEUTRAL, 10f, 1f);
                            } else {
                                world.playSound(null, pos, ModSounds.MYSTICAL_RESIDUE_FAIL, SoundCategory.NEUTRAL, 1f, 1f);
                            }
                        }
                    }
                    destroyItem(stack, player, true);
                }
                return true;
                
            }
    }
    
}
