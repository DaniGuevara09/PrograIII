package org.example.test;

import org.example.model.ClassRunnable;
import org.example.model.ClassThread;

public class Runner {
    public static void main(String[] args) {
        long timeBegin = System.currentTimeMillis();

        System.out.println("_________________ Beginning _________________");

        /*
        ClassThread th1 = new ClassThread("Hilo 1");
        ClassThread th2 = new ClassThread("Hilo 2");
        ClassThread th3 = new ClassThread("Hilo 3");
        ClassThread th4 = new ClassThread("Hilo 4");
        ClassThread th5 = new ClassThread("Hilo 5");

        th1.start();
        th2.start();
        th3.start();
        th4.start();
        th5.start();
         */

        ClassRunnable run1 = new ClassRunnable("Hilo 1");
        ClassRunnable run2 = new ClassRunnable("Hilo 2");
        ClassRunnable run3 = new ClassRunnable("Hilo 3");
        ClassRunnable run4 = new ClassRunnable("Hilo 4");
        ClassRunnable run5 = new ClassRunnable("Hilo 5");

        Thread t1 = new Thread(run1);
        Thread t2 = new Thread(run1);
        Thread t3 = new Thread(run1);
        Thread t4 = new Thread(run1);
        Thread t5 = new Thread(run1);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        long timeEnd = System.currentTimeMillis() - timeBegin;
        System.out.println(timeEnd / 1000);


        System.out.println("_________________ The End _________________");
    }
}
