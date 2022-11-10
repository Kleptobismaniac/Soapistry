package klepto.soapistry.block.advanced;

import org.jetbrains.annotations.Nullable;

import klepto.soapistry.block.entity.RendererBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class Renderer extends Block implements BlockEntityProvider{

    public Renderer(Settings settings) {
        super(settings);
        //TODO Auto-generated constructor stub
    }

    
    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new RendererBlockEntity(pos, state);
    }
}
