package com.fandza.ccs.Fandza.entities;


import com.fandza.ccs.Fandza.config.uuid.UuidV7;
import com.fandza.ccs.Fandza.enums.UserType;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Entity
@Inheritance(strategy =  InheritanceType.JOINED)
@Data
@Table(name = "users")
public abstract class AppUser {

    public AppUser() {}

    public AppUser(
            String name,
            String email,
            String phoneNumber,
            String password,
            UserType userType
    ){
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.userType = userType;
    }

    @Id
    @UuidV7
    @JdbcTypeCode(SqlTypes.UUID)
    private UUID idUser;

    @Column(
            nullable = false
    )
    private String name;

    @Column(
            nullable = false,
            unique = true
    )
    private String email;


    private String phoneNumber;

    @Column(
            nullable = false
    )
    private String password;

    @Enumerated(EnumType.STRING)
    private UserType userType;

}
