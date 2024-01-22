package klepto.soapistry.sound;

import klepto.soapistry.Soapistry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    
    public static SoundEvent MYSTICAL_RESIDUE_USE = registerSoundEvent("mystical_residue_enchant");
    public static SoundEvent SOAPY_SOAP_USE = registerSoundEvent("soapy_soap_use");
    public static SoundEvent SLIMEY_SOAP_USE = registerSoundEvent("slimey_soap_use");
    public static SoundEvent SOAP_USE = registerSoundEvent("soap_use");


    private static SoundEvent registerSoundEvent(String name){
        Identifier id = new Identifier(Soapistry.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerModSounds(){
        System.out.println("Registering ModSounds for " + Soapistry.MOD_ID);
    } 

}
