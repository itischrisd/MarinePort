package ui.input;

import ui.component.Component;

/**
 * Represents a component that reads user input.
 *
 * @param <T> The type of the input
 */
public interface Input<T> extends Component {

    /**
     * Collects the input from the user.
     *
     * @return The input
     */
    T collect();
}
