package com.example.Ej505.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
@Data
@AllArgsConstructor
public class Consulta8DTO {
    private String titulo;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
}
