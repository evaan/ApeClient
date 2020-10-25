package com.obamabob.apeclient.module.modules;

import com.obamabob.apeclient.clickgui.ClickGUI;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ESP {
    //extremely bad but itll do for now
    //TODO: do actually good esp

    @SubscribeEvent
    public void preRender(RenderPlayerEvent.Pre event) {
        if (ClickGUI.esp.isSelected()) GlStateManager.disableDepth();
    }

    @SubscribeEvent
    public void postRender(RenderPlayerEvent.Post event) {
        if (ClickGUI.esp.isSelected()) GlStateManager.enableDepth();
    }
}
