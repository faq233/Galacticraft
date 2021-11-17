package micdoodle8.mods.galacticraft.miccore.mixins.minecraft;

import micdoodle8.mods.galacticraft.core.util.WorldUtil;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(World.class)
public abstract class WorldMixin extends World {

    public WorldMixin() {
        super(null, null, (WorldProvider) null, null, null);
    }

    @Override
    public float getRainStrength(float partialTicks) {
        return WorldUtil.getRainStrength(this, partialTicks);
    }

    // CHECK
}
