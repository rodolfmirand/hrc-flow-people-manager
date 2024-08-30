package org.pmob.flowpeople_system.repository;

import org.pmob.flowpeople_system.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DriverRespository extends JpaRepository<Driver, UUID> {

    Optional<Driver> findByPhone(String phone);
}
