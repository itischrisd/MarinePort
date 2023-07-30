package model.containers;

public class LiquidToxicContainer  extends ToxicContainer implements Pumpable {

    private final int corrosivenessLevel;

    public LiquidToxicContainer(int id, int tareWeight, int netWeight, int grossWeight, String sender, int additionalHandles, int toxicityLevel, int corrosivenessLevel) {
        super(id, tareWeight, netWeight, grossWeight, sender, additionalHandles, toxicityLevel);
        this.corrosivenessLevel = corrosivenessLevel;
    }

    @Override
    public void pump() {
        System.out.println("Ciecz toksyczna jest przepompowywana przez niekorozyjny przewód hydrualiczny...");
    }

    @Override
    public String toString() {
        return "LiquidToxicContainer{" +
                "corrosivenessLevel=" + corrosivenessLevel +
                '}';
    }
}
