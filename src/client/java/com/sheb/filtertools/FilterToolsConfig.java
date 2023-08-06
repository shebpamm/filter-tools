package com.sheb.filtertools;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import fi.dy.masa.malilib.MaLiLibConfigs;
import fi.dy.masa.malilib.config.ConfigUtils;
import fi.dy.masa.malilib.config.IConfigHandler;
import fi.dy.masa.malilib.config.IConfigValue;
import fi.dy.masa.malilib.config.IHotkeyTogglable;
import fi.dy.masa.malilib.config.options.ConfigBooleanHotkeyed;
import com.google.common.collect.ImmutableList;
import fi.dy.masa.malilib.config.options.ConfigHotkey;
import fi.dy.masa.malilib.hotkeys.IHotkey;
import fi.dy.masa.malilib.util.FileUtils;
import fi.dy.masa.malilib.util.JsonUtils;

import java.io.File;

import static com.sheb.filtertools.Loader.MODID;

public class FilterToolsConfig implements IConfigHandler {
    private static final String CONFIG_FILE_NAME = MODID + ".json";

    public static class Generic {
        public static final ConfigHotkey OPEN_CONFIG_GUI = new ConfigHotkey("openConfigGui", "F,C", "Open the in-game config GUI");
        public static final ConfigBooleanHotkeyed STACK_SIZE_WARNING = new ConfigBooleanHotkeyed("stackSizeWarning", false, "", "Highlight items that don't stack to 64");
        public static final ImmutableList<IConfigValue> OPTIONS = ImmutableList.of(
                OPEN_CONFIG_GUI,
                STACK_SIZE_WARNING
        );

        public static final ImmutableList<IHotkey> HOTKEYS = ImmutableList.of(
                OPEN_CONFIG_GUI,
                STACK_SIZE_WARNING
        );
    }

    public static void loadFromFile() {
        File configFile = new File(FileUtils.getConfigDirectory(), CONFIG_FILE_NAME);

        if (configFile.exists() && configFile.isFile() && configFile.canRead()) {
            JsonElement element = JsonUtils.parseJsonFile(configFile);

            if (element != null && element.isJsonObject()) {
                JsonObject root = element.getAsJsonObject();

                ConfigUtils.readConfigBase(root, "Generic", Generic.OPTIONS);
            }
        }
    }

    public static void saveToFile()
    {
        File dir = FileUtils.getConfigDirectory();

        if ((dir.exists() && dir.isDirectory()) || dir.mkdirs())
        {
            JsonObject root = new JsonObject();

            ConfigUtils.writeConfigBase(root, "Generic", Generic.OPTIONS);

            JsonUtils.writeJsonToFile(root, new File(dir, CONFIG_FILE_NAME));
        }
    }

    @Override
    public void onConfigsChanged() {
        saveToFile();
        loadFromFile();
    }

    @Override
    public void load() { loadFromFile(); }
    public void save() { saveToFile(); }
}
