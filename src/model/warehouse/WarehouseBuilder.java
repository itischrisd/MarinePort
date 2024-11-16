package model.warehouse;

import model.container.Container;

import java.time.LocalDate;
import java.util.Map;

public class WarehouseBuilder {

    private Warehouse warehouse;

    private WarehouseBuilder() {
        this.warehouse = new Warehouse();
    }

    public static WarehouseBuilder warehouse() {
        return new WarehouseBuilder();
    }

    public WarehouseBuilder withMaxContainers(int maxContainers) {
        warehouse.setMaxContainers(maxContainers);
        return this;
    }

    public WarehouseBuilder withContainers(Map<Container, LocalDate> containers) {
        warehouse.setContainers(containers);
        return this;
    }

    public Warehouse build() {
        if (this.warehouse == null) {
            throw new IllegalStateException("This builder has already built a warehouse.");
        }
        if (isInvalidWarehouse()) {
            throw new IllegalStateException("Invalid warehouse - not all required fields are set.");
        }
        Warehouse builtWarehouse = this.warehouse;
        this.warehouse = null;
        return builtWarehouse;
    }

    private boolean isInvalidWarehouse() {
        return warehouse.getMaxContainers() <= 0 || warehouse.getContainers() == null;
    }
}
