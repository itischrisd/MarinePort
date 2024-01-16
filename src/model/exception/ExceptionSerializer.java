package model.exception;

import java.util.List;

public class ExceptionSerializer {

    public static List<String> serialize(IrresponsibleSenderWithDangerousGoods exception) {
        return List.of(
            String.valueOf(exception.getId()),
            exception.getArrivalDate().toString(),
            exception.getUtilizationDate().toString()
        );
    }
}
