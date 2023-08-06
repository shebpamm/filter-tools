package com.sheb.filtertools.compat;

import com.sheb.filtertools.config.FilterToolsConfigGui;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
public class ModMenuImpl implements ModMenuApi
{
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory()
    {
        return (screen) -> {
            FilterToolsConfigGui gui = new FilterToolsConfigGui();
            gui.setParent(screen);
            return gui;
        };
    }
}