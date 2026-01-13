package dev.higurashi.spellbound_nexus.datagen.client.lang;

import dev.higurashi.spellbound_nexus.registries.AttributeRegistry;
import net.minecraft.data.PackOutput;

public class JaJpLanguageProvider extends ModLanguageProvider {
    public JaJpLanguageProvider(PackOutput output, String locale) {
        super(output, locale);
    }

    @Override
    protected void addTranslations() {
        // === Attribute ===
        addAttribute(AttributeRegistry.MAX_MANA, "最大マナ");
        addAttribute(AttributeRegistry.MANA_REGEN, "マナ回復速度");
    }
}
