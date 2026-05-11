package me.cortex.voxy.commonImpl.mixin.minecraft;

import java.util.function.Supplier;

import me.cortex.voxy.commonImpl.IWorldGetIdentifier;
import me.cortex.voxy.commonImpl.WorldIdentifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.core.Holder;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.storage.WritableLevelData;

@Mixin(Level.class)
public class MixinWorld implements IWorldGetIdentifier {
    @Unique
    private WorldIdentifier identifier;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void voxy$injectIdentifier(WritableLevelData levelData, ResourceKey<Level> key, RegistryAccess registryAccess, Holder<DimensionType> dimensionEntry, Supplier profiler, boolean isClientSide, boolean isDebug, long seed, int maxChainedNeighborUpdates, CallbackInfo ci) {
        if (key != null) {
            this.identifier = new WorldIdentifier(key, seed, dimensionEntry == null?null:dimensionEntry.unwrapKey().orElse(null));
        } else {
            this.identifier = null;
        }
    }

    @Override
    public WorldIdentifier voxy$getIdentifier() {
        return this.identifier;
    }
}
