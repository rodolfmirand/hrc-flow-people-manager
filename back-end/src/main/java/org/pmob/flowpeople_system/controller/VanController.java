package org.pmob.flowpeople_system.controller;

import org.pmob.flowpeople_system.dto.request.VanRequest;
import org.pmob.flowpeople_system.dto.response.VanResponse;
import org.pmob.flowpeople_system.service.van.VanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flow/van")
public class VanController {

    @Autowired
    private VanService vanService;

    @PostMapping("/register")
    private ResponseEntity<?> register(@RequestBody VanRequest vanRequest) {
        if (vanService.register(vanRequest))
            return ResponseEntity.ok().body("Van registrada com sucesso!");

        return ResponseEntity.internalServerError().body("Van já cadastrada.");
    }

    @GetMapping("/find-all")
    private ResponseEntity<List<VanResponse>> findAll() {
        return ResponseEntity.ok().body(vanService.findAll());
    }
}
