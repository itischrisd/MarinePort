package view;

import ui.component.LineComponent;
import ui.component.ListComponent;
import ui.core.View;
import ui.input.Input;
import ui.input.IntegerInput;

import java.util.List;
import java.util.Objects;

import static lang.Menu.*;

public class MainMenuView extends View<Integer> {

    private static final String MENU_TITLE = TITLE;
    private static final List<String> MENU_ITEMS = List.of(
            ITEM_CREATE_SHIP,
            ITEM_CREATE_CONTAINER,
            ITEM_DISPLAY_SHIPS,
            ITEM_DISPLAY_CONTAINERS_IN_SHIP,
            ITEM_DISPLAY_WAREHOUSE,
            ITEM_DISPLAY_TRAIN,
            ITEM_DISPLAY_SENDERS,
            ITEM_UTILIZE_CONTAINER,
            ITEM_SEND_SHIP,
            ITEM_SAVE,
            ITEM_LOAD,
            ITEM_EXIT
    );
    private static final LineComponent TITLE_COMPONENT = new LineComponent(MENU_TITLE);
    private static final ListComponent<String> MENU_COMPONENT = new ListComponent<>(MENU_ITEMS, Objects::toString);
    private static final Input<Integer> INPUT = new IntegerInput(
            PROMPT,
            INVALID_OPTION,
            number -> number >= 1 && number <= MENU_ITEMS.size()
    );

    public MainMenuView() {
        super(
                List.of(
                        TITLE_COMPONENT,
                        MENU_COMPONENT
                ),
                INPUT
        );
    }
}
