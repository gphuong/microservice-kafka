package com.phuongheh.microservice.shipping.events;

import com.phuongheh.microservice.shipping.Shipment;
import org.springframework.kafka.support.serializer.JsonDeserializer;

public class ShipmentDeserializer extends JsonDeserializer<Shipment> {
    public ShipmentDeserializer() {
        super(Shipment.class);
    }
}
