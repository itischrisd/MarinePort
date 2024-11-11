package model.warehouse;

import model.container.Container;
import model.container.ExplosiveContainer;
import model.container.LiquidToxicContainer;
import model.container.LooseToxicContainer;
import model.exception.TooManyContainersException;
import model.time.Clock;

import java.time.LocalDate;
import java.util.*;

public class Warehouse {

    private final int MAX_EXPLOSIVE_TIME = 5;
    private final int MAX_LIQUID_TOXIC_TIME = 10;
    private final int MAX_LOOSE_TOXIC_TIME = 14;
    private Map<Container, LocalDate> containers;
    private int MAX_CONTAINERS;

    protected Warehouse() {
    }

    public Map<Container, LocalDate> getContainers() {
        return Collections.unmodifiableMap(containers);
    }

    protected void setContainers(Map<Container, LocalDate> containers) {
        this.containers = containers;
    }

    public int getMaxContainers() {
        return MAX_CONTAINERS;
    }

    protected void setMaxContainers(int maxContainers) {
        MAX_CONTAINERS = maxContainers;
    }

    public void addContainer(Container container) throws TooManyContainersException {
        if (containers.size() < MAX_CONTAINERS) {
            containers.put(container, LocalDate.now());
        } else {
            throw new TooManyContainersException();
        }
    }

    public void removeContainerById(int id) {
        for (Container container : containers.keySet()) {
            if (container.getId() == id) {
                containers.remove(container);
                break;
            }
        }
    }

    public void removeContainerByPosition(int position) {
        List<Container> containerList = new ArrayList<>(containers.keySet());
        containers.remove(containerList.get(position));
    }

    public void sortContainers() {
        Map<Container, LocalDate> containersCopy = new LinkedHashMap<>(this.containers);
        this.containers.clear();
        containersCopy.entrySet().stream()
                .sorted(Map.Entry.<Container, LocalDate>comparingByValue().thenComparing(e -> e.getKey().getSender().getName()))
                .forEach(e -> this.containers.put(e.getKey(), e.getValue()));
    }

    public boolean isOverdue(Map.Entry<Container, LocalDate> container) {
        if (container.getKey() instanceof ExplosiveContainer) {
            return container.getValue().plusDays(MAX_EXPLOSIVE_TIME).isBefore(Clock.getDate());
        } else if (container.getKey() instanceof LiquidToxicContainer) {
            return container.getValue().plusDays(MAX_LIQUID_TOXIC_TIME).isBefore(Clock.getDate());
        } else if (container.getKey() instanceof LooseToxicContainer) {
            return container.getValue().plusDays(MAX_LOOSE_TOXIC_TIME).isBefore(Clock.getDate());
        }
        return false;
    }
}
