package ui.component;

import static ui.core.IOProvider.getPrinter;

/**
 * A component that displays a single line of text.
 */
public class LineComponent implements Component {

    private final String line;

    /**
     * Creates a new line component.
     * @param line The line to display
     */
    public LineComponent(String line) {
        this.line = line;
    }

    @Override
    public void display() {
        getPrinter().println(line);
    }
}
