package klepto.soapistry.item.advanced;

import klepto.soapistry.item.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class Soap extends Item{

    public Soap(Settings settings) {
        super(settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(world instanceof ServerWorld){
            if (user.getStackInHand(hand).isOf(ModItems.SOAP) && user.getOffHandStack().isOf(Items.WET_SPONGE)) {
                ItemStack itemStack = user.getStackInHand(hand);
                user.giveItemStack((ModItems.ASH).getDefaultStack());
                user.getMainHandStack().decrement(1);
                //((ServerWorld) world).spawnParticles((ServerPlayerEntity) user, ParticleTypes.BUBBLE, false, user.getX(), user.getY(), user.getZ(), 50, 0.2, 1, 0.2, -50);                    
                //System.out.print("Using Soap");
                return TypedActionResult.success(itemStack);
            }
            
        }
        return TypedActionResult.pass(user.getStackInHand(hand));
    }
    
}
