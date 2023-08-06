package com.sheb.filtertools;

import fi.dy.masa.malilib.hotkeys.IKeybindManager;
import fi.dy.masa.malilib.hotkeys.IKeybindProvider;

public class FilterToolsInputHandler implements IKeybindProvider {
    private static final FilterToolsInputHandler INSTANCE = new FilterToolsInputHandler();

    private FilterToolsInputHandler() { super(); }

    public static FilterToolsInputHandler getInstance() { return INSTANCE; }

    @Override
    public void addKeysToMap(IKeybindManager manager) {
        manager.addKeybindToMap(FilterToolsConfig.Generic.STACK_SIZE_WARNING.getKeybind());
        manager.addKeybindToMap(FilterToolsConfig.Generic.OPEN_CONFIG_GUI.getKeybind());
    }

    @Override
    public void addHotkeys(IKeybindManager manager) {
        manager.addHotkeysForCategory(Loader.MODID, "filter-tools.hotkeys.category.generic_hotkeys", FilterToolsConfig.Generic.HOTKEYS);
    }
}
