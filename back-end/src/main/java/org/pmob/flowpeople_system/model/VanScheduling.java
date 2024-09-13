package org.pmob.flowpeople_system.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "van_scheduling")
@Data
public class VanScheduling {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, unique = true)
    private UUID id;

    @OneToOne
    private Van van;

    @OneToOne
    private Driver driver;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "time")
    private LocalTime time;

    @OneToMany
    private List<Passenger> passengers = new ArrayList<>();

    public void addPassenger(Passenger passenger) {
        this.passengers.add(passenger);
    }

    public VanScheduling(Van van, Driver driver, LocalDate date, LocalTime time) {
        this.van = van;
        this.driver = driver;
        this.date = date;
        this.time = time;
        this.passengers = null;
    }

    public VanScheduling() {
    }
}
