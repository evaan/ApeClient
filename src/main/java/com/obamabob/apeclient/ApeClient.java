package com.obamabob.apeclient;

import com.obamabob.apeclient.clickgui.ClickGUI;
import com.obamabob.apeclient.clickgui.SettingsManager;
import com.obamabob.apeclient.module.ModuleManager;
import com.obamabob.apeclient.util.LoadConfig;
import com.obamabob.apeclient.util.SaveConfig;
import com.obamabob.apeclient.KeyBindHandler;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import java.awt.event.KeyEvent;

@Mod(modid = ApeClient.MODID, version = ApeClient.VERSION)
public class ApeClient
{
    public static final String MODID = "apeclient";
    public static final String VERSION = "1.0";

    protected static final Minecraft mc = Minecraft.getMinecraft();

    public ClickGUI clickGUI;
    public ModuleManager moduleManager;
    public SettingsManager settingsManager;
    public KeyBindHandler keyBindHandler;

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        clickGUI = new ClickGUI();
        moduleManager = new ModuleManager();
        settingsManager = new SettingsManager();
        keyBindHandler = new KeyBindHandler();
        Runtime.getRuntime().addShutdownHook(new SaveConfig());
        LoadConfig.loadModules();
        LoadConfig.loadBinds();
        LoadConfig.loadSettings();
        if (!SaveConfig.confDir.exists()) {
            ClickGUI.openGUI(); // i wrote this on emacs with no internet so bare with me :)
            keyBindHandler.set("ClickGUI", KeyEvent.VK_HOME, true);
        }
    }
}
