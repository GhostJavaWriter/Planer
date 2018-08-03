package com.nadtsalov.dayplaner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApproveDelTaskWindow {

    private Component comp;

    public ApproveDelTaskWindow(Component comp) {
        this.comp = comp;
    }

    public void openApproveWindow (){

        final JFrame frame = new JFrame("Delete this task?");
        JPanel labelPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        JLabel label = new JLabel("Are u sure?");
        Font font = new Font("Verdana", Font.BOLD, 15);
        label.setFont(font);
        JButton yesButton = new JButton("Yep");
        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainGui.getLeftPanel().remove(comp);
                MainGui.taskList.remove(comp);
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
        frame.setLocation(MouseInfo.getPointerInfo().getLocation());
        frame.setSize(300, 100);
        frame.setVisible(true);
    }
}
