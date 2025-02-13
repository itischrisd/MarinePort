package ui.component;

import java.util.List;
import java.util.function.Function;

import static ui.core.IOProvider.getPrinter;

/**
 * A component that displays list of items in a formatted table.
 *
 * @param <T> The type of items to display
 */
public class TableComponent<T> implements Component {

    private final List<ColumnDefinition<T>> columns;
    private final List<T> data;
    private final List<Integer> columnWidths;

    /**
     * Creates a new table component.
     *
     * @param columns The columns of the table
     * @param data The data to display
     */
    public TableComponent(List<ColumnDefinition<T>> columns, List<T> data) {
        this.columns = columns;
        this.data = data;
        this.columnWidths = calculateColumnWidths();
    }

    @Override
    public void display() {
        getPrinter().println("+-" + String.join("-+-", columnWidths.stream().map("-"::repeat).toList()) + "-+");

        StringBuilder header = new StringBuilder("| ");
        for (int i = 0; i < columns.size(); i++) {
            header.append(formatValue(columns.get(i).header(), columnWidths.get(i))).append(" | ");
        }
        getPrinter().println(header);

        getPrinter().println("+-" + String.join("-+-", columnWidths.stream().map("-"::repeat).toList()) + "-+");

        for (T datum : data) {
            StringBuilder row = new StringBuilder("| ");
            for (int j = 0; j < columns.size(); j++) {
                row.append(formatValue(columns.get(j).valueGetter().apply(datum).toString(), columnWidths.get(j))).append(" | ");
            }
            getPrinter().println(row);
        }

        getPrinter().println("+-" + String.join("-+-", columnWidths.stream().map("-"::repeat).toList()) + "-+");
    }

    private List<Integer> calculateColumnWidths() {
        if (data.isEmpty()) {
            return columns.stream()
                    .map(c -> c.header.length())
                    .toList();
        } else {
            return columns.stream()
                    .map(c -> data.stream()
                            .map(e -> c.valueGetter().apply(e).toString().length())
                            .max(Integer::compareTo)
                            .map(max -> Math.max(max, c.header.length()))
                            .orElse(0))
                    .toList();
        }
    }

    private String formatValue(String value, int width) {
        return String.format("%-" + width + "s", value);
    }

    /**
     * A definition of a column in a table.
     *
     * @param header The header of the column
     * @param valueGetter The function that gets the value of the column for a given item
     * @param <T> The type of items in the table
     */
    public record ColumnDefinition<T>(String header, Function<T, Object> valueGetter) {
    }
}
