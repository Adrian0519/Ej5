package com.example.Ej505.Repositorio;

import com.example.Ej505.Entidades.Socios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SociosRepository extends JpaRepository<Socios, Integer> {

    @Query("select s.nombre, COUNT(p.libro.id_libro) " +
            "from Socios s left JOIN Prestamos p ON s.id_socio = p.socio.id_socio " +
            "GROUP BY s.id_socio, s.nombre")
    public List<Object[]> consulta3();

    @Query("select s.nombre, p.fecha_devolucion " +
            "from Socios s JOIN Prestamos p ON s.id_socio = p.socio.id_socio " +
            "where p.fecha_devolucion > p.fecha_prestamo")
    public List<Object[]> consulta4();

    @Query("select s.id_socio, s.nombre, COUNT(p.libro.id_libro) " +
            "from Socios s JOIN Prestamos p ON s.id_socio = p.socio.id_socio " +
            "group by s.id_socio, s.nombre " +
            "having count(p.libro.id_libro) > 1")
    public List<Object[]> consulta6();
}
