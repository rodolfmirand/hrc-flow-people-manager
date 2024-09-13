package org.pmob.flowpeople_system.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import org.pmob.flowpeople_system.dto.request.VanRequest;

@Data
@Entity
@Table(name = "van")
public class Van {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, unique = true)
    private UUID id;

    @Column(name = "plate", nullable = false, unique = true)
    private String plate;

    @Column(name = "model", nullable = false)
    private String model;

    public Van(VanRequest vanRequest) {
        this.plate = vanRequest.getPlate();
        this.model = vanRequest.getModel();
    }

    public Van() {
    }
}
