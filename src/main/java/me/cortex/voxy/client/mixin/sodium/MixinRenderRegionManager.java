package me.cortex.voxy.client.mixin.sodium;

import net.caffeinemc.mods.sodium.client.render.chunk.region.RenderRegionManager;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value = RenderRegionManager.class, remap = false)
public class MixinRenderRegionManager {
//    @Redirect(method = "uploadResults(Lnet/caffeinemc/mods/sodium/client/gl/device/CommandList;Lnet/caffeinemc/mods/sodium/client/render/chunk/region/RenderRegion;Ljava/util/Collection;)V", at = @At(value = "INVOKE", target = "Ljava/lang/Math;toIntExact(J)I"), remap = false)
//    private int voxy$cancelFade(long time) {
//        var vrs = ((IGetVoxyRenderSystem)(Minecraft.getInstance().levelRenderer)).voxy$getRenderSystem();
//        if (vrs!=null) {
//            return -2;
//        } else {
//            return Math.toIntExact(time);
//        }
//    }
}