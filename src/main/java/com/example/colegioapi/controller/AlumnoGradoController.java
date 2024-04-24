package com.example.colegioapi.controller;

import com.example.colegioapi.model.AlumnoGrado;
import com.example.colegioapi.service.AlumnoGradoService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/alumno-grado")
public class AlumnoGradoController {
    
    private AlumnoGradoService alumnoGradoService;

    @GetMapping
    public List<AlumnoGrado> getAlumnoGrados(
            @RequestParam(value = "size",defaultValue = "10") int size,
            @RequestParam(value = "page",defaultValue = "0") int page){
        return alumnoGradoService.findAllAlumnoGrado(PageRequest.of(page,size));
    }

    @GetMapping("{id}")
    public AlumnoGrado getAlumnoGrado(@PathVariable("id") Long id){
        return alumnoGradoService.findAlumnoGradoById(id);
    }

    @PostMapping
    public AlumnoGrado createAlumnoGrado(@RequestBody AlumnoGrado alumnoGrado){
        return alumnoGradoService.createAlumnoGrado(alumnoGrado);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAlumnoGrado(@PathVariable("id") Long id){
        alumnoGradoService.deleteAlumnoGrado(id);
    }

    @PutMapping("{id}")
    public AlumnoGrado updateAlumnoGrado(@PathVariable("id") Long id,@RequestBody AlumnoGrado alumnoGrado){
        return alumnoGradoService.updateAlumnoGrado(id,alumnoGrado);
    }
}
