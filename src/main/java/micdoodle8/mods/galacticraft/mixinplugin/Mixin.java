package micdoodle8.mods.galacticraft.mixinplugin;

import cpw.mods.fml.relauncher.FMLLaunchHandler;

import java.util.Arrays;
import java.util.List;

import static micdoodle8.mods.galacticraft.mixinplugin.TargetedMod.*;

public enum Mixin {

    //
    // IMPORTANT: Do not make any references to any mod from this file. This file is loaded quite early on and if
    // you refer to other mods you load them as well. The consequence is: You can't inject any previously loaded classes!
    // Exception: Tags.java, as long as it is used for Strings only!
    //

    ForgeHooksClientMixin("forge.ForgeHooksClientMixin", VANILLA),

    ChunkProviderServerMixin("minecraft.ChunkProviderServerMixin", VANILLA),
    EffectRendererMixin("minecraft.EffectRendererMixin", VANILLA),
    EntityArrowMixin("minecraft.EntityArrowMixin", VANILLA),
    EntityGolemMixin("minecraft.EntityGolemMixin", VANILLA),
    EntityItemMixin("minecraft.EntityItemMixin", VANILLA),
    EntityLivingBaseMixin("minecraft.EntityLivingBaseMixin", VANILLA),
    EntityMixin("minecraft.EntityMixin", VANILLA),
    EntityRendererMixin("minecraft.EntityRendererMixin", VANILLA),
    GuiSleepMPMxin("minecraft.GuiSleepMPMxin", VANILLA),
    ItemRendererMixin("minecraft.ItemRendererMixin", VANILLA),
    NetHandlerPlayClientMixin("minecraft.NetHandlerPlayClientMixin", VANILLA),
    PlayerControllerMPMixin("minecraft.PlayerControllerMPMixin", VANILLA),
    RendererLivingEntityMixin("minecraft.RendererLivingEntityMixin", VANILLA),
    ServerConfigurationManagerMixin("minecraft.ServerConfigurationManagerMixin", VANILLA),
    WorldMixin("minecraft.WorldMixin", VANILLA);

    public final String mixinClass;
    public final List<TargetedMod> targetedMods;
    private final Side side;

    Mixin(String mixinClass, Side side, TargetedMod... targetedMods) {
        this.mixinClass = mixinClass;
        this.targetedMods = Arrays.asList(targetedMods);
        this.side = side;
    }

    Mixin(String mixinClass, TargetedMod... targetedMods) {
        this.mixinClass = mixinClass;
        this.targetedMods = Arrays.asList(targetedMods);
        this.side = Side.BOTH;
    }

    public boolean shouldLoad(List<TargetedMod> loadedMods) {
        return (side == Side.BOTH
                || side == Side.SERVER && FMLLaunchHandler.side().isServer()
                || side == Side.CLIENT && FMLLaunchHandler.side().isClient())
                && loadedMods.containsAll(targetedMods);
    }
}

enum Side {
    BOTH,
    CLIENT,
    SERVER;
}
