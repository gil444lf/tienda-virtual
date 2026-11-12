package com.example.tiendavirtual.dtos;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class InvoiceUpdateDto {
    @NotBlank(message = "El número es obligatorio")
    private String number;
    @NotNull(message = "La fecha es obligatoria")
    private LocalDate date;
    @NotNull(message = "El subtotal es obligatorio")
    private Double subtotal;
    @NotNull(message = "El impuesto es obligatorio")
    private Double totalTax;
    @NotNull(message = "El total es obligatorio")
    private Double total;
}