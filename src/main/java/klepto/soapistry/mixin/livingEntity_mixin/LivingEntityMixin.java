/*package klepto.soapistry.mixin.livingEntity_mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import klepto.soapistry.status_effects.ModEffects;

import org.spongepowered.asm.mixin.injection.At;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Arm;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

@Mixin(LivingEntity.class)
public class LivingEntityMixin extends LivingEntity /*implements LivingEntityAccessor , EntityAccessor{
    protected LivingEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
        //TODO Auto-generated constructor stub
    }

    @Inject(at = @At("HEAD"), method = "Lnet/minecraft/entity/LivingEntity;travel(Lnet/minecraft/util/math/Vec3d;)V")
    public void travel(Vec3d movementInput, CallbackInfo info){
        
        if (!this.world.isClient) {
            if (this.hasStatusEffect(ModEffects.SLIPPERY)){
                float p = Blocks.ICE.getSlipperiness();
                //float f = this.onGround ? p * 0.91f : 0.91f;
                Vec3d vec3d6 = this.applyMovementInput(movementInput, p);
                double q = vec3d6.y;
                this.setVelocity(vec3d6.x, q, vec3d6.z);
                System.out.println("YOU BEEN SLIPPED");
            }
        }
    }


    public BlockPos getVelocityAffectingPos() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected void initDataTracker() {
        // TODO Auto-generated method stub
        
    }


    

    public Iterable<ItemStack> getArmorItems() {
        // TODO Auto-generated method stub
        return null;
    }

    public ItemStack getEquippedStack(EquipmentSlot var1) {
        // TODO Auto-generated method stub
        return null;
    }

    public void equipStack(EquipmentSlot var1, ItemStack var2) {
        // TODO Auto-generated method stub
        
    }

    public Arm getMainArm() {
        // TODO Auto-generated method stub
        return null;
    }
}
*/