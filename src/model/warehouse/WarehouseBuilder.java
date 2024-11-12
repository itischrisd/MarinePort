package model.warehouse;

import model.container.Container;

import java.time.LocalDate;
import java.util.LinkedHashMap;
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
        warehouse.setContainers(new LinkedHashMap<>(containers));
        return this;
    }

    public Warehouse build() {
        if (this.warehouse == null) {
            throw new IllegalStateException("This builder has already built a warehouse.");
        }
        Warehouse builtWarehouse = this.warehouse;
        this.warehouse = null;
        return builtWarehouse;
    }
}
