package com.sheb.filtertools;

import com.terraformersmc.modmenu.util.mod.Mod;
import fi.dy.masa.malilib.event.InitializationHandler;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.screen.slot.Slot;

public class FilterToolsClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		InitializationHandler.getInstance().registerInitializationHandler(new FilterToolsInitHandler());
	}
}