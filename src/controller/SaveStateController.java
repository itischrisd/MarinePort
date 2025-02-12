package controller;

import model.service.PersistanceService;
import ui.core.IOProvider;
import ui.input.Input;
import ui.input.StringInput;

public class SaveStateController {

    private final Input<String> fileNameInput;

    public SaveStateController() {
        this.fileNameInput = new StringInput("Podaj nazwę pliku do zapisu (puste aby pozostać przy domyślnej)");
    }

    public void run() {
        String fileName = fileNameInput.collect();
        try {
            if (fileName.isBlank()) {
                PersistanceService.save();
            } else {
                PersistanceService.save(fileName);
            }
        } catch (Exception e) {
            IOProvider.getPrinter().println(e.getMessage());
        }
    }
}
