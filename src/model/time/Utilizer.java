package model.time;

import model.Harbor;
import model.container.Container;
import model.container.ExplosiveContainer;
import model.container.LiquidToxicContainer;
import model.container.LooseToxicContainer;
import model.exception.IrresponsibleSenderWithDangerousGoods;
import model.warehouse.Warehouse;

import java.time.LocalDate;
import java.util.Map;

public class Utilizer extends Thread {

    private final int MAX_EXPLOSIVE_TIME = 5;
    private final int MAX_LIQUID_TOXIC_TIME = 10;
    private final int MAX_LOOSE_TOXIC_TIME = 14;

    @Override
    public void run() {
        while (!interrupted()) {
            try {
                checkUtilization();
            } catch (NullPointerException e) {
                break;
            }
        }
    }

    private void checkUtilization() {
        Warehouse warehouse = Harbor.getInstance().getWarehouse();
        for (Map.Entry<Container, LocalDate> container : warehouse.getContainers().entrySet()) {
            if (container instanceof ExplosiveContainer)
                utilizeExplosiveContainer(container.getKey(), container.getValue());
            if (container instanceof LiquidToxicContainer)
                utilizeLiquidToxicContainer(container.getKey(), container.getValue());
            if (container instanceof LooseToxicContainer)
                utilizeLooseToxicContainer(container.getKey(), container.getValue());
        }
    }

    private void utilizeExplosiveContainer(Container container, LocalDate storeTime) {
        if (!storeTime.plusDays(MAX_EXPLOSIVE_TIME).isBefore(Clock.getDate())) {
            Harbor.getInstance().getWarehouse().removeContainerById(container.getId());
            try {
                throw new IrresponsibleSenderWithDangerousGoods(storeTime, Clock.getDate());
            } catch (IrresponsibleSenderWithDangerousGoods e) {
                container.getSender().addWarning(e);
            }
        }
    }

    private void utilizeLiquidToxicContainer(Container container, LocalDate storeTime) {
        if (!storeTime.plusDays(MAX_LIQUID_TOXIC_TIME).isBefore(Clock.getDate())) {
            Harbor.getInstance().getWarehouse().removeContainerById(container.getId());
            try {
                throw new IrresponsibleSenderWithDangerousGoods(storeTime, Clock.getDate());
            } catch (IrresponsibleSenderWithDangerousGoods e) {
                container.getSender().addWarning(e);
            }
        }
    }

    private void utilizeLooseToxicContainer(Container container, LocalDate storeTime) {
        if (!storeTime.plusDays(MAX_LOOSE_TOXIC_TIME).isBefore(Clock.getDate())) {
            Harbor.getInstance().getWarehouse().removeContainerById(container.getId());
            try {
                throw new IrresponsibleSenderWithDangerousGoods(storeTime, Clock.getDate());
            } catch (IrresponsibleSenderWithDangerousGoods e) {
                container.getSender().addWarning(e);
            }
        }
    }
}
