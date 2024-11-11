package model.warehouse;

import model.container.Container;
import model.exception.TooManyContainersException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;

public class Warehouse {

    private Map<Container, LocalDate> containers;
    private int MAX_CONTAINERS;

    protected Warehouse() {
    }

    public Map<Container, LocalDate> getContainers() {
        return containers;
    }

    protected void setContainers(Map<Container, LocalDate> containers) {
        this.containers = containers;
    }

    protected int getMaxContainers() {
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
}
