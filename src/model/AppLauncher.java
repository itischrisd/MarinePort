package model;

import model.persistance.DataReader;
import model.persistance.SampleDataInitializer;

import static lang.Data.*;
import static lang.ErrorMessage.*;

public class AppLauncher {

    public static void launch() {
        try {
            DataReader.readFromFile(DEFUALT_FILE_NAME);
        } catch (Exception e) {
            System.out.println(READING_FILE);
            System.out.println(DEFAULT_DATA_MESSAGE);
            SampleDataInitializer.createExampleData();
        }
    }
}
