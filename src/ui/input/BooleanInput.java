package ui.input;

import ui.core.IOProvider;

import java.util.List;
import java.util.function.Function;

/**
 * An input that collects a boolean value from the user.
 */
public class BooleanInput implements Input<Boolean> {

    private final String prompt;
    private final String errorMessage;
    private final Function<Boolean, Boolean> validator;

    private static final List<String> TRUE_VALUES = List.of("true", "t", "yes", "y", "1", "on", "tak", "prawda", "p");
    private static final List<String> FALSE_VALUES = List.of("false", "f", "no", "n", "0", "off", "nie", "fałsz");

    /**
     * Creates a new boolean input.
     *
     * @param prompt The prompt to display to the user
     */
    public BooleanInput(String prompt) {
        this.prompt = prompt;
        this.errorMessage = null;
        this.validator = null;
    }

    /**
     * Creates a new boolean input.
     *
     * @param prompt The prompt to display to the user
     * @param errorMessage The error message to display if the input is invalid
     */
    public BooleanInput(String prompt, String errorMessage) {
        this.prompt = prompt;
        this.errorMessage = errorMessage;
        this.validator = null;
    }

    /**
     * Creates a new boolean input.
     *
     * @param prompt The prompt to display to the user
     * @param errorMessage The error message to display if the input is invalid
     * @param validator The validator function to apply to the input
     */
    public BooleanInput(String prompt, String errorMessage, Function<Boolean, Boolean> validator) {
        this.prompt = prompt;
        this.errorMessage = errorMessage;
        this.validator = validator;
    }

    @Override
    public Boolean collect() {
        display();
        String input = IOProvider.getScanner().nextLine();
        while (true) {
            boolean value;
            if (TRUE_VALUES.contains(input.toLowerCase())) {
                value = true;
            } else if (FALSE_VALUES.contains(input.toLowerCase())) {
                value = false;
            } else {
                IOProvider.getPrinter().println(errorMessage == null ? prompt : errorMessage);
                input = IOProvider.getScanner().nextLine();
                continue;
            }
            if (validator == null || validator.apply(value)) {
                return value;
            } else {
                IOProvider.getPrinter().println(errorMessage == null ? prompt : errorMessage);
                input = IOProvider.getScanner().nextLine();
            }
        }
    }

    @Override
    public void display() {
        IOProvider.getPrinter().println(prompt);
    }
}
