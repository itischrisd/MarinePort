import model.Harbor;
import model.data.DataCreator;
import model.data.DataWriter;
import model.exception.TooManyContainersException;
import model.ship.Ship;
import model.time.Clock;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws TooManyContainersException, InterruptedException {

        DataCreator.createExampleData();
        Clock clock = new Clock(LocalDate.now().minusDays(5));

        for (Ship ship : Harbor.getInstance().getShips()) {
            ship.sortContainersByWeight();
        }
        Harbor.getInstance().sortShipsByNameDescending();
        Harbor.getInstance().getWarehouse().sortContainers();


        DataWriter dataWriter = new DataWriter();
        dataWriter.writeToFile("stan_portu.txt");
    }
}