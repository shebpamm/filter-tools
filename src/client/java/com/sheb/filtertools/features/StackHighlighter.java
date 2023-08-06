package com.sheb.filtertools.features;

import fi.dy.masa.malilib.gui.interfaces.IGuiIcon;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.screen.slot.Slot;

abstract class StackHighlighter {
    protected final DrawContext context;
    protected final Slot slot;
    protected final IGuiIcon icon;

    protected final IconPlacement placement;

    protected StackHighlighter(DrawContext context,  Slot slot, IGuiIcon icon, IconPlacement placement) {
        this.icon = icon;
        this.context = context;
        this.slot = slot;
        this.placement = placement;
    }
    abstract boolean needsAnnotation();

    public void annotateSlot() {
        if (needsAnnotation()) {
            renderIcon();
        }
    }

    private void renderIcon() {
        int x = this.placement.translateX(this.slot.x);
        int y = this.placement.translateY(this.slot.y) + 1;
        renderIconAt(x, y);
    }

    private void renderIconAt(int x, int y) {
        MatrixStack stack = this.context.getMatrices();

        stack.push();
        stack.translate(0, 0, 300);
        context.drawTexture(this.icon.getTexture(), x, y, this.icon.getU(), this.icon.getV(), this.icon.getWidth(), this.icon.getHeight());
        stack.pop();
    }
//    public static void renderSizeWarning(DrawContext context, Slot slot) {
//        if (!FilterToolsConfig.Generic.STACK_SIZE_WARNING.getBooleanValue()) return;
//
//        TextColor color = TextColor.fromFormatting(Formatting.RED);
//        int opacity = 128;
//
//        assert color != null;
//        int argbColor = opacity << 24 | color.getRgb();

//        context.fillGradient(RenderLayer.getGuiOverlay(), slot.x, slot.y, slot.x + 16, slot.y + 16, argbColor , argbColor, -1);
//    }
}
