package model.time;

import model.Harbor;
import model.exception.IrresponsibleSenderWithDangerousGoods;
import model.warehouse.Warehouse;

import java.time.LocalDate;

public class Utilizer extends Thread {

    @Override
    public void run() {
        while (!interrupted()) {
            try {
                checkForOverdueContainers();
            } catch (NullPointerException e) {
                break;
            }
        }
    }

    private void checkForOverdueContainers() {
        Warehouse warehouse = Harbor.getInstance().getWarehouse();
        warehouse.getContainers().entrySet().stream().filter(warehouse::isOverdue).forEach(containerEntry -> {
            warehouse.removeContainerById(containerEntry.getKey().getId());
            try {
                LocalDate storageDate = containerEntry.getValue();
                LocalDate currentDate = Clock.getDate();
                throw new IrresponsibleSenderWithDangerousGoods(storageDate, currentDate);
            } catch (IrresponsibleSenderWithDangerousGoods e) {
                containerEntry.getKey().getSender().addWarning(e);
            }
        });
    }
}
