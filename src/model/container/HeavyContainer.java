package model.container;

import model.Sender;

public class HeavyContainer extends Container {

    private int tareWeight;


    public HeavyContainer(int weight, Sender sender, int tareWeight) {
        super(weight, sender);
        this.tareWeight = tareWeight;
    }

    public int getTareWeight() {
        return tareWeight;
    }

    public void setTareWeight(int tareWeight) {
        this.tareWeight = tareWeight;
    }
}
