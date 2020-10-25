package com.obamabob.apeclient.clickgui;

import com.bulenkov.darcula.DarculaLaf;
import com.obamabob.apeclient.KeyBindHandler;
import com.obamabob.apeclient.Panic;
import com.obamabob.apeclient.clickgui.windows.*;
import org.lwjgl.input.Keyboard;

import javax.swing.*;
import javax.swing.plaf.basic.BasicLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

public class ClickGUI {

    public static JFrame clickGui;

    public static JCheckBox sprint;
    public static JCheckBox esp;
    public static JCheckBox aura;
    public static JCheckBox antikb;
    public static JCheckBox bhop;
    public static JCheckBox aclick;
    public static JCheckBox crits;

    public static JButton sprintb;
    public static JButton espb;
    public static JButton aurab;
    public static JButton antikbb;
    public static JButton bhopb;
    public static JButton aclickb;
    public static JButton critsb;

    public ClickGUI() {

        try {
            BasicLookAndFeel darcula = new DarculaLaf();
            UIManager.setLookAndFeel(darcula);
        } catch (Exception e) {}
        clickGui = new JFrame("ApeClient");
        clickGui.setLayout(new BoxLayout(clickGui.getContentPane(), BoxLayout.Y_AXIS));
        clickGui.pack();
        clickGui.setSize(475, 500);
        clickGui.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        clickGui.setResizable(false);
        clickGui.setLocationRelativeTo(null);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));

        JPanel btmPanel = new JPanel();
        btmPanel.setLayout(null);
        JButton panicButton = new JButton("Panic!");
        panicButton.setSize(460, 35);
        btmPanel.add(panicButton);

        panicButton.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) { Panic.panic(); }});

        sprint = new JCheckBox("Sprint");
        esp = new JCheckBox("ESP");
        aura = new JCheckBox("Kill Aura");
        antikb = new JCheckBox("Anti Knockback");
        bhop = new JCheckBox("Bunny Hop");
        aclick = new JCheckBox("Auto Clicker");
        crits = new JCheckBox("Criticals");

        sprintb = new JButton("Sprint: NONE");
        espb = new JButton("ESP: NONE");
        aurab = new JButton("Kill Aura: NONE");
        antikbb = new JButton("Anti Knockback: NONE");
        bhopb = new JButton("Bunny Hop: NONE");
        aclickb = new JButton("Auto Clicker: NONE");
        critsb = new JButton("Criticals: NONE");

        JButton sprints = new JButton("Sprint Settings...");
        JButton esps = new JButton("ESP Settings...");
        JButton auras = new JButton("Kill Aura Settings...");
        JButton antikbs = new JButton("Anti Knockback Settings...");
        JButton bhops = new JButton("Bunny Hop Settings...");
        JButton aclicks = new JButton("Auto Click Settings...");
        JButton critss = new JButton("Criticals Settings...");

        sprintb.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) { bindModule("Sprint"); }});
        espb.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) { bindModule("ESP"); }});
        aurab.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) { bindModule("Kill Aura"); }});
        antikbb.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) { bindModule("Anti Knockback"); }});
        bhopb.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) { bindModule("Bunny Hop"); }});
        aclickb.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) { bindModule("Auto Clicker"); }});
        critsb.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) { bindModule("Criticals"); }});

        sprints.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) { SprintSettings.open(); }});
        esps.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) { JOptionPane.showMessageDialog(null, "There are no settings for ESP."); }});
        auras.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) { AuraSettings.open(); }});
        antikbs.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) { JOptionPane.showMessageDialog(null, "There are no settings for Anti Knockback."); }});
        bhops.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) { JOptionPane.showMessageDialog(null, "There are no settings for Bunny Hop."); }});
        aclicks.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) { AutoClickerSettings.open(); }});
        critss.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) { JOptionPane.showMessageDialog(null, "There are no settings for Criticals"); }});

        JPanel mPanel = new JPanel();
        mPanel.setLayout(new BoxLayout(mPanel, BoxLayout.Y_AXIS));
        //mPanel.setAlignmentY(Component.TOP_ALIGNMENT);
        topPanel.add(mPanel);

        JPanel bPanel = new JPanel();
        bPanel.setLayout(new BoxLayout(bPanel, BoxLayout.Y_AXIS));
        //bPanel.setAlignmentY(Component.TOP_ALIGNMENT);
        topPanel.add(bPanel);

        JPanel sPanel = new JPanel();
        sPanel.setLayout(new BoxLayout(sPanel, BoxLayout.Y_AXIS));
        //mPanel.setAlignmentY(Component.TOP_ALIGNMENT);
        topPanel.add(sPanel);

        mPanel.add(sprint);
        mPanel.add(Box.createVerticalGlue());
        mPanel.add(esp);
        mPanel.add(Box.createVerticalGlue());
        mPanel.add(aura);
        mPanel.add(Box.createVerticalGlue());
        mPanel.add(antikb);
        mPanel.add(Box.createVerticalGlue());
        mPanel.add(bhop);
        mPanel.add(Box.createVerticalGlue());
        mPanel.add(aclick);
        mPanel.add(Box.createVerticalGlue());
        mPanel.add(crits);

        bPanel.add(sprintb);
        bPanel.add(Box.createVerticalGlue());
        bPanel.add(espb);
        bPanel.add(Box.createVerticalGlue());
        bPanel.add(aurab);
        bPanel.add(Box.createVerticalGlue());
        bPanel.add(antikbb);
        bPanel.add(Box.createVerticalGlue());
        bPanel.add(bhopb);
        bPanel.add(Box.createVerticalGlue());
        bPanel.add(aclickb);
        bPanel.add(Box.createVerticalGlue());
        bPanel.add(critsb);

        sPanel.add(sprints);
        sPanel.add(Box.createVerticalGlue());
        sPanel.add(esps);
        sPanel.add(Box.createVerticalGlue());
        sPanel.add(auras);
        sPanel.add(Box.createVerticalGlue());
        sPanel.add(antikbs);
        sPanel.add(Box.createVerticalGlue());
        sPanel.add(bhops);
        sPanel.add(Box.createVerticalGlue());
        sPanel.add(aclicks);
        sPanel.add(Box.createVerticalGlue());
        sPanel.add(critss);

        clickGui.add(topPanel);
        clickGui.add(btmPanel);
    }

    public static void openGUI() {
        if (!clickGui.isVisible()) clickGui.setVisible(true);
    }
    public static void closeGUI() {
        if (clickGui.isVisible()) clickGui.setVisible(false);
    }

    public void bindModule(String module) {
        JFrame bindWindow = new JFrame("ApeClient");
        bindWindow.setLayout(new GridBagLayout());
        bindWindow.pack();
        bindWindow.setSize(250, 70);
        bindWindow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        bindWindow.setResizable(false);
        bindWindow.setLocationRelativeTo(null);
        bindWindow.add(new JLabel("Press Any Key To Bind: " + module), SwingConstants.CENTER);
        bindWindow.setVisible(true);

        bindWindow.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyReleased(KeyEvent e) {}
            @Override
            public void keyPressed(KeyEvent e) {
                KeyBindHandler.set(module, e.getKeyCode());
                bindWindow.setVisible(false);
            }
        });
    }
}
