package org.example.TaskOne;

public class OneSec extends Thread {

    long startTime = System.currentTimeMillis();

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(1000);
                System.out.println((System.currentTimeMillis() - startTime) / 1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}