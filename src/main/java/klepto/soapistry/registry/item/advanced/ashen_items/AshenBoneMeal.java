package klepto.soapistry.registry.item.advanced.ashen_items;

import klepto.soapistry.registry.item.handlers.ItemHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.NetherWartBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class AshenBoneMeal extends ItemHandler{

    public AshenBoneMeal(Settings settings) {
        super(settings);
    }

    public static final int field_30851 = 3;
    public static final int field_30852 = 1;
    public static final int field_30853 = 3;

    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        PlayerEntity user = context.getPlayer();
        BlockPos pos = context.getBlockPos();
        BlockState blockState = world.getBlockState(pos);

        if(blockState.getBlock().equals(Blocks.NETHER_WART)) {
            int i = (Integer)blockState.get(NetherWartBlock.AGE);
            if (i < 3){
               blockState = (BlockState)blockState.with(NetherWartBlock.AGE, i + 1);
               createParticles(world, pos, 0);
               world.setBlockState(pos, blockState, 2);

               //Change to custom sounds in Audacity
               world.playSound(user, user.getBlockPos(), SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 0.2f, 0.7f);
               world.playSound(user, user.getBlockPos(), SoundEvents.ENTITY_FIREWORK_ROCKET_BLAST, SoundCategory.BLOCKS, 0.01f, 0.1f);
            }
            destroyItem(user.getMainHandStack(), user, false);
        }
        return ActionResult.SUCCESS;
    }

    public static void createParticles(WorldAccess world, BlockPos pos, int count) {
        if (count == 0) {
            count = 15;
        }

        BlockState blockState = world.getBlockState(pos);
        if (!blockState.isAir()) {
            double d = 0.5;
            double e = 0;

            world.addParticle(ParticleTypes.FLAME, (double)pos.getX() + 0.5, (double)pos.getY() + 0.5, (double)pos.getZ() + 0.5, 0.0, 0.0, 0.0);
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
                   world.addParticle(ParticleTypes.FLAME, k, l + 0.4, m, f, g, h);
                }
            }
        }
    }
}