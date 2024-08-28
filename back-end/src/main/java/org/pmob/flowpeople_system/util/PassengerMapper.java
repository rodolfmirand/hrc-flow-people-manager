package org.pmob.flowpeople_system.util;

import org.pmob.flowpeople_system.dto.request.PassengerRequest;
import org.pmob.flowpeople_system.dto.response.PassengerResponse;
import org.pmob.flowpeople_system.model.Passenger;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PassengerMapper {

    public Passenger toPassenger(PassengerRequest passengerRequest) {
        return new Passenger(passengerRequest);
    }

    public List<PassengerResponse> toPassengerListResponse(List<Passenger> passengerList) {
        List<PassengerResponse> passengerResponseList = new ArrayList<>();
        for (Passenger passenger : passengerList) {
            passengerResponseList.add(new PassengerResponse(passenger));
        }
        return passengerResponseList;
    }
}
