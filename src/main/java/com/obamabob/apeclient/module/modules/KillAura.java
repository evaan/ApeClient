package com.obamabob.apeclient.module.modules;

import com.obamabob.apeclient.clickgui.ClickGUI;
import com.obamabob.apeclient.clickgui.windows.AuraSettings;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class KillAura {
    protected final Minecraft mc = Minecraft.getMinecraft();

    public int ticks = 0;
    public int tickDelay = 0;

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event) {
        AuraSettings.tickDelay.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                tickDelay = AuraSettings.tickDelay.getValue();
            }
        });
        ticks+=1;
        if (tickDelay > ticks) return;
        if (Minecraft.getMinecraft().thePlayer == null || !ClickGUI.aura.isSelected()) return;
        List<Entity> targets = mc.theWorld.loadedEntityList.stream()
                .filter(entity -> entity != mc.thePlayer)
                .filter(entity -> mc.thePlayer.getDistanceToEntity(entity) <= AuraSettings.range.getValue())
                .filter(entity -> !entity.isDead)
                .filter(entity -> entity instanceof EntityPlayer)
                .filter(entity -> ((EntityPlayer) entity).getHealth() > 0)
                .sorted(Comparator.comparing(e->mc.thePlayer.getDistanceToEntity(e)))
                .collect(Collectors.toList());

        targets.forEach(target -> {
            Minecraft.getMinecraft().playerController.attackEntity(mc.thePlayer, target);
            Minecraft.getMinecraft().thePlayer.swingItem();
        });
        ticks = 0;
    }
}
