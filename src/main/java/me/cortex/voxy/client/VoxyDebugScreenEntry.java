package me.cortex.voxy.client;

public class VoxyDebugScreenEntry /*implements DebugScreenEntry*/ {
    /*@Override
    public void display(DebugScreenDisplayer lines, @Nullable Level world, @Nullable LevelChunk clientChunk, @Nullable LevelChunk chunk) {
        if (!VoxyCommon.isAvailable()) {
            return;
        }

        var instance = VoxyCommon.getInstance();
        if (instance == null) {
            return;
        }

        VoxyRenderSystem vrs = null;
        var wr = Minecraft.getInstance().levelRenderer;
        if (wr != null) vrs = ((IGetVoxyRenderSystem) wr).voxy$getRenderSystem();

        //lines.addLineToSection();
        List<String> instanceLines = new ArrayList<>();
        instance.addDebug(instanceLines);
        lines.addToGroup(ResourceLocation.fromNamespaceAndPath("voxy", "instance_debug"), instanceLines);

        if (vrs != null) {
            List<String> renderLines = new ArrayList<>();
            vrs.addDebugInfo(renderLines);
            lines.addToGroup(ResourceLocation.fromNamespaceAndPath("voxy", "render_debug"), renderLines);
        }
    }*/

}
