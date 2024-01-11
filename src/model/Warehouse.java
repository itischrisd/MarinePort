package model;

import model.container.Container;
import model.exception.TooManyContainersException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Warehouse {

    private final Map<Container, LocalDate> containers;
    private int MAX_CONTAINERS;

    public Warehouse() {
        containers = new LinkedHashMap<>();
    }

    public Warehouse(int maxContainers) {
        MAX_CONTAINERS = maxContainers;
        containers = new LinkedHashMap<>();
    }

    public void addContainer(Container container) throws TooManyContainersException {
        if (containers.size() < MAX_CONTAINERS) {
            containers.put(container, LocalDate.now());
        } else {
            throw new TooManyContainersException();
        }
    }

    public Map<Container, LocalDate> getContainers() {
        return containers;
    }

    public int getMaxContainers() {
        return MAX_CONTAINERS;
    }

    public void setMaxContainers(int maxContainers) {
        MAX_CONTAINERS = maxContainers;
    }

    //remove container from warehouse by its id
    public void removeContainer(int id) {
        for (Container container : containers.keySet()) {
            if (container.getId() == id) {
                containers.remove(container);
                break;
            }
        }
    }

    //remove container from warehouse by its position in HashMap

}
