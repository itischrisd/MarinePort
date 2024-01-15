package model.container;

public class ExplosiveContainer extends HeavyContainer {

    private AdditionalProtection additionalProtection;

    protected ExplosiveContainer() {

    }

    protected AdditionalProtection getAdditionalProtection() {
        return additionalProtection;
    }

    protected void setAdditionalProtection(AdditionalProtection additionalProtection) {
        this.additionalProtection = additionalProtection;
    }

    public enum AdditionalProtection {
        NONE("None"),
        REINFORCED_WALLS("Reinforced Walls"),
        EXPLOSION_SUPPRESSORS("Explosion Suppressors"),
        FIRE_RESISTANT_COATING("Fire-Resistant Coating"),
        TEMPERATURE_CONTROL("Temperature Control");

        private final String displayName;

        AdditionalProtection(String displayName) {
            this.displayName = displayName;
        }

        @Override
        public String toString() {
            return displayName;
        }
    }
}
