package com.example.Ej505.Entidades;

import java.time.LocalDate;

public class SociosDTO {
    private int id_socio;
    private String nombre;
    private String direccion;
    private LocalDate fecha_inscripcion;

    public SociosDTO(Socios socios) {
        this.id_socio = socios.getId_socio();
        this.nombre = socios.getNombre();
        this.direccion = socios.getDireccion();
        this.fecha_inscripcion = socios.getFecha_inscripcion();
    }
}
