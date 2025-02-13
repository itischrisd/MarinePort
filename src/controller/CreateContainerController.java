package controller;

import model.sender.Sender;
import model.service.ContainerService;
import model.service.SenderService;
import ui.component.LineComponent;
import ui.component.ListComponent;
import ui.core.IOProvider;
import ui.input.*;

import java.util.List;
import java.util.stream.Stream;

import static lang.Data.*;

public class CreateContainerController implements Controller {

    private final LineComponent containerTypesHeader;
    private final ListComponent<String> containerTypes;
    private final LineComponent sendersHeader;
    private final ListComponent<Sender> sendersList;
    private final Input<Integer> containerTypeInput;
    private final Input<Integer> containerWeightInput;
    private final Input<Integer> senderIdInput;
    private int containerType;
    private int containerWeight;
    private int senderIndex;

    public CreateContainerController() {
        List<String> types = List.of(
                CONTAINER_COMMON,
                CONTAINER_HEAVY,
                CONTAINER_REFRIGERATED,
                CONTAINER_LIQUID,
                CONTAINER_EXPLOSIVE,
                CONTAINER_LOOSE_TOXIC,
                CONTAINER_LIQUID_TOXIC
        );
        List<Sender> senders = SenderService.getSenders();

        this.containerTypesHeader = new LineComponent("Typy kontenerów:");
        this.containerTypes = new ListComponent<>(types, Object::toString);
        this.sendersHeader = new LineComponent("Nadawcy:");
        this.sendersList = new ListComponent<>(senders, sender -> sender.getName() + " " + sender.getSurname() + ", ostrzeżeń: " + sender.getWarningsCount());
        this.containerTypeInput = new IntegerInput(
                "Wybierz typ kontenera",
                "Niepoprawny numer typu kontenera",
                number -> number >= 1 && number <= types.size()
        );
        containerWeightInput = new IntegerInput(
                "Podaj wagę kontenera",
                "Niepoprawna waga kontenera",
                weight -> weight > 0
        );
        senderIdInput = new IntegerInput(
                "Wybierz nadawcę",
                "Niepoprawny numer nadawcy",
                number -> number >= 1 && number <= senders.size()
        );
    }

    @Override
    public void run() {
        containerTypesHeader.display();
        containerTypes.display();
        containerType = containerTypeInput.collect();
        containerWeight = containerWeightInput.collect();
        sendersHeader.display();
        sendersList.display();
        senderIndex = senderIdInput.collect() - 1;
        switch (containerType) {
            case 1:
                continueCreatingCommonContainer();
                break;
            case 2:
                continueCreatingHeavyContainer();
                break;
            case 3:
                continueCreatingRefrigeratedContainer();
                break;
            case 4:
                continueCreatingLiquidContainer();
                break;
            case 5:
                continueCreatingExplosiveContainer();
                break;
            case 6:
                continueCreatingLooseToxicContainer();
                break;
            case 7:
                continueCreatingLiquidToxicContainer();
                break;
        }
    }

    private void continueCreatingCommonContainer() {
        try {
            ContainerService.createContainer(containerWeight, senderIndex);
        } catch (Exception e) {
            IOProvider.getPrinter().println(e.getMessage());
        }
    }

    private void continueCreatingHeavyContainer() {
        int tareWeight = getTareWeight();
        try {
            ContainerService.createContainer(containerWeight, senderIndex, tareWeight);
        } catch (Exception e) {
            IOProvider.getPrinter().println(e.getMessage());
        }
    }

    private void continueCreatingRefrigeratedContainer() {
        int tareWeight = getTareWeight();
        Input<Boolean> isConnectedToPowerInput = new BooleanInput(
                "Podaj czy kontener jest podłączony do prądu",
                "Niepoprawna wartość"
        );
        boolean isConnectedToPower = isConnectedToPowerInput.collect();
        try {
            ContainerService.createContainer(containerWeight, senderIndex, tareWeight, isConnectedToPower);
        } catch (Exception e) {
            IOProvider.getPrinter().println(e.getMessage());
        }
    }

