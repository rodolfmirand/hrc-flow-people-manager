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
    @Column(name = "id")
    private UUID id;

    @Column(name = "plate", nullable = false, unique = true)
    private String plate;

    @Column(name = "driver")
    private String driver;

    @Column(name = "date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @Column(name = "time")
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime time;

    @OneToMany
    private List<Passenger> passengers = new ArrayList<>();

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    public Van(VanRequest vanRequest){
        this.plate = vanRequest.getPlate();
        this.driver = vanRequest.getDriver();
        this.date = vanRequest.getDate();
        this.time = vanRequest.getTime();
        this.passengers = null;
    }

    public Van() {

    }
}
