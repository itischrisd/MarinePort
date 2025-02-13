package view;

import model.container.Container;
import ui.component.Component;
import ui.component.LineComponent;
import ui.core.View;
import ui.input.IntegerInput;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static lang.Interface.*;

public class UtilizationView extends View<Integer> {

    private static final String TITLE = WAREHOUSE_CONTAINERS_HEADER;
    private static final Component TITLE_COMPONENT = new LineComponent(TITLE);

    public UtilizationView(Map<Container, LocalDate> items) {
        super(
                List.of(
                        TITLE_COMPONENT,
                        new WarehouseContainersView(items)
                ),
                new IntegerInput(
                        UTILIZATION_PROMPT,
                        INVALID_CONTAINER_ID,
                        number -> items.keySet().stream().anyMatch(container -> container.getId() == number)
                )
        );
    }
}
