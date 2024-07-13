package klepto.soapistry.registry.status_effects;

import klepto.soapistry.Soapistry;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEffects {

    public static final StatusEffect SLIPPERY = registerEffect("slippery", new SlipperyEffect(null, 0));
    


    private static StatusEffect registerEffect(String name, StatusEffect effect){
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(Soapistry.MOD_ID, name), effect);
	}

    public static void registerModEffects(){
        System.out.println("Registering ModEffects for " + Soapistry.MOD_ID);
    }
}
