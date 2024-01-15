package model.ship;


import model.container.*;
import model.exception.*;

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

    protected int getMaxToxicOrExplosiveContainers() {
        return maxToxicOrExplosiveContainers;
    }

    protected void setMaxToxicOrExplosiveContainers(int maxToxicOrExplosiveContainers) {
        this.maxToxicOrExplosiveContainers = maxToxicOrExplosiveContainers;
    }

    protected int getMaxContainersRequiringElectricity() {
        return maxContainersRequiringElectricity;
    }

    protected void setMaxContainersRequiringElectricity(int maxContainersRequiringElectricity) {
        this.maxContainersRequiringElectricity = maxContainersRequiringElectricity;
    }

    protected int getMaxHeavyContainers() {
        return maxHeavyContainers;
    }

    protected void setMaxHeavyContainers(int maxHeavyContainers) {
        this.maxHeavyContainers = maxHeavyContainers;
    }

    protected int getMaxTotalContainers() {
        return maxTotalContainers;
    }

    protected void setMaxTotalContainers(int maxTotalContainers) {
        this.maxTotalContainers = maxTotalContainers;
    }

    protected int getMaxCargoWeight() {
        return maxCargoWeight;
    }

    protected void setMaxCargoWeight(int maxCargoWeight) {
        this.maxCargoWeight = maxCargoWeight;
    }

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected String getOriginPort() {
        return originPort;
    }

    protected void setOriginPort(String originPort) {
        this.originPort = originPort;
    }

    protected String getCargoOrigin() {
        return cargoOrigin;
    }

    protected void setCargoOrigin(String cargoOrigin) {
        this.cargoOrigin = cargoOrigin;
    }

    protected String getCargoDestination() {
        return cargoDestination;
    }

    protected void setCargoDestination(String cargoDestination) {
        this.cargoDestination = cargoDestination;
    }

    protected int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
        lastId = Math.max(lastId, id);
    }

    protected void setId() {
        this.id = ++lastId;
    }

    protected List<Container> getContainerList() {
        return containerList;
    }

    protected void setContainerList(List<Container> containerList) {
        this.containerList = containerList;
    }
}
