package klepto.soapistry.item;

import klepto.soapistry.Soapistry;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup SOAP = FabricItemGroup.builder(
        new Identifier(Soapistry.MOD_ID, "soap")) .icon(() -> new ItemStack(ModItems.SOAP)).build();

    public static void addItem(Item item){
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.SOAP).register(content -> {content.add(item);});
    }

    public static void addBlock(Block block){
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.SOAP).register(content -> {content.add(block);});
    }
}
