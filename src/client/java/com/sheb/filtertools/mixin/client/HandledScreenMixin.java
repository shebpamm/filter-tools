package com.sheb.filtertools.mixin.client;

import com.sheb.filtertools.highlight.StackDuplicateHighlighter;
import com.sheb.filtertools.highlight.StackSizeHighlighter;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.GenericContainerScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.screen.slot.Slot;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HandledScreen.class)
abstract class HandledScreenMixin extends Screen {
    protected HandledScreenMixin(Text titleIn) { super(titleIn); }

    @Inject(method = "drawSlot(Lnet/minecraft/client/gui/DrawContext;Lnet/minecraft/screen/slot/Slot;)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/DrawContext;drawItemInSlot(Lnet/minecraft/client/font/TextRenderer;Lnet/minecraft/item/ItemStack;IILjava/lang/String;)V"))
    public void drawSlot(DrawContext context, Slot slot, CallbackInfo info) {
        // Only bother if we're dealing with a Generic Container, e.g. Chests or Barrels.
        if (((HandledScreen)(Object)this) instanceof GenericContainerScreen) {
            if(slot.hasStack()) {
                new StackSizeHighlighter(context, slot).annotateSlot();
                new StackDuplicateHighlighter(context, slot).annotateSlot();
            }
        }
    }
}
