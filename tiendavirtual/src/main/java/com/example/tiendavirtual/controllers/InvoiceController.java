package com.example.tiendavirtual.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tiendavirtual.dtos.InvoiceResponseDto;
import com.example.tiendavirtual.models.Invoice;
import com.example.tiendavirtual.services.InvoiceService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController 
@RequestMapping ()
public class InvoiceController {

    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService){
        this.invoiceService = invoiceService;
    }

    @GetMapping
    public ResponseEntity<List<InvoiceResponseDto>> getInvoices() {
        List<Invoice> invoices = invoiceService.getAllInvoices();
        List<InvoiceResponseDto> invoiceResponseDtos = invoices.stream().map(InvoiceMapper::
modelToDto).toList();
return ResponseEntity.ok(invoiceResponseDtos);
    }

    @PostMapping
    public ResponseEntity <InvoiceResponseDto> create(@RequestBody  )
    }
    
    
    
}