package model.service;

import model.Harbor;
import model.container.*;
import model.exception.*;
import model.ship.Ship;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static lang.ErrorMessage.*;

public class ContainerService {

    public static Container createContainer(
            int weight,
            int senderIndex
    ) {
        return ContainerBuilder.basicContainer()
                .withNewId()
                .withWeight(weight)
                .withSender(Harbor.getInstance().getSenderByIndex(senderIndex))
                .build();
    }

    public static HeavyContainer createContainer(
            int weight,
            int senderIndex,
            int tareWeight
    ) {
        return ContainerBuilder.heavyContainer()
                .withNewId()
                .withWeight(weight)
                .withSender(Harbor.getInstance().getSenderByIndex(senderIndex))
                .withTareWeight(tareWeight)
                .build();
    }

    public static LiquidContainer createContainer(
            int weight,
            int senderIndex,
            double liquidVolume
    ) {
        return ContainerBuilder.liquidContainer()
                .withNewId()
                .withWeight(weight)
                .withSender(Harbor.getInstance().getSenderByIndex(senderIndex))
                .withLiquidVolume(liquidVolume)
                .build();
    }

    public static ExplosiveContainer createContainer(
            int weight,
            int senderIndex,
            int tareWeight,
            int additionalProtectionIndex
    ) {
        return ContainerBuilder.explosiveContainer()
                .withNewId()
                .withWeight(weight)
                .withSender(Harbor.getInstance().getSenderByIndex(senderIndex))
                .withTareWeight(tareWeight)
                .withAdditionalProtection(ExplosiveContainer.AdditionalProtection.values()[additionalProtectionIndex - 1])
                .build();
    }

    public static RefrigeratedContainer createContainer(
            int weight,
            int senderIndex,
            int tareWeight,
            boolean connectedToPower
    ) {
        return ContainerBuilder.refrigeratedContainer()
                .withNewId()
                .withWeight(weight)
                .withSender(Harbor.getInstance().getSenderByIndex(senderIndex))
                .withTareWeight(tareWeight)
                .withConnectedToPower(connectedToPower)
                .build();
    }

    public static LooseToxicContainer createContainer(
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
        return containerBuilder.build();
    }

    public static LiquidToxicContainer createContainer(
            int weight,
            int senderIndex,
            int tareWeight,
            int toxicityLevel,
            double liquidVolume
    ) {
        return ContainerBuilder.liquidToxicContainer()
                .withNewId()
                .withWeight(weight)
                .withSender(Harbor.getInstance().getSenderByIndex(senderIndex))
                .withTareWeight(tareWeight)
                .withToxicityLevel(toxicityLevel)
                .withLiquidVolume(liquidVolume)
                .build();
    }

    public static Map<Container, LocalDate> getWarehouseContainers() {
        return Harbor.getInstance().getWarehouse().getContainers();
    }

    public static List<Container> getTrainContainers() {
        return Harbor.getInstance().getTrain().getContainers();
    }

    public static List<Container> getShipContainers(int shipId) {
        Ship ship = Harbor.getInstance().getShipByIndex(shipId);
        if (ship != null) {
            return ship.getContainers();
        } else {
            throw new IllegalArgumentException(SHIP_NOT_FOUND);
        }
    }

    public static void loadOntoShip(int containerIndex, int shipIndex) {
        Container container = Harbor.getInstance().getWarehouse().getContainerByIndex(containerIndex);
        Ship ship = Harbor.getInstance().getShipByIndex(shipIndex);

        if (container == null) {
            throw new IllegalArgumentException(CONTAINER_NOT_FOUND);
        }
        if (ship == null) {
            throw new IllegalArgumentException(SHIP_NOT_FOUND);
        }

        try {
            ship.loadContainer(container);
            Harbor.getInstance().getWarehouse().removeContainerByIndex(containerIndex);
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

    public static void loadOntoTrain(int containerIndex) {
        Container container = Harbor.getInstance().getWarehouse().getContainerByIndex(containerIndex);
        if (container == null) {
            throw new IllegalArgumentException(CONTAINER_NOT_FOUND);
        }
        try {
            Harbor.getInstance().getTrain().addContainer(container);
        } catch (TooManyContainersException e) {
            throw new RuntimeException(TOO_MANY_CONTAINERS_ON_TRAIN);
        }
        Harbor.getInstance().getWarehouse().removeContainerByIndex(containerIndex);
    }

    public static void unloadToWarehouse(int containerIndex, int shipIndex) {
        Ship ship = getShipIfExists(shipIndex);
        Container container = getContainerIfExists(containerIndex, ship);

        try {
            Harbor.getInstance().getWarehouse().addContainer(container);
            ship.removeContainer(containerIndex);
        } catch (TooManyContainersException e) {
            throw new RuntimeException(TOO_MANY_CONTAINERS_IN_WAREHOUSE);
        }
    }

    public static void unloadToTrain(int containerIndex, int shipIndex) {
        Ship ship = getShipIfExists(shipIndex);
        Container container = getContainerIfExists(containerIndex, ship);

        try {
            Harbor.getInstance().getTrain().addContainer(container);
            ship.removeContainer(containerIndex);
        } catch (TooManyContainersException e) {
            throw new RuntimeException(TOO_MANY_CONTAINERS_ON_TRAIN);
        }
    }

    private static Ship getShipIfExists(int shipIndex) {
        Ship ship = Harbor.getInstance().getShipByIndex(shipIndex);
        if (ship == null) {
            throw new IllegalArgumentException(SHIP_NOT_FOUND);
        }
        return ship;
    }

    private static Container getContainerIfExists(int containerIndex, Ship ship) {
        Container container = ship.getContainerByIndex(containerIndex);
        if (container == null) {
            throw new IllegalArgumentException(CONTAINER_NOT_FOUND);
        }
        return container;
    }

    public static void utilizeContainer(int containerIndex) {
        Container container = Harbor.getInstance().getWarehouse().getContainerByIndex(containerIndex);
        if (container == null) {
            throw new IllegalArgumentException(CONTAINER_NOT_FOUND);
        }
        Harbor.getInstance().getWarehouse().removeContainerByIndex(containerIndex);
    }
}
