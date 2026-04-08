package com.example.Ej505.Controlador;

import com.example.Ej505.DTO.*;
import com.example.Ej505.Entidades.Libros;
import com.example.Ej505.Entidades.Prestamos;
import com.example.Ej505.Entidades.Socios;
import com.example.Ej505.Servicios.LibrosService;
import com.example.Ej505.Servicios.PrestamosService;
import com.example.Ej505.Servicios.SociosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/libros")
@RequiredArgsConstructor
public class AppController {
    private final LibrosService librosService;
    private final PrestamosService prestamosService;
    private final SociosService sociosService;
    @GetMapping("/consulta1")
    public ResponseEntity <List<Consulta1DTO>> consulta1(){
        return ResponseEntity.ok(librosService.consulta1());
    }
    @GetMapping("/consulta2")
    public ResponseEntity <List<Consulta2DTO>> consulta2(){
        return ResponseEntity.ok(librosService.consulta2());
    }
    @GetMapping("/consulta3")
    public ResponseEntity <List<Consulta3DTO>> consulta3(){
        return ResponseEntity.ok(sociosService.consulta3());
    }
    @GetMapping("/consulta4")
    public ResponseEntity <List<Consulta4DTO>> consulta4(){
        return ResponseEntity.ok(sociosService.consulta4());
    }
    @GetMapping("/consulta5")
    public ResponseEntity <List<Libros>> consulta5(){
        return ResponseEntity.ok(librosService.consulta5());
    }
    @GetMapping("/consulta6")
    public ResponseEntity <List<Consulta6DTO>> consulta6(){
        return ResponseEntity.ok(sociosService.consulta6());
    }
    @GetMapping("/consulta7")
    public ResponseEntity <List<Consulta3DTO>> consulta7(){
        return ResponseEntity.ok(librosService.consuta7());
    }
    @GetMapping("/consulta8/{fecha1}:{fecha2}")
    public ResponseEntity<List<Consulta8DTO>> consulta8(@PathVariable String fecha1, @PathVariable String fecha2){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate f1 = LocalDate.parse(fecha1, formatter);
        LocalDate f2 = LocalDate.parse(fecha2, formatter);
        return ResponseEntity.ok(librosService.consulta8(f1, f2));
    }
    @GetMapping("/consulta9/{id}")
    public ResponseEntity<List<Consulta8DTO>> consulta9(@PathVariable int id){
        return  ResponseEntity.ok(librosService.consulta9(id));
    }

    @PatchMapping("/cargar")
    public ResponseEntity<String> cargarDatos(){
        ArrayList<Libros> listaLibros = new ArrayList<>();
        ArrayList<Prestamos> listaPrestamos = new ArrayList<>();
        ArrayList<Socios> listaSocios = new ArrayList<>();

        listaLibros.add(new Libros("El Señor de los Anillos", "J.R.R. Tolkien", 1954));
        listaLibros.add(new Libros("Cien años de soledad", "Gabriel García Márquez", 1967));
        listaLibros.add(new Libros("Harry Potter y la piedra filosofal", "J.K. Rowling", 1997));
        listaLibros.add(new Libros("Libro X", "Autor X", 2002));
        listaLibros.add(new Libros("Libro Y", "Autora Y", 2007));

        for (Libros libro: listaLibros)
            librosService.guardarLibro(libro);

        listaSocios.add(new Socios("Ana García", "Calle 321, Ciudad X", LocalDate.of(2022, 1, 1)));
        listaSocios.add(new Socios("Carlos Martínez", "Avenida 654, Ciudad Y", LocalDate.of(2022, 12, 15)));
        listaSocios.add(new Socios("Elena Pérez", "Calle 987, Ciudad Z", LocalDate.of(2022, 2, 10)));

        for (Socios socio: listaSocios)
            sociosService.guardar(socio);

        listaPrestamos.add(new Prestamos(LocalDate.of(2022, 2, 1), LocalDate.of(2022, 3, 1)));
        listaPrestamos.add(new Prestamos(LocalDate.of(2022, 1, 15), LocalDate.of(2022, 2, 15)));
        listaPrestamos.add(new Prestamos(LocalDate.of(2022, 3, 10), LocalDate.of(2022, 4, 10)));
        listaPrestamos.add(new Prestamos(LocalDate.of(2022, 3, 10)));

        listaPrestamos.get(0).agregarLibro(listaLibros.get(0));
        listaPrestamos.get(0).agregarSocio(listaSocios.get(0));
        listaPrestamos.get(1).agregarLibro(listaLibros.get(1));
        listaPrestamos.get(1).agregarSocio(listaSocios.get(1));
        listaPrestamos.get(2).agregarLibro(listaLibros.get(2));
        listaPrestamos.get(2).agregarSocio(listaSocios.get(2));
        listaPrestamos.get(3).agregarLibro(listaLibros.get(4));
        listaPrestamos.get(3).agregarSocio(listaSocios.get(2));

        for (Prestamos prestamo: listaPrestamos)
            prestamosService.guardarPrestamos(prestamo);

        return ResponseEntity.ok("Datos cargados correctamente");
    }

}

