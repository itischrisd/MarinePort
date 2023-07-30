package model.containers;

public abstract class ToxicContainer extends HeavyContainer {

    private final int toxicityLevel;

    public ToxicContainer(int id, int tareWeight, int netWeight, int grossWeight, String sender, int additionalHandles, int toxicityLevel) {
        super(id, tareWeight, netWeight, grossWeight, sender, additionalHandles);
        this.toxicityLevel = toxicityLevel;
    }

    @Override
    public String toString() {
        return "ToxicContainer{" +
                "toxicityLevel=" + toxicityLevel +
                '}';
    }
}
