package com.obamabob.apeclient;

import com.obamabob.apeclient.clickgui.ClickGUI;
import com.obamabob.apeclient.util.Panic;
import org.lwjgl.input.Keyboard;

import javax.swing.*;

import java.awt.event.KeyEvent;
import java.util.HashMap;

public class KeyBindHandler {
    public static int sprint;
    public static int esp;
    public static int killaura;
    public static int antikb;
    public static int bhop;
    public static int aclick;
    public static int crits;
    public static int clickgui;

    public KeyBindHandler() {
        sprint = 0;
        esp = 0;
        killaura = 0;
        antikb = 0;
        bhop = 0;
        aclick = 0;
        crits = 0;
        clickgui = 0;
    }

    public static void registerKey(int key) {
        if (Panic.panic) return; //TODO: fix ruhama type shit where everything turns on
        if(key == clickgui) ClickGUI.openGUI();
        if(key == sprint) toggle(ClickGUI.sprint);
        if(key == esp) toggle(ClickGUI.esp);
        if(key == killaura) toggle(ClickGUI.aura);
        if(key == antikb) toggle(ClickGUI.antikb);
        if(key == bhop) toggle(ClickGUI.bhop);
        if(key == aclick) toggle(ClickGUI.aclick);
        if(key == crits) toggle(ClickGUI.crits);
    }

    public static void toggle(JCheckBox checkBox) {
        if (checkBox.isSelected()) checkBox.setSelected(false);
        else checkBox.setSelected(true);
    }

    public static void set(String name, int key, boolean convert) {
        int newKey;
        if (convert) newKey = convertKeyEvent(key);
        else newKey = key;

        switch (name) {
            case "Sprint": KeyBindHandler.sprint = newKey;
                ClickGUI.sprintb.setText("Sprint: " + Keyboard.getKeyName(newKey));
                break;
            case "ESP": KeyBindHandler.esp = newKey;
                ClickGUI.espb.setText("ESP: " + Keyboard.getKeyName(newKey));
                break;
            case "Kill Aura": KeyBindHandler.killaura = newKey;
                ClickGUI.aurab.setText("Kill Aura: " + Keyboard.getKeyName(newKey));
                break;
            case "Anti Knockback": KeyBindHandler.antikb = newKey;
                ClickGUI.antikbb.setText("Anti Knockback: " + Keyboard.getKeyName(newKey));
                break;
            case "Bunny Hop": KeyBindHandler.bhop = newKey;
                ClickGUI.bhopb.setText("Bunny Hop: " + Keyboard.getKeyName(newKey));
                break;
            case "Auto Clicker": KeyBindHandler.aclick = newKey;
                ClickGUI.aclickb.setText("Auto Clicker: " + Keyboard.getKeyName(newKey));
                break;
            case "Criticals": KeyBindHandler.crits = newKey;
                ClickGUI.critsb.setText("Criticals: " + Keyboard.getKeyName(newKey));
                break;
            case "ClickGUI": KeyBindHandler.clickgui = newKey;
                ClickGUI.clickguiBind.setText("ClickGUI: " + Keyboard.getKeyName(newKey));
                break;
        }
    }

