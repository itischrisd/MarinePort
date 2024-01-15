import model.Harbor;
import model.container.Container;
import model.container.ContainerBuilder;
import model.container.ExplosiveContainer;
import model.container.LooseToxicContainer.LooseToxicContainerFeatures;
import model.ship.Ship;
import model.ship.ShipBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {

    }

    public static void createExampleData() {

        Harbor harbor = Harbor.getInstance();

        ShipBuilder shipBuilder = new ShipBuilder();

        Ship ship1 = shipBuilder.ship().withId(1).withName("Ship1").withOriginPort("Port1").withCargoOrigin("Origin1").withCargoDestination("Destination1").withMaxHeavyContainers(10).withMaxTotalContainers(20).withMaxCargoWeight(1000).build();
        Ship ship2 = shipBuilder.ship().withId(2).withName("Ship2").withOriginPort("Port2").withCargoOrigin("Origin2").withCargoDestination("Destination2").withMaxHeavyContainers(20).withMaxTotalContainers(30).withMaxCargoWeight(2000).build();
        Ship ship3 = shipBuilder.ship().withId(3).withName("Ship3").withOriginPort("Port3").withCargoOrigin("Origin3").withCargoDestination("Destination3").withMaxHeavyContainers(30).withMaxTotalContainers(40).withMaxCargoWeight(3000).build();
        Ship ship4 = shipBuilder.ship().withId(4).withName("Ship4").withOriginPort("Port4").withCargoOrigin("Origin4").withCargoDestination("Destination4").withMaxHeavyContainers(40).withMaxTotalContainers(50).withMaxCargoWeight(4000).build();
        Ship ship5 = shipBuilder.ship().withId(5).withName("Ship5").withOriginPort("Port5").withCargoOrigin("Origin5").withCargoDestination("Destination5").withMaxHeavyContainers(50).withMaxTotalContainers(60).withMaxCargoWeight(5000).build();

        List<Ship> ships = List.of(ship1, ship2, ship3, ship4, ship5);

        harbor.setShips(ships);

        ContainerBuilder containerBuilder = new ContainerBuilder();

        Container container1 = containerBuilder.basicConatiner().withId(1).withWeight(100).build();
        Container container2 = containerBuilder.heavyContainer().withId(2).withWeight(200).withTareWeight(20).build();
        Container container3 = containerBuilder.liquidContainer().withId(3).withWeight(300).withLiquidVolume(30).build();
        Container container4 = containerBuilder.explosiveContainer().withId(4).withWeight(100).withAdditionalProtection(ExplosiveContainer.AdditionalProtection.EXPLOSION_SUPPRESSORS).build();
        Container container5 = containerBuilder.refrigeratedContainer().withId(5).withWeight(200).withConnectedToPower(true).build();
        List<Container> containers = List.of(container1, container2, container3, container4, container5);
        harbor.getWarehouse().a
        Container container6 = containerBuilder.looseToxicContainer().withId(6).withWeight(300).withToxicityLevel(60).withLooseToxicContainerFeature(LooseToxicContainerFeatures.VENTILATION_SYSTEM).withLooseToxicContainerFeature(LooseToxicContainerFeatures.LEAK_DETECTION_SYSTEM).build();
        Container container7 = containerBuilder.liquidToxicContainer().withId(7).withWeight(100).withToxicityLevel(70).build();
        Container container8 = containerBuilder.basicConatiner().withId(8).withWeight(200).build();
        Container container9 = containerBuilder.heavyContainer().withId(9).withWeight(300).withTareWeight(90).build();
        Container container10 = containerBuilder.liquidContainer().withId(10).withWeight(100).withLiquidVolume(100).build();
        Container container11 = containerBuilder.explosiveContainer().withId(11).withWeight(200).withAdditionalProtection(ExplosiveContainer.AdditionalProtection.EXPLOSION_SUPPRESSORS).build();
        Container container12 = containerBuilder.refrigeratedContainer().withId(12).withWeight(300).withConnectedToPower(true).build();
        Container container13 = containerBuilder.looseToxicContainer().withId(13).withWeight(100).withToxicityLevel(130).withLooseToxicContainerFeature(LooseToxicContainerFeatures.VENTILATION_SYSTEM).withLooseToxicContainerFeature(LooseToxicContainerFeatures.LEAK_DETECTION_SYSTEM).build();
        Container container14 = containerBuilder.liquidToxicContainer().withId(14).withWeight(200).withToxicityLevel(140).build();
        Container container15 = containerBuilder.basicConatiner().withId(15).withWeight(300).build();
        Container container16 = containerBuilder.heavyContainer().withId(16).withWeight(100).withTareWeight(160).build();
        Container container17 = containerBuilder.liquidContainer().withId(17).withWeight(200).withLiquidVolume(170).build();
        Container container18 = containerBuilder.explosiveContainer().withId(18).withWeight(300).withAdditionalProtection(ExplosiveContainer.AdditionalProtection.EXPLOSION_SUPPRESSORS).build();
        Container container19 = containerBuilder.refrigeratedContainer().withId(19).withWeight(100).withConnectedToPower(true).build();
        Container container20 = containerBuilder.looseToxicContainer().withId(20).withWeight(200).withToxicityLevel(200).withLooseToxicContainerFeature(LooseToxicContainerFeatures.VENTILATION_SYSTEM).withLooseToxicContainerFeature(LooseToxicContainerFeatures.LEAK_DETECTION_SYSTEM).build();
        Container container21 = containerBuilder.liquidToxicContainer().withId(21).withWeight(300).withToxicityLevel(210).build();

    }
}