package model.container;

import model.Sender;

public class RefrigeratedContainer extends HeavyContainer {

    private boolean connectedToPower;

    public RefrigeratedContainer(int weight, Sender sender, int tareWeight, boolean connectedToPower) {
        super(weight, sender, tareWeight);
        this.connectedToPower = connectedToPower;
    }

    public boolean isConnectedToPower() {
        return connectedToPower;
    }

    public void setConnectedToPower(boolean connectedToPower) {
        this.connectedToPower = connectedToPower;
    }
}
