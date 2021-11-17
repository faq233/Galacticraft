package micdoodle8.mods.galacticraft.miccore.mixins.forge;

import micdoodle8.mods.galacticraft.core.event.EventHandlerGC;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ForgeHooksClient.class)
public class ForgeHooksClientMixin {

    @Inject(method = "orientBedCamera", at = @At("HEAD"), remap = false)
    private static void onOrientBedCamera(CallbackInfo callbackInfo) {
        MinecraftForge.EVENT_BUS.post(new EventHandlerGC.OrientCameraEvent());
    }
}
