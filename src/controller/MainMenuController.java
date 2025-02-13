package controller;

import model.App;
import model.container.Container;
import model.sender.Sender;
import model.service.ContainerService;
import model.service.SenderService;
import model.service.ShipService;
import model.ship.Ship;
import ui.component.Component;
import ui.component.LineComponent;
import ui.core.View;
import view.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class MainMenuController implements Controller {

    private final View<Integer> mainMenuView;
    private boolean isRunning;

    public MainMenuController() {
        this.isRunning = true;
        this.mainMenuView = new MainMenuView();
    }

    @Override
    public void run() {
        launchApp();

        while (isRunning) {
            mainMenuView.display();
            int choice = mainMenuView.collect();
            handleChoice(choice);
        }
    }

    private void launchApp() {
        try {
            App.launch();
        } catch (Exception e) {
            Component errorComponent = new LineComponent(e.getMessage());
            errorComponent.display();
        }
    }

    private void handleChoice(int choice) {
        switch (choice) {
            case 1:
                createShip();
                break;
            case 2:
                createContainer();
                break;
            case 3:
                displayShips();
                break;
            case 4:
                displayContainersOnShip();
                break;
            case 5:
                displayWarehouse();
                break;
            case 6:
                displayTrain();
                break;
            case 7:
                displaySenders();
                break;
            case 8:
                utilizeContainerFromWarehouse();
                break;
            case 9:
                departShip();
                break;
            case 10:
                saveState();
                break;
            case 11:
                loadState();
                break;
            case 12:
                exitApp();
                break;
            default:
                break;
        }
    }

    private void createShip() {
        Controller createShipController = new CreateShipController();
        createShipController.run();
    }

    private void createContainer() {
        Controller createContainerController = new CreateContainerController();
        createContainerController.run();
    }

    private void displayShips() {
        List<Ship> ships = ShipService.getShips();
        Component shipsView = new ShipsView(ships);
        shipsView.display();
    }

    private void displayContainersOnShip() {

    }

    private void displayWarehouse() {
        Map<Container, LocalDate> containers = ContainerService.getWarehouseContainers();
        Component warehouseContainersView = new WarehouseContainersView(containers);
        warehouseContainersView.display();
    }

    private void displayTrain() {
        List<Container> containers = ContainerService.getTrainContainers();
        Component containersView = new ContainersView(containers);
        containersView.display();
    }

    private void displaySenders() {
        List<Sender> senders = SenderService.getSenders();
        Component sendersView = new SendersView(senders);
        sendersView.display();
    }

    private void utilizeContainerFromWarehouse() {
        Controller utilizationController = new UtilizationController();
        utilizationController.run();
    }

    private void departShip() {
        Controller departShipController = new DepartShipController();
        departShipController.run();
    }

    private void saveState() {
        Controller saveStateController = new SaveStateController();
        saveStateController.run();
    }

    private void loadState() {
        Controller loadStateController = new LoadStateController();
        loadStateController.run();
    }

    private void exitApp() {
        isRunning = false;

        App.exit();
    }
}
