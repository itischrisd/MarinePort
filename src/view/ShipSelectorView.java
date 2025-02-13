package view;

import model.ship.Ship;
import ui.component.LineComponent;
import ui.component.ListComponent;
import ui.core.View;
import ui.input.IntegerInput;

import java.util.List;

import static lang.Interface.*;

public class ShipSelectorView extends View<Integer> {

    public ShipSelectorView(List<Ship> ships) {
        super(
                List.of(
                        new LineComponent(SHIPS_LIST_HEADER),
                        new ListComponent<>(ships, ship -> String.format(SHIP_LIST_FORMAT, ship.getId(), ship.getName(), ship.getContainers().size()))
                )
                , new IntegerInput(
                        SHIP_ID_PROMPT,
                        INVALID_SHIP_ID,
                        number -> ships.stream().anyMatch(ship -> ship.getId() == number)
                )
        );
    }
}
