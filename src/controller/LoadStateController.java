package controller;

import model.service.PersistanceService;
import ui.core.IOProvider;
import ui.input.Input;
import ui.input.StringInput;

import java.nio.file.Files;
import java.nio.file.Paths;

import static lang.Interface.*;

public class LoadStateController implements Controller {

    private final Input<String> fileNameInput;

    public LoadStateController() {
        this.fileNameInput = new StringInput(
                LOAD_FILE_NAME_PROMPT,
                INVALID_FILE_NAME_CANNOT_BE_EMPTY,
                name -> name != null && !name.isBlank()
        );
    }

    @Override
    public void run() {
        String fileName = fileNameInput.collect();
        if (Files.notExists(Paths.get(fileName))) {
            IOProvider.getPrinter().println(INVALID_FILE_DOES_NOT_EXIST);
            return;
        }
        try {
            PersistanceService.load(fileName);
        } catch (Exception e) {
            IOProvider.printError(e);
        }
    }
}
