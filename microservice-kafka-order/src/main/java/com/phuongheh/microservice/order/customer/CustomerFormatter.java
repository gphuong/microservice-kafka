package com.phuongheh.microservice.order.customer;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class CustomerFormatter implements Formatter<Customer> {
    private CustomerRepository customerRepository;

    public CustomerFormatter(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer parse(String text, Locale locale) throws ParseException {
        return customerRepository.findById(Long.parseLong(text)).get();
    }

    @Override
    public String print(Customer customer, Locale locale) {
        return customer.getCustomerId().toString();
    }
}
