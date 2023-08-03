package klepto.soapistry.item.advanced;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import klepto.soapistry.SoapistryClient;
import klepto.soapistry.item.ModItems;
import klepto.soapistry.mixin.timer.StuffTimer;
import klepto.soapistry.status_effects.ModEffects;
import klepto.soapistry.util.StuffTimerAccessor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.vehicle.MinecartEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.integrated.IntegratedServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ClickType;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;


public class Soap extends Item implements StuffTimerAccessor{

    StatusEffect slippery = ModEffects.SLIPPERY;
    int level;
    public static IntegratedServer server;
    //StuffTimer timer = new StuffTimer();
    //SoapistryClient client = new SoapistryClient();
    //MinecraftServer server;
    //String timerID;

    public Soap(Settings settings) {
        super(settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(world instanceof ServerWorld && user.getOffHandStack().isEmpty()){
            if (!user.canTarget(EntityType.PIG)){
                if(user.getMainHandStack().isOf(ModItems.SOAP)){
                    user.addStatusEffect(new StatusEffectInstance(ModEffects.SLIPPERY, 300), (Entity)user);
                } else {
                    user.addStatusEffect(new StatusEffectInstance(ModEffects.SLIPPERY, 600), (Entity)user);
                }
            }

        }
        return TypedActionResult.consume(user.getStackInHand(hand));
    } 


    @Override
    public boolean onStackClicked(ItemStack stack, Slot slot, ClickType clickType, PlayerEntity player){
        //stack is the item thats currently held on the cursor, itemStack is the stack thats being clicked by the item
        //Ex. Holding glass bottle = stack, clicking cooked beef with glass bottle = itemStack
        ItemStack itemStack = slot.getStack();
        server = MinecraftClient.getInstance().getServer();
            if (clickType != ClickType.RIGHT){
                return false;
            } else if(itemStack.isDamaged() && itemStack.getDamage() < itemStack.getMaxDamage()){
                //int durability = itemStack.getDamage();
                //timerID = itemStack.getName().toString();
                //timer.setRegistered(true);
                if(stack.isOf(ModItems.SOAP)){
                    this.level = 1;
                } else {
                    this.level = 2;
                }
                //TODO Set timerTicks to 1200. This is equal to 10 minutes
                //((StuffTimerAccessor) server).setTimer(100, level);
                ((StuffTimerAccessor) server).setRegistered(true);
                /*while (((StuffTimerAccessor) server).getRegistered()){
                    itemStack.setDamage(durability);
                }*/
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

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
    
        // default white text
        tooltip.add(Text.literal("Cleanliness 1").formatted(Formatting.byColorIndex(6)));
    
        // formatted red text
        tooltip.add(Text.literal("Cleanliness 2").formatted(Formatting.RED));
    }

    
}
/*if (user.getStackInHand(hand).isOf(ModItems.SOAP) && user.getOffHandStack().isOf(Items.WET_SPONGE)) {
                ItemStack itemStack = user.getStackInHand(hand);
                user.getMainHandStack().decrement(1);
                //((ServerWorld) world).spawnParticles((ServerPlayerEntity) user, ParticleTypes.BUBBLE, false, user.getX(), user.getY(), user.getZ(), 50, 0.2, 1, 0.2, -50);                    
                //System.out.print("Using Soap");
                return TypedActionResult.success(itemStack);
            }*/