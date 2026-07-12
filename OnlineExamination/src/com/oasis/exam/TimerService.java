package com.oasis.exam;

public class TimerService {

    private boolean timeUp = false;

    public void startTimer(int seconds) {

        Thread timerThread = new Thread(() -> {
            try {
                Thread.sleep(seconds * 1000);
                timeUp = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        timerThread.setDaemon(true);
        timerThread.start();
    }

    public boolean isTimeUp() {
        return timeUp;
    }
}