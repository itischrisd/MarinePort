package ui.input;

import ui.core.IOProvider;

import java.util.function.Function;

/**
 * An input that collects a double value from the user.
 */
public class DoubleInput implements Input<Double> {

    private final String prompt;
    private final String errorMessage;
    private final Function<Double, Boolean> validator;

    /**
     * Creates a new double input.
     *
     * @param prompt The prompt to display to the user
     */
    public DoubleInput(String prompt) {
        this.prompt = prompt;
        this.errorMessage = null;
        this.validator = null;
    }

    /**
     * Creates a new double input.
     *
     * @param prompt The prompt to display to the user
     * @param errorMessage The error message to display if the input is invalid
     */
    public DoubleInput(String prompt, String errorMessage) {
        this.prompt = prompt;
        this.errorMessage = errorMessage;
        this.validator = null;
    }

    /**
     * Creates a new double input.
     *
     * @param prompt The prompt to display to the user
     * @param errorMessage The error message to display if the input is invalid
     * @param validator The validator function to apply to the input
     */
    public DoubleInput(String prompt, String errorMessage, Function<Double, Boolean> validator) {
        this.prompt = prompt;
        this.errorMessage = errorMessage;
        this.validator = validator;
    }

    @Override
    public Double collect() {
        display();
        String input = IOProvider.getScanner().nextLine();
        while (true) {
            try {
                Double number = Double.parseDouble(input);
                if (validator == null || validator.apply(number)) {
                    return number;
                }
                IOProvider.getPrinter().println(errorMessage == null ? prompt : errorMessage);
                input = IOProvider.getScanner().nextLine();
            } catch (NumberFormatException e) {
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
