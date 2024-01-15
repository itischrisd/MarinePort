package model;

import model.sender.Sender;
import model.ship.Ship;
import model.warehouse.Warehouse;

import java.util.ArrayList;
import java.util.List;

public class Harbor {

    private static Harbor instance;
    private Warehouse warehouse;
    private Train train;
    private List<Ship> ships;
    private List<Sender> senders;

    private Harbor() {
        warehouse = new Warehouse(25);
        train = new Train();
        ships = new ArrayList<>();
    }

    public static Harbor getInstance() {
        if (instance == null) {
            instance = new Harbor();
        }
        return instance;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public List<Ship> getShips() {
        return ships;
    }

    public void setShips(List<Ship> ships) {
        this.ships = ships;
    }

    public List<Sender> getSenders() {
        return senders;
    }

    public void setSenders(List<Sender> senders) {
        this.senders = senders;
    }

    public Ship getShip(int id) {
        return ships.get(id);
    }

    public void addShip(Ship ship) {
        ships.add(ship);
    }

    public void removeShip(int id) {
        ships.remove(id);
    }

    public Sender getSender(int id) {
        return senders.get(id);
    }
}
