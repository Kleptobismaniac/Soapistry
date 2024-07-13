package klepto.soapistry.registry.item.advanced;

import klepto.soapistry.registry.item.handlers.ItemHandler;

public class BottleOfFat extends ItemHandler{

    public BottleOfFat(Settings settings) {
        super(settings);
    }
/* 
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        PlayerEntity user = context.getPlayer();
        BlockPos pos = context.getBlockPos();
        BlockState blockState = world.getBlockState(pos);

        
            if(world.getBlockState(pos).isOf(ModBlocks.ASHEN_PATH)) {
                world.setBlockState(pos, ModBlocks.SOAKED_ASHEN_PATH.getDefaultState());
            }
            user.getMainHandStack().decrement(1);
            user.giveItemStack(Items.GLASS_BOTTLE.getDefaultStack());
        
        
        
        return ActionResult.SUCCESS;
    }

    public static void createParticles(WorldAccess world, BlockPos pos, int count, int height, ParticleEffect particle) {

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
*/
}
