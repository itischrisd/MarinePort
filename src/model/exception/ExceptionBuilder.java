package model.exception;

import java.time.LocalDate;

import static lang.ErrorMessage.*;

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
            throw new IllegalStateException(EXCEPTION_ALREADY_BUILT);
        }
        if (isInvalidException()) {
            throw new IllegalStateException(INVALID_EXCEPTION);
        }
        IrresponsibleSenderWithDangerousGoods builtException = this.exception;
        this.exception = null;
        return builtException;
    }

    private boolean isInvalidException() {
        return exception.getId() <= 0 || exception.getArrivalDate() == null || exception.getUtilizationDate() == null;
    }
}
