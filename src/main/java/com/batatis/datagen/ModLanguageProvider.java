package com.batatis.datagen;

import com.batatis.effects.ModEffects;
import com.batatis.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class ModLanguageProvider extends FabricLanguageProvider {
    public ModLanguageProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, "en_us", registriesFuture);
    }
    @Override
    public void generateTranslations(HolderLookup.Provider registries, TranslationBuilder builder) {
        builder.add(ModItems.BATATIS, "Batatis");
        builder.add(ModItems.GOLDENBOTATO, "Golden Botato");
        builder.add(ModItems.LOADEDBATATIS, "Loaded Batatis");
        builder.add(ModEffects.IMMUNE.value(), "Immune");
    }
}
