package com.tr10000mods.unfair.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.tr10000mods.unfair.things.ScreenBad;

import net.minecraft.client.MinecraftClient;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {
    @Inject(method = "tick", at = @At("HEAD"))
    private void pleaseDont(CallbackInfo info) {
        ScreenBad.otherTimeThing++;
        if (ScreenBad.otherTimeThing >= ScreenBad.timeForEachButton) {
            ScreenBad.otherTimeThing = 0;
            ScreenBad.timeValue++;
        }
    }
}
