package klepto.soapistry.mixin;

import klepto.soapistry.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

import static net.minecraft.item.Item.raycast;

@Mixin(GlassBottleItem.class)
public class GlassBottleMixin {

    @Inject(method = "use", at = @At("HEAD"))
    public void use(World world, PlayerEntity user, Hand hand, CallbackInfoReturnable<TypedActionResult<ItemStack>> cir){
        /*if (blockState.isOf(Blocks.FURNACE) && playerEntity.getMainHandStack().isOf(Items.GLASS_BOTTLE)){
            playerEntity.getMainHandStack().decrement(1);
            playerEntity.getInventory().insertStack(new ItemStack(ModItems.BOTTLE_OF_FAT));
        }*/
            
            ItemStack itemStack = user.getStackInHand(hand);
            HitResult hitResult = raycast(world, user, RaycastContext.FluidHandling.SOURCE_ONLY);
        if (hitResult.getType() != HitResult.Type.MISS) {
            if (hitResult.getType() == HitResult.Type.BLOCK) {
                BlockPos blockPos = ((BlockHitResult) hitResult).getBlockPos();
                if (!world.canPlayerModifyAt(user, blockPos)) {
                    return TypedActionResult.pass(itemStack);
                }
            }

        }
        return TypedActionResult.pass(itemStack);
    }
        }
    
}
