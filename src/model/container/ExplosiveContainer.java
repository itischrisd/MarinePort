package model.container;

import static lang.Data.*;
import static lang.ErrorMessage.ADDITIONAL_PROTECTION_INVALID_NAME;

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
        NONE(ENUM_NONE),
        REINFORCED_WALLS(ENUM_REINFORCED_WALLS),
        EXPLOSION_SUPPRESSORS(ENUM_EXPLOSION_SUPPRESSORS),
        FIRE_RESISTANT_COATING(ENUM_FIRE_RESISTANT_COATING),
        TEMPERATURE_CONTROL(ENUM_TEMPERATURE_CONTROL);

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
            throw new IllegalArgumentException(ADDITIONAL_PROTECTION_INVALID_NAME + displayName);
        }

        @Override
        public String toString() {
            return displayName;
        }
    }
}
