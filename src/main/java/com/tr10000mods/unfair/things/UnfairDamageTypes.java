package com.tr10000mods.unfair.things;

import com.tr10000mods.unfair.Unfair;

import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public final class UnfairDamageTypes {
    private UnfairDamageTypes() {}

    public static final RegistryKey<DamageType> GENERIC_UNFAIR = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Unfair.id("generic_unfair"));
    public static final RegistryKey<DamageType> BLOCK_HIT = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Unfair.id("block_hit"));
    public static final RegistryKey<DamageType> ENTITY_HIT = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Unfair.id("entity_hit"));
    public static final RegistryKey<DamageType> BED = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Unfair.id("bed"));
    public static final RegistryKey<DamageType> EXPERIENCE_COLLECT = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Unfair.id("collect_experience"));
}
