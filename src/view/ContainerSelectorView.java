package view;

import model.container.Container;
import ui.component.LineComponent;
import ui.component.ListComponent;
import ui.core.View;
import ui.input.IntegerInput;

import java.util.List;

import static lang.Data.CONTAINER_CLASS_NAMES_MAP;
import static lang.Interface.*;

public class ContainerSelectorView extends View<Integer> {

    public ContainerSelectorView(List<Container> containers) {
        super(
                List.of(
                        new LineComponent(CONTAINERS_LIST_HEADER),
                        new ListComponent<>(
                                containers,
                                container -> String.format(CONTAINER_LIST_FORMAT, container.getId(), CONTAINER_CLASS_NAMES_MAP.get(container.getClass()), container.getWeight(), container.getSender().getPesel())
                        )
                )
                , new IntegerInput(
                        CONTAINER_ID_PROMPT,
                        INVALID_CONTAINER_ID,
                        number -> containers.stream().anyMatch(container -> container.getId() == number)
                )
        );
    }
}
