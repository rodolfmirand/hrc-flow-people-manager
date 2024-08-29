package org.pmob.flowpeople_system.util;

import org.pmob.flowpeople_system.dto.request.DriverRequest;
import org.pmob.flowpeople_system.dto.response.DriverResponse;
import org.pmob.flowpeople_system.model.Driver;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DriverMapper {

    public Driver toDriver(DriverRequest driverRequest) {
        return new Driver(driverRequest);
    }

    public List<DriverResponse> toDriverList(List<Driver> drivers) {
        List<DriverResponse> driversResponse = new ArrayList<>();
        for (Driver driver : drivers) {
            driversResponse.add(new DriverResponse(driver));
        }
        return driversResponse;
    }
}
