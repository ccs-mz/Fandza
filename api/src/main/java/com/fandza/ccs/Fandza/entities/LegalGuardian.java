package com.fandza.ccs.Fandza.entities;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="legal_guardian")
public class LegalGuardian  extends AppUser{


    @OneToMany(
            mappedBy = "legalGuardian",
            cascade = CascadeType.PERSIST,
            orphanRemoval = false
    )
    private List<Student> students =  new ArrayList<>();

/*    @OneToMany(mappedBy = "legalGuardian")
    private List<Reservation> reservations = new ArrayList<>();

    @OneToMany(mappedBy = "legalGuardian")
    private List<Assessment> assessments = new ArrayList<>();*/

}
