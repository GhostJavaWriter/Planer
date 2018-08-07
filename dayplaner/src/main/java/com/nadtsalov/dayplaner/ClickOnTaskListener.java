package com.nadtsalov.dayplaner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ClickOnTaskListener implements MouseListener {

    private Timer timer;
    private boolean singleClick = true;
    ImageIcon iconDo = new ImageIcon(this.getClass().getResource("/iconDo.png"));
    ImageIcon iconDone = new ImageIcon(this.getClass().getResource("/iconDone.png"));
    private MouseEvent event;

    ClickOnTaskListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (singleClick){
                    singleClick();
                }
                else {
                    doubleClick();
                }
            }
        };
        timer = new Timer(200, al);
        timer.setRepeats(false);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.event = e;
        if (e.getClickCount() == 1 && e.getButton() == MouseEvent.BUTTON1) {
            singleClick = true;
            timer.start();
        }
        else singleClick = false;
    }

    public void singleClick(){

        JLabel label = (JLabel) event.getComponent();
        if (label.getBackground().getRed() == 255) {
            MainGui.getLeftPanel().remove(label);
            MainGui.taskList.remove(label);
            MainGui.getLeftPanel().add(label);
            MainGui.taskList.add(label);
            label.setBackground(Color.green);
            label.setIcon(iconDone);
            new Sound().makeSound();
        }
        else if (label.getBackground().getGreen() == 255){
            MainGui.getLeftPanel().remove(label);
            MainGui.taskList.remove(label);
            MainGui.getLeftPanel().add(label, 0);
            MainGui.taskList.add(0, label);
            label.setIcon(iconDo);
            label.setBackground(Color.red);
            new Sound().makeSound();
        }
    }
    public void doubleClick(){

        JLabel oldLabel = (JLabel) event.getComponent();
        String oldText = oldLabel.getText();
        new Task().editTask(oldText, oldLabel);
    }

    @Override
    public void mousePressed(MouseEvent e) {

        if (e.getButton() == MouseEvent.BUTTON3)
            new ApproveDelTaskWindow(e.getComponent()).openApproveWindow();
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
