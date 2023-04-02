package com.phuongheh.microservice.shipping;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ShipmentRepository extends PagingAndSortingRepository<Shipment, Long>, CrudRepository<Shipment, Long> {
}
