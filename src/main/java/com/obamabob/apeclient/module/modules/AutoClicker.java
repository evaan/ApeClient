package com.obamabob.apeclient.module.modules;

import com.obamabob.apeclient.clickgui.ClickGUI;
import com.obamabob.apeclient.clickgui.windows.AuraSettings;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class AutoClicker {
    protected final Minecraft mc = Minecraft.getMinecraft();

    public int ticks = 0;
    public int tickDelay = 0;

    @SubscribeEvent
    public void onTick(TickEvent.ServerTickEvent event) {
        AuraSettings.tickDelay.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                tickDelay = AuraSettings.tickDelay.getValue();
            }
        });
        ticks+=1;
        if (tickDelay > ticks) return;
        if(Minecraft.getMinecraft().gameSettings.keyBindAttack.isKeyDown() && mc.thePlayer != null && ClickGUI.aclick.isSelected()) KeyBinding.onTick(mc.gameSettings.keyBindAttack.getKeyCode());
        ticks = 0;
    }
}