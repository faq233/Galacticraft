package micdoodle8.mods.galacticraft.miccore.mixins.minecraft;

import micdoodle8.mods.galacticraft.core.util.WorldUtil;
import net.minecraft.entity.item.EntityItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(EntityItem.class)
public class EntityItemMixin extends EntityItem{

    public EntityItemMixin() {
        super(null);
    }

    @ModifyConstant(method = "onUpdate", constant = @Constant(doubleValue = 0.9800000190734863D))
    private double onOnUpdate() {
        return WorldUtil.getItemGravity(this);
    }

    // CHECK
}
