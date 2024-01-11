package model.container;

import model.sender.Sender;
import model.container.ExplosiveContainer.AdditionalProtection;
import model.container.LooseToxicContainer.LooseToxicContainerFeatures;

import java.util.List;

public class ContainerBuilder {

    private Container container;

    public ContainerBuilder basicConatiner() {
        container = new Container();
        return this;
    }

    public ContainerBuilder heavyContainer() {
        container = new HeavyContainer();
        return this;
    }

    public ContainerBuilder liquidContainer() {
        container = new LiquidContainer();
        return this;
    }

    public ContainerBuilder explosiveContainer() {
        container = new ExplosiveContainer();
        return this;
    }

    public ContainerBuilder refrigeratedContainer() {
        container = new RefrigeratedContainer();
        return this;
    }

    public ContainerBuilder looseToxicContainer() {
        container = new LooseToxicContainer();
        return this;
    }

    public ContainerBuilder liquidToxicContainer() {
        container = new LiquidToxicContainer();
        return this;
    }

    public ContainerBuilder withId(int id) {
        container.setId(id);
        return this;
    }

    public ContainerBuilder withNewId() {
        container.setId();
        return this;
    }

    public ContainerBuilder withWeight(int weight) {
        container.setWeight(weight);
        return this;
    }

    public ContainerBuilder withSender(Sender sender) {
        container.setSender(sender);
        return this;
    }

    public ContainerBuilder withTareWeight(int tareWeight) {
        ((HeavyContainer) container).setTareWeight(tareWeight);
        return this;
    }

    public ContainerBuilder withLiquidVolume(double liquidVolume) {
        ((LiquidContainer) container).setLiquidVolume(liquidVolume);
        return this;
    }

    public ContainerBuilder withAdditionalProtection(AdditionalProtection additionalProtection) {
        ((ExplosiveContainer) container).setAdditionalProtection(additionalProtection);
        return this;
    }

    public ContainerBuilder withConnectedToPower(boolean connectedToPower) {
        ((RefrigeratedContainer) container).setConnectedToPower(connectedToPower);
        return this;
    }

    public ContainerBuilder withToxicityLevel(int toxicityLevel) {
        ((ToxicContainer) container).setToxicityLevel(toxicityLevel);
        return this;
    }

    public ContainerBuilder withLooseToxicContainerFeature(LooseToxicContainerFeatures looseToxicContainerFeature) {
        ((LooseToxicContainer) container).addLooseToxicContainerFeature(looseToxicContainerFeature);
        return this;
    }

    public ContainerBuilder withLooseToxicContainerFeatures(List<LooseToxicContainerFeatures> looseToxicContainerFeatures) {
        ((LooseToxicContainer) container).setLooseToxicContainerFeatures(looseToxicContainerFeatures);
        return this;
    }

    public Container build() {
        Container container = this.container;
        this.container = null;
        return container;
    }
}
