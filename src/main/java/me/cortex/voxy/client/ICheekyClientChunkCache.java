package me.cortex.voxy.client;

import org.jetbrains.annotations.Nullable;

import net.minecraft.world.level.chunk.LevelChunk;

public interface ICheekyClientChunkCache {
    @Nullable
    LevelChunk voxy$cheekyGetChunk(int x, int z);
}
