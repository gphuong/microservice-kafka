package com.phuongheh.microservice.order.logic;

import com.phuongheh.microservice.order.customer.Customer;
import com.phuongheh.microservice.order.customer.CustomerRepository;
import com.phuongheh.microservice.order.item.Item;
import com.phuongheh.microservice.order.item.ItemRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrderController {
    private OrderRepository orderRepository;
    private OrderService orderService;
    private CustomerRepository customerRepository;
    private ItemRepository itemRepository;

    public OrderController(OrderRepository orderRepository, OrderService orderService, CustomerRepository customerRepository, ItemRepository itemRepository) {
        this.orderRepository = orderRepository;
        this.orderService = orderService;
        this.customerRepository = customerRepository;
        this.itemRepository = itemRepository;
    }

    @ModelAttribute("items")
    public Iterable<Item> items() {
        return itemRepository.findAll();
    }

    @ModelAttribute("customers")
    public Iterable<Customer> customers() {
        return customerRepository.findAll();
    }

    @GetMapping("/")
    public ModelAndView orderList() {
        return new ModelAndView("orderlist", "orders", orderRepository.findAll());
    }

    @GetMapping("/form.html")
    public ModelAndView form() {
        return new ModelAndView("orderForm", "order", new Order());
    }

    @PostMapping("/line")
    public ModelAndView addLine(Order order) {
        order.addLine(0, itemRepository.findAll().iterator().next());
        return new ModelAndView("orderForm", "order", order);
    }

    @GetMapping("/{id")
    public ModelAndView get(@PathVariable("id") long id) {
        return new ModelAndView("order", "order", orderRepository.findById(id).get());
    }

    @PostMapping("/")
    public ModelAndView post(Order order) {
        order = orderService.order(order);
        return new ModelAndView("success");
    }

    @DeleteMapping("/{id}")
    public ModelAndView post(@PathVariable("id") long id) {
        orderRepository.deleteById(id);
        return new ModelAndView("success");
    }

}
