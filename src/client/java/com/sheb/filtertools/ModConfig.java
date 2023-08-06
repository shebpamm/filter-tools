package com.sheb.filtertools;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import static com.sheb.filtertools.Loader.MODID;

public class ModConfig implements ModMenuApi, ConfigScreenFactory<Screen> {
    public static final File CFG_FILE = new File(
            FabricLoader.getInstance().getConfigDir().toFile(),
            MODID + ".properties");

    public static final boolean DEFAULT_stackSizeWarning = true;
    public static boolean stackSizeWarning = DEFAULT_stackSizeWarning;
    @Override
    public ConfigScreenFactory<Screen> getModConfigScreenFactory() {
        return this;
    }

    public Screen create(Screen screen) {
        ConfigBuilder builder = ConfigBuilder.create()
                .setParentScreen(screen)
                .setTitle(Text.literal("Filter Tools Config")); //TODO Use translatable

        ConfigEntryBuilder entryBuilder = builder.entryBuilder();
        ConfigCategory general = builder.getOrCreateCategory(Text.literal("General"));

        general.addEntry(
                entryBuilder.startBooleanToggle(
                        Text.literal("Stack Size Warning"),
                        stackSizeWarning)
                        .setDefaultValue(DEFAULT_stackSizeWarning)
                        .setTooltip(Text.literal("Enable highlighting items that stack less than 64 times"))
                        .setSaveConsumer(ModConfig::setStackSizeWarning)
                        .build()
        );

        return builder.setSavingRunnable(() -> {
            saveConfig(CFG_FILE);
            loadConfig(CFG_FILE);
        }).build();
    }

    public static void setStackSizeWarning(boolean stackSizeWarning) {
        ModConfig.stackSizeWarning = stackSizeWarning;
    }

    public static void loadConfig(File file) {
        try {
            Properties cfg = new Properties();
            if (!file.exists()) {
                saveConfig(file);
            }
            cfg.load(new FileInputStream(file));

            stackSizeWarning = Boolean.parseBoolean(cfg.getProperty("stackSizeWarning", String.valueOf(DEFAULT_stackSizeWarning)));

            // Re-save so that new properties will appear in old config files
            saveConfig(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveConfig(File file) {
        try {
            FileOutputStream fos = new FileOutputStream(file, false);
            fos.write(("stackSizeWarning=" + stackSizeWarning + "\n").getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
