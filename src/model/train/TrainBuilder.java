package model.train;

import model.container.Container;

import java.util.List;

public class TrainBuilder {

    private Train train;

    private TrainBuilder() {
        this.train = new Train();
    }

    public static TrainBuilder train() {
        return new TrainBuilder();
    }

    public TrainBuilder withContainers(List<Container> containers) {
        train.setContainers(containers);
        return this;
    }

    public Train build() {
        if (this.train == null) {
            throw new IllegalStateException("This builder has already built a train.");
        }
        if (isInvalidTrain()) {
            throw new IllegalStateException("Invalid train - not all required fields are set.");
        }
        Train builtTrain = this.train;
        this.train = null;
        return builtTrain;
    }

    private boolean isInvalidTrain() {
        return train.getContainers() == null;
    }
}
