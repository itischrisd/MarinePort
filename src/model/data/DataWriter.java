package model.data;

import model.Harbor;
import model.container.Container;
import model.container.ContainerSerializer;
import model.sender.Sender;
import model.sender.SenderSerializer;
import model.ship.Ship;
import model.ship.ShipSerializer;
import model.time.Clock;

import java.io.File;
import java.util.List;

public class DataWriter {

    public void writeToFile(String filename) {

        File file = new File(filename);
        if (file.exists()) {
            file.delete();
        }

        write("STAN PORTU PRZEŁADUNKOWEGO");
        write("Bieżąca data: " + Clock.getDate());
        write("");
        write("Nadawcy");

        for (Sender sender : Harbor.getInstance().getSenders()) {
            writeSender(sender);
        }

        write("");
        write("Statki");

        for (Ship ship : Harbor.getInstance().getShips()) {
            writeShip(ship);
        }

        write("");
        write("Pociąg");

        for (Container container : Harbor.getInstance().getTrain().getContainers()) {
            writeContainer(container);
        }
    }

    private void writeSender(Sender sender) {
        List<String> serializedSender = SenderSerializer.serialize(sender);
        write(serializedSender);
    }

    private void writeShip(Ship ship) {
        List<String> serializedShip = ShipSerializer.serialize(ship);
        write(serializedShip);
        List<Container> containers = ship.getContainers();
        for (Container container : containers) {
            writeContainer(container);
        }
    }

    private void writeContainer(Container container) {
        List<String> serializedContainer = ContainerSerializer.serialize(container);
        write(serializedContainer);
    }

    private static void write(List<String> text) {
        for (String token : text) {
            System.out.print(token + " ");
        }
        System.out.println();
    }

    private static void write(String text) {
        System.out.println(text);
    }
}
