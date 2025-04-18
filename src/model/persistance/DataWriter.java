package model.persistance;

import model.Harbor;
import model.container.*;
import model.exception.IrresponsibleSenderWithDangerousGoods;
import model.ship.Ship;
import model.time.Clock;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Paths;

import static lang.Data.*;
import static lang.ErrorMessage.WRITING_FILE;

public class DataWriter {

    private static PrintWriter printWriter;

    public static void writeToFile(String filename) {
        File file = Paths.get(filename).toFile();

        Harbor.getInstance().getShips().forEach(Ship::sortContainersByWeight);
        Harbor.getInstance().sortShipsByNameDescending();
        Harbor.getInstance().getWarehouse().sortContainers();

        try (PrintWriter newPrintWriter = new PrintWriter(file)) {
            printWriter = newPrintWriter;
            writeHeader();
            writeSenders();
            writeWarehouse();
            writeTrain();
            writeShips();
        } catch (Exception e) {
            throw new RuntimeException(WRITING_FILE);
        }
    }

    private static void writeHeader() {
        printWriter.println(TITLE_DOCUMENT);
        printWriter.println(FIELD_LOCAL_DATE + FIELD_NAME_DELIMITER + Clock.getDate());
    }

    private static void writeSenders() {
        printWriter.println(TITLE_SENDERS);

        for (var sender : Harbor.getInstance().getSenders()) {
            printWriter.print(SENDER + CLASS_NAME_DELIMITER);
            printWriter.print(FIELD_SENDER_NAME + FIELD_NAME_DELIMITER + sender.getName() + FIELD_DELIMITER);
            printWriter.print(FIELD_SENDER_SURNAME + FIELD_NAME_DELIMITER + sender.getSurname() + FIELD_DELIMITER);
            printWriter.print(FIELD_SENDER_PESEL + FIELD_NAME_DELIMITER + sender.getPesel() + FIELD_DELIMITER);
            printWriter.print(FIELD_ADDRESS + FIELD_NAME_DELIMITER + sender.getAddress() + FIELD_DELIMITER);
            printWriter.print(FIELD_BIRTH_DATE + FIELD_NAME_DELIMITER + sender.getBirthDate() + FIELD_DELIMITER);
            printWriter.print(FIELD_WARNING_COUNT + FIELD_NAME_DELIMITER + sender.getWarningsCount() + FIELD_DELIMITER);
            sender.getWarnings().forEach(DataWriter::writeWarning);
            printWriter.println();
        }
    }

    private static void writeWarning(IrresponsibleSenderWithDangerousGoods warning) {
        printWriter.println();
        printWriter.print(WARNING + CLASS_NAME_DELIMITER);
        printWriter.print(FIELD_ID + FIELD_NAME_DELIMITER + warning.getId() + FIELD_DELIMITER);
        printWriter.print(FIELD_ARRIVAL_DATE + FIELD_NAME_DELIMITER + warning.getArrivalDate() + FIELD_DELIMITER);
        printWriter.print(FIELD_UTILIZATION_DATE + FIELD_NAME_DELIMITER + warning.getUtilizationDate() + FIELD_DELIMITER);
    }

    private static void writeWarehouse() {
        printWriter.println(TITLE_WAREHOUSE);
        printWriter.println(FIELD_MAX_CONTAINERS + FIELD_NAME_DELIMITER + Harbor.getInstance().getWarehouse().getMaxContainers());

        for (var warehouseContainer : Harbor.getInstance().getWarehouse().getContainers().entrySet()) {
            writeContainer(warehouseContainer.getKey());
            printWriter.println(FIELD_STORING_DATE + FIELD_NAME_DELIMITER + warehouseContainer.getValue());
        }
    }

    private static void writeContainer(Container container) {
        switch (container) {
            case LooseToxicContainer looseToxicContainer -> writeLooseToxicContainer(looseToxicContainer);
            case LiquidToxicContainer liquidToxicContainer -> writeLiquidToxicContainer(liquidToxicContainer);
            case ToxicContainer toxicContainer -> writeToxicContainer(toxicContainer);
            case LiquidContainer liquidContainer -> writeLiquidContainer(liquidContainer);
            case ExplosiveContainer explosiveContainer -> writeExplosiveContainer(explosiveContainer);
            case RefrigeratedContainer refrigeratedContainer -> writeRefrigeratedContainer(refrigeratedContainer);
            case HeavyContainer heavyContainer -> writeHeavyContainer(heavyContainer);
            default -> writeCommonContainer(container);
        }
    }

    private static void writeLooseToxicContainer(LooseToxicContainer container) {
        printWriter.print(CONTAINER_LOOSE_TOXIC + CLASS_NAME_DELIMITER);
        writeCommonFields(container);
        printWriter.print(FIELD_TARE_WEIGHT + FIELD_NAME_DELIMITER + container.getTareWeight() + FIELD_DELIMITER);
        printWriter.print(FIELD_TOXICITY_LEVEL + FIELD_NAME_DELIMITER + container.getToxicityLevel() + FIELD_DELIMITER);
        printWriter.print(FIELD_LOOSE_TOXIC_CONTAINER_FEATURES + FIELD_NAME_DELIMITER);
        container.getLooseToxicContainerFeatures().forEach(feature -> printWriter.print(feature + FIELD_VALUE_DELIMITER));
        printWriter.println();
    }

    private static void writeLiquidToxicContainer(LiquidToxicContainer container) {
        printWriter.print(CONTAINER_LIQUID_TOXIC + CLASS_NAME_DELIMITER);
        writeCommonFields(container);
        printWriter.print(FIELD_TARE_WEIGHT + FIELD_NAME_DELIMITER + container.getTareWeight() + FIELD_DELIMITER);
        printWriter.print(FIELD_TOXICITY_LEVEL + FIELD_NAME_DELIMITER + container.getToxicityLevel() + FIELD_DELIMITER);
        printWriter.print(FIELD_LIQUID_VOLUME + FIELD_NAME_DELIMITER + container.getLiquidVolume() + FIELD_DELIMITER);
        printWriter.println();
    }

