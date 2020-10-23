package com.obamabob.apeclient.module.modules;

import com.obamabob.apeclient.clickgui.ClickGUI;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class BunnyHop {
    public boolean isToJump() {
        if (!Minecraft.getMinecraft().thePlayer.isInWater() && !Minecraft.getMinecraft().thePlayer.isOnLadder()) return true;
        return false;
    }

    //TODO: actual good bhop

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event) {
        if (!ClickGUI.bhop.isSelected()) return;
        if (isToJump() && Minecraft.getMinecraft().thePlayer != null && Minecraft.getMinecraft().thePlayer.moveForward != 0 && (Minecraft.getMinecraft().thePlayer.posY % 1 == 0)) Minecraft.getMinecraft().thePlayer.jump();
    }
}
