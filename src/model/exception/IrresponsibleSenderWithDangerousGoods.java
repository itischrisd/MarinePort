package model.exception;

import java.time.LocalDate;

public class IrresponsibleSenderWithDangerousGoods extends Exception {

    private static int lastId = 0;
    private int id;
    private LocalDate arrivalDate;
    private LocalDate utilizationDate;

    public IrresponsibleSenderWithDangerousGoods(LocalDate arrivalDate, LocalDate utilizationDate) {
        super();
        id = ++lastId;
        this.arrivalDate = arrivalDate;
        this.utilizationDate = utilizationDate;
    }

    protected IrresponsibleSenderWithDangerousGoods() {

    }

    protected int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
        lastId = Math.max(lastId, id);
    }

    protected LocalDate getArrivalDate() {
        return arrivalDate;
    }

    protected void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    protected LocalDate getUtilizationDate() {
        return utilizationDate;
    }

    protected void setUtilizationDate(LocalDate utilizationDate) {
        this.utilizationDate = utilizationDate;
    }
}
