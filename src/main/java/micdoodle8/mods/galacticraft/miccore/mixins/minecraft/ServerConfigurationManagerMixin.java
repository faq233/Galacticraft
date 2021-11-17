package micdoodle8.mods.galacticraft.miccore.mixins.minecraft;

import com.mojang.authlib.GameProfile;
import micdoodle8.mods.galacticraft.core.entities.player.GCEntityPlayerMP;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.ItemInWorldManager;
import net.minecraft.server.management.ServerConfigurationManager;
import net.minecraft.world.WorldServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ServerConfigurationManager.class)
public class ServerConfigurationManagerMixin {

    @Redirect(method = "respawnPlayer", at = @At(value = "NEW", target = "net/minecraft/entity/player/EntityPlayerMP"))
    private EntityPlayerMP onNewEntityPlayerMPInRespawnPlayer(MinecraftServer server, WorldServer world, GameProfile profile, ItemInWorldManager itemInWorldManager) {
        return new GCEntityPlayerMP(server, world, profile, itemInWorldManager);
    }

    @Redirect(method = "createPlayerForUser", at = @At(value = "NEW", target = "net/minecraft/entity/player/EntityPlayerMP"))
    private EntityPlayerMP onNewEntityPlayerMPInCreatePlayerForUser(MinecraftServer server, WorldServer world, GameProfile profile, ItemInWorldManager itemInWorldManager) {
        return new GCEntityPlayerMP(server, world, profile, itemInWorldManager);
    }

    // CHECK
}
