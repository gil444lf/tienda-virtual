package com.example.tiendavirtual.dtos;

import java.time.LocalDate;
import java.util.UUID;

import lombok.Data;

@Data
public class InvoiceResponseDto {
    private UUID id;
    private String number;
    private LocalDate date;
    private Double subtotal;
    private Double totalTax;
    private Double total;
}