package com.phuongheh.microservice.shipping;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Shipment {
    @Id
    private  long id;
    @Embedded
    private Customer customer
}
