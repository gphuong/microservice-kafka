package com.phuongheh.microservice.order.item;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class ItemFormatter implements Formatter<Item> {
    private ItemRepository itemRepository;

    public ItemFormatter(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item parse(String text, Locale locale) throws ParseException {
        return itemRepository.findById(Long.parseLong(text)).get();
    }

    @Override
    public String print(Item item, Locale locale) {
        return item.getItemId().toString();
    }
}
