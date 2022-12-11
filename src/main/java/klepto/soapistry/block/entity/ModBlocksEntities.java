package klepto.soapistry.block.entity;

import klepto.soapistry.Soapistry;
import klepto.soapistry.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocksEntities {
    
    public static BlockEntityType<PanBlockEntity> PAN_BLOCK_ENTITY =
            Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(Soapistry.MOD_ID, "pan"),
                    FabricBlockEntityTypeBuilder.create(PanBlockEntity::new, ModBlocks.PAN).build(null));

    
}
