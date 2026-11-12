package com.example.tiendavirtual.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import com.example.tiendavirtual.entities.InvoiceEntity;

@Repository
@Primary 
public class InvoiceRepository {

    @Autowired
    private IInvoiceJpaRepository repository;

    piblic List<InvoiceEntity> getAll() {
        List<InvoiceEntity> invoices = repository.findAll();
        return invoices;
    }

   
}