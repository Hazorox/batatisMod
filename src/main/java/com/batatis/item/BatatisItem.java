package com.batatis.item;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class BatatisItem extends Item
{
    public BatatisItem(Properties properties){
        super(properties);
    }
    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        ItemStack result = super.finishUsingItem(stack, level, entity);

        if (!level.isClientSide()) {
            // your effects here, examples:
            entity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING,3600,0,false,true,true));
        }

        return result;
    }
}
