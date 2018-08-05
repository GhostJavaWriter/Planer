package com.nadtsalov.dayplaner;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpenButListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser openList = new JFileChooser();
        int ret = openList.showOpenDialog(null);
        if (ret == JFileChooser.APPROVE_OPTION) {
            new OpenTask().openTask(openList.getSelectedFile());
        }
    }
}
