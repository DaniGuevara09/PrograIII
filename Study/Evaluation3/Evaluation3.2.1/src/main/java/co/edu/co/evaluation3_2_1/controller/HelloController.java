package co.edu.co.evaluation3_2_1.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {

    @FXML
    private Label p1;

    @FXML
    private Label p2;

    @FXML
    private Label p3;

    public void initialize() {
        // Esperar unos milisegundos para asegurarse de que los controles estén listos
        Platform.runLater(() -> {
            try {
                Thread.sleep(500);  // Pausa corta para dar tiempo a que los controles se inicialicen
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Se inicializan los hilos solo cuando la UI está completamente cargada
            CountryRunnable r1 = new CountryRunnable("p1", this);
            CountryRunnable r2 = new CountryRunnable("p2", this);
            CountryRunnable r3 = new CountryRunnable("p3", this);

            // Iniciar los hilos
            new Thread(r1).start();
            new Thread(r2).start();
            new Thread(r3).start();
            System.out.println("Hilos Iniciados");
        });
    }

    public void setLabel(int op, String time) {
        System.out.println(time);
        Platform.runLater(() -> {
                switch (op) {
                    case 1 -> p1 = new Label(time);
                    case 2 -> p2 = new Label(time);
                    case 3 -> p3 = new Label(time);
                }
        });
    }


}
