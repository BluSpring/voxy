package me.cortex.voxy.client.mixin.minecraft;

import com.llamalad7.mixinextras.sugar.Local;
import me.cortex.voxy.client.config.VoxyConfig;
import me.cortex.voxy.client.core.IGetVoxyRenderSystem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.Camera;
import net.minecraft.client.renderer.FogRenderer;

@Mixin(value = FogRenderer.class, priority = 900)//We must execute before sodium
public class MixinFogRenderer {
    @Inject(method = "setupFog", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/systems/RenderSystem;setShaderFogStart(F)V"))
    private static void voxy$modifyFog(Camera camera, FogRenderer.FogMode fogMode, float farPlaneDistance, boolean shouldCreateFog, float partialTick, CallbackInfo ci, @Local FogRenderer.FogData data) {
        if (!VoxyConfig.CONFIG.isRenderingEnabled()) return;

        var vrs = IGetVoxyRenderSystem.getNullable();
        if (vrs == null) return;
        boolean fogIsDamnClose = data.end<10;
        if (!VoxyConfig.CONFIG.useEnvironmentalFog && !fogIsDamnClose) {
            data.start = 99999999;
            data.end = 99999999;
        }

//        data.renderDistanceStart = 999999999;
//        data.renderDistanceEnd = 999999999;
    }
}
