package model.warehouse;

import java.util.ArrayList;
import java.util.List;

public class WarehouseSerializer {

    public static List<String> serialize(Warehouse warehouse) {
        List<String> serializedWarehouse = new ArrayList<>();
        serializedWarehouse.add(String.valueOf(warehouse.getMaxContainers()));
        return serializedWarehouse;
    }
}