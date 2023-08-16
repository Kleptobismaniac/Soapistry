package klepto.soapistry.item.advanced.soap_variants;

import java.util.Arrays;
import java.util.List;
import klepto.soapistry.item.ModItems;
import klepto.soapistry.status_effects.ModEffects;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.screen.slot.Slot;
import net.minecraft.server.integrated.IntegratedServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ClickType;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;


public class Soap extends Item{

    StatusEffect slippery = ModEffects.SLIPPERY;
    public static IntegratedServer server;

    protected List<Item> armor = Arrays.asList(Items.CHAINMAIL_HELMET, Items.IRON_HELMET, Items.GOLDEN_HELMET,
                                    Items.CHAINMAIL_CHESTPLATE, Items.IRON_CHESTPLATE, Items.GOLDEN_CHESTPLATE,
                                    Items.CHAINMAIL_LEGGINGS, Items.IRON_LEGGINGS, Items.GOLDEN_LEGGINGS,
                                    Items.CHAINMAIL_BOOTS, Items.IRON_BOOTS, Items.GOLDEN_BOOTS);


    protected List<Item> tools = Arrays.asList(Items.IRON_AXE, Items.GOLDEN_AXE,
                                    Items.IRON_PICKAXE, Items.GOLDEN_PICKAXE,
                                    Items.IRON_SHOVEL, Items.GOLDEN_SHOVEL,
                                    Items.IRON_SWORD, Items.GOLDEN_SWORD,
                                    Items.IRON_HOE, Items.GOLDEN_HOE,
                                    Items.SHEARS, Items.SHIELD);

    public Soap(Settings settings) {
        super(settings);
    }

    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        PlayerEntity user = context.getPlayer();
        BlockPos pos = context.getBlockPos();
        BlockState blockState = world.getBlockState(pos);

        if(blockState.getBlock().equals(Blocks.STICKY_PISTON)) {
            world.setBlockState(pos, Blocks.PISTON.getStateWithProperties(blockState));
            createParticles(world, pos, 25, 1, ParticleTypes.RAIN);
            user.getMainHandStack().decrement(1);
        }
        if (blockState.getBlock().equals(Blocks.WET_SPONGE)){
            user.getMainHandStack().decrement(1);
            user.dropItem(ModItems.SOAPY_SOAP.getDefaultStack(), false, false);
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
                if (itemStack.isOf(Items.POISONOUS_POTATO)){
                    player.giveItemStack(Items.POTATO.getDefaultStack());
                    stack.decrement(1);
                    itemStack.decrement(1);
                }
                if(armor.contains(itemStack.getItem()) || tools.contains(itemStack.getItem())) {
                    if (itemStack.isDamaged() && itemStack.getDamage() >= (itemStack.getMaxDamage() / 2)){
                        int durability = itemStack.getDamage();
                        int maxDura = itemStack.getMaxDamage();
                        itemStack.setDamage(durability - (int)(0.1 * maxDura));
                        stack.decrement(1);
                    } 
                }

            }
        return true;
    }

    public static void createParticles(WorldAccess world, BlockPos pos, int count, int height, ParticleEffect particle) {

        BlockState blockState = world.getBlockState(pos);
        if (!blockState.isAir()) {
            double d = 0.5;
            double e = 0;

            world.addParticle(particle, (double)pos.getX() + 0.5, (double)pos.getY() + 0.5, (double)pos.getZ() + 0.5, 0.0, 0.0, 0.0);
            Random random = world.getRandom();
        
            for(int i = 0; i < count; ++i) {
                double f = random.nextGaussian() * 0.02;
                double g = random.nextGaussian() * 0.02;
                double h = random.nextGaussian() * 0.02;
                double j = 0.5 - d;
                double k = (double)pos.getX() + j + random.nextDouble() * d * 2.0;
                double l = (double)pos.getY() + random.nextDouble() * e;
                double m = (double)pos.getZ() + j + random.nextDouble() * d * 2.0;
                if (!world.getBlockState(BlockPos.ofFloored(k, l, m).down()).isAir()) {
                   world.addParticle(particle, k, l + height, m, f, g, h);
                }
            }
        }
    }

    public void destroyItem(ItemStack stack, PlayerEntity player){
        if (!player.isCreative()){
            if (stack.getDamage() < stack.getMaxDamage()){
                stack.setDamage(stack.getDamage() + 1);
            } else if (stack.getDamage() == stack.getMaxDamage()){
                stack.decrement(1);
            }
        }
    }
}