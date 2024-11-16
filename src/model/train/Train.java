package model.train;

import model.container.Container;
import model.exception.TooManyContainersException;
import model.time.Departurer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Train {

    private static final int MAX_CONTAINERS = 10;
    private List<Container> containers;

    protected Train() {
    }

    public List<Container> getContainers() {
        return Collections.unmodifiableList(containers);
    }

    protected void setContainers(List<Container> containers) {
        this.containers = new ArrayList<>(containers);
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

    @Override
    public String toString() {
        return super.toString() + " " + containers.size();
    }
}
