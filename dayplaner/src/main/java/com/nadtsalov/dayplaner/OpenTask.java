package com.nadtsalov.dayplaner;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class OpenTask {


    public void openTask(File file){

        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
            ArrayList<JLabel> taskList = (ArrayList<JLabel>) inputStream.readObject();

            for (JLabel taskOut: taskList){
                MainGui.getLeftPanel().add(taskOut);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
