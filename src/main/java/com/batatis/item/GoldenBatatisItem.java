package com.batatis.item;import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class GoldenBatatisItem extends Item {
    public GoldenBatatisItem(Properties properties){
        super(properties);
    }
    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        ItemStack result = super.finishUsingItem(stack, level, entity);

        if (!level.isClientSide()) {
            // your effects here, examples:
            entity.setHealth(entity.getMaxHealth()); // full heal
            entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE,3600,0,false,true,true));                   // potion effect
            entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION,3600,4,false,true,true));                   // potion effect
            entity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST,3600,4,false,true,true));                   // potion effect
            entity.addEffect(new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE,3600,0,false,true,true));                   // potion effect
            entity.addEffect(new MobEffectInstance(MobEffects.SPEED,3600,4,false,true,true));                   // potion effect
            entity.addEffect(new MobEffectInstance(MobEffects.LUCK,3600,4,false,true,true));                   // potion effect
            entity.addEffect(new MobEffectInstance(MobEffects.HASTE,3600,4,false,true,true));                   // potion effect
        }

        return result;
    }
}
