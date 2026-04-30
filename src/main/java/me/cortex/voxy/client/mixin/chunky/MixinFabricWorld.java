package me.cortex.voxy.client.mixin.chunky;

import java.util.concurrent.CompletableFuture;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import me.cortex.voxy.client.config.VoxyConfig;
import me.cortex.voxy.client.core.IGetVoxelCore;
import org.popcraft.chunky.platform.FabricWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import net.minecraft.client.MinecraftClient;
import net.minecraft.server.world.OptionalChunk;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.WorldChunk;

@Mixin(FabricWorld.class)
public class MixinFabricWorld {
    @ModifyExpressionValue(method = "getChunkAtAsync", at = @At(value = "INVOKE", target = "Lorg/popcraft/chunky/mixin/ServerChunkCacheMixin;invokeGetChunkFutureMainThread(IILnet/minecraft/world/chunk/ChunkStatus;Z)Ljava/util/concurrent/CompletableFuture;"))
    private CompletableFuture<OptionalChunk<Chunk>> captureGeneratedChunk(CompletableFuture<OptionalChunk<Chunk>> future) {
        return future.thenApplyAsync(res->{
            res.ifPresent(chunk -> {
                var core = ((IGetVoxelCore)(MinecraftClient.getInstance().worldRenderer)).getVoxelCore();
                if (core != null && VoxyConfig.CONFIG.ingestEnabled) {
                    core.enqueueIngest((WorldChunk) chunk);
                }
            });
            return res;
        });
    }
}
