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

        public static AdditionalProtection fromDisplayName(String displayName) {
            for (AdditionalProtection protection : values()) {
                if (protection.displayName.equals(displayName)) {
                    return protection;
                }
            }
            throw new IllegalArgumentException("No enum constant with display name " + displayName);
        }

        @Override
        public String toString() {
            return displayName;
        }
    }
}
