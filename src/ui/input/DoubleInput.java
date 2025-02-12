package ui.input;

import ui.core.IOProvider;

import java.util.function.Function;

public class DoubleInput implements Input<Double> {

    private final String prompt;
    private final String errorMessage;
    private final Function<Double, Boolean> validator;

    public DoubleInput(String prompt) {
        this.prompt = prompt;
        this.errorMessage = null;
        this.validator = null;
    }

    public DoubleInput(String prompt, String errorMessage) {
        this.prompt = prompt;
        this.errorMessage = errorMessage;
        this.validator = null;
    }

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
