package org.example.model;

import java.util.Random;

public class ClassRunnable implements Runnable {

    private String label;
    int cont;


    public ClassRunnable(String label) {
        this.label = label;
    }

    @Override
    public synchronized void run() {
        for (cont = 1; cont <= 10; cont++){
            System.out.printf("Hilo --> %s = %d\n", Thread.currentThread().getName(), cont);

            try {
                // Between 100 and 2000
                Thread.sleep(new Random().nextInt(900) + 100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
