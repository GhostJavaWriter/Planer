package com.nadtsalov.dayplaner;

import java.io.*;

public class SaveTask {

    public void saveList(File fileName){

        new Config().saveConfig(fileName);
        try {
            FileOutputStream outputStream = new FileOutputStream(fileName);
            ObjectOutputStream os = new ObjectOutputStream(outputStream);
            os.writeObject(MainGui.taskList);
            os.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
