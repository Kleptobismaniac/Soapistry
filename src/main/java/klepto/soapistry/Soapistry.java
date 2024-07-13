package klepto.soapistry;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import klepto.soapistry.registry.block.ModBlocks;
import klepto.soapistry.registry.item.ModItems;
import klepto.soapistry.registry.sound.ModSounds;
import klepto.soapistry.registry.status_effects.ModEffects;

public class Soapistry implements ModInitializer {
	public static final String MOD_ID = "soapistry";
	public static final Logger SOAPISTRY = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		
		//TODO Add background for advancements screen
		ModSounds.registerModSounds();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModEffects.registerModEffects();
	}
}
