package com.sheb.filtertools.config;

import com.sheb.filtertools.Loader;
import fi.dy.masa.malilib.config.IConfigBase;
import fi.dy.masa.malilib.gui.GuiConfigsBase;

import java.util.List;

public class FilterToolsConfigGui extends GuiConfigsBase {
    public FilterToolsConfigGui() {
        super(10, 50, Loader.MODID, null, "filtertools.gui.title.configs");
    }

    @Override
    public List<ConfigOptionWrapper> getConfigs() {
        List<? extends IConfigBase> configs;
        configs = FilterToolsConfig.Generic.OPTIONS;

        return ConfigOptionWrapper.createFor(configs);
    }
}
