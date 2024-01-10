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
}
