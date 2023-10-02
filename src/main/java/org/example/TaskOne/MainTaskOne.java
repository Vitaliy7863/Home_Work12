package org.example.TaskOne;

public class MainTaskOne {
    public static void main(String[] args) {
        OneSec one = new OneSec();
        FiveSec fiveSec = new FiveSec();
        one.start();
        fiveSec.start();

    }
}