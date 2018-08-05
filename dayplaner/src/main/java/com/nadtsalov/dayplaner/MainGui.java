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
        //Main frame
        frame = new JFrame("To Do List / ver. 1.0");
        //Array list for save tasks
        taskList = new ArrayList<>();
        //Add button
        JButton addTaskButton = new JButton("Add new task");
        addTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EnterTask().openEnterArea();
            }
        });
        addTaskButton.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 10) new EnterTask().openEnterArea();
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        //buttons panel
        southPanel = new JPanel();
        southPanel.add(addTaskButton);
        //main panel
        leftPanel = new JPanel();
        scrollPane = new JScrollPane(leftPanel);
        leftPanel.addContainerListener(this);
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        //menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        menuBar.add(menuFile);
        JMenuItem menuOpen = new JMenuItem("Open");
        JMenuItem menuClear = new JMenuItem("Clear");
        JMenuItem menuSave = new JMenuItem("Save");
        menuOpen.addActionListener(new OpenButListener());
        menuSave.addActionListener(new SaveButListener());
        menuClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ApproveDelTaskWindow().openApproveWindow();
            }
        });
        menuFile.add(menuOpen);
        menuFile.add(menuSave);
        menuFile.add(menuClear);
        //set-up the main frame
        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(BorderLayout.SOUTH, southPanel);
        frame.getContentPane().add(scrollPane);
        //load task list
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
