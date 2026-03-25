package com.example.Ej505.Entidades;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "socios")
public class Socios {
    @Id
    private int id_socio;
    private String nombre;
    private String direccion;
    private LocalDate fecha_inscripcion;
    @OneToMany(mappedBy = "socios")
    private List <Prestamos> listPrestamos=new ArrayList<>();

    public void agregarPrestamo(Prestamos prestamos){
        listPrestamos.add(prestamos);
    }

}
