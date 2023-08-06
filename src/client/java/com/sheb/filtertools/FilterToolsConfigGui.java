package com.sheb.filtertools;

import fi.dy.masa.malilib.MaLiLibConfigs;
import fi.dy.masa.malilib.config.IConfigBase;
import fi.dy.masa.malilib.gui.GuiConfigsBase;
import net.minecraft.client.gui.screen.Screen;

import java.util.List;

public class FilterToolsConfigGui extends GuiConfigsBase {
    public FilterToolsConfigGui() {
        super(10, 50, Loader.MODID, null, "filtertools.gui.title.configs");
    }

    @Override
    public List<ConfigOptionWrapper> getConfigs() {
        List<? extends IConfigBase> configs;
        configs = MaLiLibConfigs.Generic.OPTIONS;

        return ConfigOptionWrapper.createFor(configs);
    }
}
