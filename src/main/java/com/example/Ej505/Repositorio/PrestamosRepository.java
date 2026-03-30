package com.example.Ej505.Repositorio;

import com.example.Ej505.Entidades.Prestamos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrestamosRepository extends JpaRepository<Prestamos, Integer> {
}
