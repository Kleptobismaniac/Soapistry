package klepto.soapistry.mixin.timer;

import org.spongepowered.asm.mixin.injection.At;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import klepto.soapistry.util.StuffTimerAccessor;
import net.minecraft.server.integrated.IntegratedServer;

@Mixin(IntegratedServer.class)
public class StuffTimer implements StuffTimerAccessor{
    @Unique
    private long timerTicks;
    //private long ticks;
    //private Map<String, Long> timers = new HashMap<>();
    //private ItemStack stack;
    //private ItemStack itemStack;
    //private int durability;
    //public MinecraftServer server;
    //public boolean ticking = false;
    private static boolean registered = false;


    @Inject(method = "tick", at = @At("TAIL"))
    private void onTick(CallbackInfo ci) {
        if (registered){
        //System.out.println("STARTING");
                if (timerTicks > 0) {
                    timerTicks--;
                } else if (timerTicks == 0) {
                    //System.out.println("DONE");
                    StuffTimer.registered = false;
                }
            
            }
    }

    public boolean setRegistered(boolean registered){
        return StuffTimer.registered = registered;
    }

    public boolean getRegistered(){
        return registered;
    }
     //System.out.println(ticksUntilSomething);
                //System.out.println("WORKING");                   

    /*for (Map.Entry<String, Long> entry : timers.entrySet()) {
                long i = entry.getValue();
                if (i > 0) {
                    this.itemStack.setDamage(this.durability);
                    i--;
                    timers.put(entry.getKey(), i);
                    if (i == 0) {
                        // Code to run after the timer has finished counting down
                        System.out.println("DONE");
                        timers.remove(entry.getKey());
                    }
                }
            }  

    public boolean setTicking(Boolean ticking){
        return this.ticking = ticking;
    }

    

    public int setDurability(ItemStack stack){
        return this.durability = stack.getDamage();
    }

    public ItemStack setItemStack(ItemStack itemStack){
        return this.itemStack = itemStack; 
    }

    public ItemStack setStack(ItemStack stack){
        return this.stack = stack;
    }

    public long setTicks(long ticks){
        return this.ticksUntilSomething = ticks;
    }*/

    public void setTimer(long timerTicks, int level) {
        
        this.timerTicks = timerTicks * level;
        //timers.put(timerId, this.ticksUntilSomething * level);
        System.out.println("WORKING");
    }

    

    

    
}
