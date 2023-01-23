package klepto.soapistry.status_effects;

import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class SlipperyEffect extends StatusEffect{

  float slipBlue = Blocks.BLUE_ICE.getSlipperiness();
  float slipIce = Blocks.BLUE_ICE.getSlipperiness();
  float slipPack = Blocks.BLUE_ICE.getSlipperiness();

  BlockPos pos;

  
  
    

    protected SlipperyEffect(StatusEffectCategory category, int color) {
        super(StatusEffectCategory.NEUTRAL, 0x00B4D8);
        //TODO Auto-generated constructor stub
    }
    
    @Override
  public boolean canApplyUpdateEffect(int duration, int amplifier) {
    // In our case, we just make it return true so that it applies the status effect every tick.
    return true;
  }

  @Override
  public void applyUpdateEffect(LivingEntity entity, int amplifier) {
    if (entity instanceof PlayerEntity) {
        if (this == ModEffects.SLIPPERY && entity.isOnGround()) {
          entity.setVelocity(entity.getVelocity().x * (1 + (0.989/2)), 0, entity.getVelocity().z * (1 + (0.989/2)));
          System.out.println("WORKING");
        }
    } 
  }
}


