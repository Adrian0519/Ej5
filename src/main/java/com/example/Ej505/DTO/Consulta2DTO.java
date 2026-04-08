package com.example.Ej505.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
@Data
@AllArgsConstructor
public class Consulta2DTO {
    private String titulo;
    private String nombreSocio;
    private LocalDate fecha_prestamo;
    private LocalDate fecha_devolucion;
}
