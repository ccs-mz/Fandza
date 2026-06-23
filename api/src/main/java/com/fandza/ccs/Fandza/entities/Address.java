package com.fandza.ccs.Fandza.entities;


import com.fandza.ccs.Fandza.config.uuid.UuidV7;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Entity
@Data
@Table(name = "address")
public class Address {

    public Address() {}
    public Address(
            String neighborhood,
            String block,
            String houseNumber
    ){
        this.neighborhood = neighborhood;
        this.block = block;
        this.houseNumber = houseNumber;
    }

    @Id
    @UuidV7
    @JdbcTypeCode(SqlTypes.UUID)
    @Column(name = "id_address")
    private UUID idAddress;

    private String neighborhood;

    private String block;

    @Column(name = "house_number")
    private String houseNumber;

}
