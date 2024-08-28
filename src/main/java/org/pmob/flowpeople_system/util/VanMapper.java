package org.pmob.flowpeople_system.util;

import org.pmob.flowpeople_system.dto.request.VanRequest;
import org.pmob.flowpeople_system.dto.response.VanResponse;
import org.pmob.flowpeople_system.model.Van;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VanMapper {

    public Van toVan(VanRequest vanRequest) {
        return new Van(vanRequest);
    }

    public List<VanResponse> toListVanResponse(List<Van> vanList) {
        List<VanResponse> vanResponseList = new ArrayList<>();
        for (Van van : vanList) {
            vanResponseList.add(new VanResponse(van));
        }
        return vanResponseList;
    }
}
