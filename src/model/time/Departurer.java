package model.time;

import model.Harbor;
import model.Train;

public class Departurer extends Thread {

    @Override
    public void run() {
        try {
            Thread.sleep(30000);
            Harbor.getInstance().setTrain(new Train());
        } catch (InterruptedException e) {
            Harbor.getInstance().setTrain(new Train());
        }
    }
}
