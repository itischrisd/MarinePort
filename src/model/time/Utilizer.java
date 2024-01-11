package model.time;

import java.time.LocalDate;

public class Utilizer extends Thread {

    private final Clock clock;

    public Utilizer(Clock clock) {
        this.clock = clock;
    }

    @Override
    public void run() {
        while (!interrupted()) {
            try {
                LocalDate localDate = clock.getDate();
            } catch (NullPointerException e) {
                break;
            }
        }
    }
}
