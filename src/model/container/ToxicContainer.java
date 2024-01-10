package model.container;

import model.Sender;

public abstract class ToxicContainer extends HeavyContainer {

    private int toxicityLevel;

    public ToxicContainer(int weight, Sender sender, int tareWeight, int toxicityLevel) {
        super(weight, sender, tareWeight);
        this.toxicityLevel = toxicityLevel;
    }

    public int getToxicityLevel() {
        return toxicityLevel;
    }

    public void setToxicityLevel(int toxicityLevel) {
        this.toxicityLevel = toxicityLevel;
    }
}
