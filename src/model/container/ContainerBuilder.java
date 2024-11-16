package model.container;

import model.sender.Sender;
import model.container.ExplosiveContainer.AdditionalProtection;
import model.container.LooseToxicContainer.LooseToxicContainerFeatures;

import java.util.List;

import static lang.ErrorMessage.*;

public class ContainerBuilder<T extends Container> {

    private T container;

    private ContainerBuilder(T container) {
        this.container = container;
    }

    public static ContainerBuilder<Container> basicContainer() {
        return new ContainerBuilder<>(new Container());
    }

    public static ContainerBuilder<HeavyContainer> heavyContainer() {
        return new ContainerBuilder<>(new HeavyContainer());
    }

    public static ContainerBuilder<LiquidContainer> liquidContainer() {
        return new ContainerBuilder<>(new LiquidContainer());
    }

    public static ContainerBuilder<ExplosiveContainer> explosiveContainer() {
        return new ContainerBuilder<>(new ExplosiveContainer());
    }

    public static ContainerBuilder<RefrigeratedContainer> refrigeratedContainer() {
        return new ContainerBuilder<>(new RefrigeratedContainer());
    }

    public static ContainerBuilder<LooseToxicContainer> looseToxicContainer() {
        return new ContainerBuilder<>(new LooseToxicContainer());
    }

    public static ContainerBuilder<LiquidToxicContainer> liquidToxicContainer() {
        return new ContainerBuilder<>(new LiquidToxicContainer());
    }

    public ContainerBuilder<T> withId(int id) {
        container.setId(id);
        return this;
    }

    public ContainerBuilder<T> withNewId() {
        container.setId();
        return this;
    }

    public ContainerBuilder<T> withWeight(int weight) {
        container.setWeight(weight);
        return this;
    }

    public ContainerBuilder<T> withSender(Sender sender) {
        container.setSender(sender);
        return this;
    }

    public ContainerBuilder<T> withTareWeight(int tareWeight) {
        if (container instanceof HeavyContainer) {
            ((HeavyContainer) container).setTareWeight(tareWeight);
            return this;
        }
        throw new UnsupportedOperationException(TARE_WEIGHT_HEAVY_CONTAINER_EXCLUSIVE);
    }

    public ContainerBuilder<T> withLiquidVolume(double liquidVolume) {
        if (container instanceof Liquid) {
            ((Liquid) container).setLiquidVolume(liquidVolume);
            return this;
        }
        throw new UnsupportedOperationException(LIQUID_VOLUME_LIQUID_CONTAINER_EXCLUSIVE);
    }

    public ContainerBuilder<T> withAdditionalProtection(AdditionalProtection additionalProtection) {
        if (container instanceof ExplosiveContainer) {
            ((ExplosiveContainer) container).setAdditionalProtection(additionalProtection);
            return this;
        }
        throw new UnsupportedOperationException(ADDITIONAL_PROTECTION_EXPLOSIVE_CONTAINER_EXCLUSIVE);
    }

    public ContainerBuilder<T> withConnectedToPower(boolean connectedToPower) {
        if (container instanceof RefrigeratedContainer) {
            ((RefrigeratedContainer) container).setConnectedToPower(connectedToPower);
            return this;
        }
        throw new UnsupportedOperationException(CONNECTED_TO_POWER_REFRIGERATED_CONTAINER_EXCLUSIVE);
    }

    public ContainerBuilder<T> withToxicityLevel(int toxicityLevel) {
        if (container instanceof ToxicContainer) {
            ((ToxicContainer) container).setToxicityLevel(toxicityLevel);
            return this;
        }
        throw new UnsupportedOperationException(TOXICITY_LEVEL_TOXIC_CONTAINER_EXCLUSIVE);
    }

    public ContainerBuilder<T> withLooseToxicContainerFeature(LooseToxicContainerFeatures feature) {
        if (container instanceof LooseToxicContainer) {
            ((LooseToxicContainer) container).addLooseToxicContainerFeature(feature);
            return this;
        }
        throw new UnsupportedOperationException(LOOSE_TOXIC_CONTAINER_FEATURES_LOOSE_TOXIC_CONTAINER_EXCLUSIVE);
    }

    public ContainerBuilder<T> withLooseToxicContainerFeatures(List<LooseToxicContainerFeatures> features) {
        if (container instanceof LooseToxicContainer) {
            ((LooseToxicContainer) container).setLooseToxicContainerFeatures(features);
            return this;
        }
        throw new UnsupportedOperationException(LOOSE_TOXIC_CONTAINER_FEATURES_LOOSE_TOXIC_CONTAINER_EXCLUSIVE);
    }

    public T build() {
        if (this.container == null) {
            throw new IllegalStateException(CONTAINER_ALREADY_BUILT);
        }
        if (isInvalidContainer()) {
            throw new IllegalStateException(INVALID_CONTAINER);
        }
        T builtContainer = this.container;
        this.container = null;
        return builtContainer;
    }

    private boolean isInvalidContainer() {
        boolean isInvalid = container.getId() <= 0 || container.getWeight() <= 0 || container.getSender() == null;

        if (container instanceof HeavyContainer && ((HeavyContainer) container).getTareWeight() <= 0) {
            isInvalid = true;
        }
        if (container instanceof Liquid && ((Liquid) container).getLiquidVolume() <= 0) {
            isInvalid = true;
        }
        if (container instanceof ToxicContainer && ((ToxicContainer) container).getToxicityLevel() <= 0) {
            isInvalid = true;
        }
        if (container instanceof LooseToxicContainer && ((LooseToxicContainer) container).getLooseToxicContainerFeatures() == null) {
            isInvalid = true;
        }
        if (container instanceof ExplosiveContainer && ((ExplosiveContainer) container).getAdditionalProtection() == null) {
            isInvalid = true;
        }

        return isInvalid;
    }
}
