package com.example.Ej505.Servicios;

import com.example.Ej505.DTO.Consulta3DTO;
import com.example.Ej505.DTO.Consulta4DTO;
import com.example.Ej505.DTO.Consulta6DTO;
import com.example.Ej505.Entidades.Prestamos;
import com.example.Ej505.Entidades.Socios;
import com.example.Ej505.Repositorio.SociosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SociosService {
   private final SociosRepository sociosRepository;

   public void guardar(Socios socios){
       sociosRepository.save(socios);
   }

   public List<Consulta3DTO>consulta3(){
       List<Object[]>result=sociosRepository.consulta3();
       return result.stream().map(objects -> new Consulta3DTO((String)objects[0],(Long)objects[1])).collect(Collectors.toList());
   }

   public List<Consulta4DTO>consulta4(){
       List<Object[]>result=sociosRepository.consulta4();
       return result.stream().map(objects -> new Consulta4DTO((String)objects[0],(LocalDate)objects[1])).collect(Collectors.toList());
   }

   public List<Consulta6DTO>consulta6(){
       List<Object[]>result=sociosRepository.consulta6();
       return result.stream().map(objects -> new Consulta6DTO((Integer)objects[0],(String)objects[1],(Long) objects[2] )).collect(Collectors.toList());
   }
}
