package klepto.soapistry.item;

import klepto.soapistry.Soapistry;
import klepto.soapistry.item.advanced.BottleOfFat;
import klepto.soapistry.item.advanced.MysticalResidue;
import klepto.soapistry.item.advanced.ashen_items.Ash;
import klepto.soapistry.item.advanced.ashen_items.AshenBoneMeal;
import klepto.soapistry.item.advanced.soap_variants.AshenSoap;
import klepto.soapistry.item.advanced.soap_variants.EnchantedSoap;
import klepto.soapistry.item.advanced.soap_variants.SlimeySoap;
import klepto.soapistry.item.advanced.soap_variants.Soap;
import klepto.soapistry.item.advanced.soap_variants.SoapySoap;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {


    public static final int DEFAULT_DURABILITY = 2;

    public static final Item SOAP = registerItem("soap", new Soap(new FabricItemSettings()));

    public static final Item SOAPY_SOAP = registerItem("soapy", new SoapySoap(new FabricItemSettings().maxDamage(DEFAULT_DURABILITY)));

    public static final Item ASHEN_SOAP = registerItem("ashen_soap", new AshenSoap(new FabricItemSettings().maxDamage(DEFAULT_DURABILITY)));

    public static final Item SLIMEY_SOAP = registerItem("slimey_soap", new SlimeySoap(new FabricItemSettings().maxDamage(DEFAULT_DURABILITY + 2)));

    public static final Item ENCHANTED_SOAP = registerItem("enchanted_soap", new EnchantedSoap(new FabricItemSettings().maxDamage(DEFAULT_DURABILITY + 2)));

    public static final Item MYSTICAL_RESIDUE = registerItem("mystical_residue", new MysticalResidue(new FabricItemSettings()));


    public static final Item ASH = registerItem("ash", new Ash(new FabricItemSettings()));

    public static final Item ASHEN_BONE_MEAL = registerItem("ashen_bone_meal", new AshenBoneMeal(new FabricItemSettings()));

    public static final Item LYE = registerItem("lye", new Item(new FabricItemSettings()));

    public static final Item BOTTLE_OF_FAT = registerItem("bottle_of_fat", new BottleOfFat(new FabricItemSettings().recipeRemainder(Items.GLASS_BOTTLE)));    

    

    private static Item registerItem(String name, Item item){
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.SOAP).register(content -> {content.add(item);});
        return Registry.register(Registries.ITEM, new Identifier(Soapistry.MOD_ID, name), item);
	}

    public static void registerModItems(){
        System.out.println("Registering ModItems for " + Soapistry.MOD_ID);
    }   

}
