package ui.component;

import java.util.List;
import java.util.function.Function;

import static ui.core.IOProvider.getPrinter;


public class ListComponent<T> implements Component {

    private final List<T> items;
    private final Function<T, Object> formatter;

    /**
     * Creates a new list component.
     *
     * @param items The items to display
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
