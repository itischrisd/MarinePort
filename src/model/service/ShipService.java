package model.service;

import model.Harbor;
import model.ship.Ship;
import model.ship.ShipBuilder;

import java.util.List;

import static lang.ErrorMessage.SHIP_NOT_FOUND;

public class ShipService {

    public static List<Ship> getShips() {
        return Harbor.getInstance().getShips();
    }

    public static void createShip(
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
                .withNewId()
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

    public static void departShip(int shipId) {
        Ship departingShip = Harbor.getInstance().getShipById(shipId);
        if (departingShip != null) {
            Harbor.getInstance().removeShipById(shipId);
        } else {
            throw new IllegalArgumentException(SHIP_NOT_FOUND);
        }
    }
}
