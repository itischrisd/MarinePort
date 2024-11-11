package model.container;

public class ExplosiveContainer extends HeavyContainer {

    private AdditionalProtection additionalProtection;

    protected ExplosiveContainer() {
    }

    public AdditionalProtection getAdditionalProtection() {
        return additionalProtection;
    }

    protected void setAdditionalProtection(AdditionalProtection additionalProtection) {
        this.additionalProtection = additionalProtection;
    }

    public enum AdditionalProtection {
        NONE("Brak"),
        REINFORCED_WALLS("Wzmocnione ściany"),
        EXPLOSION_SUPPRESSORS("Tłumiki eksplozji"),
        FIRE_RESISTANT_COATING("Odporna na ogień powłoka"),
        TEMPERATURE_CONTROL("Kontrola temperatury");

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
