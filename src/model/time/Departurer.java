package model.time;

import model.Harbor;
import model.train.TrainBuilder;

import java.util.ArrayList;

public class Departurer extends Thread {

    @Override
    public void run() {
        try {
            Thread.sleep(30000);
            depart();
        } catch (InterruptedException e) {
            depart();
        }
    }

    private void depart() {
        TrainBuilder trainBuilder = new TrainBuilder();
        Harbor.getInstance().setTrain(trainBuilder.train().withContainers(new ArrayList<>()).build());
    }
}
