package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op = 0;

        while (op != 3) {
            System.out.printf("Select an option:\n1. Data\n2. Workshop\n3. Exit%n");
            op = sc.nextInt();

            switch (op) {
                case 1 -> dataParallelism();
                case 2 -> workshopParallelism();
            }
        }
    }

    private static void dataParallelism() {
        Treads2 treads2 = new Treads2();
        ArrayList<Integer> data = treads2.dataArray();

        Treads2 t1 = new Treads2(1, data);
        Treads2 t2 = new Treads2(2, data);
        Treads2 t3 = new Treads2(3, data);
        Treads2 t4 = new Treads2(4, data);
        Treads2 t5 = new Treads2(5, data);

        t1.run();
        t2.run();
        t3.run();
        t4.run();
        t5.run();

        System.out.println("Av 1: " + t1.getAverage());
        System.out.println("Av 2: " + t2.getAverage());
        System.out.println("Av 3: " + t3.getAverage());
        System.out.println("Av 4: " + t4.getAverage());
        System.out.println("Av 5: " + t5.getAverage());
    }

    public static void workshopParallelism(){
        Threads threads = new Threads();

        ArrayList<Integer> data = threads.dataArray();

        Threads m1 = new Threads(1, data);
        Threads m2 = new Threads(2, data);
        Threads m3 = new Threads(3, data);

        m1.run();
        m2.run();
        m3.run();

        System.out.println("Average: " + m1.average());
        System.out.println("Median: " + m2.median());
        System.out.println("Mode: " + m3.mode());

        System.out.println("Size: " + data.size());
        data.sort(Integer::compareTo);
        System.out.println("First: " + data.getFirst());
        System.out.println("Last: " + data.getLast());
    }
}