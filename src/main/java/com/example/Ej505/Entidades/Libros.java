package com.example.Ej505.Entidades;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "libros")
public class Libros {
    @Id
    private int id_libro;
    private String titulo;
    private String autor;
    private int ano_publicacion;
    @OneToMany(mappedBy = "libros")
    private List<Prestamos> list=new ArrayList<>();

    public void agregarPrestamo(Prestamos prestamos){
        this.agregarPrestamo(prestamos);
    }


}
