package io.github.tr100000.unfair.things;

import org.jetbrains.annotations.Nullable;

import io.github.tr100000.unfair.Unfair;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.World.ExplosionSourceType;

public final class MakeThingsExplode {
    private MakeThingsExplode() {}

    public static ActionResult block(PlayerEntity player, World world, Hand hand, BlockPos pos, Direction direction) {
        if (Unfair.enabled) {
            world.removeBlock(pos, false);
            explode(world, player, player, pos.getX(), pos.getY(), pos.getZ(), ExplosionSourceType.BLOCK, UnfairDamageTypes.BLOCK_HIT);
            return ActionResult.PASS;
        }
        else {
            return ActionResult.PASS;
        }
    }

    public static ActionResult entity(PlayerEntity player, World world, Hand hand, Entity entity, HitResult hitResult) {
        if (Unfair.enabled) {
            explode(world, player, player, player.getX(), player.getY(), player.getZ(), ExplosionSourceType.MOB, UnfairDamageTypes.ENTITY_HIT);
            return ActionResult.PASS;
        }
        else {
            return ActionResult.PASS;
        }
    }


    public static void explode(World world, PlayerEntity player, @Nullable Entity explosionOwner, double x, double y, double z, ExplosionSourceType explosionSourceType, RegistryKey<DamageType> damageType) {
        UnfairUtils.killPlayer(player, UnfairUtils.fromDamageType(world, damageType));
        world.createExplosion(explosionOwner, x, y, z, 10, true, explosionSourceType);
    }
}
