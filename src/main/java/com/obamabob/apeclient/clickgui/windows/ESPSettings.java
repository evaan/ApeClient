package com.obamabob.apeclient.clickgui.windows;

import javax.swing.*;

public class ESPSettings {
    public static JFrame espSettings;
    public static JCheckBox rage;
    public ESPSettings() {
        espSettings = new JFrame("ApeClient");
        espSettings.setLayout(new BoxLayout(espSettings.getContentPane(), BoxLayout.X_AXIS));
        espSettings.pack();
        espSettings.setSize(100, 70);
        espSettings.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        espSettings.setResizable(false);
        espSettings.setLocationRelativeTo(null);

        rage = new JCheckBox("Rage Mode");

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        espSettings.add(panel);

        panel.add(rage);
    }

    public static void open() {
        espSettings.setVisible(true);
    }
}
