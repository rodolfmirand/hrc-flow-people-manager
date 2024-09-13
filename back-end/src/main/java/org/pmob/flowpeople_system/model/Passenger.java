package org.pmob.flowpeople_system.model;

import jakarta.persistence.*;
import lombok.Data;
import org.pmob.flowpeople_system.dto.request.PassengerRequest;
import org.pmob.flowpeople_system.model.enums.DocumentType;

import java.time.LocalTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "passenger")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, unique = true)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "document", nullable = false, unique = true)
    private String document;

    @Enumerated(EnumType.STRING)
    @Column(name = "document_type", nullable = false, unique = true)
    private DocumentType documentType;

    @Column(name = "specialty")
    private String specialty;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "number", nullable = false)
    private String number;

    @Column(name = "neighborhood", nullable = false)
    private String neighborhood;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "phone", nullable = false, unique = true)
    private String phone;

    @Column(name = "time")
    private LocalTime time;

    @Column(name = "local", nullable = false)
    private String local;

    @Column(name = "vessel_point", nullable = false)
    private String vesselPoint;

    public Passenger() {
    }

    public Passenger(PassengerRequest passengerRequest) {
        this.name = passengerRequest.getName();
        this.document = passengerRequest.getDocument();
        this.specialty = passengerRequest.getSpecialty();
        this.street = passengerRequest.getStreet();
        this.number = passengerRequest.getNumber();
        this.neighborhood = passengerRequest.getNeighrborhood();
        this.city = passengerRequest.getCity();
        this.state = passengerRequest.getState();
        this.phone = passengerRequest.getPhone();
        this.local = passengerRequest.getLocal();
        this.vesselPoint = passengerRequest.getVesselPoint();
        this.time = passengerRequest.getTime();
        this.documentType = passengerRequest.getDocumentType().equals("cpf") ? DocumentType.CPF : DocumentType.RG;
    }
}
