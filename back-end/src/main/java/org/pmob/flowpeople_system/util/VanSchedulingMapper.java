package org.pmob.flowpeople_system.util;

import org.pmob.flowpeople_system.dto.request.VanSchedulingRequest;
import org.pmob.flowpeople_system.dto.response.VanSchedulingResponse;
import org.pmob.flowpeople_system.model.Driver;
import org.pmob.flowpeople_system.model.Van;
import org.pmob.flowpeople_system.model.VanScheduling;
import org.pmob.flowpeople_system.repository.DriverRespository;
import org.pmob.flowpeople_system.repository.VanRepository;
import org.pmob.flowpeople_system.service.driver.DriverService;
import org.pmob.flowpeople_system.service.van.VanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VanSchedulingMapper {

    @Autowired
    private VanRepository vanRepository;

    @Autowired
    private DriverRespository driverRespository;

    public VanScheduling toVanScheduling(VanSchedulingRequest vanSchedulingRequest) {
        Van van = vanRepository.findByPlate(vanSchedulingRequest.getPlateVan()).orElse(null);
        if (van == null) return null;

        Driver driver = driverRespository.findByPhone(vanSchedulingRequest.getDriverPhone()).orElse(null);
        if (driver == null) return null;

        return new VanScheduling(van, driver, vanSchedulingRequest.getDate(), vanSchedulingRequest.getTime());
    }

    public List<VanSchedulingResponse> findAll(List<VanScheduling> vanSchedulings){
        List<VanSchedulingResponse> vansSchedulingResponse = new ArrayList<>();
        for(VanScheduling scheduling : vanSchedulings){
            vansSchedulingResponse.add(new VanSchedulingResponse(scheduling));
        }
        return vansSchedulingResponse;
    }
}
