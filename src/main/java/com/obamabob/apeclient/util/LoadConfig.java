package com.obamabob.apeclient.util;

import com.obamabob.apeclient.KeyBindHandler;
import com.obamabob.apeclient.clickgui.ClickGUI;
import com.obamabob.apeclient.clickgui.windows.AuraSettings;
import com.obamabob.apeclient.clickgui.windows.AutoClickerSettings;
import com.obamabob.apeclient.clickgui.windows.SprintSettings;
import com.obamabob.apeclient.module.modules.AutoClicker;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;

public class LoadConfig {
    public static File enabledModules = new File(System.getProperty("user.home") + "/Documents/ApeClient/EnabledModules");
    public static File binds = new File(System.getProperty("user.home") + "/Documents/ApeClient/Binds");
    public static File settings = new File(System.getProperty("user.home") + "/Documents/ApeClient/Settings");

    public static void loadModules() {
        try {
            Scanner scanner = new Scanner(new File(enabledModules.getAbsolutePath()));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                switch(line) {
                    case "Sprint": ClickGUI.sprint.setSelected(true); break;
                    case "ESP": ClickGUI.esp.setSelected(true); break;
                    case "Kill Aura": ClickGUI.aura.setSelected(true); break;
                    case "Anti Knockback": ClickGUI.antikb.setSelected(true); break;
                    case "Bunny Hop": ClickGUI.bhop.setSelected(true); break;
                    case "Auto Clicker": ClickGUI.aclick.setSelected(true); break;
                    case "Criticals": ClickGUI.crits.setSelected(true); break;
                }
            }
        } catch (Exception e) {}
    }

    public static void loadBinds() {
        try {
            int clickgui = Integer.parseInt(Files.readAllLines(Paths.get(binds.getAbsolutePath())).get(0));
            int sprint = Integer.parseInt(Files.readAllLines(Paths.get(binds.getAbsolutePath())).get(1));
            int esp = Integer.parseInt(Files.readAllLines(Paths.get(binds.getAbsolutePath())).get(2));
            int killAura = Integer.parseInt(Files.readAllLines(Paths.get(binds.getAbsolutePath())).get(3));
            int antiKnockback = Integer.parseInt(Files.readAllLines(Paths.get(binds.getAbsolutePath())).get(4));
            int bunnyHop = Integer.parseInt(Files.readAllLines(Paths.get(binds.getAbsolutePath())).get(5));
            int autoClicker = Integer.parseInt(Files.readAllLines(Paths.get(binds.getAbsolutePath())).get(6));
            int criticals = Integer.parseInt(Files.readAllLines(Paths.get(binds.getAbsolutePath())).get(7));

            KeyBindHandler.set("ClickGUI", clickgui, false);
            KeyBindHandler.set("Sprint", sprint, false);
            KeyBindHandler.set("ESP", esp, false);
            KeyBindHandler.set("Kill Aura", killAura, false);
            KeyBindHandler.set("Anti Knockback", antiKnockback, false);
            KeyBindHandler.set("Bunny Hop", bunnyHop, false);
            KeyBindHandler.set("Auto Clicker", autoClicker, false);
            KeyBindHandler.set("Criticals", criticals, false);
        } catch (Exception e) {}
    }

    public static void loadSettings () {
        try {
            int auraDelay = Integer.parseInt(Files.readAllLines(Paths.get(settings.getAbsolutePath())).get(0));
            int auraRange = Integer.parseInt(Files.readAllLines(Paths.get(settings.getAbsolutePath())).get(1));
            int aclickerDelay = Integer.parseInt(Files.readAllLines(Paths.get(settings.getAbsolutePath())).get(2));
            boolean aclickerRequireClick = Boolean.parseBoolean(Files.readAllLines(Paths.get(settings.getAbsolutePath())).get(3));
            boolean sprintRage = Boolean.parseBoolean(Files.readAllLines(Paths.get(settings.getAbsolutePath())).get(4));

            AuraSettings.tickDelay.setValue(auraDelay);
            AuraSettings.range.setValue(auraRange);
            AutoClickerSettings.tickDelay.setValue(aclickerDelay);
            AutoClickerSettings.requireClick.setSelected(aclickerRequireClick);
            SprintSettings.rage.setSelected(sprintRage);
        } catch (Exception e) {}
    }
}
