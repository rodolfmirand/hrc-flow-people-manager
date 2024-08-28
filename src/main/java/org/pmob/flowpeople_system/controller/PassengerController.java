package org.pmob.flowpeople_system.controller;

import org.pmob.flowpeople_system.dto.request.PassengerRequest;
import org.pmob.flowpeople_system.service.passenger.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "flow-people-manager/passenger")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody PassengerRequest passengerRequest){
        if(passengerService.register(passengerRequest)){
            return ResponseEntity.ok().body("Passageiro registrado com sucesso!");
        }else{
            return ResponseEntity.badRequest().body("Erro ao registrar passageiro!");
        }
    }

    @GetMapping
    public ResponseEntity<?> findAll(@RequestParam(name = "idVan") UUID idVan){
        return ResponseEntity.ok().body(passengerService.findAll(idVan));
    }
}
