package model;

import model.persistance.DataReader;
import model.persistance.SampleDataInitializer;
import model.time.Clock;
import model.time.Utilizer;

import static lang.Data.*;
import static lang.ErrorMessage.*;

public class AppLauncher {

    public static void launch() {
        try {
            DataReader.readFromFile(DEFUALT_FILE_NAME);
        } catch (Exception e) {
            SampleDataInitializer.createExampleData();
            throw new RuntimeException(READING_FILE + "\n" + DEFAULT_DATA_MESSAGE);
        }
        Clock.getInstance().start();
        Utilizer.getInstance().start();
    }
}
