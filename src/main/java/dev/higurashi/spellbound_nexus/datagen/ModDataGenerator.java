package dev.higurashi.spellbound_nexus.datagen;

import dev.higurashi.spellbound_nexus.datagen.client.lang.EnUsLanguageProvider;
import dev.higurashi.spellbound_nexus.datagen.client.lang.JaJpLanguageProvider;
import dev.higurashi.spellbound_nexus.datagen.server.ModBlockTagsProvider;
import dev.higurashi.spellbound_nexus.datagen.server.ModItemTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Locale;
import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModDataGenerator {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> provider = event.getLookupProvider();

        // === Server ===
        ModBlockTagsProvider blockTagsProvider = generator.addProvider(event.includeServer(), new ModBlockTagsProvider(packOutput, provider, existingFileHelper));
        generator.addProvider(event.includeServer(), new ModItemTagsProvider(packOutput, provider, blockTagsProvider.contentsGetter(),existingFileHelper));

        // === Client ===
        generator.addProvider(event.includeClient(), new EnUsLanguageProvider(packOutput, Locale.US.toString().toLowerCase()));
        generator.addProvider(event.includeClient(), new JaJpLanguageProvider(packOutput, Locale.JAPAN.toString().toLowerCase()));
    }
}
