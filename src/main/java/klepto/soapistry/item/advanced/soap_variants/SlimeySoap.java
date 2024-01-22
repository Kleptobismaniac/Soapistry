package klepto.soapistry.item.advanced.soap_variants;

import java.util.Arrays;
import java.util.List;

import klepto.soapistry.sound.ModSounds;
import klepto.soapistry.status_effects.ModEffects;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.screen.slot.Slot;
import net.minecraft.server.integrated.IntegratedServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ClickType;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SlimeySoap extends SoapySoap{
    StatusEffect slippery = ModEffects.SLIPPERY;
    public static IntegratedServer server;

    public SlimeySoap(Settings settings) {
        super(settings);
    }
    
    /*public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(world instanceof ServerWorld && user.getOffHandStack().isEmpty()){
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 300), (Entity)user);
            destroyItem(user.getMainHandStack(), user, false);
        }
        return TypedActionResult.success(user.getMainHandStack());
    } */

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        PlayerEntity user = context.getPlayer();
        BlockPos pos = context.getBlockPos();
        BlockState blockState = world.getBlockState(pos);

        if(blockState.getBlock().equals(Blocks.PISTON)) {
            world.setBlockState(pos, Blocks.STICKY_PISTON.getStateWithProperties(blockState));
            world.playSound(user, pos, SoundEvents.BLOCK_SLIME_BLOCK_PLACE, SoundCategory.BLOCKS);
            createParticles(world, pos, 15, 1, ParticleTypes.ITEM_SLIME);
            destroyItem(user.getMainHandStack(), user, false);
        }

        return ActionResult.SUCCESS;
    }


    @Override
    public boolean onStackClicked(ItemStack stack, Slot slot, ClickType clickType, PlayerEntity player){
        //stack is the item thats currently held on the cursor, itemStack is the stack thats being clicked by the item
        //Ex. Holding glass bottle = stack, clicking cooked beef with glass bottle = itemStack
        ItemStack itemStack = slot.getStack();
        server = MinecraftClient.getInstance().getServer();
            if (clickType != ClickType.RIGHT || slot.getStack().isEmpty()){
                return false;
            } else {
                return true;
            }
    }
}
    



