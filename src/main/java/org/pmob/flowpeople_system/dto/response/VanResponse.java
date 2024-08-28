package org.pmob.flowpeople_system.dto.response;

import lombok.Getter;
import org.pmob.flowpeople_system.model.Passenger;
import org.pmob.flowpeople_system.model.Van;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
public class VanResponse {

    private UUID id;

    private String plate;

    private String driver;

    private LocalDate date;

    private LocalTime time;

    private List<Passenger> passengers = new ArrayList<>();

    public VanResponse(Van van) {
        this.id = van.getId();
        this.plate = van.getPlate();
        this.driver = van.getDriver();
        this.date = van.getDate();
        this.time = van.getTime();
        if (van.getPassengers() != null) {
            this.passengers.addAll(van.getPassengers());
        } else {
            this.passengers = null;
        }
    }

}
