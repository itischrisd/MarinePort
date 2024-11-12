package model.exception;

import java.time.LocalDate;

public class ExceptionBuilder {

    private IrresponsibleSenderWithDangerousGoods exception;

    private ExceptionBuilder() {
        this.exception = new IrresponsibleSenderWithDangerousGoods();
    }

    public static ExceptionBuilder irresponsibleSenderWithDangerousGoods() {
        return new ExceptionBuilder();
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
        if (this.exception == null) {
            throw new IllegalStateException("This builder has already built an exception.");
        }
        IrresponsibleSenderWithDangerousGoods builtException = this.exception;
        this.exception = null;
        return builtException;
    }
}
