package com.obamabob.apeclient.util;

import com.obamabob.apeclient.KeyBindHandler;
import com.obamabob.apeclient.clickgui.ClickGUI;
import com.obamabob.apeclient.clickgui.windows.AuraSettings;
import com.obamabob.apeclient.clickgui.windows.AutoClickerSettings;
import com.obamabob.apeclient.clickgui.windows.SprintSettings;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class SaveConfig extends Thread {
    public static File confDir = new File(System.getProperty("user.home") + "/Documents/ApeClient");
    public static File enabledModules = new File(System.getProperty("user.home") + "/Documents/ApeClient/EnabledModules");
    public static File binds = new File(System.getProperty("user.home") + "/Documents/ApeClient/Binds");
    public static File settings = new File(System.getProperty("user.home") + "/Documents/ApeClient/Settings");
    @Override
    public void run() {
        if (!confDir.exists()) confDir.mkdirs();
        saveModules();
        saveBinds();
        saveSettings();
    }

    public static void saveModules() {
        if(Panic.panic) return;
        ArrayList<String> enabledMods = new ArrayList<>();

        if (ClickGUI.sprint.isSelected()) enabledMods.add("Sprint");
        if (ClickGUI.esp.isSelected()) enabledMods.add("ESP");
        if (ClickGUI.aura.isSelected()) enabledMods.add("Kill Aura");
        if (ClickGUI.antikb.isSelected()) enabledMods.add("Anti Knockback");
        if (ClickGUI.bhop.isSelected()) enabledMods.add("Bunny Hop");
        if (ClickGUI.aclick.isSelected()) enabledMods.add("Auto Clicker");
        if (ClickGUI.crits.isSelected()) enabledMods.add("Criticals");

        try {
            PrintWriter writer = new PrintWriter(new FileOutputStream(enabledModules, false));
            for(String m: enabledMods) {
                    writer.write(m + "\n");
            }
            writer.close();
        } catch (Exception e) {}
    }

    public static void saveBinds() {
        ArrayList<Integer> binds = new ArrayList<>();

        binds.add(KeyBindHandler.clickgui);
        binds.add(KeyBindHandler.sprint);
        binds.add(KeyBindHandler.esp);
        binds.add(KeyBindHandler.killaura);
        binds.add(KeyBindHandler.antikb);
        binds.add(KeyBindHandler.bhop);
        binds.add(KeyBindHandler.aclick);
        binds.add(KeyBindHandler.crits);

        try {
            PrintWriter writer = new PrintWriter(new FileOutputStream(SaveConfig.binds, false));
            for(Integer b: binds) {
                writer.write(String.valueOf(b) + "\n");
            }
            writer.close();
        } catch (Exception e) {}
    }

    public static void saveSettings() {
        ArrayList<String> settings = new ArrayList<>();

        settings.add(String.valueOf(AuraSettings.tickDelay.getValue()));
        settings.add(String.valueOf(AuraSettings.range.getValue()));
        settings.add(String.valueOf(AutoClickerSettings.tickDelay.getValue()));
        settings.add(String.valueOf(AutoClickerSettings.requireClick.isSelected()));
        settings.add(String.valueOf(SprintSettings.rage.isSelected()));

        try {
            PrintWriter writer = new PrintWriter(new FileOutputStream(SaveConfig.settings, false));
            for (String s: settings) {
                writer.write(s + "\n");
            }
            writer.close();
        } catch (Exception e) {}
    }
}
