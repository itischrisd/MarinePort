package model.container;

import model.Sender;

public class Container {

    private static int lastId = 0;
    private int id;
    private int weight;
    private Sender sender;

    public Container(int weight, Sender sender) {
        this.id = createId();
        this.weight = weight;
        this.sender = sender;
    }

    public static int getLastId() {
        return lastId;
    }

    public static void setLastId(int lastId) {
        Container.lastId = lastId;
    }

    protected static int createId() {
        return ++lastId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Sender getSender() {
        return sender;
    }

    public void setSender(Sender sender) {
        this.sender = sender;
    }
}
