package micdoodle8.mods.galacticraft.miccore.mixins.minecraft;

import cpw.mods.fml.common.registry.GameRegistry;
import micdoodle8.mods.galacticraft.core.util.WorldUtil;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ChunkProviderServer.class)
public class ChunkProviderServerMixin {
    
    @Shadow
    public IChunkProvider currentChunkProvider;

    @Shadow
    public WorldServer worldObj;

    @Unique
    private boolean skipRegistryCalls = false;
    
    @Redirect(method = "populate", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/chunk/IChunkProvider;populate(Lnet/minecraft/world/chunk/IChunkProvider;II)V"))
    private void onPopulate(IChunkProvider instance, IChunkProvider chunkProvider, int chunkX, int chunkZ) {
        skipRegistryCalls = WorldUtil.otherModPreventGenerate(chunkX, chunkZ, worldObj, currentChunkProvider, chunkProvider);
    }

    @Redirect(method = "populate",
            at = @At(value = "INVOKE",
                    target = "Lcpw/mods/fml/common/registry/GameRegistry;generateWorld(IILnet/minecraft/world/World;Lnet/minecraft/world/chunk/IChunkProvider;Lnet/minecraft/world/chunk/IChunkProvider;)V"),
            remap = false)
    private void onRegistry(int chunkX, int chunkZ, World world, IChunkProvider currentChunkProvider, IChunkProvider chunkGenerator) {
        if(skipRegistryCalls == false) {
            GameRegistry.generateWorld(chunkX, chunkZ, world, currentChunkProvider, chunkGenerator);
        }
    }

    // CHECK
}
