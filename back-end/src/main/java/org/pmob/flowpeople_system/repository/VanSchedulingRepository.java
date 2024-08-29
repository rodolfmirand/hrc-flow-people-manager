package org.pmob.flowpeople_system.repository;

import org.pmob.flowpeople_system.model.VanScheduling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface VanSchedulingRepository extends JpaRepository<VanScheduling, UUID> {

    //Optional<VanScheduling> findByDateTimeAndPlate(LocalDate date, LocalTime time, String plate);
}
