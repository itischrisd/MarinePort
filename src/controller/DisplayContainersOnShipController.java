package controller;

import model.container.Container;
import model.service.ContainerService;
import model.service.ShipService;
import model.ship.Ship;
import ui.component.Component;
import ui.core.View;
import view.ContainersTableComponent;
import view.ShipSelectorView;

import java.util.List;

public class DisplayContainersOnShipController implements Controller {

    private final View<Integer> shipSelectorView;

    public DisplayContainersOnShipController() {
        List<Ship> ships = ShipService.getShips();
        this.shipSelectorView = new ShipSelectorView(ships);
    }

    @Override
    public void run() {
        shipSelectorView.display();
        int shipId = shipSelectorView.collect();
        List<Container> containers = ContainerService.getShipContainers(shipId);
        Component containersView = new ContainersTableComponent(containers);
        containersView.display();
    }
}
