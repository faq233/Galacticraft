package micdoodle8.mods.galacticraft.miccore.mixins.minecraft;

import micdoodle8.mods.galacticraft.core.util.WorldUtil;
import net.minecraft.entity.projectile.EntityArrow;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(EntityArrow.class)
public class EntityArrowMixin extends EntityArrow {

    public EntityArrowMixin() {
        super(null);
    }

    @ModifyConstant(method = "onUpdate", constant = @Constant(floatValue = 0.05F))
    private float onOnUpdate() {
        return WorldUtil.getArrowGravity(this);
    }

    // CHECK
}
