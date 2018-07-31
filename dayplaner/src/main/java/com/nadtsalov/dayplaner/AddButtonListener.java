package com.nadtsalov.dayplaner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        new EnterTask().openEnterArea();
    }
}
