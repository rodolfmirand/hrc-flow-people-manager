package org.pmob.flowpeople_system.controller;

import org.pmob.flowpeople_system.dto.request.VanRequest;
import org.pmob.flowpeople_system.service.van.VanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/flow-people-manager/van")
public class VanController {

    @Autowired
    private VanService vanService;

    @PostMapping("/register")
    private ResponseEntity<?> register(@RequestBody VanRequest vanRequest) {
        if (vanService.register(vanRequest)) return ResponseEntity.ok().body("Van registrada com sucesso!");
        return ResponseEntity.badRequest().body("Erro ao registrar van.");
    }

    @GetMapping
    private ResponseEntity<?> findAll() {
        return ResponseEntity.ok().body(vanService.findAll());
    }

//    @PutMapping("/update")
//    private ResponseEntity<?> update(@RequestBody VanRequest vanRequest) {
//
//    }
}
