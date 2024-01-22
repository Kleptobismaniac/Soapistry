package klepto.soapistry.item.advanced.soap_variants;

import java.util.Map;

import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtList;
import net.minecraft.screen.slot.Slot;
import net.minecraft.server.integrated.IntegratedServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ClickType;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class AshenSoap extends SoapySoap{
    public static IntegratedServer server;

    public AshenSoap(Settings settings) {
        super(settings);
    }
    
    /*public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(world instanceof ServerWorld && user.getOffHandStack().isEmpty()){
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 300), (Entity)user);
            destroyItem(user.getMainHandStack(), user);
        }
        return TypedActionResult.success(user.getMainHandStack());
    } */

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        PlayerEntity user = context.getPlayer();
        BlockPos pos = context.getBlockPos();
        BlockState blockState = world.getBlockState(pos);
        return ActionResult.SUCCESS;
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
                if (itemStack.hasEnchantments()){
                    NbtList enchants = itemStack.getEnchantments();
                    Map<Enchantment, Integer> enchantmentList = EnchantmentHelper.fromNbt(enchants);
                    
                    for (int i = 0; i < enchants.size(); i++){
                        if (enchantmentList.containsKey(Enchantments.BINDING_CURSE) || enchantmentList.containsKey(Enchantments.VANISHING_CURSE))
                        //System.out.println("THIS ENCHANTMENT EXISTS");
                            enchantmentList.remove(Enchantments.BINDING_CURSE);
                            enchantmentList.remove(Enchantments.VANISHING_CURSE);
                            world.playSound(player, player.getBlockPos(), SoundEvents.ENTITY_ENDER_EYE_DEATH, SoundCategory.PLAYERS, 0.5f, 0.3f);
                            world.playSound(player, player.getBlockPos(), SoundEvents.BLOCK_CHAIN_BREAK, SoundCategory.PLAYERS, 0.1f, 0.1f);
                            world.playSound(player, player.getBlockPos(), SoundEvents.BLOCK_SCULK_BREAK, SoundCategory.PLAYERS, 0.1f, 0.1f);
                            world.playSound(player, player.getBlockPos(), SoundEvents.BLOCK_SCULK_PLACE, SoundCategory.PLAYERS, 0.1f, 0.5f);
                            world.playSound(player, player.getBlockPos(), SoundEvents.BLOCK_ANCIENT_DEBRIS_BREAK, SoundCategory.PLAYERS, 0.5f, 0.1f);
                        }
                        EnchantmentHelper.set(enchantmentList, itemStack);
                    }
                    
                    //Change to custom sounds in Audacity
                    

                    destroyItem(stack, player, true);
                    return true;
                }
        
    }

    
}
    


