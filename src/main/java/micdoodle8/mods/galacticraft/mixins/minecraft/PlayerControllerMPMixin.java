package micdoodle8.mods.galacticraft.mixins.minecraft;

import micdoodle8.mods.galacticraft.core.entities.player.GCEntityClientPlayerMP;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.stats.StatFileWriter;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(PlayerControllerMP.class)
public abstract class PlayerControllerMPMixin extends PlayerControllerMP {

    @Shadow
    @Final
    private Minecraft mc;

    @Shadow
    @Final
    private NetHandlerPlayClient netClientHandler;

    public PlayerControllerMPMixin() {
        super(null, null);
    }
    // TODO: if Player-API is not installed

    @Override
    public EntityClientPlayerMP func_147493_a(World world, StatFileWriter stats) {
        return new GCEntityClientPlayerMP(mc, world, mc.getSession(), netClientHandler, stats);
    }

    // TODO: Verify that second redirect on constructor call is NOT required!
}
