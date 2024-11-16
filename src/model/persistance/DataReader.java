package model.persistance;

import model.Harbor;
import model.container.Container;
import model.container.ContainerBuilder;
import model.container.ExplosiveContainer;
import model.container.LooseToxicContainer;
import model.exception.ExceptionBuilder;
import model.exception.IrresponsibleSenderWithDangerousGoods;
import model.sender.Sender;
import model.sender.SenderBuilder;
import model.ship.Ship;
import model.ship.ShipBuilder;
import model.time.Clock;
import model.train.TrainBuilder;
import model.warehouse.WarehouseBuilder;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;

import static model.persistance.Headers.*;

public class DataReader {

    private static List<String> lines;

    public static void readFromFile(String path) {
        try {
            lines = Files.readAllLines(Paths.get(path));
            readHeader();
            readSenders();
            readWarehouse();
            readTrain();
            readShips();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void readHeader() {
        String header = lines.removeFirst();
        if (!header.equals(TITLE_DOCUMENT)) {
            throw new IllegalArgumentException();
        }
        String currentDate = lines.removeFirst().split(FIELD_NAME_DELIMITER)[1];
        try {
            Clock.setDate(LocalDate.parse(currentDate));
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private static void readSenders() {
        String header = lines.removeFirst();
        if (!header.equals(Headers.TITLE_SENDERS)) {
            throw new IllegalArgumentException();
        }

        List<Sender> senders = new ArrayList<>();

        while (!lines.getFirst().equals(TITLE_WAREHOUSE)) {
            String[] senderData = lines.removeFirst().split(CLASS_NAME_DELIMITER);
            if (!senderData[0].equals(SENDER)) {
                throw new IllegalArgumentException();
            }

            senderData = senderData[1].split(FIELD_DELIMITER);
            SenderBuilder senderBuilder = SenderBuilder.sender();

            for (String field : senderData) {
                String[] fieldData = field.split(FIELD_NAME_DELIMITER);
                switch (fieldData[0]) {
                    case FIELD_SENDER_NAME -> senderBuilder.withName(fieldData[1]);
                    case FIELD_SENDER_SURNAME -> senderBuilder.withSurname(fieldData[1]);
                    case FIELD_SENDER_PESEL -> senderBuilder.withPesel(fieldData[1]);
                    case FIELD_ADDRESS -> senderBuilder.withAddress(fieldData[1]);
                }
            }

            List<IrresponsibleSenderWithDangerousGoods> warnings = new ArrayList<>();

            while (!lines.getFirst().startsWith(SENDER) && !lines.getFirst().equals(TITLE_WAREHOUSE)) {
                String[] warningData = lines.removeFirst().split(CLASS_NAME_DELIMITER);
                if (!warningData[0].equals(WARNING)) {
                    throw new IllegalArgumentException();
                }

                ExceptionBuilder exceptionBuilder = ExceptionBuilder.irresponsibleSenderWithDangerousGoods();
                warningData = warningData[1].split(FIELD_DELIMITER);

                for (String field : warningData) {
                    String[] fieldData = field.split(FIELD_NAME_DELIMITER);
                    switch (fieldData[0]) {
                        case FIELD_ID -> exceptionBuilder.withId(Integer.parseInt(fieldData[1]));
                        case FIELD_ARRIVAL_DATE -> exceptionBuilder.withArrivalDate(LocalDate.parse(fieldData[1]));
                        case FIELD_UTILIZATION_DATE ->
                                exceptionBuilder.withUtilizationDate(LocalDate.parse(fieldData[1]));
                    }
                }

                warnings.add(exceptionBuilder.build());
            }

            senders.add(senderBuilder.withWarnings(warnings).build());
        }

        Harbor.getInstance().setSenders(senders);
    }

    private static void readWarehouse() {
        String header = lines.removeFirst();
        if (!header.equals(Headers.TITLE_WAREHOUSE)) {
            throw new IllegalArgumentException();
        }

        String[] maxContainers = lines.removeFirst().split(FIELD_NAME_DELIMITER);
        if (!maxContainers[0].equals(FIELD_MAX_CONTAINERS)) {
            throw new IllegalArgumentException();
        }

        WarehouseBuilder warehouseBuilder = WarehouseBuilder.warehouse();
        warehouseBuilder.withMaxContainers(Integer.parseInt(maxContainers[1]));
        Map<Container, LocalDate> containers = new LinkedHashMap<>();

        while (!lines.getFirst().equals(TITLE_TRAIN)) {
            Container container = readContainer();
            LocalDate storageDate = LocalDate.parse(lines.removeFirst().split(FIELD_NAME_DELIMITER)[1]);
            containers.put(container, storageDate);
        }

        Harbor.getInstance().setWarehouse(warehouseBuilder.withContainers(containers).build());
    }

    private static Container readContainer() {
        ContainerBuilder<? extends Container> containerBuilder;
        String[] containerData = lines.removeFirst().split(CLASS_NAME_DELIMITER);
        String containerType = containerData[0];
        containerData = containerData[1].split(FIELD_DELIMITER);

        containerBuilder = switch (containerType) {
            case CONTAINER_HEAVY -> ContainerBuilder.heavyContainer();
            case CONTAINER_REFRIGERATED -> ContainerBuilder.refrigeratedContainer();
            case CONTAINER_LIQUID -> ContainerBuilder.liquidContainer();
            case CONTAINER_EXPLOSIVE -> ContainerBuilder.explosiveContainer();
            case CONTAINER_LOOSE_TOXIC -> ContainerBuilder.looseToxicContainer();
            case CONTAINER_LIQUID_TOXIC -> ContainerBuilder.liquidToxicContainer();
            default -> ContainerBuilder.basicContainer();
        };

        for (String field : containerData) {
            String[] fieldData = field.split(FIELD_NAME_DELIMITER);
            switch (fieldData[0]) {
                case FIELD_ID -> containerBuilder.withId(Integer.parseInt(fieldData[1]));
                case FIELD_WEIGHT -> containerBuilder.withWeight(Integer.parseInt(fieldData[1]));
                case FIELD_SENDER_PESEL -> {
                    Sender sender = Harbor.getInstance().getSenders().stream()
                            .filter(s -> s.getPesel().equals(fieldData[1]))
                            .findFirst()
                            .orElse(null);
                    containerBuilder.withSender(sender);
                }
                case FIELD_TARE_WEIGHT -> containerBuilder.withTareWeight(Integer.parseInt(fieldData[1]));
                case FIELD_LIQUID_VOLUME -> containerBuilder.withLiquidVolume(Double.parseDouble(fieldData[1]));
                case FIELD_ADDITIONAL_PROTECTION ->
                        containerBuilder.withAdditionalProtection(ExplosiveContainer.AdditionalProtection.fromDisplayName(fieldData[1]));
                case FIELD_CONNECTED_TO_POWER ->
                        containerBuilder.withConnectedToPower(Boolean.parseBoolean(fieldData[1]));
                case FIELD_TOXICITY_LEVEL -> containerBuilder.withToxicityLevel(Integer.parseInt(fieldData[1]));
                case FIELD_LOOSE_TOXIC_CONTAINER_FEATURES ->
                        containerBuilder.withLooseToxicContainerFeatures(Arrays.stream(fieldData[1].split(FIELD_VALUE_DELIMITER)).map(LooseToxicContainer.LooseToxicContainerFeatures::fromDisplayName).toList());
            }
        }

        return containerBuilder.build();
    }

    private static void readTrain() {
        String header = lines.removeFirst();
        if (!header.equals(Headers.TITLE_TRAIN)) {
            throw new IllegalArgumentException();
        }

        TrainBuilder trainBuilder = TrainBuilder.train();
        List<Container> containers = new ArrayList<>();

        while (!lines.getFirst().equals(TITLE_SHIPS)) {
            containers.add(readContainer());
        }

        Harbor.getInstance().setTrain(trainBuilder.withContainers(containers).build());
    }

    private static void readShips() {
        String header = lines.removeFirst();
        if (!header.equals(Headers.TITLE_SHIPS)) {
            throw new IllegalArgumentException();
        }

        List<Ship> ships = new ArrayList<>();

        while (!lines.isEmpty()) {
            String[] shipData = lines.removeFirst().split(CLASS_NAME_DELIMITER);
            if (!shipData[0].equals(SHIP)) {
                throw new IllegalArgumentException();
            }

            ShipBuilder shipBuilder = ShipBuilder.ship();
            shipData = shipData[1].split(FIELD_DELIMITER);

            for (String field : shipData) {
                String[] fieldData = field.split(FIELD_NAME_DELIMITER);
                switch (fieldData[0]) {
                    case FIELD_ID -> shipBuilder.withId(Integer.parseInt(fieldData[1]));
                    case FIELD_SHIP_NAME -> shipBuilder.withName(fieldData[1]);
                    case FIELD_ORIGIN_PORT -> shipBuilder.withOriginPort(fieldData[1]);
                    case FIELD_CARGO_ORIGIN -> shipBuilder.withCargoOrigin(fieldData[1]);
                    case FIELD_CARGO_DESTINATION -> shipBuilder.withCargoDestination(fieldData[1]);
                    case FIELD_MAX_TOXIC_OR_EXPLOSIVE_CONTAINERS ->
                            shipBuilder.withMaxToxicOrExplosiveContainers(Integer.parseInt(fieldData[1]));
                    case FIELD_MAX_CONTAINERS_REQUIRING_ELECTRICITY ->
                            shipBuilder.withMaxContainersRequiringElectricity(Integer.parseInt(fieldData[1]));
                    case FIELD_MAX_HEAVY_CONTAINERS ->
                            shipBuilder.withMaxHeavyContainers(Integer.parseInt(fieldData[1]));
                    case FIELD_MAX_TOTAL_CONTAINERS ->
                            shipBuilder.withMaxTotalContainers(Integer.parseInt(fieldData[1]));
                    case FIELD_MAX_CARGO_WEIGHT -> shipBuilder.withMaxCargoWeight(Integer.parseInt(fieldData[1]));
                }
            }

            List<Container> containers = new ArrayList<>();

            while (!lines.isEmpty() && !lines.getFirst().startsWith(SHIP)) {
                containers.add(readContainer());
            }

            ships.add(shipBuilder.withContainers(containers).build());
        }

        Harbor.getInstance().setShips(ships);
    }
}
