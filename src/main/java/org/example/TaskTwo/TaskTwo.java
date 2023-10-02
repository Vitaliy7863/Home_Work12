package org.example.TaskTwo;

public class TaskTwo extends Thread {
    int counter = 1;
    int value;
    StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        TaskTwo taskTwo = new TaskTwo(120);
        taskTwo.start();
    }

    @Override
    public void run() {
        TaskTwo taskTwo = new TaskTwo(value);
        Thread threadFizzbuzz = new Thread(() -> {
            try {
                taskTwo.fizzbuzz();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        threadFizzbuzz.start();

        Thread threadFizz = new Thread(() -> {
            try {
                taskTwo.fizz();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        threadFizz.start();

        Thread threadBuzz = new Thread(() -> {
            try {
                taskTwo.buzz();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        threadBuzz.start();

        Thread threadNumber = new Thread(() -> {
            try {
                taskTwo.number();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        threadNumber.start();
    }

    public synchronized void fizzbuzz() throws InterruptedException {
        while (counter <= value) {
            if (counter % 15 == 0) {
                if (counter < value) {
                    stringBuilder.append("fizzbuzz, ");
                } else {
                    stringBuilder.append("fizzbuzz");
                }
                counter++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public synchronized void fizz() throws InterruptedException {
        while (counter <= value) {
            if (counter % 3 == 0 && counter % 15 != 0) {
                if (counter < value) {
                    stringBuilder.append("fizz, ");
                } else {
                    stringBuilder.append("fizz");
                }
                counter++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public synchronized void buzz() throws InterruptedException {
        while (counter <= value && counter % 15 != 0) {
            if (counter % 5 == 0) {
                if (counter < value) {
                    stringBuilder.append("buzz, ");
                } else {
                    stringBuilder.append("buzz");
                }
                counter++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public synchronized void number() throws InterruptedException {
        while (counter <= value) {
            if (counter % 5 != 0 && counter % 3 != 0) {
                if (counter < value) {
                    stringBuilder.append(counter).append(", ");
                } else {
                    stringBuilder.append(counter);
                }
                counter++;
                notifyAll();
            } else {
                wait();
            }
            if (counter - 1 == value) {
                System.out.println(stringBuilder);
            }
        }
    }

    public TaskTwo(int value) {
        this.value = value;
    }
}