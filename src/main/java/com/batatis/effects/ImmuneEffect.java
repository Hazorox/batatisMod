package com.batatis.effects;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class ImmuneEffect extends MobEffect {
    // pass the effect props to the MobEffect super
    public ImmuneEffect() {
        super(MobEffectCategory.BENEFICIAL, 0x00FF00);
    }
    // Check Every tick while it's on
    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
    // Apply effect stuff...
    @Override
    public boolean applyEffectTick(ServerLevel level, LivingEntity entity, int amplifier) {
        if (entity instanceof Player player) {
            player.setInvulnerable(true);
            // only add hero of the village if not already active
            if (!player.hasEffect(MobEffects.HERO_OF_THE_VILLAGE)) {
                player.addEffect(new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 600, 0, false, true, true));
            }
        }
        return super.applyEffectTick(level, entity, amplifier);
    }
    @Override
    public void onEffectRemoved(MobEffectInstance effectInstance, LivingEntity entity) {
        if (entity instanceof Player player) {
            player.setInvulnerable(false);
            player.removeEffect(MobEffects.HERO_OF_THE_VILLAGE);
        }
    }

    }
