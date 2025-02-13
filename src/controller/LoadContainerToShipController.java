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

public class LoadContainerToShipController implements Controller {

    private final View<Integer> shipSelectorView;
    private final View<Integer> containerSelectorView;

    public LoadContainerToShipController() {
        List<Ship> ships = ShipService.getShips();
        List<Container> containers = ContainerService.getWarehouseContainers().keySet().stream().toList();
        this.shipSelectorView = new ShipSelectorView(ships);
        this.containerSelectorView = new ContainerSelectorView(containers);
    }


    @Override
    public void run() {
        containerSelectorView.display();
        int containerId = containerSelectorView.collect();
        shipSelectorView.display();
        int shipId = shipSelectorView.collect();
        try {
            ContainerService.loadOntoShip(containerId, shipId);
        } catch (Exception e) {
            IOProvider.printError(e);
        }
    }
}
