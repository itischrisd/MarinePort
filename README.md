<h1 align="center">
  <div>
    <img width="80" src="https://raw.githubusercontent.com/itischrisd/itis-PJATK/main/logo.svg" alt="" />
  </div>
MarinePort
</h1>

Repository that contains implementation of the 1st project for the GUI (Object Oriented-Programming and Graphical User Interface) practical classes, taught by Sławomir Dańczak during studies on [PJAIT](https://www.pja.edu.pl/en/).


---

## Description

**MarinePort** is a console-based application that simulates the operations of a marine container **transshipment terminal**. It provides an interactive command-line interface to manage ships, containers, a storage warehouse, and train transports within a virtual port environment. Users can create ships, load and unload containers, transfer containers between ships and the port's warehouse or trains, and simulate the passage of time to mimic real-world port activity.

This project was developed as an assignment for the *GUI / Object-Oriented Programming* course at **Polish-Japanese Academy of Information Technology (PJAIT)**, under the supervision of Sławomir Dańczak. The goal was to demonstrate robust object-oriented design principles in a non-GUI setting. MarinePort is built with **pure Java 21** without any external frameworks or libraries, highlighting fundamental Java features and design patterns in a CLI application.

---

## Main Features

- **Ship Creation & Management:** Define new ships with specific capacities (container slots, weight limits) and fuel parameters. Manage multiple ships docking at the port, track their fuel levels, and simulate ship movements or departures.
- **Container Management:** Create and manage containers of various types (e.g., standard, heavy, refrigerated, liquid). Load containers onto ships or unload them back to the port. Each container is tracked with unique identifiers and weight, with validation against ship capacity constraints.
- **Warehouse Operations:** Transfer containers to and from the port’s storage warehouse (container yard). The warehouse acts as a temporary holding area for containers not currently loaded on ships or trains, maintaining an inventory of containers on land.
- **Train Handling:** Manage trains that carry containers to or from the port. Load containers onto trains for over-land transport or unload arriving containers from trains into the warehouse, simulating intermodal transport links.
- **Time Simulation:** Advance a simulated port clock to model the duration of operations (e.g. loading/unloading delays, travel time for ships or trains). Time progression can trigger scheduled events or simply be used to track operation durations, adding realism to the simulation.
- **Save/Load State:** Save the entire state of the port (ships, containers, warehouse inventory, train loads, etc.) to a **human-readable text file**. This allows the simulation to be paused and resumed later by loading the state from file. Data persistence is implemented via plain text files (no Java object serialization), making the saved data easy to inspect or edit.

---

## Architecture & Design

MarinePort is structured with clarity and modularity in mind, following a design akin to the **Model-View-Controller (MVC)** pattern to separate concerns:
- The **Model** encapsulates core data and business logic — classes representing entities like `Ship`, `Container`, `Port` (terminal), `Warehouse`, `Train`, etc., along with their interactions (e.g. methods to load/unload containers).
- The **View** is the console interface, which handles user input and output. It presents textual menus or prompts and displays information to the user. (Since this is a CLI app, the "view" is purely text-based.)
- The **Controller** orchestrates the flow between the model and view. It interprets user commands (from the View), invokes changes on the Model, and updates the View with results or prompts for further action.

In implementing this project, several object-oriented design patterns and principles are utilized:
- **Builder Pattern:** Employed for constructing complex objects (e.g., assembling a `Ship` instance with various configuration parameters) in a clear, step-by-step manner.
- **Inheritance & Composition:** The class hierarchy uses inheritance for specialization (e.g. different container types inherit from a base `Container` class) and composition to model relationships (e.g. a `Ship` contains a collection of containers, a `Port` aggregates ships, containers in storage, and trains).
- **Exception Handling:** Custom exceptions are defined and used to handle error conditions (such as attempting to load a container that exceeds a ship’s capacity or other invalid operations). This ensures robust error checking and helps separate normal control flow from exceptional cases.
- **Collections & Generics:** Java's collection framework (e.g. `List`, `Map`) is used extensively to manage groups of objects such as the fleet of ships, the pool of containers, and the warehouse inventory. Generics provide type safety and clarity when handling these collections.
- **Multithreading:** Where appropriate, threads are used to simulate concurrent activities or the passage of time without blocking the interactive prompt. e.g., a background thread might advance the simulation clock or handle time-consuming loading operations in parallel with user commands.

The project is organized into packages that reflect these concerns and the domain areas, making the codebase easy to navigate and extend. Key packages (directories) and their responsibilities include:
- `port` – Main port terminal logic, including the central class that manages overall operations of the terminal.
- `ship` – Ship-related classes, including the `Ship` class and any helpers or subclasses for ship behavior and properties.
- `container` – Container classes, consisting of the base `Container` class and specialized subclasses for various container types (basic, heavy, refrigerated, liquid, etc.).
- `warehouse` – Classes for warehouse management, handling storage of containers on site and inventory tracking.
- `train` – Classes for train operations, managing the loading and unloading of containers to/from trains for land transport.
- `utils` – Utility classes supporting functionality such as time simulation (clocks/timers) and file I/O for saving/loading state.
- `Main` (entry point) – The main class containing the `public static void main(...)` method. This class initializes the simulation and launches the CLI loop for user interaction.

This architecture ensures a clean separation of concerns and makes the system easier to maintain. Each component of the simulation is handled in its respective module, and common tasks like persistence and time tracking are encapsulated in utility classes. The design makes it straightforward to extend or modify the application (for example, adding new container types or features) without affecting unrelated parts of the code.

---

## Getting Started

**Requirements:** To build and run MarinePort, you need Java Development Kit (JDK) 21 or later. No additional libraries or dependencies are required – the project uses only standard Java APIs.

**Compilation and Running:** Since MarinePort is a pure Java application (without Maven/Gradle), you can compile the source files using `javac` and run the program with `java`. For example:
```sh
javac *.java    # compile all Java source files (ensure you are using JDK 21)
java Main       # run the main class (the entry point of the application)
```
*(You may also compile and run within an IDE of your choice. Ensure your environment is set to use Java 21.)*

Once launched, the application will present an interactive console interface. Follow the prompts or menu options to execute operations (such as creating a ship, loading a container, advancing time, etc.). MarinePort runs in a loop, accepting multiple commands sequentially until you choose to exit. In other words, it is not a one-off command utility but an interactive session, allowing you to simulate a sequence of actions step by step and observe the outcomes in real time.

---

## License

This project is licensed under the GNU General Public License v3.0 (GPLv3). You are free to use, modify, and distribute MarinePort under the terms of this license. See the [LICENSE](./LICENSE) file for details.

---

## Contributing

Contributions are welcome! If you have ideas for improvements or new features, feel free to open an issue to discuss them first. Pull requests are welcome as well — if you decide to contribute code, please fork the repository and create a PR with your changes.

For any questions or feedback, you can reach out by opening an issue on the repository or by any other means of communication you prefer.