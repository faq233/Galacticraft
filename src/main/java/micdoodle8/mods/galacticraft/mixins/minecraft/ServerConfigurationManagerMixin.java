package micdoodle8.mods.galacticraft.mixins.minecraft;

import net.minecraft.server.management.ServerConfigurationManager;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ServerConfigurationManager.class)
public class ServerConfigurationManagerMixin {
    // TODO: check if methods are present at runtime: attemptLogin, createPlayerForUser, respawnPlayer
}
