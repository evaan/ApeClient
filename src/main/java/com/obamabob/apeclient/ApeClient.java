package com.obamabob.apeclient;

import com.obamabob.apeclient.clickgui.ClickGUI;
import com.obamabob.apeclient.clickgui.SettingsManager;
import com.obamabob.apeclient.module.ModuleManager;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

@Mod(modid = ApeClient.MODID, version = ApeClient.VERSION)
public class ApeClient
{
    public static final String MODID = "apeclient";
    public static final String VERSION = "1.0";

    protected static final Minecraft mc = Minecraft.getMinecraft();

    public ClickGUI clickGUI;
    public ModuleManager moduleManager;
    public SettingsManager settingsManager;

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        clickGUI = new ClickGUI();
        moduleManager = new ModuleManager();
        settingsManager = new SettingsManager();
    }
}
