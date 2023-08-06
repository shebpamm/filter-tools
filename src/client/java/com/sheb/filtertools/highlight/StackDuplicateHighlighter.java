package com.sheb.filtertools.highlight;

import com.sheb.filtertools.config.FilterToolsConfig;
import com.sheb.filtertools.icon.Icons;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

public class StackDuplicateHighlighter extends StackHighlighter{
    public StackDuplicateHighlighter(DrawContext context, Slot slot) {
        super(context, slot, Icons.DUPLICATE_MARK, IconPlacement.RIGHT_TOP);
    }

    private boolean slotIsDuplicated() {
        ItemStack stack = this.slot.getStack();
        return this.slot.inventory.count(stack.getItem()) > stack.getCount();
    }
    @Override
    public boolean needsAnnotation() {
        return FilterToolsConfig.Generic.STACK_DUPLICATE_WARNING.getBooleanValue() &&
            slotIsDuplicated();
    }
}

