package com.example.Ej505.Repositorio;

import com.example.Ej505.Entidades.Libros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LibrosRepository extends JpaRepository<Libros,Long> {
    @Query("select l, s.nombre, s.direccion " +
            "from Libros l " +
            "JOIN Prestamos p ON l.idLibro = p.libro.idLibro " +
            "JOIN Socios s ON p.socio.idSocio = s.idSocio")
    public List<Object[]> consulta1();
    @Query("SELECT l.titulo, s.nombre, p.fecha_prestamo, p.fecha_devolucion\n" +
            "FROM Libros l " +
            "JOIN Prestamos ON l.id_libro = p.id_libro\n" +
            "JOIN Socios ON p.id_socio = s.id_socio\n" +
            "WHERE p.fecha_devolucion IS NULL")
    public List<Object[]> consulta2();
    @Query("SELECT l\n" +
            "FROM Libros l " +
            "LEFT JOIN Prestamos ON l.id_libro = p.id_libro\n" +
            "WHERE p.id_libro IS NULL")
    public List<Libros> consulta5();
    @Query("SELECT l.titulo, COUNT(p.id_libro)\n" +
            "FROM Libros l " +
            "LEFT JOIN Prestamos ON l.id_libro = p.id_libro\n" +
            "GROUP BY l.id_libro, l.titulo")
    public List<Object[]> consulta7();
    @Query("SELECT l.titulo, p.fecha_prestamo, p.fecha_devolucion\n" +
            "FROM Libros l " +
            "JOIN Prestamos ON l.id_libro = p.id_libro\n" +
            "WHERE p.fecha_prestamo BETWEEN :fecha1 AND :fecha2")
    public List<Object[]> consulta8(@Param("fecha1") LocalDate fecha1, @Param("fecha2")LocalDate fecha2);
    @Query("SELECT l.titulo, p.fecha_prestamo, p.fecha_devolucion\n" +
            "FROM Libros l " +
            "JOIN Prestamos ON l.id_libro = p.id_libro\n" +
            "JOIN Socios ON p.id_socio = s.id_socio\n" +
            "WHERE s.id_socio = :socio")
    public List<Object[]> consulta9(@Param("socio")int id_socio);


}
