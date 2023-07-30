package model.containers;

public class RefrigeratedContainer extends HeavyContainer {

    private boolean connectedToPower;

    public RefrigeratedContainer(int id, int tareWeight, int netWeight, int grossWeight, String sender, int additionalHandles, boolean connectedToPower) {
        super(id, tareWeight, netWeight, grossWeight, sender, additionalHandles);
        this.connectedToPower = connectedToPower;
    }

    public void connectPower() {
        connectedToPower = true;
    }

    public void disconnectPower() {
        connectedToPower = false;
    }

    @Override
    public String toString() {
        return "RefrigeratedContainer{" +
                "connectedToPower=" + connectedToPower +
                '}';
    }
}
