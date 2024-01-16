package model.exception;

import java.time.LocalDate;

public class ExceptionBuilder {

    private IrresponsibleSenderWithDangerousGoods exception;

    public ExceptionBuilder irresponsibleSenderWithDangerousGoods() {
        exception = new IrresponsibleSenderWithDangerousGoods();
        return this;
    }

    public ExceptionBuilder withId(int id) {
        exception.setId(id);
        return this;
    }

    public ExceptionBuilder withArrivalDate(LocalDate arrivalDate) {
        exception.setArrivalDate(arrivalDate);
        return this;
    }

    public ExceptionBuilder withUtilizationDate(LocalDate utilizationDate) {
        exception.setUtilizationDate(utilizationDate);
        return this;
    }

    public IrresponsibleSenderWithDangerousGoods build() {
        IrresponsibleSenderWithDangerousGoods exception = this.exception;
        this.exception = null;
        return exception;
    }
}
