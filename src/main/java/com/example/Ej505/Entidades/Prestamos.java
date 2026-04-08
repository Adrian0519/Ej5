package com.example.Ej505.Entidades;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "prestamos")
@EqualsAndHashCode(exclude = {"socio","libro"})
public class Prestamos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_prestamo;
    @NonNull
    private LocalDate fecha_prestamo;
    @NonNull
    private LocalDate fecha_devolucion;
    @ManyToOne
    @JoinColumn(name = "id_socio")
    private Socios socio;

    @ManyToOne
    @JoinColumn(name = "id_libro")
    private Libros libro;

    public Prestamos(LocalDate fecha_prestamo) {
        this.fecha_prestamo = fecha_prestamo;
    }
    public void agregarSocio(Socios socio){
        this.socio=socio;
        socio.agregarPrestamo(this);
    }

    public void agregarLibro(Libros libro){
        this.libro=libro;
        libro.agregarPrestamo(this);
    }
}