    private static void writeToxicContainer(ToxicContainer container) {
        printWriter.print(CONTAINER_COMMON + CLASS_NAME_DELIMITER);
        writeCommonFields(container);
        printWriter.print(FIELD_TARE_WEIGHT + FIELD_NAME_DELIMITER + container.getTareWeight() + FIELD_DELIMITER);
        printWriter.print(FIELD_TOXICITY_LEVEL + FIELD_NAME_DELIMITER + container.getToxicityLevel() + FIELD_DELIMITER);
        printWriter.println();
    }

    private static void writeLiquidContainer(LiquidContainer container) {
        printWriter.print(CONTAINER_LIQUID + CLASS_NAME_DELIMITER);
        writeCommonFields(container);
        printWriter.print(FIELD_LIQUID_VOLUME + FIELD_NAME_DELIMITER + container.getLiquidVolume() + FIELD_DELIMITER);
        printWriter.println();
    }

    private static void writeExplosiveContainer(ExplosiveContainer container) {
        printWriter.print(CONTAINER_EXPLOSIVE + CLASS_NAME_DELIMITER);
        writeCommonFields(container);
        printWriter.print(FIELD_TARE_WEIGHT + FIELD_NAME_DELIMITER + container.getTareWeight() + FIELD_DELIMITER);
        printWriter.print(FIELD_ADDITIONAL_PROTECTION + FIELD_NAME_DELIMITER + container.getAdditionalProtection() + FIELD_DELIMITER);
        printWriter.println();
    }

    private static void writeRefrigeratedContainer(RefrigeratedContainer container) {
        printWriter.print(CONTAINER_REFRIGERATED + CLASS_NAME_DELIMITER);
        writeCommonFields(container);
        printWriter.print(FIELD_TARE_WEIGHT + FIELD_NAME_DELIMITER + container.getTareWeight() + FIELD_DELIMITER);
        printWriter.print(FIELD_CONNECTED_TO_POWER + FIELD_NAME_DELIMITER + fromBoolean(container.isConnectedToPower()) + FIELD_DELIMITER);
        printWriter.println();
    }

    private static void writeHeavyContainer(HeavyContainer container) {
        printWriter.print(CONTAINER_HEAVY + CLASS_NAME_DELIMITER);
        writeCommonFields(container);
        printWriter.print(FIELD_TARE_WEIGHT + FIELD_NAME_DELIMITER + container.getTareWeight() + FIELD_DELIMITER);
        printWriter.println();
    }

    private static void writeCommonContainer(Container container) {
        printWriter.print(CONTAINER_COMMON + CLASS_NAME_DELIMITER);
        writeCommonFields(container);
        printWriter.println();
    }

    private static void writeCommonFields(Container container) {
        printWriter.print(FIELD_ID + FIELD_NAME_DELIMITER + container.getId() + FIELD_DELIMITER);
        printWriter.print(FIELD_WEIGHT + FIELD_NAME_DELIMITER + container.getWeight() + FIELD_DELIMITER);
        printWriter.print(FIELD_SENDER_PESEL + FIELD_NAME_DELIMITER + container.getSender().getPesel() + FIELD_DELIMITER);
    }

    private static void writeTrain() {
        printWriter.println(TITLE_TRAIN);
        Harbor.getInstance().getTrain().getContainers().forEach(DataWriter::writeContainer);
    }

    private static void writeShips() {
        printWriter.println(TITLE_SHIPS);

        for (var ship : Harbor.getInstance().getShips()) {
            printWriter.print(SHIP + CLASS_NAME_DELIMITER);
            printWriter.print(FIELD_ID + FIELD_NAME_DELIMITER + ship.getId() + FIELD_DELIMITER);
            printWriter.print(FIELD_SHIP_NAME + FIELD_NAME_DELIMITER + ship.getName() + FIELD_DELIMITER);
            printWriter.print(FIELD_ORIGIN_PORT + FIELD_NAME_DELIMITER + ship.getOriginPort() + FIELD_DELIMITER);
            printWriter.print(FIELD_CARGO_ORIGIN + FIELD_NAME_DELIMITER + ship.getCargoOrigin() + FIELD_DELIMITER);
            printWriter.print(FIELD_CARGO_DESTINATION + FIELD_NAME_DELIMITER + ship.getCargoDestination() + FIELD_DELIMITER);
            printWriter.print(FIELD_MAX_TOXIC_OR_EXPLOSIVE_CONTAINERS + FIELD_NAME_DELIMITER + ship.getMaxToxicOrExplosiveContainers() + FIELD_DELIMITER);
            printWriter.print(FIELD_MAX_CONTAINERS_REQUIRING_ELECTRICITY + FIELD_NAME_DELIMITER + ship.getMaxContainersRequiringElectricity() + FIELD_DELIMITER);
            printWriter.print(FIELD_MAX_HEAVY_CONTAINERS + FIELD_NAME_DELIMITER + ship.getMaxHeavyContainers() + FIELD_DELIMITER);
            printWriter.print(FIELD_MAX_TOTAL_CONTAINERS + FIELD_NAME_DELIMITER + ship.getMaxTotalContainers() + FIELD_DELIMITER);
            printWriter.print(FIELD_MAX_CARGO_WEIGHT + FIELD_NAME_DELIMITER + ship.getMaxCargoWeight() + FIELD_DELIMITER);
            printWriter.println();
            ship.getContainers().forEach(DataWriter::writeContainer);
        }
    }
}
