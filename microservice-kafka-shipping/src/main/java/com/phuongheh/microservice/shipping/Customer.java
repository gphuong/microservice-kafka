package com.phuongheh.microservice.shipping;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;

@Embedded
public class Customer {
    @Column(nullable = false)
    private Long customerId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String fistname;

    public Customer() {
    }

    public Customer(Long customerId, String fistname,String name ) {
        this.customerId = customerId;
        this.name = name;
        this.fistname = fistname;
    }
}
