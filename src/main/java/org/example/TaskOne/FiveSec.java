package org.example.TaskOne;

public class FiveSec extends  Thread {
    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(5000);
                System.out.println("Минуло 5 секунд");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
