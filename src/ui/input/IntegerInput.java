package ui.input;

import ui.core.IOProvider;

import java.util.function.Function;

/**
 * An input that collects an integer value from the user.
 */
public class IntegerInput implements Input<Integer> {

    private final String prompt;
    private final String errorMessage;
    private final Function<Integer, Boolean> validator;

    /**
     * Creates a new integer input.
     *
     * @param prompt The prompt to display to the user
     */
    public IntegerInput(String prompt) {
        this.prompt = prompt;
        this.errorMessage = null;
        this.validator = null;
    }

    /**
     * Creates a new integer input.
     *
     * @param prompt The prompt to display to the user
     * @param errorMessage The error message to display if the input is invalid
     */
    public IntegerInput(String prompt, String errorMessage) {
        this.prompt = prompt;
        this.errorMessage = errorMessage;
        this.validator = null;
    }

    /**
     * Creates a new integer input.
     *
     * @param prompt The prompt to display to the user
     * @param errorMessage The error message to display if the input is invalid
     * @param validator The validator function to apply to the input
     */
    public IntegerInput(String prompt, String errorMessage, Function<Integer, Boolean> validator) {
        this.prompt = prompt;
        this.errorMessage = errorMessage;
        this.validator = validator;
    }

    @Override
    public Integer collect() {
        display();
        String input = IOProvider.getScanner().nextLine();
        while (true) {
            try {
                Integer number = Integer.parseInt(input);
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
