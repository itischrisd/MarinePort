package model.warehouse;

import model.container.Container;
import model.container.ExplosiveContainer;
import model.container.LiquidToxicContainer;
import model.container.LooseToxicContainer;
import model.exception.IrresponsibleSenderWithDangerousGoods;
import model.exception.TooManyContainersException;
import model.time.Clock;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Warehouse {

    private static final int MAX_EXPLOSIVE_TIME = 5;
    private static final int MAX_LIQUID_TOXIC_TIME = 10;
    private static final int MAX_LOOSE_TOXIC_TIME = 14;
    private Map<Container, LocalDate> containers;
    private int MAX_CONTAINERS;

    protected Warehouse() {
        this.containers = new ConcurrentHashMap<>();
    }

    public static int calculateDaysBeforeUtilization(Map.Entry<Container, LocalDate> entry) {
        return switch (entry.getKey()) {
            case ExplosiveContainer ignored -> MAX_EXPLOSIVE_TIME - Clock.getDate().compareTo(entry.getValue());
            case LiquidToxicContainer ignored -> MAX_LIQUID_TOXIC_TIME - Clock.getDate().compareTo(entry.getValue());
            case LooseToxicContainer ignored -> MAX_LOOSE_TOXIC_TIME - Clock.getDate().compareTo(entry.getValue());
            default -> 0;
        };
    }

    public Map<Container, LocalDate> getContainers() {
        return Collections.unmodifiableMap(containers);
    }

    protected void setContainers(Map<Container, LocalDate> containers) {
        this.containers = new ConcurrentHashMap<>(containers);
    }

    public int getMaxContainers() {
        return MAX_CONTAINERS;
    }

    protected void setMaxContainers(int maxContainers) {
        MAX_CONTAINERS = maxContainers;
    }

    public void addContainer(Container container) throws TooManyContainersException {
        if (containers.size() < MAX_CONTAINERS) {
            containers.put(container, Clock.getDate());
        } else {
            throw new TooManyContainersException();
        }
    }

    public Container getContainerById(int id) {
        return containers.keySet().stream().filter(container -> container.getId() == id).findFirst().orElse(null);
    }

    public void removeContainerById(int id) {
        containers.keySet().stream().filter(container -> container.getId() == id).findFirst().ifPresent(container -> containers.remove(container));
    }

    public void sortContainers() {
        Map<Container, LocalDate> containersCopy = new ConcurrentHashMap<>(this.containers);
        this.containers.clear();
        containersCopy.entrySet().stream()
                .sorted(Map.Entry.<Container, LocalDate>comparingByValue().thenComparing(e -> e.getKey().getSender().getSurname()))
                .forEach(e -> this.containers.put(e.getKey(), e.getValue()));
    }

    private boolean isOverdue(Map.Entry<Container, LocalDate> container) {
        return switch (container.getKey()) {
            case ExplosiveContainer ignored ->
                    container.getValue().plusDays(MAX_EXPLOSIVE_TIME).isBefore(Clock.getDate());
            case LiquidToxicContainer ignored ->
                    container.getValue().plusDays(MAX_LIQUID_TOXIC_TIME).isBefore(Clock.getDate());
            case LooseToxicContainer ignored ->
                    container.getValue().plusDays(MAX_LOOSE_TOXIC_TIME).isBefore(Clock.getDate());
            default -> false;
        };
    }

    public void removeOverdueContainers() {
        List<Container> containersToRemove = containers.entrySet().stream().filter(this::isOverdue).map(Map.Entry::getKey).toList();
        containersToRemove.forEach(container -> {
            try {
                LocalDate storageDate = containers.get(container);
                LocalDate currentDate = Clock.getDate();
                throw new IrresponsibleSenderWithDangerousGoods(storageDate, currentDate);
            } catch (IrresponsibleSenderWithDangerousGoods e) {
                container.getSender().addWarning(e);
            }
            containers.remove(container);
        });
    }
}
