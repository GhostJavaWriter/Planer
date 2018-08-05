package com.nadtsalov.dayplaner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnterTask {
    private JFrame newTaskFrame;
    private JTextArea newTask;
    private JLabel task;

    public void openEnterArea(){

        newTaskFrame = new JFrame("Please enter new task");

        newTask = new JTextArea(9, 50);
        JPanel panel = new JPanel();
        panel.add(newTask);

        JButton ok = new JButton("Ok");
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                task = new JLabel(newTask.getText());
                task.addMouseListener(new ClickOnTaskListener(task));
                Font font = new Font("Sans Serif", Font.ROMAN_BASELINE, 18);
                task.setFont(font);
                task.setPreferredSize(new Dimension(550, 50));
                MainGui.getLeftPanel().add(task);
                MainGui.taskList.add(task);
                newTaskFrame.dispose();
            }
        });
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
