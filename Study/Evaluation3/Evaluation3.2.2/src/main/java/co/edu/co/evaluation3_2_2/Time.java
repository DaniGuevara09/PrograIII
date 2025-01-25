package co.edu.co.evaluation3_2_2;

import javafx.application.Platform;
import javafx.scene.control.Label;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Time implements Runnable {

    private String zone;
    private LocalTime time;
    private DateTimeFormatter formatter;
    private Label label;

    public Time(String zone, Label label) {
        this.zone = zone;
        this.label = label;
    }

    public String getTime() {
        return zone + "\n" + time.format(formatter);
    }

    @Override
    public void run() {
        try {
            while (true){
                time = ZonedDateTime.now(ZoneId.of(zone)).toLocalTime();
                formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                Platform.runLater(() -> label.setText(getTime()));

                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
