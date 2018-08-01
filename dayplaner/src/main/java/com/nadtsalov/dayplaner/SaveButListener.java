package com.nadtsalov.dayplaner;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class SaveButListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser saveList = new JFileChooser();
        File file = new File("MyTaskList.ser");
        saveList.setSelectedFile(file);
        int ret = saveList.showSaveDialog(null);
        if (ret == JFileChooser.APPROVE_OPTION) {
            new SaveTask().saveList(saveList.getSelectedFile());
        }
    }
}
