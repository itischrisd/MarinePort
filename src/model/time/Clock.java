package model.time;

import java.time.LocalDate;

public class Clock extends Thread {

    private static LocalDate date;

    public Clock(LocalDate initialDate) {
        date = initialDate;
    }

    private static synchronized void incrementDate() {
        date = date.plusDays(1);
        System.out.println("Current Date: " + date);
    }

    public static synchronized LocalDate getDate() {
        return date;
    }

    @Override
    public void run() {
        while (!interrupted()) {
            try {
                Thread.sleep(5000);
                incrementDate();
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
