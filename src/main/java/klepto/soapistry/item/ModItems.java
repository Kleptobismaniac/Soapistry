package klepto.soapistry.item;

import klepto.soapistry.Soapistry;
import klepto.soapistry.item.advanced.Soap;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item SOAP = registerItem("soap", new Soap(new FabricItemSettings().group(ModItemGroup.SOAP)));

    public static final Item ASH = registerItem("ash", new Item(new FabricItemSettings().group(ModItemGroup.SOAP)));

    public static final Item LYE = registerItem("lye", new Item(new FabricItemSettings().group(ModItemGroup.SOAP)));

    public static final Item BOTTLE_OF_FAT = registerItem("bottle_of_fat", new Item(new FabricItemSettings().recipeRemainder(Items.GLASS_BOTTLE).group(ModItemGroup.SOAP)));


    

    private static Item registerItem(String name, Item item){
		return Registry.register(Registry.ITEM, new Identifier(Soapistry.MOD_ID, name), item);
	}

    public static void registerModItems(){
        System.out.println("Registering ModItems for " + Soapistry.MOD_ID);
    }   
}
