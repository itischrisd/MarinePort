package controller;

import model.service.ShipService;
import model.ship.Ship;
import ui.core.IOProvider;
import ui.input.Input;
import ui.input.IntegerInput;
import view.ShipsView;

import java.util.List;

public class DepartShipController {

    private final ShipsView shipsView;
    private final Input<Integer> shipIdInput;

    public DepartShipController() {
        List<Ship> ships = ShipService.getShips();
        this.shipsView = new ShipsView(ships);
        this.shipIdInput = new IntegerInput(
                "Podaj ID statku do wypłynięcia",
                "Niepoprawny numer statku",
                number -> ships.stream().anyMatch(ship -> ship.getId() == number)
        );
    }

    public void run() {
        shipsView.display();
        int shipId = shipIdInput.collect();
        try {
            ShipService.departShip(shipId);
        } catch (Exception e) {
            IOProvider.getPrinter().println(e.getMessage());
        }
    }
}
