package model.containers;

public class BasicContainer {

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
    public String toString() {
        return "BasicContainer{" +
                "id=" + id +
                ", tareWeight=" + tareWeight +
                ", netWeight=" + netWeight +
                ", grossWeight=" + grossWeight +
                ", sender='" + sender + '\'' +
                '}';
    }
}
