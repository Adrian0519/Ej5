package com.example.Ej505.Entidades;

import java.time.LocalDate;

public class PrestamosDTO {
    private int id_prestamo;
    private int id_libro;
    private int id_socio;
    private LocalDate fecha_prestamo;
    private LocalDate fecha_devolucion;


    public PrestamosDTO(Prestamos prestamos) {
        this.id_prestamo = prestamos.getId_prestamo();
        this.id_libro = prestamos.getId_libro();
        this.id_socio = prestamos.getId_socio();
        this.fecha_prestamo = prestamos.getFecha_prestamo();
        this.fecha_devolucion = prestamos.getFecha_devolucion();
    }
}
