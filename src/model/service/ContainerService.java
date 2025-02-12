package model.service;

import model.Harbor;
import model.container.Container;
import model.container.ContainerBuilder;
import model.container.ExplosiveContainer;
import model.container.LooseToxicContainer;
import model.exception.*;
import model.ship.Ship;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static lang.ErrorMessage.*;

public class ContainerService {

    public static void createContainer(
            int weight,
            int senderIndex
    ) {
        Container container = ContainerBuilder.basicContainer()
                .withNewId()
                .withWeight(weight)
                .withSender(Harbor.getInstance().getSenderByIndex(senderIndex))
                .build();
        try {
            Harbor.getInstance().getWarehouse().addContainer(container);
        } catch (TooManyContainersException e) {
            throw new RuntimeException(TOO_MANY_CONTAINERS_IN_WAREHOUSE);
        }
    }

    public static void createContainer(
            int weight,
            int senderIndex,
            int tareWeight
    ) {
        Container container = ContainerBuilder.heavyContainer()
                .withNewId()
                .withWeight(weight)
                .withSender(Harbor.getInstance().getSenderByIndex(senderIndex))
                .withTareWeight(tareWeight)
                .build();
        try {
            Harbor.getInstance().getWarehouse().addContainer(container);
        } catch (TooManyContainersException e) {
            throw new RuntimeException(TOO_MANY_CONTAINERS_IN_WAREHOUSE);
        }
    }

    public static void createContainer(
            int weight,
            int senderIndex,
            double liquidVolume
    ) {
        Container container = ContainerBuilder.liquidContainer()
                .withNewId()
                .withWeight(weight)
                .withSender(Harbor.getInstance().getSenderByIndex(senderIndex))
                .withLiquidVolume(liquidVolume)
                .build();
        try {
            Harbor.getInstance().getWarehouse().addContainer(container);
        } catch (TooManyContainersException e) {
            throw new RuntimeException(TOO_MANY_CONTAINERS_IN_WAREHOUSE);
        }
    }

    public static void createContainer(
            int weight,
            int senderIndex,
            int tareWeight,
            int additionalProtectionIndex
    ) {
        Container container = ContainerBuilder.explosiveContainer()
                .withNewId()
                .withWeight(weight)
                .withSender(Harbor.getInstance().getSenderByIndex(senderIndex))
                .withTareWeight(tareWeight)
                .withAdditionalProtection(ExplosiveContainer.AdditionalProtection.values()[additionalProtectionIndex - 1])
                .build();
        try {
            Harbor.getInstance().getWarehouse().addContainer(container);
        } catch (TooManyContainersException e) {
            throw new RuntimeException(TOO_MANY_CONTAINERS_IN_WAREHOUSE);
        }
    }

    public static void createContainer(
            int weight,
            int senderIndex,
            int tareWeight,
            boolean connectedToPower
    ) {
        Container container = ContainerBuilder.refrigeratedContainer()
                .withNewId()
                .withWeight(weight)
                .withSender(Harbor.getInstance().getSenderByIndex(senderIndex))
                .withTareWeight(tareWeight)
                .withConnectedToPower(connectedToPower)
                .build();
        try {
            Harbor.getInstance().getWarehouse().addContainer(container);
        } catch (TooManyContainersException e) {
            throw new RuntimeException(TOO_MANY_CONTAINERS_IN_WAREHOUSE);
        }
    }

    public static void createContainer(
            int weight,
            int senderIndex,
            int tareWeight,
            int toxicityLevel,
            List<Integer> featuresIndexes
    ) {
        ContainerBuilder<LooseToxicContainer> containerBuilder = ContainerBuilder.looseToxicContainer()
                .withNewId()
                .withWeight(weight)
                .withSender(Harbor.getInstance().getSenderByIndex(senderIndex))
                .withTareWeight(tareWeight)
                .withToxicityLevel(toxicityLevel);

        featuresIndexes.forEach(index -> containerBuilder.withLooseToxicContainerFeature(LooseToxicContainer.LooseToxicContainerFeatures.values()[index - 1]));
        Container container = containerBuilder.build();
        try {
            Harbor.getInstance().getWarehouse().addContainer(container);
        } catch (TooManyContainersException e) {
            throw new RuntimeException(TOO_MANY_CONTAINERS_IN_WAREHOUSE);
        }
    }

