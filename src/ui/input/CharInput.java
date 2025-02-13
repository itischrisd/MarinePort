package ui.input;

import ui.core.IOProvider;

import java.util.function.Function;

/**
 * An input that collects a character value from the user.
 */
public class CharInput implements Input<Character> {

    private final String prompt;
    private final String errorMessage;
    private final Function<Character, Boolean> validator;

    /**
     * Creates a new character input.
     *
     * @param prompt The prompt to display to the user
     */
    public CharInput(String prompt) {
        this.prompt = prompt;
        this.errorMessage = null;
        this.validator = null;
    }

    /**
     * Creates a new character input.
     *
     * @param prompt The prompt to display to the user
     * @param errorMessage The error message to display if the input is invalid
     */
    public CharInput(String prompt, String errorMessage) {
        this.prompt = prompt;
        this.errorMessage = errorMessage;
        this.validator = null;
    }

    /**
     * Creates a new character input.
     *
     * @param prompt The prompt to display to the user
     * @param errorMessage The error message to display if the input is invalid
     * @param validator The validator function to apply to the input
     */
    public CharInput(String prompt, String errorMessage, Function<Character, Boolean> validator) {
        this.prompt = prompt;
        this.errorMessage = errorMessage;
        this.validator = validator;
    }

    @Override
    public Character collect() {
        display();
        String input = IOProvider.getScanner().nextLine();
        while (true) {
            Character character = input.charAt(0);
            if (input.length() == 1 && (validator == null || validator.apply(character))) {
                return character;
            }
            IOProvider.getPrinter().println(errorMessage == null ? prompt : errorMessage);
            input = IOProvider.getScanner().nextLine();
        }
    }

    @Override
    public void display() {
        IOProvider.getPrinter().println(prompt);
    }
}
