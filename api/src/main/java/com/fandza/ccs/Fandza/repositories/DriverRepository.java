package com.fandza.ccs.Fandza.repositories;

import com.fandza.ccs.Fandza.entities.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface DriverRepository extends JpaRepository<Driver, UUID> {
}
