package model.ship;

import java.util.ArrayList;
import java.util.List;

public class ShipSerializer {

    public static List<String> serialize(Ship ship) {
        List<String> serializedShip = new ArrayList<>();

        serializedShip.add(String.valueOf(ship.getId()));
        serializedShip.add(ship.getName());
        serializedShip.add(ship.getOriginPort());
        serializedShip.add(ship.getCargoOrigin());
        serializedShip.add(ship.getCargoDestination());
        serializedShip.add(String.valueOf(ship.getMaxToxicOrExplosiveContainers()));
        serializedShip.add(String.valueOf(ship.getMaxContainersRequiringElectricity()));
        serializedShip.add(String.valueOf(ship.getMaxHeavyContainers()));
        serializedShip.add(String.valueOf(ship.getMaxTotalContainers()));
        serializedShip.add(String.valueOf(ship.getMaxCargoWeight()));

        return serializedShip;
    }
}
