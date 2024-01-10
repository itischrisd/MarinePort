package model.container;

import model.Sender;

public class ExplosiveContainer extends HeavyContainer {

    private AdditionalProtection additionalProtection;

    public ExplosiveContainer(int weight, Sender sender, int tareWeight) {
        super(weight, sender, tareWeight);
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
