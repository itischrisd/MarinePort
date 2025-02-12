package view;

import model.container.Container;
import ui.component.TableComponent;

import java.util.List;

import static lang.Data.CONTAINER_CLASS_NAMES;

public class ContainersView extends TableComponent<Container> {

    private static final List<ColumnDefinition<Container>> COLUMNS = List.of(
            new ColumnDefinition<>("ID", Container::getId),
            new ColumnDefinition<>("Typ", e -> CONTAINER_CLASS_NAMES.get(e.getClass())),
            new ColumnDefinition<>("Waga", Container::getWeight)
    );

    public ContainersView(List<Container> items) {
        super(COLUMNS, items);
    }
}
