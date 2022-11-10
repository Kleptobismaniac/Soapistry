package klepto.soapistry.mixin;

import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import klepto.soapistry.Soapistry;

@Mixin(TitleScreen.class)
public class SoapistryMixin {
	@Inject(at = @At("HEAD"), method = "init()V")
	private void init(CallbackInfo info) {
		Soapistry.LOGGER.info("This line is printed by an example mod mixin!");
	}
}
