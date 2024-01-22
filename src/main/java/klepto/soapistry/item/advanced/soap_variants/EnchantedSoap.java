/*package klepto.soapistry.item.advanced.soap_variants;

import klepto.soapistry.block.ModBlocks;
import klepto.soapistry.status_effects.ModEffects;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.screen.slot.Slot;
import net.minecraft.server.integrated.IntegratedServer;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ClickType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class EnchantedSoap extends SoapySoap{
    StatusEffect slippery = ModEffects.SLIPPERY;
    public static IntegratedServer server;

    public EnchantedSoap(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        PlayerEntity user = context.getPlayer();
        BlockPos pos = context.getBlockPos();
        BlockState blockState = world.getBlockState(pos);
        BlockEntity blockEntity = world.getBlockEntity(pos);
        ItemStack itemStack = user.getMainHandStack();

        if(blockState.getBlock().equals(Blocks.ENCHANTING_TABLE)) {
            Random random = Random.create();
            //TODO Give Enchanted Soap Item functionality 
            EnchantmentHelper.enchant(random, itemStack, 0, true);
        }
        return ActionResult.SUCCESS;
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
                return true;
            }
    }

    public void destroyItem(ItemStack stack){
        if (stack.getDamage() < stack.getMaxDamage()){
            stack.setDamage(stack.getDamage() + 1);
        } else if (stack.getDamage() == stack.getMaxDamage()){
            stack.decrement(1);
        }
    }
}
    



*/