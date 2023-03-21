package com.phuongheh.kafka.invoicing;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;

public interface InvoiceRepository extends PagingAndSortingRepository<Invoice, Long>, CrudRepository<Invoice, Long> {
    @Query("SELECT MAX(i.updated) FROM Invoice i")
    Date lastUpdate();
}
