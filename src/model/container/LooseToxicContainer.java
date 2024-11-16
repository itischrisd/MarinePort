package model.container;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lang.Data.*;
import static lang.ErrorMessage.*;

public class LooseToxicContainer extends ToxicContainer {

    private List<LooseToxicContainerFeatures> looseToxicContainerFeatures;

    protected LooseToxicContainer() {
        looseToxicContainerFeatures = new ArrayList<>();
    }

    public List<LooseToxicContainerFeatures> getLooseToxicContainerFeatures() {
        return Collections.unmodifiableList(looseToxicContainerFeatures);
    }

    protected void setLooseToxicContainerFeatures(List<LooseToxicContainerFeatures> looseToxicContainerFeatures) {
        this.looseToxicContainerFeatures = new ArrayList<>(looseToxicContainerFeatures);
    }

    protected void addLooseToxicContainerFeature(LooseToxicContainerFeatures looseToxicContainerFeature) {
        looseToxicContainerFeatures.add(looseToxicContainerFeature);
    }

    public enum LooseToxicContainerFeatures {
        NONE(ENUM_NONE),
        VENTILATION_SYSTEM(ENUM_VENTILATION_SYSTEM),
        LEAK_DETECTION_SYSTEM(ENUM_LEAK_DETECTION_SYSTEM),
        DUST_CONTROL_SYSTEM(ENUM_DUST_CONTROL_SYSTEM),;

        private final String displayName;

        LooseToxicContainerFeatures(String displayName) {
            this.displayName = displayName;
        }

        public static LooseToxicContainerFeatures fromDisplayName(String displayName) {
            for (LooseToxicContainerFeatures feature : values()) {
                if (feature.displayName.equals(displayName)) {
                    return feature;
                }
            }
            throw new IllegalArgumentException(LOOSE_TOXIC_CONTAINER_FEATURES_INVALID_NAME + displayName);
        }

        @Override
        public String toString() {
            return displayName;
        }
    }
}
