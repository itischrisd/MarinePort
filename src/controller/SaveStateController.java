package controller;

import model.service.PersistanceService;
import ui.core.IOProvider;
import ui.input.Input;
import ui.input.StringInput;

import static lang.Interface.SAVE_FILE_NAME_PROMPT;

public class SaveStateController implements Controller {

    private final Input<String> fileNameInput;

    public SaveStateController() {
        this.fileNameInput = new StringInput(SAVE_FILE_NAME_PROMPT);
    }

    @Override
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
