package com.example.Ej505.Entidades;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "libros")
@EqualsAndHashCode(exclude = {"listaPrestamo"})
public class Libros {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_libro;
    @NonNull
    private String titulo;
    @NonNull
    private String autor;
    @NonNull
    private int ano_publicacion;
    @OneToMany(mappedBy = "libro")
    private List<Prestamos> list=new ArrayList<>();

    public void agregarPrestamo(Prestamos prestamos){
        this.list.add(prestamos);
    }

}
