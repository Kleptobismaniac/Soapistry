package klepto.soapistry.registry.item.advanced.ashen_items;

import klepto.soapistry.registry.item.handlers.ItemHandler;


public class Ash extends ItemHandler{

    
    public Ash(Settings settings) {
        super(settings);
    }
/*
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
*/
}