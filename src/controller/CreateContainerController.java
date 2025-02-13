package controller;

import model.sender.Sender;
import model.service.ContainerService;
import model.service.SenderService;
import ui.component.Component;
import ui.component.LineComponent;
import ui.component.ListComponent;
import ui.core.IOProvider;
import ui.input.*;

import java.util.List;
import java.util.stream.Stream;

import static lang.Data.*;
import static lang.Interface.*;

public class CreateContainerController implements Controller {

    private final Component containerTypesHeader;
    private final Component containerTypes;
    private final Component sendersHeader;
    private final Component sendersList;
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

        this.containerTypesHeader = new LineComponent(CONTAINER_TYPES_HEADER);
        this.containerTypes = new ListComponent<>(types, Object::toString);
        this.sendersHeader = new LineComponent(SENDERS_HEADER);
        this.sendersList = new ListComponent<>(senders, sender -> String.format(SENDER_LIST_FORMAT, sender.getName(), sender.getSurname(), sender.getWarningsCount()));
        this.containerTypeInput = new IntegerInput(
                CONTAINER_TYPE_PROMPT,
                INVALID_CONTAINER_TYPE,
                number -> number >= 1 && number <= types.size()
        );
        containerWeightInput = new IntegerInput(
                CONTAINER_WEIGHT_PROMPT,
                INVALID_CONTAINER_WEIGHT,
                weight -> weight > 0
        );
        senderIdInput = new IntegerInput(
                SENDER_PROMPT,
                INVALID_SENDER_INDEX,
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
                CONNECTED_TO_POWER_PROMPT,
                INVALID_VALUE
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
                LIQUID_VOLUME_PROMPT,
                INVALID_LIQUID_VOLUME,
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
        Component additionalProtectionHeader = new LineComponent(ADDITIONAL_PROTECTION_HEADER);
        Component additionalProtection = new ListComponent<>(List.of(
                ENUM_NONE,
                ENUM_REINFORCED_WALLS,
                ENUM_EXPLOSION_SUPPRESSORS,
                ENUM_FIRE_RESISTANT_COATING,
                ENUM_TEMPERATURE_CONTROL
        ), Object::toString);
        Input<Integer> additionalProtectionInput = new IntegerInput(
                ADDITIONAL_PROTECTION_TYPE_PROMPT,
                INVALID_ADDITIONAL_PROTECTION,
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
                TOXICITY_LEVEL_PROMPT,
                INVALID_TOXICITY_LEVEL,
                toxicityLevel -> toxicityLevel >= 0
        );
        int toxicityLevel = toxicityLevelInput.collect();
        Component featuresHeader = new LineComponent(CONTAINER_FEATURES_HEADER);
        Component features = new ListComponent<>(List.of(
                ENUM_NONE,
                ENUM_VENTILATION_SYSTEM,
                ENUM_LEAK_DETECTION_SYSTEM,
                ENUM_DUST_CONTROL_SYSTEM
        ), Object::toString);
        Input<String> featuresInput = new StringInput(
                CONTAINER_FEATURES_PROMPT,
                INVALID_FEATURES,
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
                TOXICITY_LEVEL_PROMPT,
                INVALID_TOXICITY_LEVEL,
                toxicityLevel -> toxicityLevel >= 1 && toxicityLevel <= 10
        );
        int toxicityLevel = toxicityLevelInput.collect();
        Input<Double> liquidVolumeInput = new DoubleInput(
                LIQUID_VOLUME_PROMPT,
                INVALID_LIQUID_VOLUME,
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
                TARE_WEIGHT_PROMPT,
                INVALID_TARE_WEIGHT,
                weight -> weight >= 0 && weight <= containerWeight
        );
        return tarerWeightInput.collect();
    }
}
