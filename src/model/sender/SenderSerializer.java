package model.sender;

import java.util.ArrayList;
import java.util.List;

public class SenderSerializer {

    public static List<String> serialize(Sender sender) {
        List<String> serializedSender = new ArrayList<>();

        serializedSender.add(sender.getName());
        serializedSender.add(sender.getSurname());
        serializedSender.add(sender.getPesel());
        serializedSender.add(sender.getAddress());
        serializedSender.add(String.valueOf(sender.getBirthDate()));

        return serializedSender;
    }
}
