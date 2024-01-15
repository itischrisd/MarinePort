package model.warehouse;

import model.container.Container;
import model.exception.TooManyContainersException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Warehouse {

    private Map<Container, LocalDate> containers;
    private int MAX_CONTAINERS;

    public Warehouse() {
        containers = new LinkedHashMap<>();
    }

    public Warehouse(int maxContainers) {
        MAX_CONTAINERS = maxContainers;
        containers = new LinkedHashMap<>();
    }

    public Map<Container, LocalDate> getContainers() {
        return containers;
    }

    public void setContainers(Map<Container, LocalDate> containers) {
        this.containers = containers;
    }

    public int getMaxContainers() {
        return MAX_CONTAINERS;
    }

    public void setMaxContainers(int maxContainers) {
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
}
