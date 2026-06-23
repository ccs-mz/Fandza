package com.fandza.ccs.Fandza.entities;


import com.fandza.ccs.Fandza.enums.UserType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="legal_guardian")
@Data
public class LegalGuardian  extends AppUser{


    public LegalGuardian() {}

    public LegalGuardian(
            String name,
            String email,
            String password,
            String phoneNumber
    ){
        super(name,email,password,phoneNumber, UserType.LEGAL_GUARDIAN);

    }

    @OneToMany(
            mappedBy = "legalGuardian",
            cascade = CascadeType.PERSIST,
            orphanRemoval = false
    )
    private List<Student> students =  new ArrayList<>();

    @OneToMany(mappedBy = "legalGuardian")
    private List<Reservation> reservations = new ArrayList<>();

    @OneToMany(mappedBy = "legalGuardian")
    private List<Assessment> assessments = new ArrayList<>();

}
