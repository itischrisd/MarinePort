package model;


import model.container.*;

import java.util.ArrayList;
import java.util.List;


public class Ship {
    private static int lastId = 0;
    private final int maxToxicOrExplosiveContainers;
    private final int maxContainersRequiringElectricity;
    private final int maxHeavyContainers;
    private final int maxTotalContainers;
    private final int maxCargoWeight;
    private final String name;
    private final String originPort;
    private final String cargoOrigin;
    private final String cargoDestination;
    private final int id;
    private final List<Container> containerList;

    public Ship(int maxToxicOrExplosiveContainers, int maxContainersRequiringElectricity, int maxHeavyContainers, int maxTotalContainers, int maxCargoWeight, String name, String originPort, String cargoOrigin, String cargoDestination) {
        this.maxToxicOrExplosiveContainers = maxToxicOrExplosiveContainers;
        this.maxContainersRequiringElectricity = maxContainersRequiringElectricity;
        this.maxHeavyContainers = maxHeavyContainers;
        this.maxTotalContainers = maxTotalContainers;
        this.maxCargoWeight = maxCargoWeight;
        this.name = name;
        this.originPort = originPort;
        this.cargoOrigin = cargoOrigin;
        this.cargoDestination = cargoDestination;
        this.id = createId();
        this.containerList = new ArrayList<>();
    }

    private int createId() {
        return ++lastId;
    }

    public Container unloadContainer(int id) {
        return containerList.remove(id);
    }

    public void loadContainer(Container container) {
        if (containerList.stream().map(Container::getWieght).reduce(0, Integer::sum) + container.getWieght() > maxCargoWeight) {
            ///TODO print error
            return;
        } else if (containerList.size() >= maxTotalContainers) {
            ///TODO print error
            return;
        } else if (containerList.stream().filter(e -> e instanceof HeavyContainer).count() >= maxHeavyContainers) {
            ///TODO print error
            return;
        } else if (containerList.stream().filter(e -> e instanceof RefrigeratedContainer).count() >= maxContainersRequiringElectricity) {
            ///TODO print error
            return;
        } else if (containerList.stream().filter(e -> e instanceof ToxicContainer || e instanceof ExplosiveContainer).count() >= maxToxicOrExplosiveContainers) {
            ///TODO print error
            return;
        }

        containerList.add(container);
    }
}
