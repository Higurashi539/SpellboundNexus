package dev.higurashi.spellbound_nexus.datagen.client.lang;

import dev.higurashi.spellbound_nexus.SpellboundNexus;
import net.minecraft.data.PackOutput;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.function.Supplier;

public class ModLanguageProvider extends LanguageProvider {
    public ModLanguageProvider(PackOutput output, String locale) {
        super(output, SpellboundNexus.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() { }

    public void addAttribute(Supplier<? extends Attribute> key, String name) {
        add(key.get(), name);
    }
    private void add(Attribute key, String name) { add(key.getDescriptionId(), name); }
}
