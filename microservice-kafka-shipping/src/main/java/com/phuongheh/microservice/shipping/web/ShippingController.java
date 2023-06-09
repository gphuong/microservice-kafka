package com.phuongheh.microservice.shipping.web;

import com.phuongheh.microservice.shipping.ShipmentRepository;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShippingController {
    private ShipmentRepository shipmentRepository;

    public ShippingController(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    @GetMapping(value = "/{id}", produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView Item(@PathVariable("id") long id) {
        return new ModelAndView("shipment", "shipment", shipmentRepository.findById(id).get());
    }

    @GetMapping("/")
    public ModelAndView ItemList() {
        return new ModelAndView("shipmentlist", "shipments0", shipmentRepository.findAll());
    }
}
