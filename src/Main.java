import model.Harbor;
import model.persistance.DataReader;
import model.persistance.DataWriter;
import model.persistance.SampleDataInitializer;
import model.time.Clock;
import model.train.TrainBuilder;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        SampleDataInitializer.createExampleData();
        Clock.setDate(LocalDate.now());
        Clock.setDate(LocalDate.now().plusDays(1));
        Harbor.getInstance().setTrain(TrainBuilder.train().withContainers(new ArrayList<>()).build());
        DataWriter.writeToFile("test.bak");
        Harbor.deleteInstance();
        DataReader.readFromFile("test.bak");
        DataWriter.writeToFile("test2.bak");
    }
}