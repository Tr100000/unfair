package io.github.tr100000.unfair.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.boss.dragon.EnderDragonEntity;

@Mixin(EnderDragonEntity.class)
public class EnderDragonEntityMixin {
    @Inject(method = "tickMovement", at = @At("HEAD"))
    private void infiniteHealth(CallbackInfo info) {
        ((EnderDragonEntity)(Object)this).setHealth(Float.MAX_VALUE);
    }
}
