package org.pmob.flowpeople_system.service.vanScheduling;

import org.pmob.flowpeople_system.dto.request.VanSchedulingRequest;
import org.pmob.flowpeople_system.dto.response.VanSchedulingResponse;
import org.pmob.flowpeople_system.model.VanScheduling;
import org.pmob.flowpeople_system.repository.VanSchedulingRepository;
import org.pmob.flowpeople_system.util.VanSchedulingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VanSchedulingServiceImplementation implements VanSchedulingService {

    @Autowired
    private VanSchedulingRepository vanSchedulingRepository;

    @Autowired
    private VanSchedulingMapper vanSchedulingMapper;

    @Override
    public boolean register(VanSchedulingRequest vanSchedulingRequest) {
//        if (vanSchedulingRepository.findByDateTimeAndPlate(vanSchedulingRequest.getDate(),
//                vanSchedulingRequest.getTime(),
//                vanSchedulingRequest.getPlateVan()).isPresent())
//            return false;

        VanScheduling vanScheduling = vanSchedulingMapper.toVanScheduling(vanSchedulingRequest);
        if (vanScheduling != null) {
            vanSchedulingRepository.save(vanScheduling);
            return true;
        }
        return false;
    }

    @Override
    public List<VanSchedulingResponse> findAll() {
        return vanSchedulingMapper.findAll(vanSchedulingRepository.findAll());
    }
}
