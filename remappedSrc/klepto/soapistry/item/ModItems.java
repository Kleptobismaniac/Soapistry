package klepto.soapistry.item;

import klepto.soapistry.Soapistry;
import klepto.soapistry.item.advanced.Soap;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item SOAP = registerItem("soap", new Soap(new FabricItemSettings().maxDamage(338)));

    public static final Item SOAPY_SOAP = registerItem("soapy_soap", new Soap(new FabricItemSettings().maxDamage(238)));

    public static final Item ASH = registerItem("ash", new Item(new FabricItemSettings()));

    public static final Item LYE = registerItem("lye", new Item(new FabricItemSettings()));

    public static final Item BOTTLE_OF_FAT = registerItem("bottle_of_fat", new Item(new FabricItemSettings().recipeRemainder(Items.GLASS_BOTTLE)));    

    

    private static Item registerItem(String name, Item item){
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.SOAP).register(content -> {content.add(item);});
        return Registry.register(Registries.ITEM, new Identifier(Soapistry.MOD_ID, name), item);
	}

    public static void registerModItems(){
        System.out.println("Registering ModItems for " + Soapistry.MOD_ID);
    }   

}
