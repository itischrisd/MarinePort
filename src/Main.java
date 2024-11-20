import model.AppLauncher;
import model.Harbor;
import model.persistance.DataReader;
import model.persistance.DataWriter;
import model.service.ContainerService;
import model.time.Clock;
import model.time.Utilizer;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Clock.setDate(LocalDate.now().plusDays(1));
        AppLauncher.launch();

        int weight = 999;
        int senderIndex = 1;
        int tareWeight = 888;
        double liquidVolume = 77.7;
        int toxicityLevel = 10;
        int additionalProtectionIndex = 1;
        boolean connectedToPower = false;
        List<Integer> featuresIndexes = List.of(1, 2);

        ContainerService.createContainer(weight, senderIndex);
        ContainerService.createContainer(weight, senderIndex, tareWeight);
        ContainerService.createContainer(weight, senderIndex, liquidVolume);
        ContainerService.createContainer(weight, senderIndex, tareWeight, additionalProtectionIndex);
        ContainerService.createContainer(weight, senderIndex, tareWeight, toxicityLevel, liquidVolume);
        ContainerService.createContainer(weight, senderIndex, tareWeight, toxicityLevel, featuresIndexes);
        ContainerService.createContainer(weight, senderIndex, tareWeight, connectedToPower);

        DataWriter.writeToFile("test.bak");
        Harbor.deleteInstance();
        DataReader.readFromFile("test.bak");

        try {
            Thread.sleep(120000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Clock.getInstance().interrupt();
        Utilizer.getInstance().interrupt();

        DataWriter.writeToFile("test2.bak");
    }
}