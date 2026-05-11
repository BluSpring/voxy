package me.cortex.voxy.client.mixin.nvidium;

import me.cortex.nvidium.RenderPipeline;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value = RenderPipeline.class, remap = false)
public class MixinRenderPipeline {
    /*@Inject(method = "renderFrame", at = @At("RETURN"))
    private void voxy$injectRender(TerrainRenderPass pass, Viewport frustum, FogParameters fogParameters, ChunkRenderMatrices crm, double px, double py, double pz, GpuSampler terrainSampler, CallbackInfo ci) {
        var renderer = ((IGetVoxyRenderSystem) Minecraft.getInstance().levelRenderer).voxy$getRenderSystem();
        if (renderer != null) {
            renderer.renderOpaque(renderer.setupViewport(crm.projection(), crm.modelView(), fogParameters, px, py, pz));
        }
    }*/
}
