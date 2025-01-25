package co.edu.co.evaluation3_2_1.controller;

import co.edu.co.evaluation3_2_1.model.Zone;

public class CountryRunnable implements Runnable {

    private final String country;
    private Zone zone;
    private final HelloController helloController;

    public CountryRunnable(String country, HelloController helloController) {
        this.country = country;
        this.helloController = helloController;
        zone = new Zone();
    }

    public void time(int op){
        switch(op){
            case 1 -> {
                zone = new Zone("Europe/Madrid");
                helloController.setLabel(1, zone.getTime());
            }
            case 2 -> {
                zone = new Zone("America/Bogota");
                helloController.setLabel(2, zone.getTime());
            }
            case 3 -> {
                zone = new Zone("Asia/Tokyo");
                helloController.setLabel(3, zone.getTime());
            }
        }
    }

    @Override
    public void run() {
        while(true){
            try {
                switch (country) {
                    case "p1" -> time(1);
                    case "p2" -> time(2);
                    case "p3" -> time(3);
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
