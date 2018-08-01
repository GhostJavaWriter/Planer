package com.nadtsalov.dayplaner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ClickOnTaskListener implements MouseListener {

    private Component comp;

    public ClickOnTaskListener(Component comp) {
        this.comp = comp;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            if (comp.getBackground() == Color.green) comp.setBackground(Color.yellow);
            else comp.setBackground(Color.green);
        }
        else if (e.getButton() == MouseEvent.BUTTON3) new ApproveDelTaskWindow(comp).openApproveWindow();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
