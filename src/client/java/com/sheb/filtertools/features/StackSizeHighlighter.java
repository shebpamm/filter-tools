package com.sheb.filtertools.features;

import com.sheb.filtertools.config.FilterToolsConfig;
import com.sheb.filtertools.icon.Icons;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.screen.slot.Slot;

public class StackSizeHighlighter extends StackHighlighter{
    public StackSizeHighlighter(DrawContext context, Slot slot) {
        super(context, slot, Icons.EXCLAMATION_MARK, IconPlacement.LEFT_TOP);
    }

    @Override
    public boolean needsAnnotation() {
        return FilterToolsConfig.Generic.STACK_SIZE_WARNING.getBooleanValue() &&
                this.slot.hasStack() &&
                this.slot.getStack().getMaxCount() != 64;
    }
}
