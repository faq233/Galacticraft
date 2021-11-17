package micdoodle8.mods.galacticraft.miccore.mixins.minecraft;

import micdoodle8.mods.galacticraft.core.util.WorldUtil;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(World.class)
public abstract class WorldMixin {

    // TODO
    public float getRainStrength(float partialTicks) {
        System.out.println("getRainStrength");
        return WorldUtil.getRainStrength((World) (Object) this, partialTicks);
    }

    // CHECK
}
