package model.containers;

import java.util.List;

public class BulkToxicContainer extends ToxicContainer {

    private final List<ToxicBulkContainerFeatures> toxicBulkContainerFeatures;

    public BulkToxicContainer(int id, int tareWeight, int netWeight, int grossWeight, String sender, int additionalHandles, int toxicityLevel, List<ToxicBulkContainerFeatures> toxicBulkContainerFeatures) {
        super(id, tareWeight, netWeight, grossWeight, sender, additionalHandles, toxicityLevel);
        this.toxicBulkContainerFeatures = toxicBulkContainerFeatures;
    }

    @Override
    public String toString() {
        return "BulkToxicContainer{" +
                "toxicBulkContainerFeatures=" + toxicBulkContainerFeatures +
                '}';
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
