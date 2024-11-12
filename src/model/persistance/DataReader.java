package model.persistance;

import java.io.File;
import java.nio.file.Paths;
import java.util.Scanner;

public class DataReader {

    public static void readFromFile(String path) {
        File file = Paths.get(path).toFile();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
