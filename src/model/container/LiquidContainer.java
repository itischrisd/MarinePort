package model.container;

public class LiquidContainer extends Container implements Liquid {

    private double liquidVolume;

    protected LiquidContainer() {
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
