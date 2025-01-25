package co.edu.co.evaluation3_2_1.model;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Zone {
    private String zone;

    public Zone() {
    }

    public Zone(String zone) {
        this.zone = zone;
    }

    public String getTime() {
        return zone + "\n" + ZonedDateTime.now(ZoneId.of(zone));
    }
}
