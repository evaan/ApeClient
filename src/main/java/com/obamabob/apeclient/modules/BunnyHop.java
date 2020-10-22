package com.obamabob.apeclient.modules;

import com.obamabob.apeclient.clickgui.ClickGUI;
import com.obamabob.apeclient.clickgui.windows.SprintSettings;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class BunnyHop {
    public boolean isToJump() {
        if (Minecraft.getMinecraft().thePlayer.isInWater() && Minecraft.getMinecraft().thePlayer.isOnLadder()) return true;
        return false;
    }

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event) {
        if (!ClickGUI.bhop.isSelected()) return;
        if (SprintSettings.rage.isSelected() && Minecraft.getMinecraft().thePlayer != null && Minecraft.getMinecraft().thePlayer.moveForward != 0 && (Minecraft.getMinecraft().thePlayer.posY % 1 == 0)) Minecraft.getMinecraft().thePlayer.jump();
    }
}
