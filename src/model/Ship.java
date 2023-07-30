package model;

public class Ship {
    private final int maxToxicOrExplosiveContainers;
    private final int maxHeavyContainers;
    private final int maxContainersRequiringElectricity;
    private final int maxTotalContainers;
    private final int maxCargoWeight;
    private String name;
    private String originPort;
    private String cargoOrigin;
    private String cargoDestination;
    private int id;

    public Ship(int maxToxicOrExplosiveContainers, int maxHeavyContainers, int maxContainersRequiringElectricity, int maxTotalContainers, int maxCargoWeight) {
        this.maxToxicOrExplosiveContainers = maxToxicOrExplosiveContainers;
        this.maxHeavyContainers = maxHeavyContainers;
        this.maxContainersRequiringElectricity = maxContainersRequiringElectricity;
        this.maxTotalContainers = maxTotalContainers;
        this.maxCargoWeight = maxCargoWeight;
    }
}
