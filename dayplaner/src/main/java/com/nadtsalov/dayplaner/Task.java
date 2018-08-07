package com.nadtsalov.dayplaner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Task {

    private JLabel task;
    private ImageIcon iconDo;

    void addTask(){

        iconDo = new ImageIcon(this.getClass().getResource("/iconDo.png"));
        final TaskEditor taskEditor = new TaskEditor();
        taskEditor.createTaskEditor();
        taskEditor.ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                task = new JLabel(taskEditor.newTask.getText());
                task.addMouseListener(new ClickOnTaskListener());
                Font font = new Font("Sans Serif", Font.ROMAN_BASELINE, 14);
                task.setFont(font);
                task.setIcon(iconDo);
                task.setBackground(Color.red);
                MainGui.getLeftPanel().add(task);
                MainGui.taskList.add(task);
                taskEditor.newTaskFrame.dispose();
            }
        });

    }
    void editTask(String oldText, final JLabel oldLabel){
        final TaskEditor taskEditor = new TaskEditor();
        taskEditor.createTaskEditor();
        taskEditor.newTask.setText(oldText);
        taskEditor.ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                oldLabel.setText(taskEditor.newTask.getText());
                taskEditor.newTaskFrame.dispose();
             }
        });
    }
}
