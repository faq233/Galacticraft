package micdoodle8.mods.galacticraft.miccore.mixins.minecraft;

import micdoodle8.mods.galacticraft.core.util.WorldUtil;
import net.minecraft.entity.EntityLivingBase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(EntityLivingBase.class)
public abstract class EntityLivingBaseMixin extends EntityLivingBase {

    public EntityLivingBaseMixin() {
        super(null);
    }

    @ModifyConstant(method = "moveEntityWithHeading", constant = @Constant(doubleValue = 0.08D))
    private double onMoveEntityWithHeading() {
        return WorldUtil.getGravityForEntity(this);
    }

    // CHECK
}
