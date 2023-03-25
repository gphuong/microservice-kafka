package com.phuongheh.kafka.invoicing;

import jakarta.persistence.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Invoice {
    @Id
    private Long id;

    @Embedded
    private Customer customer;

    private Date updated;

    @Embedded
    private Address billingAddress = new Address();

    @OneToMany(cascade = CascadeType.ALL)
    private List<InvoiceLine> invoiceLine;

    public Invoice() {
        invoiceLine = new ArrayList<>();
    }

    public Invoice(long id, Customer customer, Date updated, Address billingAddress, List<InvoiceLine> invoiceLine) {
        this.id = id;
        this.customer = customer;
        this.updated = updated;
        this.billingAddress = billingAddress;
        this.invoiceLine = invoiceLine;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public List<InvoiceLine> getInvoiceLine() {
        return invoiceLine;
    }

    public void setInvoiceLine(List<InvoiceLine> invoiceLine) {
        this.invoiceLine = invoiceLine;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Id
    public Long getId() {
        return id;
    }
}
