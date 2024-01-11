import model.container.*;

import java.util.Collections;
import model.container.LooseToxicContainer.LooseToxicContainerFeatures;

import static model.container.LooseToxicContainer.LooseToxicContainerFeatures.LEAK_DETECTION_SYSTEM;

public class Main {
    public static void main(String[] args) {
        ContainerBuilder containerBuilder = new ContainerBuilder();

        Container container = containerBuilder.basicConatiner().withId(1).withWeight(100).build();
        Container container1 = containerBuilder.heavyContainer().withId(2).withWeight(200).withTareWeight(20).build();
        Container container2 = containerBuilder.liquidContainer().withId(3).withWeight(300).withLiquidVolume(30).build();
        Container container3 = containerBuilder.explosiveContainer().withId(4).withWeight(400).withAdditionalProtection(ExplosiveContainer.AdditionalProtection.EXPLOSION_SUPPRESSORS).build();
        Container container4 = containerBuilder.refrigeratedContainer().withId(5).withWeight(500).withConnectedToPower(true).build();
        Container container5 = containerBuilder
                .looseToxicContainer()
                .withId(6)
                .withWeight(600)
                .withToxicityLevel(60)
                .withLooseToxicContainerFeature(LooseToxicContainerFeatures.VENTILATION_SYSTEM)
                .withLooseToxicContainerFeature(LooseToxicContainerFeatures.LEAK_DETECTION_SYSTEM)
                .build();
        Container container6 = containerBuilder.liquidToxicContainer().withId(7).withWeight(700).withToxicityLevel(70).build();

        System.out.println(container);
        System.out.println(container1);
        System.out.println(container2);
        System.out.println(container3);
        System.out.println(container4);
        System.out.println(container5);
        System.out.println(container6);
        System.out.println(ContainerSerializer.serialize(container));
        System.out.println(ContainerSerializer.serialize(container1));
        System.out.println(ContainerSerializer.serialize(container2));
        System.out.println(ContainerSerializer.serialize(container3));
        System.out.println(ContainerSerializer.serialize(container4));
        System.out.println(ContainerSerializer.serialize(container5));
        System.out.println(ContainerSerializer.serialize(container6));

    }
}