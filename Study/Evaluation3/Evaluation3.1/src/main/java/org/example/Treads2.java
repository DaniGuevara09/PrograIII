package org.example;

import java.util.ArrayList;
import java.util.Random;

public class Treads2 implements Runnable {
    private Random random;
    private ArrayList<Integer> data;
    private int size;

    private double average;
    private int interval;

    public Treads2(){
        data = new ArrayList<>();
        random = new Random();
        size = random.nextInt(50000 - 10000 + 1) + 10000; // 10k - 50k
    }

    public Treads2(int interval, ArrayList<Integer> data) {
        this.data = data;
        this.interval = interval;
        average = 0.0;
    }

    public ArrayList<Integer> dataArray(){
        // 10k y 50k
        for (int i = 0; i < size; i++) {
            data.add(random.nextInt(10000 - 500 + 1) + 500); // 500 - 10k
        }
        return data;
    }

    public void average(){
        double sum = 0;
        int pos = 0;
        int pos2 = 0;

        for (int i = 0; i < (data.size() / 5); i++) {
            sum += data.get(i * interval);
            pos ++;
        }

        if (interval == 5 && pos * 5 < data.size() + 1) {
            for (int i = 0; i < data.size() - pos * 5; i++) {
                sum += data.get(i * interval);
                pos2 ++;
            }
        }
        average = sum / (pos + pos2);
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

    public double getAverage() {
        return average;
    }
}
