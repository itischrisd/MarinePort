package view;

import lang.Interface;
import ui.component.Component;
import ui.component.LineComponent;
import ui.component.ListComponent;
import ui.core.View;
import ui.input.Input;
import ui.input.IntegerInput;

import java.util.List;
import java.util.Objects;

import static lang.Interface.*;

public class MainMenuView extends View<Integer> {

    private static final String MENU_TITLE = Interface.MENU_TITLE;
    private static final List<String> MENU_ITEMS = List.of(
            MENU_ITEM_CREATE_SHIP,
            MENU_ITEM_CREATE_CONTAINER,
            MENU_ITEM_DISPLAY_SHIPS,
            MENU_ITEM_DISPLAY_CONTAINERS_IN_SHIP,
            MENU_ITEM_DISPLAY_WAREHOUSE,
            MENU_ITEM_DISPLAY_TRAIN,
            MENU_ITEM_DISPLAY_SENDERS,
            MENU_ITEM_UTILIZE_CONTAINER,
            MENU_ITEM_SEND_SHIP,
            MENU_ITEM_SAVE,
            MENU_ITEM_LOAD,
            MENU_ITEM_EXIT
    );
    private static final Component TITLE_COMPONENT = new LineComponent(MENU_TITLE);
    private static final Component MENU_COMPONENT = new ListComponent<>(MENU_ITEMS, Objects::toString);
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
