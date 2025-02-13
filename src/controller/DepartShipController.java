package controller;

import model.service.ShipService;
import model.ship.Ship;
import ui.core.IOProvider;
import ui.input.Input;
import ui.input.IntegerInput;
import view.ShipsView;

import java.util.List;

import static lang.Interface.*;

public class DepartShipController implements Controller {

    private final ShipsView shipsView;
    private final Input<Integer> shipIdInput;

    public DepartShipController() {
        List<Ship> ships = ShipService.getShips();
        this.shipsView = new ShipsView(ships);
        this.shipIdInput = new IntegerInput(
                DEPARTURE_PROMPT,
                INVALID_SHIP_ID,
                number -> ships.stream().anyMatch(ship -> ship.getId() == number)
        );
    }

    @Override
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
