package model.container;

public class RefrigeratedContainer extends HeavyContainer {

    private boolean connectedToPower;

    protected RefrigeratedContainer() {

    }

    public boolean isConnectedToPower() {
        return connectedToPower;
    }

    public void setConnectedToPower(boolean connectedToPower) {
        this.connectedToPower = connectedToPower;
    }
}
