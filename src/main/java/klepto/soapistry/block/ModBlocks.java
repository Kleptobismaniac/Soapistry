
package klepto.soapistry.block;

import klepto.soapistry.Soapistry;
import klepto.soapistry.block.advanced.ashen_path.AshenPath;
import klepto.soapistry.block.advanced.ashen_path.SoakedAshenPath;
import klepto.soapistry.item.ModItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {


    public static final Block ASHEN_PATH = registerBlock("ashen_path", new AshenPath(FabricBlockSettings.copyOf(Blocks.SNOW_BLOCK)));
    
    public static final Block SOAKED_ASHEN_PATH = registerBlock("soaked_ashen_path", new SoakedAshenPath(FabricBlockSettings.copyOf(Blocks.SNOW_BLOCK)));

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
