package controller;

import model.service.ShipService;
import ui.core.IOProvider;
import ui.input.Input;
import ui.input.IntegerInput;
import ui.input.StringInput;

public class CreateShipController {

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
                "Podaj nazwę statku",
                "Nazwa statku nie może być pusta",
                name -> !name.isBlank()
        );
        this.originPortInput = new StringInput(
                "Podaj port pochodzenia",
                "Port pochodzenia nie może być pusty",
                originPort -> !originPort.isBlank()
        );
        this.cargoOriginInput = new StringInput(
                "Podaj pochodzenie ładunku",
                "Pochodzenie ładunku nie może być puste",
                cargoOrigin -> !cargoOrigin.isBlank()
        );
        this.cargoDestinationInput = new StringInput(
                "Podaj cel ładunku",
                "Cel ładunku nie może być pusty",
                cargoDestination -> !cargoDestination.isBlank()
        );
        this.maxTotalContainersInput = new IntegerInput(
                "Podaj maksymalną liczbę kontenerów",
                "Maksymalna liczba kontenerów musi być większa od 0",
                number -> number > 0
        );
        this.maxCargoWeightInput = new IntegerInput(
                "Podaj maksymalną wagę ładunku",
                "Maksymalna waga ładunku musi być większa od 0",
                number -> number > 0
        );
    }

    public void run() {
        String name = nameInput.collect();
        String originPort = originPortInput.collect();
        String cargoOrigin = cargoOriginInput.collect();
        String cargoDestination = cargoDestinationInput.collect();
        int maxCargoWeight = maxCargoWeightInput.collect();
        int maxTotalContainers = maxTotalContainersInput.collect();


        this.maxHeavyContainersInput = new IntegerInput(
                "Podaj maksymalną liczbę ciężkich kontenerów",
                "Maksymalna liczba ciężkich kontenerów nie może być większa niż maksymalna liczba kontenerów i musi być większa od 0",
                number -> number <= maxTotalContainers && number >= 0
        );

        int maxHeavyContainers = maxHeavyContainersInput.collect();

        this.maxContainersRequiringElectricityInput = new IntegerInput(
                "Podaj maksymalną liczbę kontenerów wymagających prądu",
                "Maksymalna liczba kontenerów wymagających prądu nie może być większa niż maksymalna liczba ciężkich kontenerów i musi być większa od 0",
                number -> number <= maxHeavyContainers && number >= 0
        );

        int maxContainersRequiringElectricity = maxContainersRequiringElectricityInput.collect();

        this.maxToxicOrExplosiveContainersInput = new IntegerInput(
                "Podaj maksymalną liczbę kontenerów toksycznych lub wybuchowych",
                "Maksymalna liczba kontenerów toksycznych lub wybuchowych nie może być większa niż maksymalna liczba kontenerów ciężkich wyłączając kontenery wymagające prądu i musi być większa od 0",
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
            IOProvider.getPrinter().println(e.getMessage());
        }
    }
}
