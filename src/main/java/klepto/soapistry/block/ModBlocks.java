
package klepto.soapistry.block;

import klepto.soapistry.Soapistry;
//import klepto.soapistry.block.advanced.ashen_path.AshenPath;
//import klepto.soapistry.block.advanced.ashen_path.SoakedAshenPath;
import klepto.soapistry.item.ModItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {


    public static final Block PACKED_SOAP_BLOCK = registerBlock("packed_soap", new Block(FabricBlockSettings.of(Material.DECORATION).hardness(1f).slipperiness(1f)));
    public static final Block PACKED_ASH_BLOCK = registerBlock("packed_ash", new Block(FabricBlockSettings.copyOf(Blocks.CYAN_CONCRETE_POWDER)));
    public static final Block PACKED_LYE_BLOCK = registerBlock("packed_lye", new Block(FabricBlockSettings.copyOf(Blocks.CYAN_CONCRETE_POWDER)));

    //TODO Add Cursed Fire: Black fire that burns forever ~ Mixin into FlintAndSteelItem to set Soaked Ashen Path on fire
    
    private static Block registerBlock(String name, Block block){
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.SOAP).register(content -> {content.add(block);});
		registerBlockItem(name, block);
		return Registry.register(Registries.BLOCK, new Identifier(Soapistry.MOD_ID, name), block);
	}

    private static BlockItem registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, new Identifier(Soapistry.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks(){
        System.out.println("Registering ModBlocks for " + Soapistry.MOD_ID);
    }
}
