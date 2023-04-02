package com.phuongheh.microservice.shipping;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;

public interface ShipmentRepository extends PagingAndSortingRepository<Shipment, Long>, CrudRepository<Shipment, Long> {
    @Query("SELECT max(s.updated) FROM Shipment s")
    Date lastUpdate();
}
