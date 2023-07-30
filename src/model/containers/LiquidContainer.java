package model.containers;

public class LiquidContainer extends BasicContainer implements Pumpable {

    private final double liquidVolume;

    public LiquidContainer(int id, int tareWeight, int netWeight, int grossWeight, String sender, double liquidVolume) {
        super(id, tareWeight, netWeight, grossWeight, sender);
        this.liquidVolume = liquidVolume;
    }

    @Override
    public void pump() {
        System.out.println("Ciecz jest przepompowywana przez przewód hydrualiczny...");
    }

    @Override
    public String toString() {
        return "LiquidContainer{" +
                "liquidVolume=" + liquidVolume +
                '}';
    }
}
