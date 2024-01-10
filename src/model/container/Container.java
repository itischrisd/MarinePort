package model.container;

public abstract class Container {

    private static int lastId = 0;

    public abstract int getWieght();

    protected int createId() {
        return ++lastId;
    }
}
