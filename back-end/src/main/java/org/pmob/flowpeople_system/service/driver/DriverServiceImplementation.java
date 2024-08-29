package org.pmob.flowpeople_system.service.driver;

import org.pmob.flowpeople_system.dto.request.DriverRequest;
import org.pmob.flowpeople_system.dto.response.DriverResponse;
import org.pmob.flowpeople_system.model.Driver;
import org.pmob.flowpeople_system.repository.DriverRespository;
import org.pmob.flowpeople_system.util.DriverMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverServiceImplementation implements DriverService {

    @Autowired
    private DriverRespository driverRespository;

    @Autowired
    private DriverMapper driverMapper;

    @Override
    public boolean register(DriverRequest driverRequest) {
        if (driverRespository.findByCnh(driverRequest.getCnh()).isPresent()) return false;

        Driver driver = driverMapper.toDriver(driverRequest);
        driverRespository.save(driver);
        return true;
    }

    @Override
    public List<DriverResponse> findAll() {
        return driverMapper.toDriverList(driverRespository.findAll());
    }
}
