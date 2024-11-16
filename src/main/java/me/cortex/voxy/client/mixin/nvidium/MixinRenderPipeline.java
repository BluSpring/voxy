package me.cortex.voxy.client.mixin.nvidium;

import me.cortex.nvidium.RenderPipeline;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value = RenderPipeline.class, remap = false)
public class MixinRenderPipeline {
    /*@Inject(method = "renderFrame", at = @At("RETURN"))
    private void injectVoxyRender(Viewport frustum, ChunkRenderMatrices crm, double px, double py, double pz, CallbackInfo ci) {
        var core = ((IGetVoxelCore) MinecraftClient.getInstance().worldRenderer).getVoxelCore();
        if (core != null) {
            var stack = new MatrixStack();
            stack.loadIdentity();
            stack.multiplyPositionMatrix(new Matrix4f(crm.modelView()));
            core.renderOpaque(stack, px, py, pz);
        }
    }*/
}
