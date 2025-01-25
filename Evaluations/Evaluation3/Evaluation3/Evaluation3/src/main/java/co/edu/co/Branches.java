package co.edu.co;

import java.util.ArrayList;
import java.util.Random;

public class Branches implements Runnable{
    private ArrayList<Integer> dataPrice;
    private int size;
    private Random random;
    private int interval;

    public Branches() {
        dataPrice = new ArrayList<>();
        random = new Random();
        size = 500;
    }

    public Branches(int interval, ArrayList<Integer> dataPrice) {
        this.interval = interval;
        this.dataPrice = dataPrice;
    }

    public int average() {
        int sum = 0;
        int firstPos = 0;
        int finalPos = 0;

        switch (interval){
            case 1:
                finalPos = 99;
            break;
            case 2:
                firstPos = 100;
                finalPos = 199;
            break;
            case 3:
                firstPos = 200;
                finalPos = 299;
            break;
            case 4:
                firstPos = 300;
                finalPos = 399;
            break;
            case 5:
                firstPos = 400;
                finalPos = 499;
        }

        for (int i = firstPos; i < finalPos; i++) {
            sum += dataPrice.get(i);
        }

        return sum / 100;
    }

    public ArrayList<Integer> randomArray() {
        for (int i = 0; i < size; i++) {
            dataPrice.add(random.nextInt(100000 - 50000 + 1) + 50000); // 50k - 100k
        }
        return dataPrice;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            average();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
