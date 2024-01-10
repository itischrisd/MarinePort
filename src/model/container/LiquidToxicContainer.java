package model.container;

import model.Sender;

public class LiquidToxicContainer  extends ToxicContainer implements Liquid {

    private double liquidVolume;

    public LiquidToxicContainer(int weight, Sender sender, int tareWeight, int toxicityLevel) {
        super(weight, sender, tareWeight, toxicityLevel);
    }

    @Override
    public double getLiquidVolume() {
        return liquidVolume;
    }

    @Override
    public void setLiquidVolume(double liquidVolume) {
        this.liquidVolume = liquidVolume;
    }
}
