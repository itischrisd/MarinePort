package ui.core;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Provides access to input and output objects.
 * This class is a singleton.
 */
public class IOProvider {

    private static IOProvider instance;
    private final PrintStream out;
    private final Scanner in;

    private IOProvider() {
        this.out = System.out;
        this.in = new Scanner(System.in);
    }

    private IOProvider(PrintStream out, Scanner in) {
        this.out = out;
        this.in = in;
    }

    /**
     * Gets the output stream.
     *
     * @return The output stream
     */
    public static PrintStream getPrinter() {
        if (instance == null) {
            instance = new IOProvider();
        }
        return instance.out;
    }

    /**
     * Gets the global Scanner object.
     *
     * @return The Scanner object
     */
    public static Scanner getScanner() {
        if (instance == null) {
            instance = new IOProvider();
        }
        return instance.in;
    }

    /**
     * Initializes global IOProvider object for the view components to use
     * @param out The output stream
     * @param in The input scanner
     */
    public static void init(PrintStream out, Scanner in) {
        if (instance != null) {
            throw new IllegalStateException("IOProvider already initialized!");
        }
        instance = new IOProvider(out, in);
    }
}
