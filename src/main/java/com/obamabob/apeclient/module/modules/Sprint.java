package com.obamabob.apeclient.module.modules;

import com.obamabob.apeclient.clickgui.ClickGUI;
import com.obamabob.apeclient.clickgui.windows.SprintSettings;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Sprint {
    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event) {
        if (Minecraft.getMinecraft().thePlayer == null) return;
        if (!SprintSettings.rage.isSelected() && ClickGUI.sprint.isSelected() && !Minecraft.getMinecraft().thePlayer.isCollidedHorizontally && Minecraft.getMinecraft().thePlayer.moveForward > 0) Minecraft.getMinecraft().thePlayer.setSprinting(true);
        if (SprintSettings.rage.isSelected() && ClickGUI.sprint.isSelected() && !Minecraft.getMinecraft().thePlayer.isCollidedHorizontally && (Minecraft.getMinecraft().thePlayer.motionX != 0 || Minecraft.getMinecraft().thePlayer.motionZ != 0)) Minecraft.getMinecraft().thePlayer.setSprinting(true);
    }
}
