package io.github.tr100000.unfair.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import io.github.tr100000.unfair.Unfair;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

@Mixin(Entity.class)
public class EntityMixin {
    @ModifyVariable(method = "dropStack", at = @At("HEAD"), ordinal = 0)
    private ItemStack replaceWithDirt(ItemStack stack) {
        return Unfair.enabled ? new ItemStack(Items.DIRT, stack.getCount()) : stack;
    }
}
