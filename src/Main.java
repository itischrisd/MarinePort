import model.Harbor;
import model.exception.TooManyContainersException;
import model.persistance.DataReader;
import model.persistance.DataWriter;
import model.persistance.SampleDataInitializer;
import model.service.ContainerService;
import model.time.Clock;
import model.train.TrainBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws TooManyContainersException {
        SampleDataInitializer.createExampleData();
        Clock.setDate(LocalDate.now());
        Clock.setDate(LocalDate.now().plusDays(1));
        Harbor.getInstance().setTrain(TrainBuilder.train().withContainers(new ArrayList<>()).build());

        int weight = 999;
        int senderIndex = 1;
        int tareWeight = 888;
        double liquidVolume = 77.7;
        int toxicityLevel = 10;
        int additionalProtectionIndex = 1;
        boolean connectedToPower = false;
        List<Integer> featuresIndexes = List.of(1, 2);

        Harbor.getInstance().getWarehouse().addContainer(ContainerService.createContainer(weight, senderIndex));
        Harbor.getInstance().getWarehouse().addContainer(ContainerService.createContainer(weight, senderIndex, tareWeight));
        Harbor.getInstance().getWarehouse().addContainer(ContainerService.createContainer(weight, senderIndex, liquidVolume));
        Harbor.getInstance().getWarehouse().addContainer(ContainerService.createContainer(weight, senderIndex, tareWeight, additionalProtectionIndex));
        Harbor.getInstance().getWarehouse().addContainer(ContainerService.createContainer(weight, senderIndex, tareWeight, toxicityLevel, liquidVolume));
        Harbor.getInstance().getWarehouse().addContainer(ContainerService.createContainer(weight, senderIndex, tareWeight, toxicityLevel, featuresIndexes));
        Harbor.getInstance().getWarehouse().addContainer(ContainerService.createContainer(weight, senderIndex, tareWeight, connectedToPower));

        DataWriter.writeToFile("test.bak");
        Harbor.deleteInstance();
        DataReader.readFromFile("test.bak");
        DataWriter.writeToFile("test2.bak");
    }
}