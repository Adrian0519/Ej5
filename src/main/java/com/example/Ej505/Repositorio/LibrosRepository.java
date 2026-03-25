package com.example.Ej505.Repositorio;

import com.example.Ej505.Entidades.Libros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibrosRepository extends JpaRepository<Libros,Long> {
    @Query("select l, s.nombre, s.direccion " +
            "from Libro " +
            "l JOIN Prestamo p ON l.idLibro = p.libro.idLibro " +
            "JOIN Socio s ON p.socio.idSocio = s.idSocio")
    public List<Object[]> consulta1();
    @Query("select l.titulos,s.nombre" +
            "AS s.nombre_socio,p.fecha_prestamo,p.fecha_devolucion" +
            "FROM")

}
