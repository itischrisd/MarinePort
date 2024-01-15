package model;

import model.container.Container;
import model.exception.TooManyContainersException;
import model.time.Departurer;

import java.util.ArrayList;
import java.util.List;

public class Train {

    private static final int MAX_CONTAINERS = 10;
    private List<Container> containers;

    public Train() {
        containers = new ArrayList<>();
    }

    public void addContainer(Container container) throws TooManyContainersException {
        if (containers.size() < MAX_CONTAINERS) {
            containers.add(container);
        } else {
            throw new TooManyContainersException();
        }

        if (containers.size() == MAX_CONTAINERS) {
            Departurer departurer = new Departurer();
            departurer.start();
        }
    }

    public List<Container> getContainers() {
        return containers;
    }

    public void setContainers(List<Container> containers) {
        this.containers = containers;
    }
}
