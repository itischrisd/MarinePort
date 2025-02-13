package ui.component;

import java.util.List;
import java.util.function.Function;

import static ui.core.IOProvider.getPrinter;

/**
 * A component that displays a numbered list of items.
 *
 * @param <T> The type of items to display
 */
public class ListComponent<T> implements Component {

    private final List<T> items;
    private final Function<T, Object> formatter;

    /**
     * Creates a new list component.
     *
     * @param items The items to display
     * @param formatter The function that maps items to their string representation
     */
    public ListComponent(List<T> items, Function<T, Object> formatter) {
        this.items = items;
        this.formatter = formatter;
    }

    @Override
    public void display() {
        for (int i = 0; i < items.size(); i++) {
            getPrinter().println((i + 1) + ". " + formatter.apply(items.get(i)));
        }
    }
}
