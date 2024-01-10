package model.container;

import model.Sender;

public class BasicContainer extends Container {

    private int id;
    private int grossWeight;
    private Sender sender;

    public BasicContainer(int grossWeight, Sender sender) {
        this.id = createId();
        this.grossWeight = grossWeight;
        this.sender = sender;
    }

    @Override
    public int getWieght() {
        return grossWeight;
    }
}
