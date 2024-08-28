package org.pmob.flowpeople_system.service.van;

import org.pmob.flowpeople_system.dto.request.VanRequest;
import org.pmob.flowpeople_system.dto.request.VanUpdateRequest;
import org.pmob.flowpeople_system.dto.response.VanResponse;
import org.pmob.flowpeople_system.model.Van;
import org.pmob.flowpeople_system.repository.VanRepository;
import org.pmob.flowpeople_system.util.VanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VanServiceImplementation implements VanService {

    @Autowired
    private VanRepository vanRepository;

    @Autowired
    private VanMapper vanMapper;

    @Override
    public boolean register(VanRequest vanRequest) {
        Van van = vanMapper.toVan(vanRequest);
        if (van != null) {
            vanRepository.save(van);
            return true;
        }
        return false;
    }

    @Override
    public List<VanResponse> findAll() {
        return vanMapper.toListVanResponse(vanRepository.findAll());
    }

    @Override
    public boolean update(VanUpdateRequest vanUpdateRequest) {
        Van van = vanRepository.findById(vanUpdateRequest.getId()).orElse(null);
        if (van != null) {
            van = vanMapper.toVan(vanUpdateRequest.getVanRequest());
            vanRepository.save(van);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(UUID id) {
        Van van = vanRepository.findById(id).orElse(null);
        if (van != null) {
            van.setPassengers(null);
            vanRepository.save(van);
            vanRepository.delete(van);
            return true;
        }
        return false;
    }
}
