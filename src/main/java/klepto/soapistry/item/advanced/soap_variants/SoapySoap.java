package klepto.soapistry.item.advanced.soap_variants;

import klepto.soapistry.item.ModItems;
import klepto.soapistry.status_effects.ModEffects;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
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
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class SoapySoap extends Soap{
    StatusEffect slippery = ModEffects.SLIPPERY;
    public static IntegratedServer server;

    public SoapySoap(Settings settings) {
        super(settings);
    }
    
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(world instanceof ServerWorld && world.getBlockState(user.getBlockPos()).isAir()){
            int duration = 400;
            if (user.hasStatusEffect(slippery)){
                duration = duration + 200;
            }
            user.addStatusEffect(new StatusEffectInstance(ModEffects.SLIPPERY, duration), (Entity)user);
            world.playSound(user, user.getBlockPos(), SoundEvents.BLOCK_BUBBLE_COLUMN_BUBBLE_POP, SoundCategory.BLOCKS);
            world.playSound(user, user.getBlockPos(), SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS, 0.5f, 1f);

            destroyItem(user.getMainHandStack(), user, false);
        }
        return TypedActionResult.success(user.getMainHandStack());
    } 

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        PlayerEntity user = context.getPlayer();
        BlockPos pos = context.getBlockPos();
        BlockState blockState = world.getBlockState(pos);

        if(blockState.getBlock().equals(Blocks.STICKY_PISTON)) {
            world.setBlockState(pos, Blocks.PISTON.getStateWithProperties(blockState));
            createParticles(world, pos, 25, 1, ParticleTypes.RAIN);
            destroyItem(user.getMainHandStack(), user, false);
            //TODO Replace sounds with customs
            world.playSound(user, pos, SoundEvents.BLOCK_BUBBLE_COLUMN_BUBBLE_POP, SoundCategory.BLOCKS);
            world.playSound(user, user.getBlockPos(), SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS, 0.5f, 1f);

        }

        if(blockState.getBlock().equals(Blocks.ENCHANTING_TABLE) && user.getOffHandStack().isOf(Items.LAPIS_LAZULI)) {
            user.dropItem(ModItems.MYSTICAL_RESIDUE.getDefaultStack(), false, false);
            createParticles(world, pos, 25, 1, ParticleTypes.RAIN);
            destroyItem(user.getMainHandStack(), user, true);
            destroyItem(user.getOffHandStack(), user, true);
            //TODO Replace sounds with customs
            world.playSound(user, pos, SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.PLAYERS);
            world.playSound(user, pos, SoundEvents.BLOCK_RESPAWN_ANCHOR_CHARGE, SoundCategory.BLOCKS);
            world.playSound(user, pos, SoundEvents.BLOCK_CALCITE_BREAK, SoundCategory.BLOCKS);
        }
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
                if (itemStack.isOf(Items.POISONOUS_POTATO)){
                    player.giveItemStack(Items.POTATO.getDefaultStack());
                    world.playSound(player, player.getBlockPos(), SoundEvents.BLOCK_BUBBLE_COLUMN_BUBBLE_POP, SoundCategory.BLOCKS, 0.5f, 1f);
                    world.playSound(player, player.getBlockPos(), SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS, 0.4f, 1.5f);
                    destroyItem(stack, player, false);
                    destroyItem(itemStack, player, true);
                }
                if(armor.contains(itemStack.getItem()) || tools.contains(itemStack.getItem())) {
                    if (itemStack.isDamaged() && itemStack.getDamage() >= (itemStack.getMaxDamage() / 2)){
                        int durability = itemStack.getDamage();
                        int maxDura = itemStack.getMaxDamage();
                        itemStack.setDamage(durability - (int)(0.2 * maxDura));
                        world.playSound(player, player.getBlockPos(), SoundEvents.ITEM_ARMOR_EQUIP_IRON, SoundCategory.BLOCKS, 0.3f, 0.7f);
                        world.playSound(player, player.getBlockPos(), SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, SoundCategory.BLOCKS, 0.3f, 1f);
                        world.playSound(player, player.getBlockPos(), SoundEvents.BLOCK_BUBBLE_COLUMN_WHIRLPOOL_AMBIENT, SoundCategory.BLOCKS, 0.1f, 1.2f);
                        world.playSound(player, player.getBlockPos(), SoundEvents.BLOCK_BUBBLE_COLUMN_WHIRLPOOL_INSIDE, SoundCategory.BLOCKS, 0.1f, 1.2f);
                        world.playSound(player, player.getBlockPos(), SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS, 0.05f, 1f);
                        destroyItem(stack, player, false);
                    }
                }
            }
        return true;
    }

    

    

    
}
