package com.obamabob.apeclient.clickgui.windows;

import javax.swing.*;

public class AuraSettings {
    public static JFrame auraSettings;
    public static JCheckBox rage;
    public AuraSettings() {
        auraSettings = new JFrame("ApeClient");
        auraSettings.setLayout(new BoxLayout(auraSettings.getContentPane(), BoxLayout.X_AXIS));
        auraSettings.pack();
        auraSettings.setSize(100, 70);
        auraSettings.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        auraSettings.setResizable(false);
        auraSettings.setLocationRelativeTo(null);

        rage = new JCheckBox("Rage Mode");

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        auraSettings.add(panel);

        panel.add(rage);
    }

    public static void open() {
        auraSettings.setVisible(true);
    }
}
