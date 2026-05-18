package com.batatis.effects;

import com.batatis.Batatis;
import com.batatis.item.BatatisItem;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;


public class ModEffects {
public static final Holder<MobEffect> IMMUNE = registerEffect("immune",new ImmuneEffect());
private static Holder<MobEffect> registerEffect(String name, MobEffect effect) {
    return Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, Identifier.fromNamespaceAndPath(Batatis.MOD_ID, name), effect);
}
    public static void registerModEffects(){
        Batatis.LOGGER.info("Reigstering Effects...");
    }
}
