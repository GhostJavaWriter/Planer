package com.nadtsalov.dayplaner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskEditor {

    public JFrame newTaskFrame;
    public JTextArea newTask;
    public JButton ok;

    public void createTaskEditor(){
        newTaskFrame = new JFrame("Please enter new task");
        newTask = new JTextArea(9, 50);
        JPanel panel = new JPanel();
        panel.add(newTask);
        ok = new JButton("Ok");
        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newTaskFrame.dispose();
            }
        });
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(ok);
        buttonsPanel.add(cancel);
        newTaskFrame.getContentPane().add(BorderLayout.SOUTH, buttonsPanel);
        newTaskFrame.getContentPane().add(panel);
        newTaskFrame.setLocation(MainGui.getFrame().getX() + 50, MainGui.getFrame().getY() + 150);
        newTaskFrame.setSize(600, 200);
        newTaskFrame.setVisible(true);
    }
}
