package com.nadtsalov.dayplaner;

import javax.sound.midi.ControllerEventListener;
import javax.sound.midi.ShortMessage;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.util.ArrayList;

public class MainGui implements ContainerListener{

    JFrame frame;
    static JPanel leftPanel;
    JPanel southPanel;
    JScrollPane scrollPane;

    public void startApp(){
        frame = new JFrame("To Do List");

        JButton addTaskButton = new JButton("Add Task");
        addTaskButton.addActionListener(new AddButtonListener());
        JButton delTaskButton = new JButton("Delete Task");
        delTaskButton.addActionListener(new DelButtonListener());
        southPanel = new JPanel();
        southPanel.add(addTaskButton);
        southPanel.add(delTaskButton);

        leftPanel = new JPanel();
        scrollPane = new JScrollPane(leftPanel);
        leftPanel.addContainerListener(this);

        frame.getContentPane().add(BorderLayout.SOUTH, southPanel);
        frame.getContentPane().add(scrollPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 800);
        frame.setVisible(true);
    }

    @Override
    public void componentAdded(ContainerEvent e) {
        scrollPane.revalidate();
    }

    @Override
    public void componentRemoved(ContainerEvent e) {

    }
}
