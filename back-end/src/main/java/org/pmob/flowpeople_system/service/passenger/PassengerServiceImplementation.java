package org.pmob.flowpeople_system.service.passenger;

import org.pmob.flowpeople_system.dto.request.PassengerRequest;
import org.pmob.flowpeople_system.dto.response.PassengerResponse;
import org.pmob.flowpeople_system.model.Passenger;
import org.pmob.flowpeople_system.model.Van;
import org.pmob.flowpeople_system.repository.PassengerRespository;
import org.pmob.flowpeople_system.repository.VanRepository;
import org.pmob.flowpeople_system.util.PassengerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PassengerServiceImplementation {

    @Autowired
    private PassengerRespository passengerRespository;

    @Autowired
    private PassengerMapper passengerMapper;

    @Autowired
    private VanRepository vanRepository;

}
