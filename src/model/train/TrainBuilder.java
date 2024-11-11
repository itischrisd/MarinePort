package model.train;

import model.container.Container;

import java.util.List;

public class TrainBuilder {

    private Train train;

    public TrainBuilder train() {
        train = new Train();
        return this;
    }

    public TrainBuilder withContainers(List<Container> containers) {
        train.setContainers(containers);
        return this;
    }

    public Train build() {
        Train train = this.train;
        this.train = null;
        return train;
    }
}
