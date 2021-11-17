package micdoodle8.mods.galacticraft.miccore.mixins.minecraft;

import micdoodle8.mods.galacticraft.core.util.WorldUtil;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Entity.class)
public abstract class EntityMixin extends Entity {

    public EntityMixin() {
        super(null);
    }

    @Override
    public boolean canRenderOnFire() {
        return WorldUtil.shouldRenderFire(this);
    }

    // CHECK
}
