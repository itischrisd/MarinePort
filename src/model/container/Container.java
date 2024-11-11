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

    protected void setId(int id) {
        this.id = id;
        lastId = Math.max(lastId, id);
    }

    protected void setId() {
        this.id = ++lastId;
    }

    public int getWeight() {
        return weight;
    }

    protected void setWeight(int weight) {
        this.weight = weight;
    }

    public Sender getSender() {
        return sender;
    }

    protected void setSender(Sender sender) {
        this.sender = sender;
    }
}
