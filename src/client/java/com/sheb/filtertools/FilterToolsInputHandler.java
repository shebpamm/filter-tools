package com.sheb.filtertools;

import com.google.common.collect.ImmutableList;
import fi.dy.masa.malilib.MaLiLibConfigs;
import fi.dy.masa.malilib.hotkeys.IHotkey;
import fi.dy.masa.malilib.hotkeys.IKeybindManager;
import fi.dy.masa.malilib.hotkeys.IKeybindProvider;
import me.shedaniel.autoconfig.event.ConfigSerializeEvent;

import java.util.List;
import java.util.logging.Filter;

public class FilterToolsInputHandler implements IKeybindProvider {
    private static final FilterToolsInputHandler INSTANCE = new FilterToolsInputHandler();

    private FilterToolsInputHandler() { super(); };

    public static FilterToolsInputHandler getInstance() { return INSTANCE; }

    @Override
    public void addKeysToMap(IKeybindManager manager) {
        manager.addKeybindToMap(FilterToolsConfig.Generic.STACK_SIZE_WARNING.getKeybind());
        manager.addKeybindToMap(FilterToolsConfig.Generic.OPEN_CONFIG_GUI.getKeybind());
    }

    @Override
    public void addHotkeys(IKeybindManager manager) {
        List<? extends IHotkey> hotkeys = ImmutableList.of( FilterToolsConfig.Generic.OPEN_CONFIG_GUI );
        manager.addHotkeysForCategory(Loader.MODID, "filter-tools.hotkeys.category.generic_hotkeys", hotkeys);
    }
}
