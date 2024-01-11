package model.ship;


import model.container.*;
import model.exception.*;

import java.util.ArrayList;
import java.util.List;


public class Ship {
    private static int lastId = 0;
    private int id;
    private String name;
    private String originPort;
    private String cargoOrigin;
    private String cargoDestination;
    private int maxToxicOrExplosiveContainers;
    private int maxContainersRequiringElectricity;
    private int maxHeavyContainers;
    private int maxTotalContainers;
    private int maxCargoWeight;
    private List<Container> containerList;

    public Ship() {

    }

    public Container unloadContainer(int id) {
        return containerList.remove(id);
    }

    public void loadContainer(Container container) throws ContainerLoadingException {
        if (containerList.stream().map(Container::getWeight).reduce(0, Integer::sum) + container.getWeight() > maxCargoWeight) {
            throw new TooHeavyCargoException();
        } else if (containerList.size() >= maxTotalContainers) {
            throw new TooManyContainersException();
        } else if (containerList.stream().filter(e -> e instanceof HeavyContainer).count() >= maxHeavyContainers) {
            throw new TooManyHeavyContainersException();
        } else if (containerList.stream().filter(e -> e instanceof RefrigeratedContainer).count() >= maxContainersRequiringElectricity) {
            throw new TooManyContainersRequiringElectricityException();
        } else if (containerList.stream().filter(e -> e instanceof ToxicContainer || e instanceof ExplosiveContainer).count() >= maxToxicOrExplosiveContainers) {
            throw new TooManyToxicOrExplosiveContainersException();
        }

        containerList.add(container);
    }

    public int getMaxToxicOrExplosiveContainers() {
        return maxToxicOrExplosiveContainers;
    }

    public void setMaxToxicOrExplosiveContainers(int maxToxicOrExplosiveContainers) {
        this.maxToxicOrExplosiveContainers = maxToxicOrExplosiveContainers;
    }

    public int getMaxContainersRequiringElectricity() {
        return maxContainersRequiringElectricity;
    }

    public void setMaxContainersRequiringElectricity(int maxContainersRequiringElectricity) {
        this.maxContainersRequiringElectricity = maxContainersRequiringElectricity;
    }

    public int getMaxHeavyContainers() {
        return maxHeavyContainers;
    }

    public void setMaxHeavyContainers(int maxHeavyContainers) {
        this.maxHeavyContainers = maxHeavyContainers;
    }

    public int getMaxTotalContainers() {
        return maxTotalContainers;
    }

    public void setMaxTotalContainers(int maxTotalContainers) {
        this.maxTotalContainers = maxTotalContainers;
    }

    public int getMaxCargoWeight() {
        return maxCargoWeight;
    }

    public void setMaxCargoWeight(int maxCargoWeight) {
        this.maxCargoWeight = maxCargoWeight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginPort() {
        return originPort;
    }

    public void setOriginPort(String originPort) {
        this.originPort = originPort;
    }

    public String getCargoOrigin() {
        return cargoOrigin;
    }

    public void setCargoOrigin(String cargoOrigin) {
        this.cargoOrigin = cargoOrigin;
    }

    public String getCargoDestination() {
        return cargoDestination;
    }

    public void setCargoDestination(String cargoDestination) {
        this.cargoDestination = cargoDestination;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        lastId = Math.max(lastId, id);
    }

    public void setId() {
        this.id = ++lastId;
    }

    public List<Container> getContainerList() {
        return containerList;
    }

    public void setContainerList(List<Container> containerList) {
        this.containerList = containerList;
    }
}
