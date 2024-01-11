package model.container;

import model.sender.Sender;

public class Container {

    private static int lastId = 0;
    private int id;
    private int weight;
    private Sender sender;

    protected Container() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        lastId = Math.max(lastId, id);
    }

    public void setId() {
        this.id = ++lastId;
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
