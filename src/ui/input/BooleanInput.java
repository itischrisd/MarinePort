package ui.input;

import ui.core.IOProvider;

import java.util.function.Function;

public class BooleanInput implements Input<Boolean> {

    private final String prompt;
    private final String errorMessage;
    private final Function<Boolean, Boolean> validator;

    public BooleanInput(String prompt) {
        this.prompt = prompt;
        this.errorMessage = null;
        this.validator = null;
    }

    public BooleanInput(String prompt, String errorMessage) {
        this.prompt = prompt;
        this.errorMessage = errorMessage;
        this.validator = null;
    }

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
            try {
                Boolean bool = Boolean.parseBoolean(input);
                if (validator == null || validator.apply(bool)) {
                    return bool;
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
