package org.pmob.flowpeople_system.repository;

import org.pmob.flowpeople_system.model.Van;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface VanRepository extends JpaRepository<Van, UUID> {
    Optional<Van> findByPlate(String plate);
}
