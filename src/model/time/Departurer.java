package model.time;

import model.Harbor;
import model.train.Train;
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
        Train train = TrainBuilder.train().withContainers(new ArrayList<>()).build();
        Harbor.getInstance().setTrain(train);
    }
}
