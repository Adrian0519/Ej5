package com.example.Ej505.Servicios;

import com.example.Ej505.DTO.Consulta1DTO;
import com.example.Ej505.DTO.Consulta2DTO;
import com.example.Ej505.DTO.Consulta3DTO;
import com.example.Ej505.DTO.Consulta8DTO;
import com.example.Ej505.Entidades.Libros;
import com.example.Ej505.Repositorio.LibrosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
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

    public List<Consulta2DTO> consulta2(){
        List<Object[]>resultado = librosRepository.consulta2();
        return resultado.stream().map(objects -> new Consulta2DTO((String) objects[0],(String) objects[1],(LocalDate) objects[2],(LocalDate) objects[3])).collect(Collectors.toList());
    }

    public List<Libros> consulta5(){
        return librosRepository.consulta5();
    }

    public List<Consulta3DTO> consuta7(){
        List<Object[]>resultado = librosRepository.consulta7();
        return resultado.stream().map(objects -> new Consulta3DTO((String)objects[0],(Long)objects[1])).collect(Collectors.toList());
    }

    public List<Consulta8DTO> consulta8(LocalDate fecha1, LocalDate fecha2){
        List<Object[]>resultado = librosRepository.consulta8(fecha1,fecha2);
        return resultado.stream().map(objects -> new Consulta8DTO((String) objects[0],(LocalDate) objects[1],(LocalDate) objects[2])).collect(Collectors.toList());
    }

    public List<Consulta8DTO> consulta9(int idSocio){
        List<Object[]>resultado = librosRepository.consulta9(idSocio);
        return resultado.stream().map(objects -> new Consulta8DTO((String) objects[0],(LocalDate) objects[1],(LocalDate) objects[2])).collect(Collectors.toList());
    }
}
