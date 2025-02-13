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

public class UnloadContainerToWarehouseController implements Controller {

    private final View<Integer> shipSelectorView;
    private View<Integer> containerSelectorView;

    public UnloadContainerToWarehouseController() {
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
            ContainerService.unloadToWarehouse(containerId, shipId);
        } catch (Exception e) {
            IOProvider.getPrinter().println(e.getMessage());
        }
    }
}
