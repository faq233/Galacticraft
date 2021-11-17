package micdoodle8.mods.galacticraft.miccore.mixins.minecraft;

import micdoodle8.mods.galacticraft.core.client.render.entities.RenderPlayerGC;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.entity.EntityLivingBase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(RendererLivingEntity.class)
public abstract class RendererLivingEntityMixin extends RendererLivingEntity{

    public RendererLivingEntityMixin() {
        super(null, 0);
    }

    @Inject(method = "renderModel", at = @At("RETURN"), locals = LocalCapture.CAPTURE_FAILEXCEPTION)
    private void onRenderModel(EntityLivingBase visibleEntity, float p_77036_2_, float p_77036_3_, float p_77036_4_, float p_77036_5_, float p_77036_6_, float p_77036_7_, CallbackInfo ci) {
        RenderPlayerGC.renderModelS(this, visibleEntity, p_77036_2_, p_77036_3_, p_77036_4_, p_77036_5_, p_77036_6_, p_77036_7_);
    }

    // CHECK
}
