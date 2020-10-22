package com.obamabob.apeclient.clickgui.windows;

import javax.swing.*;

public class SprintSettings {
    public static JFrame sprintSettings;
    public static JCheckBox rage;
    public SprintSettings() {
        sprintSettings = new JFrame("ApeClient");
        sprintSettings.setLayout(new BoxLayout(sprintSettings.getContentPane(), BoxLayout.X_AXIS));
        sprintSettings.pack();
        sprintSettings.setSize(100, 70);
        sprintSettings.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        sprintSettings.setResizable(false);
        sprintSettings.setLocationRelativeTo(null);

        rage = new JCheckBox("Rage Mode");

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        sprintSettings.add(panel);

        panel.add(rage);
    }

    public static void open() {
        sprintSettings.setVisible(true);
    }
}
