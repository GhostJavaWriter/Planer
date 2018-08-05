package com.nadtsalov.dayplaner;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

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
