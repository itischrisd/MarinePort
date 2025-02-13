import controller.Controller;
import controller.MainMenuController;

public class Main {

    public static void main(String[] args) {
        Controller mainMenuController = new MainMenuController();
        mainMenuController.run();
    }
}