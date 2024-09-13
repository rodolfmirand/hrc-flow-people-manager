package org.pmob.flowpeople_system.service.driver;

import org.pmob.flowpeople_system.dto.request.DriverRequest;
import org.pmob.flowpeople_system.dto.response.DriverResponse;

import java.util.List;

public interface DriverService {

    boolean register(DriverRequest driverRequest);

    List<DriverResponse> findAll();

    DriverResponse findIdByPhone(String phone);
}
