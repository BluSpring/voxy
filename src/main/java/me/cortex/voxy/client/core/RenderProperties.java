package me.cortex.voxy.client.core;


import static org.lwjgl.opengl.GL11C.GL_GEQUAL;
import static org.lwjgl.opengl.GL11C.GL_GREATER;
import static org.lwjgl.opengl.GL11C.GL_LEQUAL;
import static org.lwjgl.opengl.GL11C.GL_LESS;

import com.mojang.blaze3d.platform.GlConst;
import com.mojang.blaze3d.platform.GlStateManager;
import me.cortex.voxy.client.core.gl.shader.Shader;
import me.cortex.voxy.client.core.util.IrisUtil;
import me.cortex.voxy.client.iris.IGetIrisVoxyPipelineData;
import net.irisshaders.iris.Iris;
import org.lwjgl.opengl.GL;

public record RenderProperties(boolean isZero2One, boolean isReverseZ, boolean useBlockAtlasUVs) {

    public <T extends Shader.Builder<J>, J extends Shader> T apply(T builder) {
        return (T) builder.defineIf("USE_ZERO_ONE_DEPTH", this.isZero2One)
                .defineIf("USE_REVERSE_Z", this.isReverseZ);
    }

    public int closerEqualDepthCompare() {
        return this.isReverseZ?GL_GEQUAL:GL_LEQUAL;
    }

    public int closerDepthCompare() {
        return this.isReverseZ?GL_GREATER:GL_LESS;
    }

    public int furtherDepthCompare() {
        return this.isReverseZ?GL_LESS:GL_GREATER;
    }

    public float clearDepth() {
        return this.isReverseZ?0.0f:1.0f;
    }

    public float inverseClearDepth() {
        return this.isReverseZ?1.0f:0.0f;
    }







    private static boolean irisUseBlockAtlasUv() {
        var irisPipe = Iris.getPipelineManager().getPipelineNullable();
        if (irisPipe == null) {
            return false;
        }
        if (irisPipe instanceof IGetIrisVoxyPipelineData getVoxyPipeData) {
            var pipeData = getVoxyPipeData.voxy$getPipelineData();
            if (pipeData == null) {
                return false;
            }
            //return pipeData.useBlockAtlasUV;
            return false;
        }
        return false;
    }

    public static RenderProperties getRenderProperties() {
        RenderProperties properties = new RenderProperties(
            GL.getCapabilities().GL_ARB_clip_control, //RenderSystem.getDevice().isZZeroToOne()
            GlStateManager.DEPTH.func == GlConst.GL_GEQUAL,
            false);

        if (IrisUtil.IRIS_INSTALLED && IrisUtil.SHADER_SUPPORT) {
            properties = new RenderProperties(properties.isZero2One(), properties.isReverseZ(), irisUseBlockAtlasUv());
        }

        return properties;
    }
}
