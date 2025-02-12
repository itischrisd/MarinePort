package ui.component;

import static ui.core.IOProvider.getPrinter;

public class LineComponent implements Component {

    private final String line;

    public LineComponent(String line) {
        this.line = line;
    }

    @Override
    public void display() {
        getPrinter().println(line);
    }
}
