package model.containers;

public class HeavyContainer extends BasicContainer {

    private final int additionalHandles;

    public HeavyContainer(int id, int tareWeight, int netWeight, int grossWeight, String sender, int additionalHandles) {
        super(id, tareWeight, netWeight, grossWeight, sender);
        this.additionalHandles = additionalHandles;
    }

    @Override
    public String toString() {
        return "HeavyContainer{" +
                "additionalHandles=" + additionalHandles +
                '}';
    }
}
