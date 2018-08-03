package com.nadtsalov.dayplaner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;

public class MainGui implements ContainerListener{

    private JFrame frame;
    private static JPanel leftPanel;
    private JPanel southPanel;
    private JScrollPane scrollPane;
    public static ArrayList<JLabel> taskList;

    public static JPanel getLeftPanel() {
        return leftPanel;
    }

    public void startApp(){
        frame = new JFrame("To Do List");
        taskList = new ArrayList<JLabel>();
        JButton addTaskButton = new JButton("Add Task");
        addTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EnterTask().openEnterArea();
            }
        });
        southPanel = new JPanel();
        southPanel.add(addTaskButton);
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
        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                String configFilename =
                        System.getProperty("user.home") + File.separator + "planerConfig.properties";
                Properties props = new Properties();
                try {
                    FileInputStream input = new FileInputStream(configFilename);
                    props.load(input);
                    input.close();
                } catch(Exception ignore) { }
                String dir = props.getProperty("dir");
                if (dir != null){
                    File file = new File(dir);
                    new SaveTask().saveList(file);
                }
                else new SaveButListener().actionPerformed(null);
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
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
