package com.example.Ej505.Entidades;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "socios")
@EqualsAndHashCode(exclude = {"listaPrestamo"})
public class Socios {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_socio;
    @NonNull
    private String nombre;
    @NonNull
    private String direccion;
    @NonNull
    private LocalDate fecha_inscripcion;
    @OneToMany(mappedBy = "socio")
    private List <Prestamos> listPrestamos=new ArrayList<>();

    public void agregarPrestamo(Prestamos prestamos){
        listPrestamos.add(prestamos);
    }

}
