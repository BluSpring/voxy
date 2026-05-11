package me.cortex.voxy.client;

import net.minecraft.resources.ResourceLocation;

public class DebugEntries {
    public static final ResourceLocation GPU_DEBUG = ResourceLocation.fromNamespaceAndPath("voxy", "gpu_debug");
    public static void init() {
        /*DebugScreenEntries.register(ResourceLocation.fromNamespaceAndPath("voxy", "version"), new DebugScreenEntry() {
            @Override
            public void display(DebugScreenDisplayer lines, @Nullable Level level, @Nullable LevelChunk levelChunk, @Nullable LevelChunk levelChunk2) {
                if (!VoxyCommon.isAvailable()) {
                    lines.addLine(ChatFormatting.RED + "voxy-"+VoxyCommon.MOD_VERSION);//Voxy installed, not avalible
                    return;
                }
                var instance = VoxyCommon.getInstance();
                if (instance == null) {
                    lines.addLine(ChatFormatting.YELLOW + "voxy-" + VoxyCommon.MOD_VERSION);//Voxy avalible, no instance active
                    return;
                }
                VoxyRenderSystem vrs = null;
                var wr = Minecraft.getInstance().levelRenderer;
                if (wr != null) vrs = ((IGetVoxyRenderSystem) wr).voxy$getRenderSystem();

                //Voxy instance active
                lines.addLine((vrs==null?ChatFormatting.DARK_GREEN:ChatFormatting.GREEN)+"voxy-"+VoxyCommon.MOD_VERSION);
            }
        });

        DebugScreenEntries.register(ResourceLocation.fromNamespaceAndPath("voxy","debug"), new VoxyDebugScreenEntry());

        DebugScreenEntries.register(GPU_DEBUG, new DebugScreenEntry() {
            @Override
            public void display(DebugScreenDisplayer debugScreenDisplayer, @Nullable Level level, @Nullable LevelChunk levelChunk, @Nullable LevelChunk levelChunk2) {

            }
        });*/
    }

    private static boolean previousGpuDebugEnabled = false;
    /*public static void onRebuild(Map<ResourceLocation, DebugScreenEntryStatus> allStatuses, List<ResourceLocation> enabled) {
        var entry = allStatuses.getOrDefault(GPU_DEBUG, DebugScreenEntryStatus.NEVER);
        if ((entry!=DebugScreenEntryStatus.NEVER)!=previousGpuDebugEnabled) {
            previousGpuDebugEnabled ^= true;

            GPUTiming.INSTANCE.setEnabled(previousGpuDebugEnabled);
            RenderStatistics.enabled = previousGpuDebugEnabled;
            var renderer = Minecraft.getInstance().levelRenderer;
            if (renderer!=null)renderer.allChanged();
        }
    }*/
}
