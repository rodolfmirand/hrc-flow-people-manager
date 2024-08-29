package org.pmob.flowpeople_system.service.vanScheduling;

import org.pmob.flowpeople_system.dto.request.VanSchedulingRequest;
import org.pmob.flowpeople_system.dto.response.VanSchedulingResponse;

import java.util.List;

public interface VanSchedulingService {

    boolean register(VanSchedulingRequest vanSchedulingRequest);

    List<VanSchedulingResponse> findAll();
}
