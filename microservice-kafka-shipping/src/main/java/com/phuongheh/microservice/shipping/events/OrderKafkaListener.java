package com.phuongheh.microservice.shipping.events;

import com.phuongheh.microservice.shipping.Shipment;
import com.phuongheh.microservice.shipping.ShipmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;


@Component
public class OrderKafkaListener {
    private final Logger log = LoggerFactory.getLogger(OrderKafkaListener.class);
    private ShipmentService shipmentService;

    public OrderKafkaListener(ShipmentService shipmentService) {
        super();
        this.shipmentService = shipmentService;
    }

    @KafkaListener(topics = "order")
    public void order(Shipment shipment, Acknowledgment acknowledgment) {
        log.info("Received shipment " + shipment.getId());
        shipmentService.ship(shipment);
        acknowledgment.acknowledge();
    }
}
