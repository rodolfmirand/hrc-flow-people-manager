package org.pmob.flowpeople_system.model;

import jakarta.persistence.*;
import lombok.Data;
import org.pmob.flowpeople_system.dto.request.PassengerRequest;

import java.time.LocalTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "passenger")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "time")
    private LocalTime time;

    @Column(name = "specialty")
    private String specialty;

    @Column(name = "local")
    private String local;

    @Column(name = "vessel_point")
    private String vesselPoint;

    @Column(name = "document", unique = true, nullable = false)
    private String document;

    public Passenger() {
    }

    public Passenger(PassengerRequest passengerRequest) {
        this.name = passengerRequest.getName();
        this.phone = passengerRequest.getPhone();
        this.document = passengerRequest.getDocument();
        this.address = passengerRequest.getAdress();
        this.specialty = passengerRequest.getSpecialty();
        this.local = passengerRequest.getLocal();
        this.vesselPoint = passengerRequest.getVesselPoint();
        this.time = passengerRequest.getTime();
    }
}
