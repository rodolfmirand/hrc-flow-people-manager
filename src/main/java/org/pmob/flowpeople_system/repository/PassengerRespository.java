package org.pmob.flowpeople_system.repository;

import org.pmob.flowpeople_system.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PassengerRespository extends JpaRepository<Passenger, UUID> {
}
