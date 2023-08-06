package com.sheb.filtertools;

import fi.dy.masa.malilib.config.ConfigManager;
import fi.dy.masa.malilib.event.InputEventHandler;
import fi.dy.masa.malilib.gui.GuiBase;
import fi.dy.masa.malilib.hotkeys.IHotkeyCallback;
import fi.dy.masa.malilib.hotkeys.IKeybind;
import fi.dy.masa.malilib.hotkeys.KeyAction;
import fi.dy.masa.malilib.interfaces.IInitializationHandler;

public class FilterToolsInitHandler implements IInitializationHandler {
    @Override
    public void registerModHandlers() {
        ConfigManager.getInstance().registerConfigHandler(Loader.MODID, new FilterToolsConfig());
        InputEventHandler.getKeybindManager().registerKeybindProvider(FilterToolsInputHandler.getInstance());

        FilterToolsConfig.Generic.OPEN_CONFIG_GUI.getKeybind().setCallback(new CallbackOpenConfigGui());
    }
    private static class CallbackOpenConfigGui implements IHotkeyCallback
    {
        @Override
        public boolean onKeyAction(KeyAction action, IKeybind key)
        {
            GuiBase.openGui(new FilterToolsConfigGui());
            return true;
        }
    }
}
