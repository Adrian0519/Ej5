package com.example.Ej505.Repositorio;

import com.example.Ej505.Entidades.Socios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SociosRepository extends JpaRepository<Socios, Integer> {
    @Query("SELECT s.nombre, COUNT(p.id_libro)\n" +
            "FROM Socios\n" +
            "LEFT JOIN Prestamos ON s.id_socio = p.id_socio\n" +
            "GROUP BY s.id_socio, s.nombre")
    public List<Object[]> consulta3();
    @Query("SELECT s.nombre, p.fecha_devolucion\n" +
            "FROM Socios\n" +
            "JOIN Prestamos ON s.id_socio = p.id_socio\n" +
            "WHERE p.fecha_devolucion > p.fecha_prestamo")
    public List<Object[]> consulta4();
    @Query("SELECT s.id_socio, s.nombre, COUNT(p.id_libro) \n" +
            "FROM Socios\n" +
            "JOIN Prestamos ON s.id_socio = p.id_socio\n" +
            "GROUP BY s.id_socio, s.nombre\n" +
            "HAVING COUNT(p.id_libro) > 1")
    public List<Object[]> consulta6();
}
