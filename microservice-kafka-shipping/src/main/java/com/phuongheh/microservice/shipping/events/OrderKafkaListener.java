package com.phuongheh.microservice.shipping.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class OrderKafkaListener {
    private final Logger log = LoggerFactory.getLogger(OrderKafkaListener.class);
    private ShipmentService shipmentService;

    public OrderKafkaListener(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }
}