    private void continueCreatingLiquidContainer() {
        Input<Double> liquidVolumeInput = new DoubleInput(
                "Podaj objętość cieczy",
                "Niepoprawna objętość cieczy",
                volume -> volume > 0
        );
        double liquidVolume = liquidVolumeInput.collect();
        try {
            ContainerService.createContainer(containerWeight, senderIndex, liquidVolume);
        } catch (Exception e) {
            IOProvider.getPrinter().println(e.getMessage());
        }
    }

    private void continueCreatingExplosiveContainer() {
        int tareWeight = getTareWeight();
        LineComponent additionalProtectionHeader = new LineComponent("Dodatkowa ochrona:");
        ListComponent<String> additionalProtection = new ListComponent<>(List.of(
                ENUM_NONE,
                ENUM_REINFORCED_WALLS,
                ENUM_EXPLOSION_SUPPRESSORS,
                ENUM_FIRE_RESISTANT_COATING,
                ENUM_TEMPERATURE_CONTROL
        ), Object::toString);
        Input<Integer> additionalProtectionInput = new IntegerInput(
                "Wybierz dodatkową ochronę",
                "Niepoprawny numer dodatkowej ochrony",
                number -> number >= 1 && number <= 5
        );
        additionalProtectionHeader.display();
        additionalProtection.display();
        int additionalProtectionIndex = additionalProtectionInput.collect() - 1;
        try {
            ContainerService.createContainer(containerWeight, senderIndex, tareWeight, additionalProtectionIndex);
        } catch (Exception e) {
            IOProvider.getPrinter().println(e.getMessage());
        }
    }

    private void continueCreatingLooseToxicContainer() {
        int tareWeight = getTareWeight();
        Input<Integer> toxicityLevelInput = new IntegerInput(
                "Podaj poziom toksyczności",
                "Niepoprawny poziom toksyczności",
                toxicityLevel -> toxicityLevel >= 1 && toxicityLevel <= 10
        );
        int toxicityLevel = toxicityLevelInput.collect();
        LineComponent featuresHeader = new LineComponent("Cechy:");
        ListComponent<String> features = new ListComponent<>(List.of(
                ENUM_NONE,
                ENUM_VENTILATION_SYSTEM,
                ENUM_LEAK_DETECTION_SYSTEM,
                ENUM_DUST_CONTROL_SYSTEM
        ), Object::toString);
        Input<String> featuresInput = new StringInput(
                "Podaj numery cech oddzielone spacjami",
                "Niepoprawne numery cech",
                number -> {
                    String[] numbers = number.split(" ");
                    for (String num : numbers) {
                        if (Integer.parseInt(num) < 1 || Integer.parseInt(num) > 4) {
                            return false;
                        }
                    }
                    return true;
                }
        );
        featuresHeader.display();
        features.display();
        List<Integer> featuresIndexes = Stream.of(featuresInput.collect().split(" ")).map(Integer::parseInt).toList();
        try {
            ContainerService.createContainer(containerWeight, senderIndex, tareWeight, toxicityLevel, featuresIndexes);
        } catch (Exception e) {
            IOProvider.getPrinter().println(e.getMessage());
        }
    }

    private void continueCreatingLiquidToxicContainer() {
        int tareWeight = getTareWeight();
        Input<Integer> toxicityLevelInput = new IntegerInput(
                "Podaj poziom toksyczności",
                "Niepoprawny poziom toksyczności",
                toxicityLevel -> toxicityLevel >= 1 && toxicityLevel <= 10
        );
        int toxicityLevel = toxicityLevelInput.collect();
        Input<Double> liquidVolumeInput = new DoubleInput(
                "Podaj objętość cieczy",
                "Niepoprawna objętość cieczy",
                volume -> volume > 0
        );
        double liquidVolume = liquidVolumeInput.collect();
        try {
            ContainerService.createContainer(containerWeight, senderIndex, tareWeight, toxicityLevel, liquidVolume);
        } catch (Exception e) {
            IOProvider.getPrinter().println(e.getMessage());
        }
    }

    private int getTareWeight() {
        Input<Integer> tarerWeightInput = new IntegerInput(
                "Podaj wagę tara",
                "Niepoprawna waga tara",
                weight -> weight >= 0 && weight <= containerWeight
        );
        return tarerWeightInput.collect();
    }
}
