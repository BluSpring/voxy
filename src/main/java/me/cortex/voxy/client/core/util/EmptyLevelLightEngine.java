package me.cortex.voxy.client.core.util;

import org.jetbrains.annotations.Nullable;

import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.chunk.LightChunk;
import net.minecraft.world.level.chunk.LightChunkGetter;
import net.minecraft.world.level.lighting.LevelLightEngine;

public class EmptyLevelLightEngine extends LevelLightEngine {
    public EmptyLevelLightEngine(BlockGetter level) {
        super(new LightChunkGetter() {
            @Override
            public @Nullable LightChunk getChunkForLighting(int chunkX, int chunkZ) {
                return null;
            }

            @Override
            public BlockGetter getLevel() {
                return level;
            }
        }, false, false);
    }
}
