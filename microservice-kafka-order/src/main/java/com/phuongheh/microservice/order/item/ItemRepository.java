package com.phuongheh.microservice.order.item;

import jakarta.websocket.server.PathParam;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(exported = false)
public interface ItemRepository extends PagingAndSortingRepository<Item, Long>, CrudRepository<Item, Long> {
    List<Item> findByName(@Param("name") String name);

    List<Item> findByNameContaining(@PathParam("name") String name);

    @Query("SELECT price FROM Item i where i.itemId=?1")
    double price(long itemId);
}
