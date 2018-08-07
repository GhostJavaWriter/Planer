package com.nadtsalov.dayplaner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ApproveDelTaskWindow {

    private Component comp;
    private Boolean all;
    private JFrame frame;

    public ApproveDelTaskWindow(Component comp) {
        this.comp = comp;
        this.all = false;
    }

    public ApproveDelTaskWindow() {
        this.all = true;
    }

    public void openApproveWindow (){

        String thisCase = "Delete this task";;
        if (all) thisCase = "Clear this list";
        frame = new JFrame(thisCase);
        JPanel labelPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        JLabel label = new JLabel("Are u sure?");
        Font font = new Font("Verdana", Font.BOLD, 15);
        label.setFont(font);
        JButton yesButton = new JButton("Yep");
        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!all) {
                    MainGui.getLeftPanel().remove(comp);
                    MainGui.taskList.remove(comp);
                }else{
                    MainGui.getLeftPanel().removeAll();
                    MainGui.taskList.clear();
                }
                new Sound().makeSound();
                frame.dispose();
            }
        });
        JButton noButton = new JButton("Nope");
        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        labelPanel.add(label);
        buttonPanel.add(yesButton);
        buttonPanel.add(noButton);
        frame.getContentPane().add(BorderLayout.SOUTH, buttonPanel);
        frame.getContentPane().add(labelPanel);
        frame.setLocation(MainGui.getFrame().getX() + 50, MainGui.getFrame().getY() + 150);
        frame.setSize(300, 100);
        frame.setVisible(true);
    }
}
