package view;

import model.container.Container;
import ui.component.TableComponent;

import java.util.List;

import static lang.Data.*;

public class ContainersTableComponent extends TableComponent<Container> {

    private static final List<ColumnDefinition<Container>> COLUMNS = List.of(
            new ColumnDefinition<>(FIELD_ID, Container::getId),
            new ColumnDefinition<>(FIELD_TYPE, e -> CONTAINER_CLASS_NAMES_MAP.get(e.getClass())),
            new ColumnDefinition<>(FIELD_WEIGHT, Container::getWeight)
    );

    public ContainersTableComponent(List<Container> items) {
        super(COLUMNS, items);
    }
}
