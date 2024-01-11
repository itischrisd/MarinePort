package model.exception;

public class IrresponsibleSenderWithDangerousGoods extends Exception {

    private static int lastId = 0;
    private int id;
    private String arrivalDate;
    private String utilizationDate;

    public IrresponsibleSenderWithDangerousGoods() {
        super();
        id = ++lastId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        lastId = Math.max(lastId, id);
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getUtilizationDate() {
        return utilizationDate;
    }

    public void setUtilizationDate(String utilizationDate) {
        this.utilizationDate = utilizationDate;
    }
}
