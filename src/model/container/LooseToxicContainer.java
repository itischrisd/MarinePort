package model.container;

import java.util.ArrayList;
import java.util.List;

public class LooseToxicContainer extends ToxicContainer {

    private List<LooseToxicContainerFeatures> looseToxicContainerFeatures;

    protected LooseToxicContainer() {
        looseToxicContainerFeatures = new ArrayList<>();
    }

    public List<LooseToxicContainerFeatures> getLooseToxicContainerFeatures() {
        return looseToxicContainerFeatures;
    }

    public void setLooseToxicContainerFeatures(List<LooseToxicContainerFeatures> looseToxicContainerFeatures) {
        this.looseToxicContainerFeatures = looseToxicContainerFeatures;
    }

    public void addLooseToxicContainerFeature(LooseToxicContainerFeatures looseToxicContainerFeature) {
        looseToxicContainerFeatures.add(looseToxicContainerFeature);
    }

    public enum LooseToxicContainerFeatures {
        NONE("None"),
        VENTILATION_SYSTEM("Ventillation System"),
        LEAK_DETECTION_SYSTEM("Leak Detection System"),
        DUST_CONTROL_SYSTEM("Dust Control System");

        private final String displayName;

        LooseToxicContainerFeatures(String displayName) {
            this.displayName = displayName;
        }

        @Override
        public String toString() {
            return displayName;
        }
    }
}
