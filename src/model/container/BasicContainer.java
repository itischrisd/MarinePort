package model.container;

public class BasicContainer extends Container {

    private final int id;
    private final int tareWeight;
    private final int netWeight;
    private final int grossWeight;
    private final String sender;

    public BasicContainer(int id, int tareWeight, int netWeight, int grossWeight, String sender) {
        this.id = id;
        this.tareWeight = tareWeight;
        this.netWeight = netWeight;
        this.grossWeight = grossWeight;
        this.sender = sender;
    }

    @Override
    public int getWieght() {
        return grossWeight;
    }
}
