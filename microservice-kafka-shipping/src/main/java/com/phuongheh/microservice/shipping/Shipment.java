package com.phuongheh.microservice.shipping;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Shipment {
    @Id
    private  long id;
    @Embedded
    private Customer customer;

    private Date updated;

    @Embedded
    private Address shippingAddress = new Address();

    @OneToMany(cascade = CascadeType.ALL)
    private List<ShippingLine> shj
}
