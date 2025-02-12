package view;

import model.container.Container;
import ui.component.LineComponent;
import ui.core.View;
import ui.input.IntegerInput;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class UtilizationView extends View<Integer> {

    private static final String TITLE = "Lista kontenerów w magazynie";
    private static final LineComponent TITLE_COMPONENT = new LineComponent(TITLE);

    public UtilizationView(Map<Container, LocalDate> items) {
        super(
                List.of(
                        TITLE_COMPONENT,
                        new WarehouseContainersView(items)
                ),
                new IntegerInput(
                        "Podaj ID kontenera do utylizacji",
                        "Niepoprawny numer kontenera",
                        number -> items.keySet().stream().anyMatch(container -> container.getId() == number)
                )
        );
    }
}
