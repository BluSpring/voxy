package me.cortex.voxy.client.mixin.iris;

import me.cortex.voxy.client.config.VoxyConfig;
import net.irisshaders.iris.Iris;
import net.irisshaders.iris.compat.dh.DHCompat;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.io.IOException;

@Mixin(value = DHCompat.class, remap = false)
public abstract class MixinDHCompat {
    @Shadow
    public static boolean checkFrame() {
        return false;
    }

    @Unique private static boolean voxyEnabled = false;
    @Unique private static int guiScale = -1;

    @Inject(method = "checkFrame", at = @At("HEAD"), cancellable = true)
    private static void checkVoxyFrame(CallbackInfoReturnable<Boolean> cir) {
        if (VoxyConfig.CONFIG.enabled != voxyEnabled || guiScale != MinecraftClient.getInstance().options.getGuiScale().getValue() && Iris.isPackInUseQuick()) {
            voxyEnabled = VoxyConfig.CONFIG.enabled;
            guiScale = MinecraftClient.getInstance().options.getGuiScale().getValue();

            try {
                Iris.reload();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            cir.setReturnValue(voxyEnabled);
        }

        cir.setReturnValue(voxyEnabled);
    }

    @Inject(method = "hasRenderingEnabled", at = @At("HEAD"), cancellable = true)
    private static void checkVoxyRenderingEnabled(CallbackInfoReturnable<Boolean> cir) {
        if (voxyEnabled) {
            cir.setReturnValue(checkFrame());
        }
    }

    @Inject(method = "getRenderDistance", at = @At("HEAD"), cancellable = true)
    private static void checkVoxyRenderDistance(CallbackInfoReturnable<Integer> cir) {
        if (voxyEnabled) {
            cir.setReturnValue(VoxyConfig.CONFIG.renderDistance * 16);
        }
    }

    @Inject(method = "getFarPlane", at = @At("HEAD"), cancellable = true)
    private static void checkVoxyFarPlane(CallbackInfoReturnable<Float> cir) {
        if (voxyEnabled) {
            int lodChunkDist = VoxyConfig.CONFIG.renderDistance;
            int lodBlockDist = lodChunkDist * 16;
            cir.setReturnValue((float) ((double) (lodBlockDist + 512) * Math.sqrt(2.0)));
        }
    }
}
