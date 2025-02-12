package controller;

import model.service.PersistanceService;
import ui.core.IOProvider;
import ui.input.Input;
import ui.input.StringInput;

import java.nio.file.Files;
import java.nio.file.Paths;

public class LoadStateController {

    private final Input<String> fileNameInput;

    public LoadStateController() {
        this.fileNameInput = new StringInput(
                "Podaj nazwę pliku do wczytania",
                "Nazwa pliku nie może być pusta",
                name -> name != null && !name.isBlank()
        );
    }


    public void run() {
        String fileName = fileNameInput.collect();
        if (Files.notExists(Paths.get(fileName))) {
            IOProvider.getPrinter().println("Plik o podanej nazwie nie istnieje");
            return;
        }
        try {
            PersistanceService.load(fileName);
        } catch (Exception e) {
            IOProvider.getPrinter().println(e.getMessage());
        }
    }
}
