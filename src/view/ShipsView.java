package view;

import model.ship.Ship;
import ui.component.TableComponent;

import java.util.List;

import static lang.Data.*;

public class ShipsView extends TableComponent<Ship> {

    private static final List<ColumnDefinition<Ship>> COLUMNS = List.of(
            new ColumnDefinition<>(FIELD_ID, Ship::getId),
            new ColumnDefinition<>(FIELD_SHIP_NAME, Ship::getName),
            new ColumnDefinition<>(FIELD_ORIGIN_PORT, Ship::getOriginPort),
            new ColumnDefinition<>(FIELD_CARGO_ORIGIN, Ship::getCargoOrigin),
            new ColumnDefinition<>(FIELD_CARGO_DESTINATION, Ship::getCargoDestination),
            new ColumnDefinition<>(FIELD_MAX_TOXIC_OR_EXPLOSIVE_CONTAINERS_TRUNC, Ship::getMaxToxicOrExplosiveContainers),
            new ColumnDefinition<>(FIELD_MAX_CONTAINERS_REQUIRING_ELECTRICITY_TRUNC, Ship::getMaxContainersRequiringElectricity),
            new ColumnDefinition<>(FIELD_MAX_HEAVY_CONTAINERS_TRUNC, Ship::getMaxHeavyContainers),
            new ColumnDefinition<>(FIELD_MAX_TOTAL_CONTAINERS_TRUNC, Ship::getMaxTotalContainers),
            new ColumnDefinition<>(FIELD_MAX_CARGO_WEIGHT_TRUNC, Ship::getMaxCargoWeight),
            new ColumnDefinition<>(FIELD_CONTAINERS_COUNT, ship -> ship.getContainers().size())
    );

    public ShipsView(List<Ship> data) {
        super(COLUMNS, data);
    }
}
