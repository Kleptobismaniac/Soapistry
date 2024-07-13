package klepto.soapistry.registry.data_generation;

import klepto.soapistry.registry.data_generation.advancements_generator.AdvancementsProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class DataGeneration implements DataGeneratorEntrypoint {
 
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator dataGenerator) {
		FabricDataGenerator.Pack pack = dataGenerator.createPack();
    
    pack.addProvider(AdvancementsProvider::new);

    }
}