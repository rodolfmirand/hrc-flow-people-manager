package org.pmob.flowpeople_system.model;

import jakarta.persistence.*;
import lombok.Data;
import org.pmob.flowpeople_system.dto.request.DriverRequest;

import java.util.UUID;

@Entity
@Table(name = "driver")
@Data
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "cnh")
    private String cnh;

    @Column(name = "cnh_type")
    private Character cnhType;

    public Driver(DriverRequest driverRequest) {
        this.name = driverRequest.getName();
        this.cnh = driverRequest.getCnh();
        this.cnhType = driverRequest.getCnhType();
    }

    public Driver() {
    }
}
