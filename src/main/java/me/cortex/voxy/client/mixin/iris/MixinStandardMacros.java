package me.cortex.voxy.client.mixin.iris;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.irisshaders.iris.gl.shader.StandardMacros;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = StandardMacros.class, remap = false)
public class MixinStandardMacros {
    @ModifyExpressionValue(method = "createStandardEnvironmentDefines", at = @At(value = "INVOKE", target = "Lnet/irisshaders/iris/platform/IrisPlatformHelpers;isModLoaded(Ljava/lang/String;)Z"))
    private static boolean checkVoxyLoaded(boolean original) {
        return true;
    }
}
