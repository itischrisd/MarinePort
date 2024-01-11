package model;

import model.ship.Ship;

import java.util.List;

public class Harbor {

    private Warehouse warehouse;
    private Train train;
    private List<Ship> ships;

    public Harbor() {
        warehouse = new Warehouse(25);
        train = new Train();
    }
}
