package com.fandza.ccs.Fandza.repositories;

import com.fandza.ccs.Fandza.entities.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface DocumentRepository extends JpaRepository<Document, UUID> {
}
