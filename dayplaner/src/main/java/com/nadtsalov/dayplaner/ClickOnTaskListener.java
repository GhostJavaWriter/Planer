package com.nadtsalov.dayplaner;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileReader;
import java.io.InputStream;

public class ClickOnTaskListener implements MouseListener {

    int clickCount;

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        ImageIcon iconDo = new ImageIcon(this.getClass().getResource("/iconDo.png"));
        ImageIcon iconDone = new ImageIcon(this.getClass().getResource("/iconDone.png"));

        if (e.getButton() == MouseEvent.BUTTON1) {
            clickCount++;
            JLabel label = (JLabel) e.getComponent();
            if (clickCount % 2.0 > 0) label.setIcon(iconDo);
            else label.setIcon(iconDone);
        }

        else if (e.getButton() == MouseEvent.BUTTON3) new ApproveDelTaskWindow(e.getComponent()).openApproveWindow();
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
