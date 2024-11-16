package model.container;

import model.sender.Sender;
import model.container.ExplosiveContainer.AdditionalProtection;
import model.container.LooseToxicContainer.LooseToxicContainerFeatures;

import java.util.List;

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
        throw new UnsupportedOperationException("Tare weight is only applicable to HeavyContainer.");
    }

    public ContainerBuilder<T> withLiquidVolume(double liquidVolume) {
        if (container instanceof Liquid) {
            ((Liquid) container).setLiquidVolume(liquidVolume);
            return this;
        }
        throw new UnsupportedOperationException("Liquid volume is only applicable to LiquidContainer.");
    }

    public ContainerBuilder<T> withAdditionalProtection(AdditionalProtection additionalProtection) {
        if (container instanceof ExplosiveContainer) {
            ((ExplosiveContainer) container).setAdditionalProtection(additionalProtection);
            return this;
        }
        throw new UnsupportedOperationException("Additional protection is only applicable to ExplosiveContainer.");
    }

    public ContainerBuilder<T> withConnectedToPower(boolean connectedToPower) {
        if (container instanceof RefrigeratedContainer) {
            ((RefrigeratedContainer) container).setConnectedToPower(connectedToPower);
            return this;
        }
        throw new UnsupportedOperationException("Power connection is only applicable to RefrigeratedContainer.");
    }

    public ContainerBuilder<T> withToxicityLevel(int toxicityLevel) {
        if (container instanceof ToxicContainer) {
            ((ToxicContainer) container).setToxicityLevel(toxicityLevel);
            return this;
        }
        throw new UnsupportedOperationException("Toxicity level is only applicable to ToxicContainer.");
    }

    public ContainerBuilder<T> withLooseToxicContainerFeature(LooseToxicContainerFeatures feature) {
        if (container instanceof LooseToxicContainer) {
            ((LooseToxicContainer) container).addLooseToxicContainerFeature(feature);
            return this;
        }
        throw new UnsupportedOperationException("Loose toxic container features are only applicable to LooseToxicContainer.");
    }

    public ContainerBuilder<T> withLooseToxicContainerFeatures(List<LooseToxicContainerFeatures> features) {
        if (container instanceof LooseToxicContainer) {
            ((LooseToxicContainer) container).setLooseToxicContainerFeatures(features);
            return this;
        }
        throw new UnsupportedOperationException("Loose toxic container features are only applicable to LooseToxicContainer.");
    }

    public T build() {
        if (this.container == null) {
            throw new IllegalStateException("This builder has already built a container.");
        }
        if (isInvalidContainer()) {
            throw new IllegalStateException("Container is invalid - not all required fields are set.");
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
