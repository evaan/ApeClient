package com.obamabob.apeclient.clickgui;

import com.bulenkov.darcula.DarculaLaf;
import com.obamabob.apeclient.clickgui.windows.*;

import javax.swing.*;
import javax.swing.plaf.basic.BasicLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class ClickGUI {

    public static JFrame clickGui;

    public static JCheckBox sprint;
    public static JCheckBox esp;
    public static JCheckBox aura;
    public static JCheckBox antikb;
    public static JCheckBox bhop;

    public ClickGUI() {

        try {
            BasicLookAndFeel darcula = new DarculaLaf();
            UIManager.setLookAndFeel(darcula);
        } catch (Exception e) {}
        clickGui = new JFrame("ApeClient");
        clickGui.setLayout(new BoxLayout(clickGui.getContentPane(), BoxLayout.X_AXIS));
        clickGui.pack();
        clickGui.setSize(475, 300);
        clickGui.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        clickGui.setResizable(false);
        clickGui.setLocationRelativeTo(null);

        sprint = new JCheckBox("Sprint");
        esp = new JCheckBox("ESP");
        aura = new JCheckBox("Kill Aura");
        antikb = new JCheckBox("Anti Knockback");
        bhop = new JCheckBox("Bunny Hop");

        JButton sprintb = new JButton("Sprint: None");
        JButton espb = new JButton("ESP: None");
        JButton aurab = new JButton("Kill Aura: None");
        JButton antikbb = new JButton("Anti Knockback: None");
        JButton bhopb = new JButton("Bunny Hop: None");

        JButton sprints = new JButton("Sprint Settings...");
        JButton esps = new JButton("ESP Settings...");
        JButton auras = new JButton("Kill Aura Settings...");
        JButton antikbs = new JButton("Anti Knockback Settings...");
        JButton bhops = new JButton("Bunny Hop Settings...");

        JPanel mPanel = new JPanel();
        mPanel.setLayout(new BoxLayout(mPanel, BoxLayout.Y_AXIS));
        //mPanel.setAlignmentY(Component.TOP_ALIGNMENT);
        clickGui.add(mPanel);

        JPanel bPanel = new JPanel();
        bPanel.setLayout(new BoxLayout(bPanel, BoxLayout.Y_AXIS));
        //bPanel.setAlignmentY(Component.TOP_ALIGNMENT);
        clickGui.add(bPanel);

        JPanel sPanel = new JPanel();
        sPanel.setLayout(new BoxLayout(sPanel, BoxLayout.Y_AXIS));
        //mPanel.setAlignmentY(Component.TOP_ALIGNMENT);
        clickGui.add(sPanel);

        mPanel.add(sprint);
        mPanel.add(Box.createVerticalGlue());
        mPanel.add(esp);
        mPanel.add(Box.createVerticalGlue());
        mPanel.add(aura);
        mPanel.add(Box.createVerticalGlue());
        mPanel.add(antikb);
        mPanel.add(Box.createVerticalGlue());
        mPanel.add(bhop);

        bPanel.add(sprintb);
        bPanel.add(Box.createVerticalGlue());
        bPanel.add(espb);
        bPanel.add(Box.createVerticalGlue());
        bPanel.add(aurab);
        bPanel.add(Box.createVerticalGlue());
        bPanel.add(antikbb);
        bPanel.add(Box.createVerticalGlue());
        bPanel.add(bhopb);

        sPanel.add(sprints);
        sPanel.add(Box.createVerticalGlue());
        sPanel.add(esps);
        sPanel.add(Box.createVerticalGlue());
        sPanel.add(auras);
        sPanel.add(Box.createVerticalGlue());
        sPanel.add(antikbs);
        sPanel.add(Box.createVerticalGlue());
        sPanel.add(bhops);

        bindKeys(sprints, esps, auras, antikbs, bhops);
    }

    public static void openGUI() {
        if (!clickGui.isVisible()) clickGui.setVisible(true);
    }

    public void bindKeys(JButton sprint, JButton esp, JButton aura, JButton antikb, JButton bhop) {
        sprint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SprintSettings.open();
            }
        });

        esp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ESPSettings.open();
            }
        });

        aura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AuraSettings.open();
            }
        });


        antikb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "There are no settings for Anti Knockback.");
            }
        });

        bhop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "There are no settings for Bunny Hop.");
            }
        });
    }
}
