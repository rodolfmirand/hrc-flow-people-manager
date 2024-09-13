package org.pmob.flowpeople_system.controller;

import org.pmob.flowpeople_system.dto.request.DriverRequest;
import org.pmob.flowpeople_system.dto.response.DriverResponse;
import org.pmob.flowpeople_system.service.driver.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flow/driver")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody DriverRequest driverRequest) {
        if (driverService.register(driverRequest))
            return ResponseEntity.ok().body("Motorista cadastrado com sucesso!");

        return ResponseEntity.internalServerError().body("Motorista já cadastrado.");
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<DriverResponse>> findAll() {
        return ResponseEntity.ok().body(driverService.findAll());
    }

    @GetMapping("find-by-phone")
    public ResponseEntity<?> findByPhone(@RequestParam String phone) {
        DriverResponse driverResponse = driverService.findIdByPhone(phone);
        if (driverResponse == null)
            return ResponseEntity.badRequest().body("Motorista não encontrado.");

        return ResponseEntity.ok().body(driverResponse);
    }
}
