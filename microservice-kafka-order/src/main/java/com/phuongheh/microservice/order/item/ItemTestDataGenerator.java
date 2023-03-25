package com.phuongheh.microservice.order.item;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class ItemTestDataGenerator {
    private final ItemRepository itemRepository;

    public ItemTestDataGenerator(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @PostConstruct
    public void geneerateTestData(){
        itemRepository.save(new Item("iPod", 42.0));
        itemRepository.save(new Item("iPod touch", 1.0));
        itemRepository.save(new Item("iPod nano", 1.0));
        itemRepository.save(new Item("Apple TV", 100.0));
    }
}
