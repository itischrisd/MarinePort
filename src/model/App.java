package model;

import model.persistance.DataReader;
import model.persistance.SampleDataInitializer;
import model.time.Clock;
import model.time.Utilizer;

import static lang.Data.*;
import static lang.ErrorMessage.*;

public class App {

    public static void launch() {
        try {
            DataReader.readFromFile(DEFUALT_FILE_NAME);
        } catch (Exception e) {
            SampleDataInitializer.createExampleData();
            Clock.getInstance().start();
            Utilizer.getInstance().start();
            throw new RuntimeException(READING_FILE + "\n" + DEFAULT_DATA_MESSAGE);
        }
        Clock.getInstance().start();
        Utilizer.getInstance().start();
    }

    public static void exit() {
        Clock.getInstance().interrupt();
        Utilizer.getInstance().interrupt();
    }
}
