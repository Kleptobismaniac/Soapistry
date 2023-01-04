package klepto.soapistry.mixin.glass_bottle;

import klepto.soapistry.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.FurnaceBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.StackReference;
import net.minecraft.item.*;
import net.minecraft.screen.slot.Slot;
import net.minecraft.stat.Stats;
import net.minecraft.util.ClickType;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

import java.util.Optional;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GlassBottleItem.class)
public class GlassBottleMixin extends Item implements GlassBottleAccessor{


    public GlassBottleMixin(Settings settings) {
        super(settings);
    }

    @Override
    public boolean onStackClicked(ItemStack stack, Slot slot, ClickType clickType, PlayerEntity player){
        if (clickType != ClickType.RIGHT){
            return false;
        } else {
            if (slot.getStack().isOf(Items.COOKED_BEEF) && slot.getStack().isEmpty()) {
                    //slot.setStack(new ItemStack(Items.BONE));
                    //cursorStackReference.set(new ItemStack(ModItems.BOTTLE_OF_FAT));
                    player.giveItemStack(Items.BONE.getDefaultStack());
                    System.out.println("THIS WORKS");
                    
            }
        } 
        System.out.println("THIS DOES NOT WORK");
        return true;
        

    }
    

    /*@Inject(method = "use", at = @At("HEAD"))
    public void use(World world, PlayerEntity user, Hand hand, CallbackInfoReturnable<TypedActionResult<ItemStack>> cir){
            
        ItemStack itemStack = user.getStackInHand(hand);
        HitResult hitResult = raycast(world, user, RaycastContext.FluidHandling.SOURCE_ONLY);
        BlockState blockState = world.getBlockState(((BlockHitResult) hitResult).getBlockPos());
        BlockPos blockPos = ((BlockHitResult) hitResult).getBlockPos();
        BlockEntity blockEntity = world.getBlockEntity(blockPos);

        Optional<FurnaceBlockEntity> furnace = world.getBlockEntity(blockPos, BlockEntityType.FURNACE);
        

        System.out.println("THIS WORKS");
        if (hitResult.getType() == HitResult.Type.BLOCK && blockState.isOf(Blocks.FURNACE) && furnace.) {

            if (user.getStackInHand(hand).isOf(Items.GLASS_BOTTLE)) {
                fill(itemStack, user, new ItemStack(ModItems.BOTTLE_OF_FAT));
                System.out.println("BOTTLE FILLED");
                System.out.println("BOTTLE NEW");
            }
        }
    }

    @Override
    public ItemStack fill(ItemStack stack, PlayerEntity player, ItemStack outputStack) {
        player.incrementStat(Stats.USED.getOrCreateStat(this));
        return ItemUsage.exchangeStack(stack, player, outputStack);
    }*/
}
