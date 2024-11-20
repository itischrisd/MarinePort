package model.time;

import java.time.LocalDate;

public class Clock extends Thread {

    private static final int SECONDS_PER_DAY = 5000;
    private static LocalDate date;
    private static Clock instance;

    private Clock() {
        if (date == null) {
            date = LocalDate.now();
        }
    }

    public static Clock getInstance() {
        if (instance == null) {
            instance = new Clock();
        }
        return instance;
    }

    private static synchronized void incrementDate() {
        date = date.plusDays(1);
    }

    public static synchronized LocalDate getDate() {
        return date;
    }

    public static synchronized void setDate(LocalDate newDate) {
        date = newDate;
    }

    @Override
    public void run() {
        while (!interrupted()) {
            try {
                Thread.sleep(SECONDS_PER_DAY);
                incrementDate();
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
