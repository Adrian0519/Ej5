package com.example.Ej505.Entidades;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LibrosDTO {
    private int id_libro;
    private String titulo;
    private String autor;
    private int ano_publicacion;

    public LibrosDTO(Libros libros) {
        this.id_libro = libros.getId_libro();
        this.titulo = libros.getTitulo();
        this.autor = libros.getAutor();
        this.ano_publicacion = libros.getAno_publicacion();
    }
}
