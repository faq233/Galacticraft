package micdoodle8.mods.galacticraft.miccore.mixinplugin;

import cpw.mods.fml.relauncher.FMLLaunchHandler;

import java.util.Arrays;
import java.util.List;

import static micdoodle8.mods.galacticraft.miccore.mixinplugin.TargetedMod.*;

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
    EntityRendererWithoutOptifineMixin("minecraft.EntityRendererWithoutOptifineMixin", true, false, VANILLA),
    GuiSleepMPMxin("minecraft.GuiSleepMPMxin", VANILLA),
    ItemRendererMixin("minecraft.ItemRendererMixin", VANILLA),
    NetHandlerPlayClientMixin("minecraft.NetHandlerPlayClientMixin", VANILLA),
    PlayerControllerMPMixin("minecraft.PlayerControllerMPMixin", false, true, VANILLA),
    RendererLivingEntityMixin("minecraft.RendererLivingEntityMixin", VANILLA),
    ServerConfigurationManagerMixin("minecraft.ServerConfigurationManagerMixin", false, true, VANILLA),
    WorldMixin("minecraft.WorldMixin", VANILLA);

    public final String mixinClass;
    public final List<TargetedMod> targetedMods;
    private final Side side;
    private final boolean injectAlongPlayerAPI;
    private final boolean isInjectAlongOptifine;

    Mixin(String mixinClass, Side side, boolean injectAlongPlayerAPI, boolean isInjectAlongOptifine, TargetedMod... targetedMods) {
        this.mixinClass = mixinClass;
        this.targetedMods = Arrays.asList(targetedMods);
        this.side = side;
        this.injectAlongPlayerAPI = injectAlongPlayerAPI;
        this.isInjectAlongOptifine = isInjectAlongOptifine;
    }

    Mixin(String mixinClass, Side side, TargetedMod... targetedMods) {
        this.mixinClass = mixinClass;
        this.targetedMods = Arrays.asList(targetedMods);
        this.side = side;
        this.injectAlongPlayerAPI = true;
        this.isInjectAlongOptifine = true;
    }

    Mixin(String mixinClass, boolean injectAlongPlayerAPI, boolean isInjectAlongOptifine, TargetedMod... targetedMods) {
        this.mixinClass = mixinClass;
        this.targetedMods = Arrays.asList(targetedMods);
        this.side = Side.BOTH;
        this.injectAlongPlayerAPI = injectAlongPlayerAPI;
        this.isInjectAlongOptifine = isInjectAlongOptifine;
    }

    Mixin(String mixinClass, TargetedMod... targetedMods) {
        this.mixinClass = mixinClass;
        this.targetedMods = Arrays.asList(targetedMods);
        this.side = Side.BOTH;
        this.injectAlongPlayerAPI = true;
        this.isInjectAlongOptifine = true;
    }

    public boolean shouldLoad(List<TargetedMod> loadedMods) {
        return (side == Side.BOTH
                || side == Side.SERVER && FMLLaunchHandler.side().isServer()
                || side == Side.CLIENT && FMLLaunchHandler.side().isClient())
                && loadedMods.containsAll(targetedMods)
                && (loadedMods.contains(PLAYER_API) == false || injectAlongPlayerAPI)
                && (loadedMods.contains(OPTIFINE) == false || isInjectAlongOptifine);
    }
}

enum Side {
    BOTH,
    CLIENT,
    SERVER;
}
