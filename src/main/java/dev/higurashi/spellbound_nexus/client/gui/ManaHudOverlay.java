package dev.higurashi.spellbound_nexus.client.gui;

import dev.higurashi.spellbound_nexus.api.Mana;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

public class ManaHudOverlay {
    public static final IGuiOverlay HUD_MANA = (gui, poseStack, partialTicks, width, height) -> {
        int x = width / 2;
        int y = height;

        float currentMana = Mana.get(Minecraft.getInstance().player);
        String text = "Mana: " + (int) currentMana;

        poseStack.drawString(gui.getFont(), text, x + 10, y - 20, 0xFFFFFF);
    };
}
