package model.warehouse;

import model.container.Container;

import java.time.LocalDate;
import java.util.Map;

public class WarehouseBuilder {

    private Warehouse warehouse;

    public WarehouseBuilder warehouse() {
        warehouse = new Warehouse();
        return this;
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
        Warehouse warehouse = this.warehouse;
        this.warehouse = null;
        return warehouse;
    }
}
