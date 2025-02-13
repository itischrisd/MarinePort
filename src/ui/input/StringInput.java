package ui.input;

import ui.core.IOProvider;

import java.util.function.Function;

/**
 * An input that collects a string value from the user.
 */
public class StringInput implements Input<String> {

    private final String prompt;
    private final String errorMessage;
    private final Function<String, Boolean> validator;

    /**
     * Creates a new string input.
     *
     * @param prompt The prompt to display to the user
     */
    public StringInput(String prompt) {
        this.prompt = prompt;
        this.errorMessage = null;
        this.validator = null;
    }

    /**
     * Creates a new string input.
     *
     * @param prompt The prompt to display to the user
     * @param errorMessage The error message to display if the input is invalid
     * @param validator The validator function to apply to the input
     */
    public StringInput(String prompt, String errorMessage, Function<String, Boolean> validator) {
        this.prompt = prompt;
        this.errorMessage = errorMessage;
        this.validator = validator;
    }

    @Override
    public String collect() {
        display();
        String input = IOProvider.getScanner().nextLine();
        while (true) {
            if (validator == null || validator.apply(input)) {
                return input;
            }
            IOProvider.getPrinter().println(errorMessage == null ? prompt : errorMessage);
            input = IOProvider.getScanner().nextLine();
        }
    }

    @Override
    public void display() {
        System.out.println(prompt);
    }
}
