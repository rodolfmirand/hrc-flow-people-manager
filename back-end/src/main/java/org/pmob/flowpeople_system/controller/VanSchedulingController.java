package org.pmob.flowpeople_system.controller;

import org.pmob.flowpeople_system.dto.request.VanSchedulingRequest;
import org.pmob.flowpeople_system.dto.response.VanSchedulingResponse;
import org.pmob.flowpeople_system.service.vanScheduling.VanSchedulingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flow/scheduling/van")
public class VanSchedulingController {

    @Autowired
    private VanSchedulingService vanSchedulingService;

    @PostMapping("/register")
    private ResponseEntity<?> register(@RequestBody VanSchedulingRequest vanSchedulingRequest) {
        if (vanSchedulingService.register(vanSchedulingRequest))
            return ResponseEntity.ok().body("Agendamento de van registrado com sucesso!");
        return ResponseEntity.internalServerError().body("Erro ao registrar agendamento.");
    }

    @GetMapping("/find-all")
    private ResponseEntity<List<VanSchedulingResponse>> findAll(){
        return ResponseEntity.ok().body(vanSchedulingService.findAll());
    }
}
