package model.ship;


import model.container.*;
import model.exception.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
    private List<Container> containers;

    protected Ship() {
        this.containers = new ArrayList<>();
    }

    public Container unloadContainer(int id) {
        return containers.remove(id);
    }

    public void loadContainer(Container container) throws ContainerLoadingException {
        if (containers.stream().map(Container::getWeight).reduce(0, Integer::sum) + container.getWeight() > maxCargoWeight) {
            throw new TooHeavyCargoException();
        } else if (containers.size() >= maxTotalContainers) {
            throw new TooManyContainersException();
        } else if (containers.stream().filter(e -> e instanceof HeavyContainer).count() >= maxHeavyContainers) {
            throw new TooManyHeavyContainersException();
        } else if (containers.stream().filter(e -> e instanceof RefrigeratedContainer).count() >= maxContainersRequiringElectricity) {
            throw new TooManyContainersRequiringElectricityException();
        } else if (containers.stream().filter(e -> e instanceof ToxicContainer || e instanceof ExplosiveContainer).count() >= maxToxicOrExplosiveContainers) {
            throw new TooManyToxicOrExplosiveContainersException();
        }

        containers.add(container);
    }

    public int getMaxToxicOrExplosiveContainers() {
        return maxToxicOrExplosiveContainers;
    }

    protected void setMaxToxicOrExplosiveContainers(int maxToxicOrExplosiveContainers) {
        this.maxToxicOrExplosiveContainers = maxToxicOrExplosiveContainers;
    }

    public int getMaxContainersRequiringElectricity() {
        return maxContainersRequiringElectricity;
    }

    protected void setMaxContainersRequiringElectricity(int maxContainersRequiringElectricity) {
        this.maxContainersRequiringElectricity = maxContainersRequiringElectricity;
    }

    public int getMaxHeavyContainers() {
        return maxHeavyContainers;
    }

    protected void setMaxHeavyContainers(int maxHeavyContainers) {
        this.maxHeavyContainers = maxHeavyContainers;
    }

    public int getMaxTotalContainers() {
        return maxTotalContainers;
    }

    protected void setMaxTotalContainers(int maxTotalContainers) {
        this.maxTotalContainers = maxTotalContainers;
    }

    public int getMaxCargoWeight() {
        return maxCargoWeight;
    }

    protected void setMaxCargoWeight(int maxCargoWeight) {
        this.maxCargoWeight = maxCargoWeight;
    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public String getOriginPort() {
        return originPort;
    }

    protected void setOriginPort(String originPort) {
        this.originPort = originPort;
    }

    public String getCargoOrigin() {
        return cargoOrigin;
    }

    protected void setCargoOrigin(String cargoOrigin) {
        this.cargoOrigin = cargoOrigin;
    }

    public String getCargoDestination() {
        return cargoDestination;
    }

    protected void setCargoDestination(String cargoDestination) {
        this.cargoDestination = cargoDestination;
    }

    public int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
        lastId = Math.max(lastId, id);
    }

    protected void setId() {
        this.id = ++lastId;
    }

    public List<Container> getContainers() {
        return Collections.unmodifiableList(containers);
    }

    protected void setContainers(List<Container> containers) {
        this.containers = new ArrayList<>(containers);
    }

    public void sortContainersByWeight() {
        containers.sort(Comparator.comparingInt(Container::getWeight));
    }
}