    public static void createContainer(
            int weight,
            int senderIndex,
            int tareWeight,
            int toxicityLevel,
            double liquidVolume
    ) {
        Container container = ContainerBuilder.liquidToxicContainer()
                .withNewId()
                .withWeight(weight)
                .withSender(Harbor.getInstance().getSenderByIndex(senderIndex))
                .withTareWeight(tareWeight)
                .withToxicityLevel(toxicityLevel)
                .withLiquidVolume(liquidVolume)
                .build();
        try {
            Harbor.getInstance().getWarehouse().addContainer(container);
        } catch (TooManyContainersException e) {
            throw new RuntimeException(TOO_MANY_CONTAINERS_IN_WAREHOUSE);
        }
    }

    public static Map<Container, LocalDate> getWarehouseContainers() {
        return Harbor.getInstance().getWarehouse().getContainers();
    }

    public static List<Container> getTrainContainers() {
        return Harbor.getInstance().getTrain().getContainers();
    }

    public static List<Container> getShipContainers(int shipId) {
        Ship ship = Harbor.getInstance().getShipById(shipId);
        if (ship != null) {
            return ship.getContainers();
        } else {
            throw new IllegalArgumentException(SHIP_NOT_FOUND);
        }
    }

    public static void loadOntoShip(int containerId, int shipId) {
        Container container = Harbor.getInstance().getWarehouse().getContainerById(containerId);
        Ship ship = Harbor.getInstance().getShipById(shipId);

        if (container == null) {
            throw new IllegalArgumentException(CONTAINER_NOT_FOUND);
        }
        if (ship == null) {
            throw new IllegalArgumentException(SHIP_NOT_FOUND);
        }

        try {
            ship.loadContainer(container);
            Harbor.getInstance().getWarehouse().removeContainerById(containerId);
        } catch (TooHeavyCargoException e) {
            throw new IllegalArgumentException(TOO_HEAVY_CONTAINER);
        } catch (TooManyContainersException e) {
            throw new RuntimeException(TOO_MANY_CONTAINERS_ON_SHIP);
        } catch (TooManyContainersRequiringElectricityException e) {
            throw new RuntimeException(TOO_MANY_ELECTRIC_CONTAINERS);
        } catch (TooManyToxicOrExplosiveContainersException e) {
            throw new RuntimeException(TOO_MANY_TOXIC_OR_EXPLOSIVE_CONTAINERS);
        } catch (TooManyHeavyContainersException e) {
            throw new RuntimeException(TOO_MANY_HEAVY_CONTAINERS);
        } catch (ContainerLoadingException e) {
            throw new RuntimeException(CONTAINER_LOADING_EXCEPTION);
        }
    }

    public static void loadOntoTrain(int containerId) {
        Container container = Harbor.getInstance().getWarehouse().getContainerById(containerId);
        if (container == null) {
            throw new IllegalArgumentException(CONTAINER_NOT_FOUND);
        }
        try {
            Harbor.getInstance().getTrain().addContainer(container);
        } catch (TooManyContainersException e) {
            throw new RuntimeException(TOO_MANY_CONTAINERS_ON_TRAIN);
        }
        Harbor.getInstance().getWarehouse().removeContainerById(containerId);
    }

    public static void unloadToWarehouse(int containerId, int shipId) {
        Ship ship = getShipIfExists(shipId);
        Container container = getContainerIfExists(containerId, ship);

        try {
            Harbor.getInstance().getWarehouse().addContainer(container);
            ship.removeContainer(containerId);
        } catch (TooManyContainersException e) {
            throw new RuntimeException(TOO_MANY_CONTAINERS_IN_WAREHOUSE);
        }
    }

    public static void unloadToTrain(int containerId, int shipId) {
        Ship ship = getShipIfExists(shipId);
        Container container = getContainerIfExists(containerId, ship);

        try {
            Harbor.getInstance().getTrain().addContainer(container);
            ship.removeContainer(containerId);
        } catch (TooManyContainersException e) {
            throw new RuntimeException(TOO_MANY_CONTAINERS_ON_TRAIN);
        }
    }

    private static Ship getShipIfExists(int shipId) {
        Ship ship = Harbor.getInstance().getShipById(shipId);
        if (ship == null) {
            throw new IllegalArgumentException(SHIP_NOT_FOUND);
        }
        return ship;
    }

    private static Container getContainerIfExists(int containerId, Ship ship) {
        Container container = ship.getContainerById(containerId);
        if (container == null) {
            throw new IllegalArgumentException(CONTAINER_NOT_FOUND);
        }
        return container;
    }

    public static void utilizeContainer(int containerId) {
        Container container = Harbor.getInstance().getWarehouse().getContainerById(containerId);
        if (container == null) {
            throw new IllegalArgumentException(CONTAINER_NOT_FOUND);
        }
        Harbor.getInstance().getWarehouse().removeContainerById(containerId);
    }
}
