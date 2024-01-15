package model.container;

import java.util.ArrayList;
import java.util.List;

public class ContainerSerializer {

    public static List<String> serialize(Container container) {
        List<String> serializedContainer = new ArrayList<>();

        serializedContainer.add(String.valueOf(container.getId()));
        serializedContainer.add(String.valueOf(container.getWeight()));
        serializedContainer.add(String.valueOf(container.getSender().getPesel()));

        if (container instanceof HeavyContainer) {
            serializedContainer.add(String.valueOf(((HeavyContainer) container).getTareWeight()));
        }
        if (container instanceof Liquid) {
            serializedContainer.add(String.valueOf(((Liquid) container).getLiquidVolume()));
        }
        if (container instanceof ExplosiveContainer) {
            serializedContainer.add(String.valueOf(((ExplosiveContainer) container).getAdditionalProtection()));
        }
        if (container instanceof RefrigeratedContainer) {
            serializedContainer.add(String.valueOf(((RefrigeratedContainer) container).isConnectedToPower()));
        }
        if (container instanceof ToxicContainer) {
            serializedContainer.add(String.valueOf(((ToxicContainer) container).getToxicityLevel()));
        }
        if (container instanceof LooseToxicContainer) {
            serializedContainer.add(String.valueOf(((LooseToxicContainer) container).getLooseToxicContainerFeatures()));
        }

        return serializedContainer;
    }
}
