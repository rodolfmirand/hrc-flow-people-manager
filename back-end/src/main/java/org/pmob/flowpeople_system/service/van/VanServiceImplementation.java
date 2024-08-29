package org.pmob.flowpeople_system.service.van;

import org.pmob.flowpeople_system.dto.request.VanRequest;
import org.pmob.flowpeople_system.dto.response.VanResponse;
import org.pmob.flowpeople_system.model.Van;
import org.pmob.flowpeople_system.repository.VanRepository;
import org.pmob.flowpeople_system.util.VanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VanServiceImplementation implements VanService {

    @Autowired
    private VanRepository vanRepository;

    @Autowired
    private VanMapper vanMapper;

    @Override
    public boolean register(VanRequest vanRequest) {
        if (vanRepository.findByPlate(vanRequest.getPlate()).isPresent()) return false;

        Van van = vanMapper.toVan(vanRequest);
        vanRepository.save(van);
        return true;
    }

    @Override
    public List<VanResponse> findAll() {
        return vanMapper.toListVanResponse(vanRepository.findAll());
    }
}
