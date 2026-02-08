package dev.higurashi.spellbound_nexus.datagen.client.lang;

import dev.higurashi.spellbound_nexus.registries.AttributeRegistry;
import dev.higurashi.spellbound_nexus.registries.ItemRegistry;
import net.minecraft.data.PackOutput;

public class JaJpLanguageProvider extends BaseLanguageProvider {
    public JaJpLanguageProvider(PackOutput output, String locale) {
        super(output, locale);
    }

    @Override
    protected void addTranslations() {
        // === Attribute ===
        addAttribute(AttributeRegistry.MAX_MANA, "最大マナ");
        addAttribute(AttributeRegistry.MANA_REGEN, "マナ回復速度");

        // === Item ===
        addItem(ItemRegistry.WOODEN_WAND, "木製魔法杖");
    }
}
