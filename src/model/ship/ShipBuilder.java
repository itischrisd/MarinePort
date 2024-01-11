package model.ship;

import model.container.Container;

import java.util.List;

public class ShipBuilder {

    private Ship ship;

    public ShipBuilder ship() {
        ship = new Ship();
        return this;
    }

    public ShipBuilder withId(int id) {
        ship.setId(id);
        return this;
    }

    public ShipBuilder withNewId() {
        ship.setId();
        return this;
    }

    public ShipBuilder withName(String name) {
        ship.setName(name);
        return this;
    }

    public ShipBuilder withOriginPort(String originPort) {
        ship.setOriginPort(originPort);
        return this;
    }

    public ShipBuilder withCargoOrigin(String cargoOrigin) {
        ship.setCargoOrigin(cargoOrigin);
        return this;
    }

    public ShipBuilder withCargoDestination(String cargoDestination) {
        ship.setCargoDestination(cargoDestination);
        return this;
    }

    public ShipBuilder withMaxHeavyContainers(int maxHeavyContainers) {
        ship.setMaxHeavyContainers(maxHeavyContainers);
        return this;
    }

    public ShipBuilder withMaxTotalContainers(int maxTotalContainers) {
        ship.setMaxTotalContainers(maxTotalContainers);
        return this;
    }

    public ShipBuilder withMaxCargoWeight(int maxCargoWeight) {
        ship.setMaxCargoWeight(maxCargoWeight);
        return this;
    }

    public ShipBuilder withMaxContainersRequiringElectricity(int maxContainersRequiringElectricity) {
        ship.setMaxContainersRequiringElectricity(maxContainersRequiringElectricity);
        return this;
    }

    public ShipBuilder withMaxToxicOrExplosiveContainers(int maxToxicOrExplosiveContainers) {
        ship.setMaxToxicOrExplosiveContainers(maxToxicOrExplosiveContainers);
        return this;
    }

    public ShipBuilder withContainers(List<Container> containers) {
        ship.setContainerList(containers);
        return this;
    }

    public Ship build() {
        Ship ship = this.ship;
        this.ship = null;
        return ship;
    }
}
