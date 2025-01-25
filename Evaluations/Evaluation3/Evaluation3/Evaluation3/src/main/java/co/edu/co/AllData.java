package co.edu.co;

import java.util.ArrayList;
import java.util.Random;

public class AllData implements Runnable{
    private ArrayList<Integer> dataPrice;
    private int size;
    private Random random;
    private int numMethod;

    public AllData() {
        size = 500;
        dataPrice = new ArrayList<>();
        random = new Random();
    }

    public AllData(int mehod, ArrayList<Integer> dataPrice) {
        this.dataPrice = dataPrice;
        numMethod = mehod;
    }

    public int major() {
        int major = 0;

        for (int i = 1; i < dataPrice.size(); i++) {
            if (dataPrice.get(i) > major) {
                major = dataPrice.get(i);
            }
        }
        return major;
    }

    public int minor() {
        int minor = 100001;

        for (int i = 1; i < dataPrice.size(); i++) {
            if (dataPrice.get(i) < minor) {
                minor = dataPrice.get(i);
            }
        }
        return minor;
    }

    public int average() {
        int sum = 0;

        for (int i = 1; i < dataPrice.size(); i++) {
            sum += dataPrice.get(i);
        }

        return sum / dataPrice.size();
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
            switch (numMethod){
                case 1 -> minor();
                case 2 -> major();
                case 3 -> average();
            }
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
