package model.time;

import model.Harbor;

public class Utilizer extends Thread {

    private static Utilizer instance;

    private Utilizer() {
    }

    public static Utilizer getInstance() {
        if (instance == null) {
            instance = new Utilizer();
        }
        return instance;
    }

    @Override
    public void run() {
        while (!interrupted()) {
            try {
                Thread.sleep(5000);
                checkForOverdueContainers();
            } catch (NullPointerException ignored) {
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    private void checkForOverdueContainers() {
        Harbor.getInstance().getWarehouse().removeOverdueContainers();
    }
}
