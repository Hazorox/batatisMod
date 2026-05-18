package com.batatis.datagen;

import com.batatis.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider{
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        return new RecipeProvider(registries,output) {
            @Override
            public void buildRecipes() {
                List<ItemLike> GOLDENBOTATO = List.of(ModItems.GOLDENBOTATO);
                shaped(RecipeCategory.FOOD,ModItems.GOLDENBOTATO)
                        .pattern("xxx")
                        .pattern("xRx")
                        .pattern("xxx")
                        .define('R',ModItems.BATATIS)
                        .define('x',Items.GOLD_INGOT)
                        .unlockedBy(getHasName(ModItems.BATATIS), has(Items.GOLD_INGOT))
                        .group("batatis")
                        .save(output);
                List<ItemLike> LOADEDBOTATO = List.of(ModItems.GOLDENBOTATO);
                shaped(RecipeCategory.FOOD,ModItems.LOADEDBATATIS)
                        .pattern("xxx")
                        .pattern("xRx")
                        .pattern("xxx")
                        .define('R',ModItems.GOLDENBOTATO)
                        .define('x',Items.DIAMOND)
                        .group("batatis")
                        .unlockedBy("has_golden_botato", has(ModItems.GOLDENBOTATO))
                        .save(output);
                List<ItemLike> BATATIS = List.of(ModItems.BATATIS);
                shapeless(RecipeCategory.FOOD,ModItems.BATATIS)
                        .requires(Items.GOLD_NUGGET)
                        .requires(Items.POTATO)
                        .unlockedBy("has_golden_botato", has(Items.GOLD_NUGGET))
                        .group("batatis")
                        .save(output);

            }
        };
    }

    @Override
    public String getName() {
        return "Golden Botato Recipes";
    }
}
