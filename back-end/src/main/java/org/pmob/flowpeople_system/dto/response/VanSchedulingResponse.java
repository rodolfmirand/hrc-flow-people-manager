package org.pmob.flowpeople_system.dto.response;

import lombok.Getter;
import org.pmob.flowpeople_system.model.Passenger;
import org.pmob.flowpeople_system.model.VanScheduling;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class VanSchedulingResponse {

    private DriverResponse driver;

    private VanResponse van;

    private LocalDate date;

    private LocalTime time;

    private List<PassengerResponse> passengers = new ArrayList<>();

    public VanSchedulingResponse(VanScheduling vanScheduling) {
        this.driver = new DriverResponse(vanScheduling.getDriver());
        this.van = new VanResponse(vanScheduling.getVan());
        this.date = vanScheduling.getDate();
        this.time = vanScheduling.getTime();
        if (vanScheduling.getPassengers() == null) this.passengers = null;
        else {
            for (Passenger passenger : vanScheduling.getPassengers()) {
                this.passengers.add(new PassengerResponse(passenger));
            }
        }
    }
}
