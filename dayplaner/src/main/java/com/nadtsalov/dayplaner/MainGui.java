package com.nadtsalov.dayplaner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MainGui implements ContainerListener{

    private static JFrame frame;
    private static JPanel leftPanel;
    private JPanel southPanel;
    private JScrollPane scrollPane;
    public static ArrayList<JLabel> taskList;

    public static JPanel getLeftPanel() {
        return leftPanel;
    }

    public void startApp() {
        frame = new JFrame("To Do List / ver. 1.0");
        taskList = new ArrayList<>();
        JButton addTaskButton = new JButton("Add new task");
        addTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EnterTask().openEnterArea();
            }
        });
        JButton clearList = new JButton("Clear list");
        clearList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ApproveDelTaskWindow().openApproveWindow();
            }
        });
        southPanel = new JPanel();
        southPanel.add(addTaskButton);
        southPanel.add(clearList);
        leftPanel = new JPanel();
        scrollPane = new JScrollPane(leftPanel);
        leftPanel.addContainerListener(this);
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        menuBar.add(menuFile);
        JMenuItem menuOpen = new JMenuItem("Open task list");
        menuOpen.addActionListener(new OpenButListener());
        menuFile.add(menuOpen);
        JMenuItem menuSave = new JMenuItem("Save task list");
        menuSave.addActionListener(new SaveButListener());
        menuFile.add(menuSave);
        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(BorderLayout.SOUTH, southPanel);
        frame.getContentPane().add(scrollPane);
        new Config().openConfig();
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setLocation(600, 200);
        frame.setSize(600, 700);
        frame.setVisible(true);
        frame.addWindowListener(new CloseWindowListener());
    }

    public static JFrame getFrame() {
        return frame;
    }

    @Override
    public void componentAdded(ContainerEvent e) {
        scrollPane.repaint();
        scrollPane.revalidate();
    }

    @Override
    public void componentRemoved(ContainerEvent e) {
        scrollPane.repaint();
        scrollPane.revalidate();
    }
}
