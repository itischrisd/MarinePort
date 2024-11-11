package model.container;

public class RefrigeratedContainer extends HeavyContainer {

    private boolean connectedToPower;

    protected RefrigeratedContainer() {
    }

    public boolean isConnectedToPower() {
        return connectedToPower;
    }

    protected void setConnectedToPower(boolean connectedToPower) {
        this.connectedToPower = connectedToPower;
    }
}
