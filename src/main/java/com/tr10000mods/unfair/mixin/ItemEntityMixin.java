package com.tr10000mods.unfair.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import com.tr10000mods.unfair.Unfair;

import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

@Mixin(ItemEntity.class)
public class ItemEntityMixin {
    @ModifyVariable(method = "setStack", at = @At("HEAD"), ordinal = 0)
    public ItemStack dirt(ItemStack stack) {
        return Unfair.enabled ? new ItemStack(Items.DIRT, stack.getCount()) : stack;
    }
}
