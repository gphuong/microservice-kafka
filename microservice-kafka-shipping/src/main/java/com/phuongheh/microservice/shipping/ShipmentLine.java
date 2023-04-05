package com.phuongheh.microservice.shipping;

import jakarta.persistence.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
public class ShipmentLine {
    @Column(name = "F_COUNT")
    private int count;

    @Embedded
    private Item item;

    @Id
    @GeneratedValue
    private long id;

    public void setCount(int count) {
        this.count = count;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public ShipmentLine() {
    }

    public ShipmentLine(int count, Item item) {
        this.count = count;
        this.item = item;
    }

    public int getCount() {
        return count;
    }

    public Item getItem() {
        return item;
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
