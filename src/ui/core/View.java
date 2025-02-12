package ui.core;

import ui.component.Component;
import ui.input.Input;

import java.util.List;

public class View<T> implements Component, Input<T> {

    private final List<Component> components;
    private final Input<T> input;

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
