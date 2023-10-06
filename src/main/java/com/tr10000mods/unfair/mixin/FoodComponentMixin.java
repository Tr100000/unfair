package com.tr10000mods.unfair.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.tr10000mods.unfair.Unfair;

import net.minecraft.item.FoodComponent;

@Mixin(FoodComponent.class)
public class FoodComponentMixin {
    @Inject(method = "getHunger", at = @At("RETURN"), cancellable = true)
    private void hungry(CallbackInfoReturnable<Integer> info) {
        if (Unfair.enabled) {
            info.setReturnValue(info.getReturnValue() * -1);
        }
    }

    @Inject(method = "isAlwaysEdible", at = @At("HEAD"), cancellable = true)
    private void hungry2(CallbackInfoReturnable<Boolean> info) {
        if (Unfair.enabled) {
            info.setReturnValue(true);
        }
    }
}
