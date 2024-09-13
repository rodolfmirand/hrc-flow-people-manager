package org.pmob.flowpeople_system.dto.request;

import lombok.Getter;

import java.time.LocalTime;
import java.util.UUID;

@Getter
public class PassengerRequest {

    private UUID idVan;

    private String name;

    private String document;

    private String documentType;

    private String street;

    private String number;

    private String neighrborhood;

    private String city;

    private String state;

    private String phone;

    private String specialty;

    private String local;

    private String vesselPoint;

    private LocalTime time;

}
