package klepto.soapistry.item;

import klepto.soapistry.Soapistry;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup SOAP = FabricItemGroupBuilder.build(
        new Identifier(Soapistry.MOD_ID, "soap"), () -> new ItemStack(ModItems.SOAP));
}
