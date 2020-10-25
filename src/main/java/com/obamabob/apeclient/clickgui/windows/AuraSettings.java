package com.obamabob.apeclient.clickgui.windows;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class AuraSettings {
    public static JFrame auraSettings;
    public static JSlider tickDelay;
    public static JSlider range;
    public AuraSettings() {
        auraSettings = new JFrame("ApeClient");
        auraSettings.setLayout(new BoxLayout(auraSettings.getContentPane(), BoxLayout.Y_AXIS));
        auraSettings.pack();
        auraSettings.setSize(350, 125);
        auraSettings.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        auraSettings.setResizable(false);
        auraSettings.setLocationRelativeTo(null);

        tickDelay = new JSlider(0, 1, 40, 1);
        JLabel tickDelayLabel = new JLabel("Tick Delay: " + tickDelay.getValue(), SwingConstants.CENTER);
        tickDelay.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                tickDelayLabel.setText("Tick Delay: " + tickDelay.getValue());
            }
        });

        JPanel panel = new JPanel();
        //panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        auraSettings.add(panel);

        panel.add(tickDelayLabel);
        panel.add(tickDelay);

        range = new JSlider(0, 1, 7, 1);
        JLabel rangeLabel = new JLabel("Range: " + tickDelay.getValue(), SwingConstants.CENTER);
        range.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                rangeLabel.setText("Range: " + range.getValue());
            }
        });

        JPanel panel1 = new JPanel();
        auraSettings.add(panel1);

        panel1.add(range);
        panel1.add(rangeLabel);
    }

    public static void open() {
        auraSettings.setVisible(true);
    }
}
