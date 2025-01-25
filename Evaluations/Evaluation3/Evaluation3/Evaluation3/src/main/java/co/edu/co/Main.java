package co.edu.co;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op = 0;

        while (op != 3) {
            System.out.printf("\n_____ Select an option _____\n\n1. See the Major, Minor and Average of All Data\n2. See at the average per branch\n3. Exit%n");
            op = sc.nextInt();

            switch (op) {
                case 1 -> workshopParallelism();
                case 2 -> dataParallelism();
            }
        }
    }

    public static void dataParallelism(){
        Branches branches = new Branches();
        ArrayList<Integer> data = branches.randomArray();

        Branches t1 = new Branches(1, data);
        Branches t2 = new Branches(2, data);
        Branches t3 = new Branches(3, data);
        Branches t4 = new Branches(4, data);
        Branches t5 = new Branches(5, data);

        t1.run();
        t2.run();
        t3.run();
        t4.run();
        t5.run();

        System.out.println("Branch 1: " + t1.average());
        System.out.println("Branch 2: " + t2.average());
        System.out.println("Branch 3: " + t3.average());
        System.out.println("Branch 4: " + t4.average());
        System.out.println("Branch 5: " + t5.average());
    }

    public static void workshopParallelism(){
        AllData allData = new AllData();

        ArrayList<Integer> data = allData.randomArray();

        AllData m1 = new AllData(1, data);
        AllData m2 = new AllData(2, data);
        AllData m3 = new AllData(3, data);

        m1.run();
        m2.run();
        m3.run();

        System.out.println("Minor: $" + m1.minor());
        System.out.println("Major: $" + m2.major());
        System.out.println("Average: $" + m3.average());
    }
}