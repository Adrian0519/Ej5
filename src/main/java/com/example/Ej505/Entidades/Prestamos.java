package com.example.Ej505.Entidades;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "prestamos")

public class Prestamos {
    @Id
    private int id_prestamo;
    private int id_libro;
    private int id_socio;
    private LocalDate fecha_prestamo;
    private LocalDate fecha_devolucion;
    @ManyToOne
    @JoinColumn(name = "id_socio")
    private Socios socio;

    @ManyToOne
    @JoinColumn(name = "id_libro")
    private Libros libro;

    public void agregarSocio(Socios socio){
        this.socio=socio;
        socio.agregarPrestamo(this);
    }

    public void agregarLibro(Libros libro){
        this.libro=libro;
        libro.agregarPrestamo(this);
    }
}
