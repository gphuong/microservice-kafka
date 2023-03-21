package com.phuongheh.kafka.invoicing;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Embeddable
public class Customer {
    @Column(nullable = false)
    private Long customerId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    @Email
    private String email;

    public Customer() {
        super();
        customerId = 0l;
    }

    public Customer(Long customerId, String firstname, String name, String email) {
        super();
        this.customerId = customerId;
        this.name = name;
        this.firstname = firstname;
        this.email = email;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
