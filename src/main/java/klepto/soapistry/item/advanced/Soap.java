package klepto.soapistry.item.advanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import klepto.soapistry.SoapistryClient;
import klepto.soapistry.item.ModItems;
import klepto.soapistry.mixin.timer.StuffTimer;
import klepto.soapistry.status_effects.ModEffects;
import klepto.soapistry.util.StuffTimerAccessor;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.vehicle.MinecartEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.screen.slot.Slot;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.integrated.IntegratedServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ClickType;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class Soap extends Item implements StuffTimerAccessor{

    StatusEffect slippery = ModEffects.SLIPPERY;
    int level;
    public static IntegratedServer server;
    public static boolean clicked = false;
    public static ItemStack stack;

    private List<Item> armor = Arrays.asList(Items.CHAINMAIL_HELMET, Items.IRON_HELMET, Items.GOLDEN_HELMET,
                                    Items.CHAINMAIL_CHESTPLATE, Items.IRON_CHESTPLATE, Items.GOLDEN_CHESTPLATE,
                                    Items.CHAINMAIL_LEGGINGS, Items.IRON_LEGGINGS, Items.GOLDEN_LEGGINGS,
                                    Items.CHAINMAIL_BOOTS, Items.IRON_BOOTS, Items.GOLDEN_BOOTS);


    private List<Item> tools = Arrays.asList(Items.IRON_AXE, Items.GOLDEN_AXE,
                                    Items.IRON_PICKAXE, Items.GOLDEN_PICKAXE,
                                    Items.IRON_SHOVEL, Items.GOLDEN_SHOVEL,
                                    Items.IRON_SWORD, Items.GOLDEN_SWORD,
                                    Items.IRON_HOE, Items.GOLDEN_HOE,
                                    Items.SHEARS, Items.SHIELD);


    //StuffTimer timer = new StuffTimer();
    //SoapistryClient client = new SoapistryClient();
    //MinecraftServer server;
    //String timerID;

    public Soap(Settings settings) {
        super(settings);
    }



    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(world instanceof ServerWorld && user.getOffHandStack().isEmpty()){
                if(user.getMainHandStack().isOf(ModItems.SOAPY_SOAP)){
                    user.addStatusEffect(new StatusEffectInstance(ModEffects.SLIPPERY, 300), (Entity)user);
                    int durability = user.getMainHandStack().getDamage();
                    int max = user.getMainHandStack().getMaxDamage();
                    if (durability < max){user.getMainHandStack().setDamage(durability + 1);}
                    if (durability == max){user.getMainHandStack().decrement(1);}
                }
            }
        
        return TypedActionResult.consume(user.getMainHandStack());
    } 

    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        PlayerEntity user = context.getPlayer();
        BlockPos pos = context.getBlockPos();
        BlockState blockState = world.getBlockState(pos);

        if(blockState.getBlock().equals(Blocks.STICKY_PISTON)) {
            world.setBlockState(pos, Blocks.PISTON.getStateWithProperties(blockState));
                user.getMainHandStack().decrement(1);
        }

        if (blockState.getBlock().equals(Blocks.WET_SPONGE)){
            user.getMainHandStack().decrement(1);
            user.dropItem(ModItems.SOAPY_SOAP.getDefaultStack(), clicked, clicked);
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
                if(armor.contains(itemStack.getItem()) || tools.contains(itemStack.getItem())) {
                    if (itemStack.isDamaged() && itemStack.getDamage() >= (itemStack.getMaxDamage() / 2)){
                        if (stack.isOf(ModItems.SOAPY_SOAP)){
                                int durability = itemStack.getDamage();
                                int maxDura = itemStack.getMaxDamage();
                                itemStack.setDamage(durability - (int)(0.2 * maxDura));
                                //timerID = itemStack.getName().toString();
                                //this.level = 1;
                                //((StuffTimerAccessor) server).setRegistered(true);
                                //timer.setRegistered(true);
                                if (stack.getDamage() < stack.getMaxDamage()){stack.setDamage(stack.getDamage() + 1);}
                                if (stack.getDamage() == stack.getMaxDamage()){stack.decrement(1);}

                        } else if (stack.isOf(ModItems.SOAP)){
                                    int durability = itemStack.getDamage();
                                    int maxDura = itemStack.getMaxDamage();
                                    itemStack.setDamage(durability - (int)(0.1 * maxDura));
                                    stack.decrement(1);
                }
 
            }
                
                    /*
                if(itemStack.isOf(Items.DIAMOND_BOOTS)) {
                    clicked = true;
                }
                    //TODO Set timerTicks to 1200. This is equal to 10 minutes
                    //((StuffTimerAccessor) server).setTimer(100, level);
                    
                    while (((StuffTimerAccessor) server).getRegistered()){
                        itemStack.setDamage(durability);
                    }*/
            }
        }
        return true;
    }


    @Override
    public void setTimer(long ticksUntilSomething, int level) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean setRegistered(boolean registered) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean getRegistered() {
        // TODO Auto-generated method stub
        return false;
    }

    /*@Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
    
        // default white text
        tooltip.add(Text.literal("Cleanliness 1").formatted(Formatting.byColorIndex(6)));
    
        // formatted red text
        tooltip.add(Text.literal("Cleanliness 2").formatted(Formatting.RED));
    }*/

    
}
/*if (user.getStackInHand(hand).isOf(ModItems.SOAP) && user.getOffHandStack().isOf(Items.WET_SPONGE)) {
                ItemStack itemStack = user.getStackInHand(hand);
                user.getMainHandStack().decrement(1);
                //((ServerWorld) world).spawnParticles((ServerPlayerEntity) user, ParticleTypes.BUBBLE, false, user.getX(), user.getY(), user.getZ(), 50, 0.2, 1, 0.2, -50);                    
                //System.out.print("Using Soap");
                return TypedActionResult.success(itemStack);
            }*/