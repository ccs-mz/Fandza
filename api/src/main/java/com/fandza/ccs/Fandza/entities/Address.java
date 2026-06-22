package com.fandza.ccs.Fandza.entities;


import com.fandza.ccs.Fandza.config.uuid.UuidV7;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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


    @UuidV7
    @JdbcTypeCode(SqlTypes.UUID)
    private UUID idAddress;

    private String neighborhood;

    private String block;

    private String houseNumber;

}
