package model.container;

public abstract class ToxicContainer extends HeavyContainer {

    private int toxicityLevel;

    protected ToxicContainer() {
    }

    public int getToxicityLevel() {
        return toxicityLevel;
    }

    protected void setToxicityLevel(int toxicityLevel) {
        this.toxicityLevel = toxicityLevel;
    }
}
