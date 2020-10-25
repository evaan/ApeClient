package com.obamabob.apeclient.clickgui;

import com.bulenkov.darcula.DarculaLaf;
import com.obamabob.apeclient.KeyBindHandler;
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

    public static JButton sprintb;
    public static JButton espb;
    public static JButton aurab;
    public static JButton antikbb;
    public static JButton bhopb;
    public static JButton aclickb;

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
        aclick = new JCheckBox("Auto Clicker");

        sprintb = new JButton("Sprint: None");
        espb = new JButton("ESP: None");
        aurab = new JButton("Kill Aura: None");
        antikbb = new JButton("Anti Knockback: None");
        bhopb = new JButton("Bunny Hop: None");
        aclickb = new JButton("Auto Clicker: None");

        JButton sprints = new JButton("Sprint Settings...");
        JButton esps = new JButton("ESP Settings...");
        JButton auras = new JButton("Kill Aura Settings...");
        JButton antikbs = new JButton("Anti Knockback Settings...");
        JButton bhops = new JButton("Bunny Hop Settings...");
        JButton aclicks = new JButton("Auto Click Settings...");

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
        mPanel.add(Box.createVerticalGlue());
        mPanel.add(aclick);

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

        settingsButtons(sprints, esps, auras, antikbs, bhops, aclicks);
        bindButtons(sprintb, espb, aurab, antikbb, bhopb, aclickb);
    }

    public static void openGUI() {
        if (!clickGui.isVisible()) clickGui.setVisible(true);
    }

    public void settingsButtons(JButton sprint, JButton esp, JButton aura, JButton antikb, JButton bhop, JButton aclick) {
        sprint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SprintSettings.open();
            }
        });

        esp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "There are no settings for ESP.");
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

        aclick.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AutoClickerSettings.open();
            }
        });
    }

    public void bindButtons(JButton sprint, JButton esp, JButton aura, JButton antikb, JButton bhop, JButton aclick) {
        sprint.addActionListener(new ActionListener() {
            JFrame bindWindow;
            @Override
            public void actionPerformed(ActionEvent e) {
                bindWindow = new JFrame("ApeClient");
                bindWindow.setLayout(new GridBagLayout());
                bindWindow.pack();
                bindWindow.setSize(250, 70);
                bindWindow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                bindWindow.setResizable(false);
                bindWindow.setLocationRelativeTo(null);
                bindWindow.add(new JLabel("Press Any Key To Bind: Sprint"), SwingConstants.CENTER);
                bindWindow.setVisible(true);

                bindWindow.addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {}
                    @Override
                    public void keyReleased(KeyEvent e) {}
                    @Override
                    public void keyPressed(KeyEvent e) {
                        KeyBindHandler.set("Sprint", e.getKeyCode());
                        bindWindow.setVisible(false);
                    }
                });
            }
        });

        esp.addActionListener(new ActionListener() {
            JFrame bindWindow;
            @Override
            public void actionPerformed(ActionEvent e) {
                bindWindow = new JFrame("ApeClient");
                bindWindow.setLayout(new GridBagLayout());
                bindWindow.pack();
                bindWindow.setSize(250, 70);
                bindWindow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                bindWindow.setResizable(false);
                bindWindow.setLocationRelativeTo(null);
                bindWindow.add(new JLabel("Press Any Key To Bind: ESP"), SwingConstants.CENTER);
                bindWindow.setVisible(true);

                bindWindow.addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {}
                    @Override
                    public void keyReleased(KeyEvent e) {}
                    @Override
                    public void keyPressed(KeyEvent e) {
                        KeyBindHandler.set("ESP", e.getKeyCode());
                        bindWindow.setVisible(false);
                    }
                });
            }
        });

        aura.addActionListener(new ActionListener() {
            JFrame bindWindow;
            @Override
            public void actionPerformed(ActionEvent e) {
                bindWindow = new JFrame("ApeClient");
                bindWindow.setLayout(new GridBagLayout());
                bindWindow.pack();
                bindWindow.setSize(250, 70);
                bindWindow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                bindWindow.setResizable(false);
                bindWindow.setLocationRelativeTo(null);
                bindWindow.add(new JLabel("Press Any Key To Bind: Kill Aura"), SwingConstants.CENTER);
                bindWindow.setVisible(true);

                bindWindow.addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {}
                    @Override
                    public void keyReleased(KeyEvent e) {}
                    @Override
                    public void keyPressed(KeyEvent e) {
                        KeyBindHandler.set("Kill Aura", e.getKeyCode());
                        bindWindow.setVisible(false);
                    }
                });
            }
        });


        antikb.addActionListener(new ActionListener() {
            JFrame bindWindow;
            @Override
            public void actionPerformed(ActionEvent e) {
                bindWindow = new JFrame("ApeClient");
                bindWindow.setLayout(new GridBagLayout());
                bindWindow.pack();
                bindWindow.setSize(250, 70);
                bindWindow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                bindWindow.setResizable(false);
                bindWindow.setLocationRelativeTo(null);
                bindWindow.add(new JLabel("Press Any Key To Bind: Anti Knockback"), SwingConstants.CENTER);
                bindWindow.setVisible(true);

                bindWindow.addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {}
                    @Override
                    public void keyReleased(KeyEvent e) {}
                    @Override
                    public void keyPressed(KeyEvent e) {
                        KeyBindHandler.set("Anti Knockback", e.getKeyCode());
                        bindWindow.setVisible(false);
                    }
                });
            }
        });

        bhop.addActionListener(new ActionListener() {
            JFrame bindWindow;
            @Override
            public void actionPerformed(ActionEvent e) {
                bindWindow = new JFrame("ApeClient");
                bindWindow.setLayout(new GridBagLayout());
                bindWindow.pack();
                bindWindow.setSize(250, 70);
                bindWindow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                bindWindow.setResizable(false);
                bindWindow.setLocationRelativeTo(null);
                bindWindow.add(new JLabel("Press Any Key To Bind: Bunny Hop"), SwingConstants.CENTER);
                bindWindow.setVisible(true);

                bindWindow.addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {}
                    @Override
                    public void keyReleased(KeyEvent e) {}
                    @Override
                    public void keyPressed(KeyEvent e) {
                        KeyBindHandler.set("Bunny Hop", e.getKeyCode());
                        bindWindow.setVisible(false);
                    }
                });
            }
        });

        aclick.addActionListener(new ActionListener() {
            JFrame bindWindow;
            @Override
            public void actionPerformed(ActionEvent e) {
                bindWindow = new JFrame("ApeClient");
                bindWindow.setLayout(new GridBagLayout());
                bindWindow.pack();
                bindWindow.setSize(250, 70);
                bindWindow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                bindWindow.setResizable(false);
                bindWindow.setLocationRelativeTo(null);
                bindWindow.add(new JLabel("Press Any Key To Bind: Auto Clicker"), SwingConstants.CENTER);
                bindWindow.setVisible(true);

                bindWindow.addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {}
                    @Override
                    public void keyReleased(KeyEvent e) {}
                    @Override
                    public void keyPressed(KeyEvent e) {
                        KeyBindHandler.set("Auto Clicker", e.getKeyCode());
                        bindWindow.setVisible(false);
                    }
                });
            }
        });
    }
}
