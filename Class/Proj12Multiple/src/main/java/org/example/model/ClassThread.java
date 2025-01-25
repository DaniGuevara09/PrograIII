package org.example.model;

import java.util.Random;

public class ClassThread extends Thread{
    private String label;

    public ClassThread(String label) {
        this.label = label;
    }

    @Override
    public void run(){
        for (int cont = 1; cont <= 10; cont++){
            System.out.printf("Hilo --> %s = %d\n", label, cont);

            try {
                // Between 100 and 2000
                sleep(new Random().nextInt(1900) + 100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
