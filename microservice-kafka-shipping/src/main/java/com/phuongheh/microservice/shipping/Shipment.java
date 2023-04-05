package com.phuongheh.microservice.shipping;

import jakarta.persistence.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Shipment {
    @Id
    private long id;

    @Embedded
    private Customer customer;

    private Date updated;

    @Embedded
    private Address shippingAddress = new Address();

    @OneToMany(cascade = CascadeType.ALL)
    private List<ShipmentLine> shipmentLine;

    public Shipment() {
        super();
        shipmentLine = new ArrayList<>();
    }

    public Shipment(long id, Customer customer, Date updated, Address shippingAddress, List<ShipmentLine> shipmentLine) {
        this.id = id;
        this.customer = customer;
        this.updated = updated;
        this.shippingAddress = shippingAddress;
        this.shipmentLine = shipmentLine;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<ShipmentLine> getShipmentLine() {
        return shipmentLine;
    }

    public Shipment(Customer customer) {
        this.customer = customer;
        this.shipmentLine = new ArrayList<>();
    }

    public void setShipmentLine(List<ShipmentLine> shipmentLine) {
        this.shipmentLine = shipmentLine;
    }

    @Transient
    public void setOrderLine(List<ShipmentLine> shipmentLine) {
        this.shipmentLine = shipmentLine;
    }

    public int getNumberOfLines() {
        return shipmentLine.size();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
