package com.nadtsalov.dayplaner;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class SaveButListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser save = new JFileChooser();
        File file = new File("MyTaskList.ser");
        save.setSelectedFile(file);
        int ret = save.showSaveDialog(null);
        if (ret == JFileChooser.APPROVE_OPTION) {
            new SaveTask().saveList(save.getSelectedFile());
        }
    }
}
