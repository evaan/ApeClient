package com.obamabob.apeclient;

import com.obamabob.apeclient.clickgui.ClickGUI;
import com.obamabob.apeclient.clickgui.SettingsManager;
import com.obamabob.apeclient.clickgui.windows.SprintSettings;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;

@Mod(modid = ApeClient.MODID, version = ApeClient.VERSION)
public class ApeClient
{
    public static final String MODID = "apeclient";
    public static final String VERSION = "1.0";

    protected static final Minecraft mc = Minecraft.getMinecraft();

    public ClickGUI clickGUI;
    public ModuleManager moduleManager;
    public SettingsManager settingsManager;

    @SubscribeEvent
    public void onKeyPress(InputEvent.KeyInputEvent event) {
        if (Keyboard.getEventKey() == Keyboard.KEY_HOME) ClickGUI.openGUI();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
        clickGUI = new ClickGUI();
        moduleManager = new ModuleManager();
        settingsManager = new SettingsManager();
    }

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event) {
        if (mc.thePlayer == null) return;
        if (!SprintSettings.rage.isSelected() && ClickGUI.sprint.isSelected() && !mc.thePlayer.isCollidedHorizontally && mc.thePlayer.moveForward > 0) mc.thePlayer.setSprinting(true);
        if (SprintSettings.rage.isSelected() && ClickGUI.sprint.isSelected() && !mc.thePlayer.isCollidedHorizontally && (mc.thePlayer.motionX != 0 || mc.thePlayer.motionZ != 0)) mc.thePlayer.setSprinting(true);
    }
}
