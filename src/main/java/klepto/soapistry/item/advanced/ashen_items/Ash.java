package klepto.soapistry.item.advanced.ashen_items;

import klepto.soapistry.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;


public class Ash extends Item{

    
    public Ash(Settings settings) {
        super(settings);
    }

    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        PlayerEntity user = context.getPlayer();
        BlockPos pos = context.getBlockPos();
        BlockState blockState = world.getBlockState(pos);

        
            if(world.getBlockState(pos.up(1)).isAir()) {
                world.setBlockState(pos.up(1), ModBlocks.ASHEN_PATH.getDefaultState());
            }
            createParticles(world, pos, 25, 1, ParticleTypes.SMOKE);
            user.getMainHandStack().decrement(1);
        
        
        
        return ActionResult.SUCCESS;
    }

    
    public static void createParticles(WorldAccess world, BlockPos pos, int count, double height, ParticleEffect particle) {

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

    public void destroyItem(ItemStack stack){
        if (stack.getDamage() < stack.getMaxDamage()){
            stack.setDamage(stack.getDamage() + 1);
        } else if (stack.getDamage() == stack.getMaxDamage()){
            stack.decrement(1);
        }
    }
}