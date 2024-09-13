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
    @Column(name = "id", nullable = false, unique = true)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone", nullable = false, unique = true)
    private String phone;

    public Driver(DriverRequest driverRequest) {
        this.name = driverRequest.getName();
        this.phone = driverRequest.getPhone();
    }

    public Driver() {
    }
}
