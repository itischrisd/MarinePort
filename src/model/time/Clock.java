package model.time;

import java.time.LocalDate;

public class Clock extends Thread {

    private LocalDate date;

    public Clock(LocalDate initialDate) {
        this.date = initialDate;
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

    private synchronized void incrementDate() {
        date = date.plusDays(1);
        System.out.println("Current Date: " + date);
    }

    public synchronized LocalDate getDate() {
        return date;
    }
}