    public static int convertKeyEvent(int key) {
        HashMap<Integer, Integer> keyCodeMap = new HashMap<>();
        keyCodeMap.put(KeyEvent.VK_ESCAPE, 0);
        keyCodeMap.put(KeyEvent.VK_0, Keyboard.KEY_0);
        keyCodeMap.put(KeyEvent.VK_1, Keyboard.KEY_1);
        keyCodeMap.put(KeyEvent.VK_2, Keyboard.KEY_2);
        keyCodeMap.put(KeyEvent.VK_3, Keyboard.KEY_3);
        keyCodeMap.put(KeyEvent.VK_4, Keyboard.KEY_4);
        keyCodeMap.put(KeyEvent.VK_5, Keyboard.KEY_5);
        keyCodeMap.put(KeyEvent.VK_6, Keyboard.KEY_6);
        keyCodeMap.put(KeyEvent.VK_7, Keyboard.KEY_7);
        keyCodeMap.put(KeyEvent.VK_8, Keyboard.KEY_8);
        keyCodeMap.put(KeyEvent.VK_9, Keyboard.KEY_9);
        keyCodeMap.put(KeyEvent.VK_UP, Keyboard.KEY_UP);
        keyCodeMap.put(KeyEvent.VK_DOWN, Keyboard.KEY_DOWN);
        keyCodeMap.put(KeyEvent.VK_LEFT, Keyboard.KEY_LEFT);
        keyCodeMap.put(KeyEvent.VK_RIGHT, Keyboard.KEY_RIGHT);
        keyCodeMap.put(KeyEvent.VK_SPACE, Keyboard.KEY_SPACE);
        keyCodeMap.put(KeyEvent.VK_MINUS, Keyboard.KEY_MINUS);
        keyCodeMap.put(KeyEvent.VK_EQUALS, Keyboard.KEY_EQUALS);
        keyCodeMap.put(KeyEvent.VK_BACK_SPACE, Keyboard.KEY_BACK);
        keyCodeMap.put(KeyEvent.VK_A, Keyboard.KEY_A);
        keyCodeMap.put(KeyEvent.VK_B, Keyboard.KEY_B);
        keyCodeMap.put(KeyEvent.VK_C, Keyboard.KEY_C);
        keyCodeMap.put(KeyEvent.VK_D, Keyboard.KEY_D);
        keyCodeMap.put(KeyEvent.VK_E, Keyboard.KEY_E);
        keyCodeMap.put(KeyEvent.VK_F, Keyboard.KEY_F);
        keyCodeMap.put(KeyEvent.VK_G, Keyboard.KEY_G);
        keyCodeMap.put(KeyEvent.VK_H, Keyboard.KEY_H);
        keyCodeMap.put(KeyEvent.VK_I, Keyboard.KEY_I);
        keyCodeMap.put(KeyEvent.VK_J, Keyboard.KEY_J);
        keyCodeMap.put(KeyEvent.VK_K, Keyboard.KEY_K);
        keyCodeMap.put(KeyEvent.VK_L, Keyboard.KEY_L);
        keyCodeMap.put(KeyEvent.VK_M, Keyboard.KEY_M);
        keyCodeMap.put(KeyEvent.VK_N, Keyboard.KEY_N);
        keyCodeMap.put(KeyEvent.VK_O, Keyboard.KEY_O);
        keyCodeMap.put(KeyEvent.VK_P, Keyboard.KEY_P);
        keyCodeMap.put(KeyEvent.VK_Q, Keyboard.KEY_Q);
        keyCodeMap.put(KeyEvent.VK_R, Keyboard.KEY_R);
        keyCodeMap.put(KeyEvent.VK_S, Keyboard.KEY_S);
        keyCodeMap.put(KeyEvent.VK_T, Keyboard.KEY_T);
        keyCodeMap.put(KeyEvent.VK_U, Keyboard.KEY_U);
        keyCodeMap.put(KeyEvent.VK_V, Keyboard.KEY_V);
        keyCodeMap.put(KeyEvent.VK_W, Keyboard.KEY_W);
        keyCodeMap.put(KeyEvent.VK_X, Keyboard.KEY_X);
        keyCodeMap.put(KeyEvent.VK_Y, Keyboard.KEY_Y);
        keyCodeMap.put(KeyEvent.VK_Z, Keyboard.KEY_Z);
        keyCodeMap.put(KeyEvent.VK_F1, Keyboard.KEY_F1);
        keyCodeMap.put(KeyEvent.VK_F2, Keyboard.KEY_F2);
        keyCodeMap.put(KeyEvent.VK_F3, Keyboard.KEY_F3);
        keyCodeMap.put(KeyEvent.VK_F4, Keyboard.KEY_F4);
        keyCodeMap.put(KeyEvent.VK_F5, Keyboard.KEY_F5);
        keyCodeMap.put(KeyEvent.VK_F6, Keyboard.KEY_F6);
        keyCodeMap.put(KeyEvent.VK_F7, Keyboard.KEY_F7);
        keyCodeMap.put(KeyEvent.VK_F8, Keyboard.KEY_F8);
        keyCodeMap.put(KeyEvent.VK_F9, Keyboard.KEY_F9);
        keyCodeMap.put(KeyEvent.VK_F10, Keyboard.KEY_F10);
        keyCodeMap.put(KeyEvent.VK_F11, Keyboard.KEY_F11);
        keyCodeMap.put(KeyEvent.VK_F12, Keyboard.KEY_F12);
        keyCodeMap.put(KeyEvent.VK_HOME, Keyboard.KEY_HOME);
        keyCodeMap.put(KeyEvent.VK_INSERT, Keyboard.KEY_INSERT);
        return keyCodeMap.get(key);
    }
}
