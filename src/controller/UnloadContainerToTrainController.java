package controller;

import model.container.Container;
import model.service.ContainerService;
import model.service.ShipService;
import model.ship.Ship;
import ui.core.IOProvider;
import ui.core.View;
import view.ContainerSelectorView;
import view.ShipSelectorView;

import java.util.List;

public class UnloadContainerToTrainController implements Controller {

    private final View<Integer> shipSelectorView;
    private View<Integer> containerSelectorView;

    public UnloadContainerToTrainController() {
        List<Ship> ships = ShipService.getShips();
        this.shipSelectorView = new ShipSelectorView(ships);
    }

    @Override
    public void run() {
        shipSelectorView.display();
        int shipId = shipSelectorView.collect();
        List<Container> containers = ContainerService.getShipContainers(shipId);
        containerSelectorView = new ContainerSelectorView(containers);
        containerSelectorView.display();
        int containerId = containerSelectorView.collect();
        try {
            ContainerService.unloadToTrain(containerId, shipId);
        } catch (Exception e) {
            IOProvider.printError(e);
        }

    }
}
