package klepto.soapistry.block.advanced.ashen_path;

import klepto.soapistry.block.ModBlocks;
import klepto.soapistry.item.ModItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.event.GameEvent.Emitter;

public class AshenPath extends Block {
   protected static final VoxelShape SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 1.0, 16.0);

   public AshenPath(AbstractBlock.Settings settings) {
      super(settings);
   }

   public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
      return SHAPE;
   }

   public VoxelShape getSidesShape(BlockView world, BlockPos pos) {
      return SHAPE;
   }

   public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
      return !state.canPlaceAt(world, pos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
   }

   public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
      return !world.isAir(pos.down()) || !world.getBlockState(pos).isOf(ModBlocks.ASHEN_PATH);
   }

   @Override
   public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
      this.spawnBreakParticles(world, player, pos, state);
      Block.dropStack(world, pos, ModItems.ASH.getDefaultStack());

      world.emitGameEvent(GameEvent.BLOCK_DESTROY, pos, Emitter.of(player, state));
   }



   @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        // Check if the entity colliding with the block is a LivingEntity (including players)
        if (entity instanceof LivingEntity) {
            // Slow down the player's motion
            double slowFactor = 0.5; // Adjust this value to control the slowdown effect
            entity.setVelocity(entity.getVelocity().multiply(slowFactor, 1.0, slowFactor));
        }

        // Call the super method to apply default behavior for entity collision with the block
        super.onEntityCollision(state, world, pos, entity);
    }
}
