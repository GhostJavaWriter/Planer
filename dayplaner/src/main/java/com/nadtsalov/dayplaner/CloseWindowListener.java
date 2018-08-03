package com.nadtsalov.dayplaner;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class CloseWindowListener implements WindowListener {
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
}
