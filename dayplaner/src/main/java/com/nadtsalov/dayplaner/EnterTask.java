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

                JLabel task = new JLabel(newTask.getText());
                int indexComp = MainGui.leftPanel.getComponentZOrder(task);
                task.addMouseListener(new ClickOnTaskListener(task));
                task.setBackground(Color.yellow);
                task.setOpaque(true);
                task.setBorder(BorderFactory.createLineBorder(Color.gray, 2));

                Font font = new Font("Verdana", Font.BOLD, 20);
                task.setFont(font);

                task.setPreferredSize(new Dimension(550, 50));
                MainGui.leftPanel.add(task);

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
        newTaskFrame.setSize(600, 200);
        newTaskFrame.setVisible(true);

    }
}
