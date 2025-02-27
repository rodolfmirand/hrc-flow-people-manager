package org.pmob.flowpeople_system.dto.response;

import lombok.Getter;
import org.pmob.flowpeople_system.model.Driver;

import java.util.UUID;

@Getter
public class DriverResponse {

    private UUID id;

    private String name;

    private String phone;

    public DriverResponse(Driver driver) {
        this.id = driver.getId();
        this.name = driver.getName();
        this.phone = driver.getPhone();
    }
}
