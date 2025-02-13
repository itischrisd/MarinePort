package controller;

import model.service.ShipService;
import ui.core.IOProvider;
import ui.input.Input;
import ui.input.IntegerInput;
import ui.input.StringInput;

import static lang.Interface.*;

public class CreateShipController implements Controller {

    private final Input<String> nameInput;
    private final Input<String> originPortInput;
    private final Input<String> cargoOriginInput;
    private final Input<String> cargoDestinationInput;
    private final Input<Integer> maxTotalContainersInput;
    private final Input<Integer> maxCargoWeightInput;
    private Input<Integer> maxHeavyContainersInput;
    private Input<Integer> maxContainersRequiringElectricityInput;
    private Input<Integer> maxToxicOrExplosiveContainersInput;

    public CreateShipController() {
        this.nameInput = new StringInput(
                SHIP_NAME_PROMPT,
                INVALID_SHIP_NAME,
                name -> !name.isBlank()
        );
        this.originPortInput = new StringInput(
                ORIGIN_PORT_PROMPT,
                INVALID_ORIGIN_PORT,
                originPort -> !originPort.isBlank()
        );
        this.cargoOriginInput = new StringInput(
                CARGO_ORIGIN_PROMPT,
                INVALID_CARGO_ORIGIN,
                cargoOrigin -> !cargoOrigin.isBlank()
        );
        this.cargoDestinationInput = new StringInput(
                CARGO_DESTINATION_PROMPT,
                INVALID_CARGO_DESTINATION,
                cargoDestination -> !cargoDestination.isBlank()
        );
        this.maxTotalContainersInput = new IntegerInput(
                MAX_CONTAINERS_PROMPT,
                INVALID_MAX_CONTAINERS,
                number -> number > 0
        );
        this.maxCargoWeightInput = new IntegerInput(
                MAX_CARGO_WEIGHT_PROMPT,
                INVALID_MAX_CARGO_WEIGHT,
                number -> number > 0
        );
    }

    @Override
    public void run() {
        String name = nameInput.collect();
        String originPort = originPortInput.collect();
        String cargoOrigin = cargoOriginInput.collect();
        String cargoDestination = cargoDestinationInput.collect();
        int maxCargoWeight = maxCargoWeightInput.collect();
        int maxTotalContainers = maxTotalContainersInput.collect();


        this.maxHeavyContainersInput = new IntegerInput(
                MAX_HEAVY_CONTAINERS_PROMPT,
                INVALID_MAX_HEAVY_CONTAINERS,
                number -> number <= maxTotalContainers && number >= 0
        );

        int maxHeavyContainers = maxHeavyContainersInput.collect();

        this.maxContainersRequiringElectricityInput = new IntegerInput(
                MAX_CONTAINERS_REQUIRING_ELECTRICITY_PROMPT,
                INVALID_MAX_CONTAINERS_REQUIRING_ELECTRICITY,
                number -> number <= maxHeavyContainers && number >= 0
        );

        int maxContainersRequiringElectricity = maxContainersRequiringElectricityInput.collect();

        this.maxToxicOrExplosiveContainersInput = new IntegerInput(
                MAX_TOXIC_OR_EXPLOSIVE_CONTAINERS_PROMPT,
                INVALID_MAX_TOXIC_OR_EXPLOSIVE_CONTAINERS,
                number -> number <= maxHeavyContainers - maxContainersRequiringElectricity && number >= 0
        );

        int maxToxicOrExplosiveContainers = maxToxicOrExplosiveContainersInput.collect();

        try {
            ShipService.createShip(
                    name,
                    originPort,
                    cargoOrigin,
                    cargoDestination,
                    maxHeavyContainers,
                    maxTotalContainers,
                    maxCargoWeight,
                    maxContainersRequiringElectricity,
                    maxToxicOrExplosiveContainers
            );
        } catch (Exception e) {
            IOProvider.printError(e);
        }
    }
}
