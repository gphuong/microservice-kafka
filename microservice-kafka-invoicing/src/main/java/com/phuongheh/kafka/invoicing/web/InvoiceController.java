package com.phuongheh.kafka.invoicing.web;

import com.phuongheh.kafka.invoicing.InvoiceRepository;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InvoiceController {
    private InvoiceRepository invoiceRepository;

    public InvoiceController(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @GetMapping(value = "/{id}", produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView Item(@PathVariable("id") long id) {
        return new ModelAndView("invoice", "invoice", invoiceRepository.findById(id).get());
    }

    @GetMapping("/")
    public ModelAndView ItemList() {
        return new ModelAndView("invoiceList", "invoices", invoiceRepository.findAll());
    }
}
