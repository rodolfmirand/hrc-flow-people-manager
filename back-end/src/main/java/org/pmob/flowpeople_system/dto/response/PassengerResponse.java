package org.pmob.flowpeople_system.dto.response;

import lombok.Getter;
import org.pmob.flowpeople_system.model.Passenger;

import java.util.UUID;

@Getter
public class PassengerResponse {

    private UUID id;

    private String name;

    private String document;

    private String street;

    private String number;

    private String neighborhood;

    private String city;

    private String state;

    private String phone;

    private String specialty;

    private String local;

    private String vesselPoint;

    public PassengerResponse(Passenger passenger) {
        this.id = passenger.getId();
        this.name = passenger.getName();
        this.document = passenger.getDocument();
        this.street = passenger.getStreet();
        this.number = passenger.getNumber();
        this.neighborhood = passenger.getNeighborhood();
        this.city = passenger.getCity();
        this.state = passenger.getState();
        this.phone = passenger.getPhone();
        this.specialty = passenger.getSpecialty();
        this.local = passenger.getLocal();
        this.vesselPoint = passenger.getVesselPoint();
    }
}
