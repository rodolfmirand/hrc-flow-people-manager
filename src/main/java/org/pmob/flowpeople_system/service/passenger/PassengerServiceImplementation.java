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
public class PassengerServiceImplementation implements PassengerService {

    @Autowired
    private PassengerRespository passengerRespository;

    @Autowired
    private PassengerMapper passengerMapper;

    @Autowired
    private VanRepository vanRepository;

    @Override
    public boolean register(PassengerRequest passengerRequest) {
        Passenger passenger = passengerMapper.toPassenger(passengerRequest);
        if (passenger != null) {
            passengerRespository.save(passenger);
            Van van = vanRepository.findById(passengerRequest.getIdVan()).orElse(null);
            if (van != null) {
                van.addPassenger(passenger);
                vanRepository.save(van);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<PassengerResponse> findAll(UUID idVan) {
        Van van = vanRepository.findById(idVan).orElse(null);
        if (van != null) {
            return van.getPassengers() != null ? passengerMapper.toPassengerListResponse(van.getPassengers()) : null;
        }
        return null;
    }
}
