package com.obamabob.apeclient.clickgui.windows;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class AutoClickerSettings {
    public static JFrame aclickSettings;
    public static JSlider tickDelay;
    public static JCheckBox requireClick;
    public AutoClickerSettings() {
        aclickSettings = new JFrame("ApeClient");
        aclickSettings.setLayout(new BoxLayout(aclickSettings.getContentPane(), BoxLayout.Y_AXIS));
        aclickSettings.pack();
        aclickSettings.setSize(350, 125);
        aclickSettings.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        aclickSettings.setResizable(false);
        aclickSettings.setLocationRelativeTo(null);

        tickDelay = new JSlider(0, 1, 40, 1);
        JLabel tickDelayLabel = new JLabel("Tick Delay: " + tickDelay.getValue(), SwingConstants.CENTER);
        tickDelay.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                tickDelayLabel.setText("Tick Delay: " + tickDelay.getValue());
            }
        });

        requireClick = new JCheckBox("Require Mouse Click");

        JPanel panel = new JPanel();
        //panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        aclickSettings.add(panel);

        JPanel panel1 = new JPanel();
        aclickSettings.add(panel1);

        panel1.add(requireClick);

        panel.add(tickDelayLabel);
        panel.add(tickDelay);
    }

    public static void open() {
        if (!aclickSettings.isVisible()) aclickSettings.setVisible(true);
    }
    public static void close() {
         if (aclickSettings.isVisible()) aclickSettings.setVisible(false);
    }
}
