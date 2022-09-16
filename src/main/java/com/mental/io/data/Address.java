package com.mental.io.data;

import lombok.Data;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Address {

    private @Id @GeneratedValue
    Long addressId;
    private String location;
    private String addressLine1;
    private String addressLine2;
    private String zipcode;
    private String city;
    private String state;
    private String country;

    public Address() {

    }
}
