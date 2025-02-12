package ui.input;

import ui.core.IOProvider;

import java.util.function.Function;

public class StringInput implements Input<String> {

    private final String prompt;
    private final String errorMessage;
    private final Function<String, Boolean> validator;

    public StringInput(String prompt) {
        this.prompt = prompt;
        this.errorMessage = null;
        this.validator = null;
    }

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
