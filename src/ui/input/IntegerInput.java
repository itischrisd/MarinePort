package ui.input;

import ui.core.IOProvider;

import java.util.function.Function;

public class IntegerInput implements Input<Integer> {

    private final String prompt;
    private final String errorMessage;
    private final Function<Integer, Boolean> validator;

    public IntegerInput(String prompt) {
        this.prompt = prompt;
        this.errorMessage = null;
        this.validator = null;
    }

    public IntegerInput(String prompt, String errorMessage) {
        this.prompt = prompt;
        this.errorMessage = errorMessage;
        this.validator = null;
    }

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
