package com.sheb.filtertools.features;

import com.sheb.filtertools.config.FilterToolsConfig;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.screen.slot.Slot;
import net.minecraft.text.TextColor;
import net.minecraft.util.Formatting;

public class StackSizeHighlighter {
    public static void renderItemWarning(DrawContext context, Slot slot) {
        if (!FilterToolsConfig.Generic.STACK_SIZE_WARNING.getBooleanValue()) return;

        TextColor color = TextColor.fromFormatting(Formatting.RED);
        int opacity = 128;

        assert color != null;
        int argbColor = opacity << 24 | color.getRgb();

        context.fillGradient(RenderLayer.getGuiOverlay(), slot.x, slot.y, slot.x + 16, slot.y + 16, argbColor , argbColor, -1);
    }
}
