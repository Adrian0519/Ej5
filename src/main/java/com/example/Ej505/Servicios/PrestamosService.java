package com.example.Ej505.Servicios;

import com.example.Ej505.Entidades.Prestamos;
import com.example.Ej505.Repositorio.PrestamosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrestamosService {

    private final PrestamosRepository prestamosRepository;

    public void  guardarPrestamos(Prestamos prestamos){
        prestamosRepository.save(prestamos);
    }

}
