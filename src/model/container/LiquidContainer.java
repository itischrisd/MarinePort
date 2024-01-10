package model.container;

import model.Sender;

public class LiquidContainer extends Container implements Liquid {

    private double liquidVolume;

    public LiquidContainer(int weight, Sender sender, double liquidVolume) {
        super(weight, sender);
        this.liquidVolume = liquidVolume;
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
