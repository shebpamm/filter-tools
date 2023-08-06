package com.sheb.filtertools.config;

import com.sheb.filtertools.Loader;
import fi.dy.masa.malilib.hotkeys.IHotkey;
import fi.dy.masa.malilib.hotkeys.IKeybindManager;
import fi.dy.masa.malilib.hotkeys.IKeybindProvider;

public class FilterToolsInputHandler implements IKeybindProvider {
    private static final FilterToolsInputHandler INSTANCE = new FilterToolsInputHandler();

    private FilterToolsInputHandler() { super(); }

    public static FilterToolsInputHandler getInstance() { return INSTANCE; }

    @Override
    public void addKeysToMap(IKeybindManager manager) {
        for (IHotkey hotkey: FilterToolsConfig.Generic.HOTKEYS) {
            manager.addKeybindToMap(hotkey.getKeybind());
        }
    }

    @Override
    public void addHotkeys(IKeybindManager manager) {
        manager.addHotkeysForCategory(Loader.MODID, "filter-tools.hotkeys.category.generic_hotkeys", FilterToolsConfig.Generic.HOTKEYS);
    }
}
