package com.example.tiendavirtual.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.tiendavirtual.controllers.InvoiceResponseDto;
import com.example.tiendavirtual.entities.CustomerEntity;
import com.example.tiendavirtual.entities.InvoiceEntity;
import com.example.tiendavirtual.entities.ProductEntity;
import com.example.tiendavirtual.mappers.InvoiceMapper;
import com.example.tiendavirtual.models.Invoice;
import com.example.tiendavirtual.repositories.InvoiceRepository;
import com.example.tiendavirtual.repositories.ProductRepository;
import com.example.tiendavirtual.repositories.CustomerRepository;
import com.example.tiendavirtual.repositories.InvoiceRepository;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    private final CustomerRepository customerRepository;

    private final ProductRepository productRepository;

    public InvoiceService(InvoiceRepository invoiceRepository, CustomerRepository customerRepository, ProductRepository productRepository){
        this.invoiceRepository = invoiceRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    public List <Invoice> getAllInvoices() {
        List<InvoiceEntity> invoiceEntities = invoiceRepository.getAll();
        List<Invoice> invoices = new ArrayList<>();
        
        }
        return invoices;
    }

    public  Invoice create(Invoice invoice){
        InvoiceEntity invoiceEntity = new InvoiceEntity();
        invoiceEntity.setNumber(invoice.getNumber());
        invoiceEntity.setDate(invoice.getDate());

        CustomerEntity customerEntity = customerRepository.getById(invoice.getCustomerId());
        Double total = 0.0;
        List<ProductEntity> products = new ArrayList<>();
        for(UUID productId : invoice.getProductIds()){
            ProductEntity productEntity = productRepository.getById(productId);
            products.add(productEntity);
            total += productEntity.getPrice();
           
        }
        invoiceEntity.setCustomer(customerEntity);
        invoiceEntity.setProducts(products);
        invoiceEntity.setTotal(total);

        InvoiceEntity invoiceEntityCreate = invoiceRepository.create(invoiceEntity);
        Invoice invoiceCreate = InvoiceMapper.entityToModel(invoiceEntityCreate);
        return invoiceCreate;
        
        
    }

    public List<InvoiceResponseDto> getInvoices() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getInvoices'");
    }

   
}