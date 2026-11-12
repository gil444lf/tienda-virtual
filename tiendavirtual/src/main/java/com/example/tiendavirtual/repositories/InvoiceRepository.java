package com.example.tiendavirtual.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import com.example.tiendavirtual.entities.InvoiceEntity;

@Repository

public class InvoiceRepository {

    private final IInvoiceJpaRepository repository;

    public InvoiceRepository(IInvoiceJpaRepository repository){
        this.repository = repository;
    }

    public List<InvoiceEntity> getAllInvoiceEntity(){
        return repository.findAll();
    }

    public InvoiceEntity getById(UUID id){
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Factura no encontrada"));
    }

    public InvoiceEntity getByNumber(String number){
        return repository.findByNumber(number)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Factura no encontrada"));
    }

    public boolean existsByNumber(String number){
        return repository.existsByNumber(number);
    }

    public InvoiceEntity create(InvoiceEntity invoiceEntity){
        return repository.save(invoiceEntity);
    }

    public InvoiceEntity update(InvoiceEntity invoiceEntity){
        return repository.save(invoiceEntity);
    }
}