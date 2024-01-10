package model.container;

import model.Sender;

public class HeavyContainer extends BasicContainer {

    private int tareWeight;

    public HeavyContainer(int grossWeight, Sender sender) {
        super(grossWeight, sender);
        this.tareWeight = tareWeight;
    }
}
