package com.nadtsalov.dayplaner;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class OpenTask {

    public void openTask(File file){

        MainGui.getLeftPanel().removeAll();
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
            ArrayList<JLabel> taskList = (ArrayList<JLabel>) inputStream.readObject();

            for (JLabel taskOut: taskList){
                MainGui.getLeftPanel().add(taskOut);
                MainGui.taskList.add(taskOut);
                taskOut.addMouseListener(new ClickOnTaskListener());
            }
            inputStream.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ignore) { }
    }
}
