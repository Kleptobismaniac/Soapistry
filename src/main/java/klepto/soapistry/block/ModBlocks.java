package klepto.soapistry.block;

import klepto.soapistry.Soapistry;
import klepto.soapistry.block.advanced.Renderer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static final Block RENDERER = registerBlock("renderer", new Renderer(FabricBlockSettings.of(Material.STONE).strength(6)));


    

    private static Block registerBlock(String name, Block block){
		registerBlockItem(name, block);
		return Registry.register(Registry.BLOCK, new Identifier(Soapistry.MOD_ID, name), block);
	}

    private static BlockItem registerBlockItem(String name, Block block){
        return Registry.register(Registry.ITEM, new Identifier(Soapistry.MOD_ID, name), new BlockItem(block, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
    }

    public static void registerModBlocks(){
        System.out.println("Registering ModBlocks for " + Soapistry.MOD_ID);
    }
}
