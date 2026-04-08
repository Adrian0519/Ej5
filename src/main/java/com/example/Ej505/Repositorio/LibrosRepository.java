package com.example.Ej505.Repositorio;

import com.example.Ej505.Entidades.Libros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LibrosRepository extends JpaRepository<Libros, Integer> {

    @Query("select l, s.nombre, s.direccion from Libros l JOIN Prestamos p ON l.id_libro = p.libro.id_libro JOIN Socios s ON p.socio.id_socio = s.id_socio")
    public List<Object[]> consulta1();

    @Query("select l.titulo, s.nombre, p.fecha_prestamo, p.fecha_devolucion " +
            "from Libros l JOIN Prestamos p ON l.id_libro = p.libro.id_libro " +
            "JOIN Socios s ON p.socio.id_socio = s.id_socio " +
            "where p.fecha_devolucion is null")
    public List<Object[]> consulta2();

    @Query("select l " +
            "from Libros l LEFT JOIN Prestamos p ON l.id_libro = p.libro.id_libro " +
            "where p.libro.id_libro is null")
    public List<Libros> consulta5();

    @Query("select l.titulo, COUNT(p.libro.id_libro) " +
            "from Libros l LEFT JOIN Prestamos p ON l.id_libro = p.libro.id_libro " +
            "group by l.id_libro, l.titulo")
    public List<Object[]> consulta7();

    @Query("select l.titulo, p.fecha_prestamo, p.fecha_devolucion from Libros l " +
            "JOIN Prestamos p ON l.id_libro = p.libro.id_libro " +
            "where p.fecha_prestamo between :fecha1 and :fecha2")
    public List<Object[]> consulta8(@Param("fecha1") LocalDate fecha1,
                                    @Param("fecha2") LocalDate fecha2);

    @Query("select l.titulo, p.fecha_prestamo, p.fecha_devolucion from Libros l " +
            "JOIN Prestamos p ON l.id_libro = p.libro.id_libro " +
            "JOIN Socios s ON p.socio.id_socio = s.id_socio " +
            "where s.id_socio = :socio")
    public List<Object[]> consulta9(@Param("socio") int idSocio);
}
