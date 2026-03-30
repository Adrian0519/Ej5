package com.example.Ej505.DTO;

import com.example.Ej505.Entidades.Libros;

public class Consulta1DTO {
    private int id_libro;
    private String titulo;
    private String autor;
    private int ano_publicacion;
    private String nombreSocio;
    private String direccionSocio;

    public Consulta1DTO(Libros libros,String nombreSocio,String direccionSocio) {
        this.id_libro=libros.getId_libro();
        this.titulo=libros.getTitulo();
        this.autor=libros.getAutor();
        this.ano_publicacion=libros.getAno_publicacion();
        this.nombreSocio=nombreSocio;
        this.direccionSocio=direccionSocio;
    }
}
