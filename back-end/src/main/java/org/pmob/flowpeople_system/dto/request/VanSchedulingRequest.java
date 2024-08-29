package org.pmob.flowpeople_system.dto.request;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
public class VanSchedulingRequest {

    private String cnhDriver;

    private String plateVan;

    private LocalDate date;

    private LocalTime time;

}
