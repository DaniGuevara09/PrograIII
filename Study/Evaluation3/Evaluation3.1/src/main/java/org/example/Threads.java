package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class Threads implements Runnable {

    private Random random;
    private ArrayList<Integer> data;
    private int size;
    private int method;

    public Threads() {
        data = new ArrayList<>();
        random = new Random();
        size = random.nextInt(50000 - 10000 + 1) + 10000; // 10k - 50k
    }

    public Threads(int method, ArrayList<Integer> data) {
        this.data = data;
        this.method = method;
    }

    public Threads(int method){
        data = new ArrayList<>();
        this.method = method;
        random = new Random();
        size = random.nextInt(50000 - 10000 + 1) + 10000; // 10k - 50k
    }

    public ArrayList<Integer> dataArray(){
        // 10k y 50k
        for (int i = 0; i < size; i++) {
            data.add(random.nextInt(10000 - 500 + 1) + 500); // 500 - 10k
        }
        return data;
    }

    public double average(){
        double sum = 0;

        for (int i = 0; i < data.size(); i++) {
            sum += data.get(i);
        }
        return sum / data.size();
    }

    public int median(){
        sort();
        return size % 2 == 0? (data.get(data.size() / 2) + data.get(data.size() / 2 - 1)) / 2 : data.get((size + 1) / 2);
    }

    public double mode(){
        HashMap<Integer, Integer> frecuencias = new HashMap<>();
        int mode = data.getFirst(), maxFrequency = 0;

        for (int num : data) {
            int frecuencia = frecuencias.merge(num, 1, Integer::sum);
            if (frecuencia > maxFrequency) {
                maxFrequency = frecuencia;
                mode = num;
            }
        }
        return mode;
    }

    public void sort(){
        Collections.sort(data);
    }

    @Override
    public void run() {
        try {
            switch (method){
                case 1 -> average();
                case 2 -> median();
                case 3 -> mode();
            }
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
