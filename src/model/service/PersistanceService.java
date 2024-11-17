package model.service;

import model.persistance.DataReader;
import model.persistance.DataWriter;

import static lang.Data.*;

public class PersistanceService {

    public static void save(String filename) {
        DataWriter.writeToFile(filename);
    }

    public static void load(String filename) {
        DataReader.readFromFile(filename);
    }

    public static void save() {
        DataWriter.writeToFile(DEFUALT_FILE_NAME);
    }
}
