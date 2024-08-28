package org.pmob.flowpeople_system.dto.request;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
public class VanRequest {

    private String plate;

    private String driver;

    private LocalDate date;

    private LocalTime time;

}
