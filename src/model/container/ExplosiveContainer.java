package model.container;

public class ExplosiveContainer extends HeavyContainer {

    private final AdditionalProtection additionalProtection;

    public ExplosiveContainer(int id, int tareWeight, int netWeight, int grossWeight, String sender, int additionalHandles, AdditionalProtection additionalProtection) {
        super(id, tareWeight, netWeight, grossWeight, sender, additionalHandles);
        this.additionalProtection = additionalProtection;
    }

    @Override
    public String toString() {
        return "ExplosiveContainer{" +
                "additionalProtection=" + additionalProtection +
                '}';
    }

    enum AdditionalProtection {
        NONE("None"),
        REINFORCED_WALLS("Reinforced Walls"),
        EXPLOSION_SUPPRESSORS("Explosion Suppressors"),
        FIRE_RESISTANT_COATING("Fire-Resistant Coating"),
        TEMPERATURE_CONTROL("Temperature Control");

        private final String displayName;

        AdditionalProtection(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }
}
