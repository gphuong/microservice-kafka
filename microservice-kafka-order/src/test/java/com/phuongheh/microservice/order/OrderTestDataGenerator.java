package com.phuongheh.microservice.order;

import com.phuongheh.microservice.order.customer.CustomerRepository;
import com.phuongheh.microservice.order.item.ItemRepository;
import com.phuongheh.microservice.order.logic.Address;
import com.phuongheh.microservice.order.logic.Order;
import com.phuongheh.microservice.order.logic.OrderRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("test")
@DependsOn({"itemTestDataGenerator", "customerTestDataGenerator"})
public class OrderTestDataGenerator {
    private final OrderRepository orderRepository;
    private ItemRepository itemRepository;
    private CustomerRepository customerRepository;

    public OrderTestDataGenerator(OrderRepository orderRepository, ItemRepository itemRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;
        this.customerRepository = customerRepository;
    }

    @PostConstruct
    public void generateTestData() {
        Order order = createOrder();
    }

    private Order createOrder() {
        Order order = new Order(customerRepository.findAll().iterator().next());
        order.setShippingAddress(new Address("Ohlauer Str. 43", "10999", "Berlin"));
        order.setBillingAddress(new Address("Krischerstr. 100", "40799", "Monheim am Rhein"));
        order.addLine(42, itemRepository.findAll().iterator().next());
        return order;
    }
}
