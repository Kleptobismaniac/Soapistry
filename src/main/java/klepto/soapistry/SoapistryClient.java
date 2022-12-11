package klepto.soapistry;

import klepto.soapistry.block.advanced.render.PanBlockEntityRenderer;
import klepto.soapistry.block.entity.ModBlocksEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;

public class SoapistryClient implements ClientModInitializer{

    @Override
    public void onInitializeClient() {
        BlockEntityRendererRegistry.register(ModBlocksEntities.PAN_BLOCK_ENTITY, PanBlockEntityRenderer::new);
        
    }
    
}
