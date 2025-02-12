package view;

import model.ship.Ship;
import ui.component.TableComponent;

import java.util.List;

public class ShipsView extends TableComponent<Ship> {

    private static final List<ColumnDefinition<Ship>> COLUMNS = List.of(
            new ColumnDefinition<>("ID", Ship::getId),
            new ColumnDefinition<>("Nazwa", Ship::getName),
            new ColumnDefinition<>("Port macierzysty", Ship::getOriginPort),
            new ColumnDefinition<>("Port załadunku", Ship::getCargoOrigin),
            new ColumnDefinition<>("Port rozładunku", Ship::getCargoDestination),
            new ColumnDefinition<>("Max ekspl./toks.", Ship::getMaxToxicOrExplosiveContainers),
            new ColumnDefinition<>("Max elektr.", Ship::getMaxContainersRequiringElectricity),
            new ColumnDefinition<>("Max ciężkich", Ship::getMaxHeavyContainers),
            new ColumnDefinition<>("Max zwykłych", Ship::getMaxTotalContainers),
            new ColumnDefinition<>("Max waga", Ship::getMaxCargoWeight),
            new ColumnDefinition<>("Liczba kontenerów", ship -> ship.getContainers().size())
    );

    public ShipsView(List<Ship> data) {
        super(COLUMNS, data);
    }
}
