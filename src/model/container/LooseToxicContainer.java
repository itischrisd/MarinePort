package model.container;

import model.Sender;

import java.util.List;

public class LooseToxicContainer extends ToxicContainer {

    private List<ToxicBulkContainerFeatures> toxicBulkContainerFeatures;

    public LooseToxicContainer(int weight, Sender sender, int tareWeight, int toxicityLevel) {
        super(weight, sender, tareWeight, toxicityLevel);
    }

    enum ToxicBulkContainerFeatures {
        NONE("None"),
        VENTILATION_SYSTEM("Ventillation System"),
        LEAK_DETECTION_SYSTEM("Leak Detection System"),
        DUST_CONTROL_SYSTEM("Dust Control System");

        private final String displayName;

        ToxicBulkContainerFeatures(String displayName) {
            this.displayName = displayName;
        }
        public String getDisplayName() {
            return displayName;
        }

    }
}
