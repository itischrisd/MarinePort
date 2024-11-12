package model.service;

import model.Harbor;
import model.ship.Ship;

import java.util.List;

public class ShipService {

    public static void createShip() {

    }

    public static void departShip(Ship ship) {
//        try {
//            Harbor.getInstance().removeShip(ship);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public static List<Ship> getShips() {
        return Harbor.getInstance().getShips();
    }
}
