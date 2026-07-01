package com.fandza.ccs.Fandza.repositories;

import com.fandza.ccs.Fandza.entities.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface RouteRepository extends JpaRepository<Route, UUID> {
}
