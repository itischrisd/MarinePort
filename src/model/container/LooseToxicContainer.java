package model.container;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LooseToxicContainer extends ToxicContainer {

    private List<LooseToxicContainerFeatures> looseToxicContainerFeatures;

    protected LooseToxicContainer() {
        looseToxicContainerFeatures = new ArrayList<>();
    }

    public List<LooseToxicContainerFeatures> getLooseToxicContainerFeatures() {
        return Collections.unmodifiableList(looseToxicContainerFeatures);
    }

    protected void setLooseToxicContainerFeatures(List<LooseToxicContainerFeatures> looseToxicContainerFeatures) {
        this.looseToxicContainerFeatures = looseToxicContainerFeatures;
    }

    protected void addLooseToxicContainerFeature(LooseToxicContainerFeatures looseToxicContainerFeature) {
        looseToxicContainerFeatures.add(looseToxicContainerFeature);
    }

    public enum LooseToxicContainerFeatures {
        NONE("Brak"),
        VENTILATION_SYSTEM("System wentylacji"),
        LEAK_DETECTION_SYSTEM("System wykrywania wycieków"),
        DUST_CONTROL_SYSTEM("System kontroli pyłów"),;

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
