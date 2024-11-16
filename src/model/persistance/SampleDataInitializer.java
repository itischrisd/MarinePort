package model.persistance;

import model.Harbor;
import model.container.Container;
import model.container.ContainerBuilder;
import model.container.ExplosiveContainer.AdditionalProtection;
import model.container.LooseToxicContainer.LooseToxicContainerFeatures;
import model.exception.ExceptionBuilder;
import model.sender.Sender;
import model.sender.SenderBuilder;
import model.ship.Ship;
import model.ship.ShipBuilder;
import model.warehouse.WarehouseBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SampleDataInitializer {

    public static void createExampleData() {
        populateSenders();
        populateWarehouse();
        populateShips();
    }

    private static void populateSenders() {
        Sender sender1 = SenderBuilder
                .sender()
                .withName("Anna")
                .withSurname("Kowalska")
                .withPesel("78050812345")
                .withAddress("ul. Długa 15, 00-238 Warsaw")
                .withWarnings(new ArrayList<>())
                .build();
        Sender sender2 = SenderBuilder
                .sender()
                .withName("Jan")
                .withSurname("Nowak")
                .withPesel("80050812345")
                .withAddress("ul. Szeroka 30, 31-156 Kraków")
                .withWarnings(new ArrayList<>())
                .build();
        Sender sender3 = SenderBuilder
                .sender()
                .withName("Ewa")
                .withSurname("Zielińska")
                .withPesel("92040598765")
                .withAddress("ul. Krótka 4, 80-864 Gdańsk")
                .withWarnings(new ArrayList<>())
                .build();
        Sender sender4 = SenderBuilder
                .sender()
                .withName("Piotr")
                .withSurname("Wiśniewski")
                .withPesel("71021376543")
                .withAddress("ul. Kwiatowa 12, 61-623 Poznań")
                .withWarnings(new ArrayList<>())
                .build();
        Sender sender5 = SenderBuilder
                .sender()
                .withName("Katarzyna")
                .withSurname("Lewandowska")
                .withPesel("66090154321")
                .withAddress("al. Niepodległości 100, 02-554 Warsaw")
                .withWarnings(new ArrayList<>())
                .build();
        Sender sender6 = SenderBuilder
                .sender()
                .withName("Michał")
                .withSurname("Dąbrowski")
                .withPesel("93071165432")
                .withAddress("ul. Piękna 22, 50-506 Wrocław")
                .withWarnings(new ArrayList<>())
                .build();
        Sender sender7 = SenderBuilder
                .sender()
                .withName("Agnieszka")
                .withSurname("Kamińska")
                .withPesel("88020412389")
                .withAddress("ul. Ogrodowa 56, 44-100 Gliwice")
                .withWarnings(new ArrayList<>())
                .build();
        Sender sender8 = SenderBuilder
                .sender()
                .withName("Łukasz")
                .withSurname("Wojciechowski")
                .withPesel("84030876598")
                .withAddress("ul. Morska 11, 81-222 Gdynia")
                .withWarnings(new ArrayList<>())
                .build();
        Sender sender9 = SenderBuilder
                .sender()
                .withName("Magdalena")
                .withSurname("Jankowska")
                .withPesel("74051298760")
                .withAddress("ul. Parkowa 33, 70-410 Szczecin")
                .withWarnings(List.of(
                        ExceptionBuilder
                                .irresponsibleSenderWithDangerousGoods()
                                .withId(1)
                                .withArrivalDate(LocalDate.now())
                                .withUtilizationDate(LocalDate.now().plusDays(1))
                                .build()))
                .build();
        Sender sender10 = SenderBuilder
                .sender()
                .withName("Tomasz")
                .withSurname("Mazur")
                .withPesel("83090587612")
                .withAddress("ul. Leśna 77, 15-157 Białystok")
                .withWarnings(List.of(
                        ExceptionBuilder
                                .irresponsibleSenderWithDangerousGoods()
                                .withId(2)
                                .withArrivalDate(LocalDate.now())
                                .withUtilizationDate(LocalDate.now().plusDays(1))
                                .build(),
                        ExceptionBuilder
                                .irresponsibleSenderWithDangerousGoods()
                                .withId(3)
                                .withArrivalDate(LocalDate.now())
                                .withUtilizationDate(LocalDate.now().plusDays(1))
                                .build()))
                .build();
        List<Sender> senders = List.of(sender1, sender2, sender3, sender4, sender5, sender6, sender7, sender8, sender9, sender10);
        Harbor.getInstance().setSenders(senders);
    }

    private static void populateWarehouse() {
        Container container1 = ContainerBuilder
                .basicContainer()
                .withId(1)
                .withWeight(100)
                .withSender(Harbor.getInstance().getSenders().get(0))
                .build();
        Container container2 = ContainerBuilder
                .heavyContainer()
                .withId(2)
                .withWeight(200)
                .withTareWeight(20)
                .withSender(Harbor.getInstance().getSenders().get(1))
                .build();
        Container container3 = ContainerBuilder
                .liquidContainer()
                .withId(3)
                .withWeight(300)
                .withLiquidVolume(30)
                .withSender(Harbor.getInstance().getSenders().get(2))
                .build();
        Container container4 = ContainerBuilder
                .heavyContainer()
                .withId(4)
                .withWeight(150)
                .withTareWeight(40)
                .withSender(Harbor.getInstance().getSenders().get(3))
                .build();
        Container container5 = ContainerBuilder
                .refrigeratedContainer()
                .withId(5)
                .withWeight(200)
                .withTareWeight(50)
                .withConnectedToPower(false)
                .withSender(Harbor.getInstance().getSenders().get(4))
                .build();
        Map<Container, LocalDate> containers = Map.of(
                container1, LocalDate.now(),
                container2, LocalDate.now(),
                container3, LocalDate.now(),
                container4, LocalDate.now(),
                container5, LocalDate.now());
        Harbor.getInstance().setWarehouse(WarehouseBuilder
                .warehouse()
                .withMaxContainers(15)
                .withContainers(containers)
                .build());
    }

    private static void populateShips() {
        Container container1 = ContainerBuilder
                .looseToxicContainer()
                .withId(6)
                .withWeight(300)
                .withTareWeight(50)
                .withToxicityLevel(60)
                .withLooseToxicContainerFeature(LooseToxicContainerFeatures.VENTILATION_SYSTEM)
                .withLooseToxicContainerFeature(LooseToxicContainerFeatures.LEAK_DETECTION_SYSTEM)
                .withSender(Harbor.getInstance().getSenders().get(5))
                .build();
        Container container2 = ContainerBuilder
                .liquidToxicContainer()
                .withId(7)
                .withWeight(100)
                .withTareWeight(60)
                .withToxicityLevel(70)
                .withLiquidVolume(70)
                .withSender(Harbor.getInstance().getSenders().get(6))
                .build();
        Container container3 = ContainerBuilder
                .basicContainer()
                .withId(8)
                .withWeight(200)
                .withSender(Harbor.getInstance().getSenders().get(7))
                .build();
        Container container4 = ContainerBuilder
                .heavyContainer()
                .withId(9)
                .withWeight(300)
                .withTareWeight(90)
                .withSender(Harbor.getInstance().getSenders().get(8))
                .build();
        Container container5 = ContainerBuilder
                .liquidContainer()
                .withId(10)
                .withWeight(100)
                .withLiquidVolume(100)
                .withSender(Harbor.getInstance().getSenders().get(9))
                .build();
        Container container6 = ContainerBuilder
                .explosiveContainer()
                .withId(11)
                .withWeight(200)
                .withTareWeight(110)
                .withAdditionalProtection(AdditionalProtection.EXPLOSION_SUPPRESSORS)
                .withSender(Harbor.getInstance().getSenders().get(0))
                .build();
        Container container7 = ContainerBuilder
                .refrigeratedContainer()
                .withId(12)
                .withWeight(300)
                .withTareWeight(120)
                .withConnectedToPower(true)
                .withSender(Harbor.getInstance().getSenders().get(1))
                .build();
        Container container8 = ContainerBuilder
                .looseToxicContainer()
                .withId(13)
                .withWeight(100)
                .withTareWeight(80)
                .withToxicityLevel(130)
                .withLooseToxicContainerFeature(LooseToxicContainerFeatures.VENTILATION_SYSTEM)
                .withLooseToxicContainerFeature(LooseToxicContainerFeatures.LEAK_DETECTION_SYSTEM)
                .withSender(Harbor.getInstance().getSenders().get(2))
                .build();
        Container container9 = ContainerBuilder
                .liquidToxicContainer()
                .withId(14)
                .withWeight(200)
                .withTareWeight(140)
                .withToxicityLevel(140)
                .withLiquidVolume(140)
                .withSender(Harbor.getInstance().getSenders().get(3))
                .build();
        Container container10 = ContainerBuilder
                .basicContainer()
                .withId(15)
                .withWeight(300)
                .withSender(Harbor.getInstance().getSenders().get(4))
                .build();
        Container container11 = ContainerBuilder
                .heavyContainer()
                .withId(16)
                .withWeight(100)
                .withTareWeight(160)
                .withSender(Harbor.getInstance().getSenders().get(5))
                .build();
        Container container12 = ContainerBuilder
                .liquidContainer()
                .withId(17)
                .withWeight(200)
                .withLiquidVolume(170)
                .withSender(Harbor.getInstance().getSenders().get(6))
                .build();
        Container container13 = ContainerBuilder
                .explosiveContainer()
                .withId(18)
                .withWeight(300)
                .withTareWeight(180)
                .withAdditionalProtection(AdditionalProtection.EXPLOSION_SUPPRESSORS)
                .withSender(Harbor.getInstance().getSenders().get(7))
                .build();
        Container container14 = ContainerBuilder
                .refrigeratedContainer()
                .withId(19)
                .withWeight(100)
                .withTareWeight(90)
                .withConnectedToPower(true)
                .withSender(Harbor.getInstance().getSenders().get(8))
                .build();
        Container container15 = ContainerBuilder
                .looseToxicContainer()
                .withId(20)
                .withWeight(200)
                .withTareWeight(100)
                .withToxicityLevel(200)
                .withLooseToxicContainerFeatures(Arrays.asList(LooseToxicContainerFeatures.VENTILATION_SYSTEM, LooseToxicContainerFeatures.LEAK_DETECTION_SYSTEM))
                .withSender(Harbor.getInstance().getSenders().get(9))
                .build();
        List<Container> containers1 = List.of(container1, container2, container3);
        List<Container> containers2 = List.of(container4, container5, container6);
        List<Container> containers3 = List.of(container7, container8, container9);
        List<Container> containers4 = List.of(container10, container11, container12);
        List<Container> containers5 = List.of(container13, container14, container15);
        Ship ship1 = ShipBuilder
                .ship()
                .withId(1)
                .withName("Voyager's Whisper")
                .withOriginPort("Sapphire Bay")
                .withCargoOrigin("Brazil")
                .withCargoDestination("Japan")
                .withMaxTotalContainers(20)
                .withMaxHeavyContainers(10)
                .withMaxContainersRequiringElectricity(3)
                .withMaxToxicOrExplosiveContainers(3)
                .withMaxCargoWeight(1000)
                .withContainers(containers1)
                .build();
        Ship ship2 = ShipBuilder
                .ship()
                .withId(2)
                .withName("Celestial Navigator")
                .withOriginPort("Twilight Cove")
                .withCargoOrigin("Canada")
                .withCargoDestination("Germany")
                .withMaxTotalContainers(30)
                .withMaxHeavyContainers(20)
                .withMaxContainersRequiringElectricity(3)
                .withMaxToxicOrExplosiveContainers(3)
                .withMaxCargoWeight(2000)
                .withContainers(containers2)
                .build();
        Ship ship3 = ShipBuilder
                .ship()
                .withId(3)
                .withName("Oceanic Odyssey")
                .withOriginPort("Golden Shore Marina")
                .withCargoOrigin("India")
                .withCargoDestination("Australia")
                .withMaxHeavyContainers(30)
                .withMaxTotalContainers(40)
                .withMaxCargoWeight(3000)
                .withContainers(containers3)
                .build();
        Ship ship4 = ShipBuilder
                .ship()
                .withId(4)
                .withName("Eternal Horizon")
                .withOriginPort("Azure Haven")
                .withCargoOrigin("Mexico")
                .withCargoDestination("South Africa")
                .withMaxHeavyContainers(40)
                .withMaxTotalContainers(50)
                .withMaxCargoWeight(4000)
                .withContainers(containers4)
                .build();
        Ship ship5 = ShipBuilder
                .ship()
                .withId(5)
                .withName("Mystic Mariner")
                .withOriginPort("Whispering Waves Port")
                .withCargoOrigin("France")
                .withCargoDestination("Italy")
                .withMaxHeavyContainers(50)
                .withMaxTotalContainers(60)
                .withMaxCargoWeight(5000)
                .withContainers(containers5)
                .build();
        Harbor.getInstance().addShip(ship1);
        Harbor.getInstance().addShip(ship2);
        Harbor.getInstance().addShip(ship3);
        Harbor.getInstance().addShip(ship4);
        Harbor.getInstance().addShip(ship5);
    }
}