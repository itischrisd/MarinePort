package ui.core;

import ui.component.Component;
import ui.input.Input;

import java.util.List;

/**
 * A view that is composed of multiple dispayable components and an input.
 *
 * @param <T> The type of input to collect
 */
public class View<T> implements Component, Input<T> {

    private final List<Component> components;
    private final Input<T> input;

    /**
     * Creates a new view.
     *
     * @param components The components to display
     * @param input The input to collect
     */
    public View(List<Component> components, Input<T> input) {
        this.components = components;
        this.input = input;
    }

    @Override
    public void display() {
        for (Component component : components) {
            component.display();
        }
    }

    @Override
    public T collect() {
        return input.collect();
    }
}
