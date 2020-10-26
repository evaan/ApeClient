package com.obamabob.apeclient.util;

import com.obamabob.apeclient.clickgui.ClickGUI;
import com.obamabob.apeclient.clickgui.windows.AuraSettings;
import com.obamabob.apeclient.clickgui.windows.AutoClickerSettings;
import com.obamabob.apeclient.clickgui.windows.SprintSettings;

public class Panic {
    public static boolean panic = false;

    public static void panic() {
        Panic.panic = true;
        ClickGUI.closeGUI();
        AuraSettings.close();
        AutoClickerSettings.close();
        SprintSettings.close();
        ClickGUI.sprint.setSelected(false);
        ClickGUI.esp.setSelected(false);
        ClickGUI.aura.setSelected(false);
        ClickGUI.antikb.setSelected(false);
        ClickGUI.bhop.setSelected(false);
        ClickGUI.aclick.setSelected(false);
        ClickGUI.crits.setSelected(false);
    }
}
