package com.example.Ej505.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
@Data
@AllArgsConstructor
public class Consulta6DTO {
    private int id_socio;
    private String nombre;
    private Long fechaDevolucion;

}
