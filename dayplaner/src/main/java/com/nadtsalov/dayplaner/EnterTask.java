package com.nadtsalov.dayplaner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EnterTask {
    JFrame newTaskFrame;
    JTextArea newTask;

    public void openEnterArea(){

        newTaskFrame = new JFrame("Please enter new task");

        newTask = new JTextArea(9, 52);
        JPanel panel = new JPanel();
        panel.add(newTask);

        JButton ok = new JButton("Ok");
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                MainGui.leftPanel.add(new JLabel(newTask.getText()));
                newTaskFrame.dispose();
            }
        });
        JButton cancel = new JButton("Cancel");
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(ok);
        buttonsPanel.add(cancel);

        newTaskFrame.getContentPane().add(BorderLayout.SOUTH, buttonsPanel);
        newTaskFrame.getContentPane().add(panel);
        newTaskFrame.setSize(600, 200);
        newTaskFrame.setVisible(true);

    }
}
