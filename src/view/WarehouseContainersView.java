package view;

import model.container.Container;
import ui.component.TableComponent;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static lang.Data.*;

public class WarehouseContainersView extends TableComponent<Map.Entry<Container, LocalDate>> {

    private static final List<ColumnDefinition<Map.Entry<Container, LocalDate>>> COLUMNS = List.of(
            new ColumnDefinition<>(FIELD_ID, e -> e.getKey().getId()),
            new ColumnDefinition<>(FIELD_TYPE, e -> CONTAINER_CLASS_NAMES.get(e.getKey().getClass())),
            new ColumnDefinition<>(FIELD_WEIGHT, e -> e.getKey().getWeight()),
            new ColumnDefinition<>(FIELD_ARRIVAL_DATE, Map.Entry::getValue)
    );

    public WarehouseContainersView(Map<Container, LocalDate> items) {
        super(COLUMNS, items.entrySet().stream().toList());
    }
}
