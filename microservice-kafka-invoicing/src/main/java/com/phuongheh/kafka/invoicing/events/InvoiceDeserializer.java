package com.phuongheh.kafka.invoicing.events;

import com.phuongheh.kafka.invoicing.Invoice;
import org.springframework.kafka.support.serializer.JsonDeserializer;

public class InvoiceDeserializer extends JsonDeserializer<Invoice> {
    public InvoiceDeserializer() {
        super(Invoice.class);
    }
}
