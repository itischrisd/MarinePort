package model.service;

import model.Harbor;
import model.ship.Ship;
import model.ship.ShipBuilder;

import java.util.List;

public class ShipService {

    public static void createShip(
            int id,
            String name,
            String originPort,
            String cargoOrigin,
            String cargoDestination,
            int maxHeavyContainers,
            int maxTotalContainers,
            int maxCargoWeight,
            int maxContainersRequiringElectricity,
            int maxToxicOrExplosiveContainers) {
        Ship newShip = ShipBuilder.ship()
                .withId(id)
                .withName(name)
                .withOriginPort(originPort)
                .withCargoOrigin(cargoOrigin)
                .withCargoDestination(cargoDestination)
                .withMaxHeavyContainers(maxHeavyContainers)
                .withMaxTotalContainers(maxTotalContainers)
                .withMaxCargoWeight(maxCargoWeight)
                .withMaxContainersRequiringElectricity(maxContainersRequiringElectricity)
                .withMaxToxicOrExplosiveContainers(maxToxicOrExplosiveContainers)
                .build();
        Harbor.getInstance().addShip(newShip);
    }

    public static void departShip(int id) {
        Ship departingShip = Harbor.getInstance().getShip(id);
        if (departingShip != null) {
            Harbor.getInstance().removeShip(id);
        } else {
            throw new IllegalArgumentException("Ship with id " + id + " does not exist.");
        }
    }

    public static List<Ship> getShips() {
        return Harbor.getInstance().getShips();
    }
}
