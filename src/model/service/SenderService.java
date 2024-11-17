package model.service;

import model.Harbor;
import model.sender.Sender;

import java.util.List;

public class SenderService {

    public static List<Sender> getSenders() {
        return Harbor.getInstance().getSenders();
    }
}
