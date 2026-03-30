package com.example.Ej505.Servicios;

import com.example.Ej505.DTO.Consulta1DTO;
import com.example.Ej505.Entidades.Libros;
import com.example.Ej505.Repositorio.LibrosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class LibrosService {

    private final LibrosRepository librosRepository;

    public void  guardarLibro(Libros libros){
        librosRepository.save(libros);
    }

    public List<Consulta1DTO>consulta1(){
        List<Object[]>resultado = librosRepository.consulta1();
        return resultado.stream().map(objects -> new Consulta1DTO((Libros) objects[0],(String) objects[1],(String) objects[2])).collect(Collectors.toList());
    }

    public List<Libros> consulta5(){
        return librosRepository.consulta5();
    }

}
