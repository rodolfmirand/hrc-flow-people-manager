package org.pmob.flowpeople_system.service.passenger;

import org.pmob.flowpeople_system.dto.request.PassengerRequest;
import org.pmob.flowpeople_system.dto.response.PassengerResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

public interface PassengerService {

    boolean register(PassengerRequest passengerRequest);

    List<PassengerResponse> findAll(UUID idVan);
}
