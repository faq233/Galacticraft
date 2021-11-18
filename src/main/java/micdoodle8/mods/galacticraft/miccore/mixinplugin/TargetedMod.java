package micdoodle8.mods.galacticraft.miccore.mixinplugin;

public enum TargetedMod {

    //
    // IMPORTANT: Do not make any references to any mod from this file. This file is loaded quite early on and if
    // you refer to other mods you load them as well. The consequence is: You can't inject any previously loaded classes!
    // Exception: Tags.java, as long as it is used for Strings only!
    //

    // Replace with your injected mods here, but always keep VANILLA:
    VANILLA("Minecraft", "unused", true),
    FORGE("Forge", "unused", true),
    PLAYER_API("Player-API", "Player-API", true),
    OPTIFINE("Optifine", "OptiFine_1.7.10", false),
    SYNCMOD("Sync Mod", "sync", false);

    public final String modName;
    public final String jarNameBeginsWith;
    // Optional dependencies can be omitted in development. Especially skipping GT5U will drastically speed up your game start!
    public final boolean loadInDevelopment;

    TargetedMod(String modName, String jarNameBeginsWith, boolean loadInDevelopment) {
        this.modName = modName;
        this.jarNameBeginsWith = jarNameBeginsWith;
        this.loadInDevelopment = loadInDevelopment;
    }
}
