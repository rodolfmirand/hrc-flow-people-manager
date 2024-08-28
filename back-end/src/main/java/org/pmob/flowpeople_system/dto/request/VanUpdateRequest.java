package org.pmob.flowpeople_system.dto.request;

import lombok.Getter;

import java.util.UUID;

@Getter
public class VanUpdateRequest {

    private UUID id;

    private VanRequest vanRequest;

}
