package org.pmob.flowpeople_system.service.van;

import org.pmob.flowpeople_system.dto.request.VanRequest;
import org.pmob.flowpeople_system.dto.request.VanUpdateRequest;
import org.pmob.flowpeople_system.dto.response.VanResponse;

import java.util.List;
import java.util.UUID;

public interface VanService {

    boolean register(VanRequest vanRequest);

    List<VanResponse> findAll();

    boolean update(VanUpdateRequest vanUpdateRequest);

    boolean delete(UUID id);

}
