package view;

import model.container.Container;
import ui.component.TableComponent;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static lang.Data.CONTAINER_CLASS_NAMES;

public class WarehouseContainersView extends TableComponent<Map.Entry<Container, LocalDate>> {

    private static final List<ColumnDefinition<Map.Entry<Container, LocalDate>>> COLUMNS = List.of(
            new ColumnDefinition<>("ID", e -> e.getKey().getId()),
            new ColumnDefinition<>("Typ", e -> CONTAINER_CLASS_NAMES.get(e.getKey().getClass())),
            new ColumnDefinition<>("Waga", e -> e.getKey().getWeight()),
            new ColumnDefinition<>("Data przyjęcia", Map.Entry::getValue)
    );

    public WarehouseContainersView(Map<Container, LocalDate> items) {
        super(COLUMNS, items.entrySet().stream().toList());
    }
}
