package model;

import model.sender.Sender;
import model.ship.Ship;
import model.train.Train;
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
        ships = new ArrayList<>();
    }

    public static Harbor getInstance() {
        if (instance == null) {
            instance = new Harbor();
        }
        return instance;
    }

    public static void deleteInstance() {
        instance = null;
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

    public Ship getShipByIndex(int index) {
        return ships.get(index);
    }

    public void addShip(Ship ship) {
        ships.add(ship);
    }

    public void removeShip(int id) {
        ships.remove(id);
    }

    public Sender getSenderByIndex(int id) {
        return senders.get(id);
    }

    public void sortShipsByNameDescending() {
        ships.sort((s1, s2) -> s2.getName().compareTo(s1.getName()));
    }
}
