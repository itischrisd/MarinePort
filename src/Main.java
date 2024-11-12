import model.Harbor;
import model.persistance.DataWriter;
import model.persistance.SampleDataInitializer;
import model.time.Clock;
import model.train.TrainBuilder;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        SampleDataInitializer.createExampleData();
        Clock clock = new Clock(LocalDate.now());
        clock.start();
        Harbor.getInstance().setTrain(TrainBuilder.train().withContainers(new ArrayList<>()).build());
        DataWriter.writeToFile("test.bak");
    }
}