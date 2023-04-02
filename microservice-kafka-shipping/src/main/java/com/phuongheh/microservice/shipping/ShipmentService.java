package com.phuongheh.microservice.shipping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ShipmentService {
    private final Logger log = LoggerFactory.getLogger(ShipmentService.class);
    private ShipmentRepository shipmentRepository;
}
