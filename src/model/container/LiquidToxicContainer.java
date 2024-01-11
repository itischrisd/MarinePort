package model.container;

public class LiquidToxicContainer  extends ToxicContainer implements Liquid {

    private double liquidVolume;

    protected LiquidToxicContainer() {

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
