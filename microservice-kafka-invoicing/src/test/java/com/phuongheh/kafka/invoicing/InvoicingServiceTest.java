package com.phuongheh.kafka.invoicing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = InvoiceTestApp.class, webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ActiveProfiles("test")
public class InvoicingServiceTest {
    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private InvoiceService invoiceService;

    @Test
    public void ensureIdempotencySecondCallIgnored() {
        long countBefore = invoiceRepository.count();
        Invoice invoice = new Invoice(42,
                new Customer(23, "Eberhard", "Wolff", "eberhard.wolff@innoq.com"),
                new Date(0L), new Address("Krischstr. 100", "40789", "Monheim am Rhein"), new ArrayList<>());
        invoiceService.generateInvoice(invoice);
        assertEquals(countBefore + 1, invoiceRepository.count());
        assertEquals(0L, invoiceRepository.findById(42L).get().getUpdated().getTime());
        invoice = new Invoice(42,
                new Customer(23, "Eberhard", "Wolff", "eberhard.wolff@innoq.com"),
                new Date(), new Address("Krischstr. 100", "40789", "Monheim am Rhein"), new ArrayList<>());
        invoiceService.generateInvoice(invoice);
        assertEquals(countBefore + 1, invoiceRepository.count());
        assertEquals(0L, invoiceRepository.findById(42L).get().getUpdated().getTime());

    }
}
