package com.fandza.ccs.Fandza.entities;


import com.fandza.ccs.Fandza.config.uuid.UuidV7;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.aop.target.LazyInitTargetSource;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "school")
public class School {


    @Id
    @UuidV7
    @JdbcTypeCode(SqlTypes.UUID)
    private UUID idSchool;

    private String schoolName;


    @OneToMany(mappedBy = "school")
    private List<Student> students = new ArrayList<>();



}
