package dev.higurashi.spellbound_nexus.datagen.client.lang;

import dev.higurashi.spellbound_nexus.registry.AttributeRegistry;
import dev.higurashi.spellbound_nexus.registry.ItemRegistry;
import net.minecraft.data.PackOutput;

public class EnUsLanguageProvider extends BaseLanguageProvider {
    public EnUsLanguageProvider(PackOutput output, String locale) {
        super(output, locale);
    }

    @Override
    protected void addTranslations() {
        // === Attribute ===
        addAttribute(AttributeRegistry.MAX_MANA, "Max Mana");
        addAttribute(AttributeRegistry.MANA_REGEN, "Mana Regen Speed");

        // === Item ===
        addItem(ItemRegistry.WOODEN_WAND, "Wooden Wand");
    }
}
