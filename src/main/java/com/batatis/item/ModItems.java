package com.batatis.item;

import com.batatis.Batatis;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

import java.util.function.Function;

public class ModItems {
    public static final Item BATATIS = registerItem("batatis", properties ->
            new BatatisItem(properties.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationModifier(1f)
                    .alwaysEdible()
                    .build()))
    );
    public static final Item GOLDENBATATIS = registerItem("golden_batatis", properties ->
            new GoldenBatatisItem(properties.food(new FoodProperties.Builder()
                    .nutrition(10)
                    .saturationModifier(10f)
                    .alwaysEdible()
                    .build()))
    );
    public static final Item LOADEDBATATIS = registerItem("loaded_batatis", properties ->
            new LoadedBatatisItem(properties.food(new FoodProperties.Builder()
                    .nutrition(20)
                    .saturationModifier(20f)
                    .alwaysEdible()

                    .build()))
    );
    private static Item registerItem(String name, Function<Item.Properties, Item> function){
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(Batatis.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM,Identifier.fromNamespaceAndPath(Batatis.MOD_ID,name)))));
    }
    public static void registerModItems(){
        Batatis.LOGGER.info("Registering Item : " + ModItems.BATATIS);
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FOOD_AND_DRINKS).register(output -> {
            output.accept(BATATIS);
            output.accept(LOADEDBATATIS);
            output.accept(GOLDENBATATIS);
        });
    }




}
