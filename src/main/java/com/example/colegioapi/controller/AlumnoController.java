package com.example.colegioapi.controller;

import com.example.colegioapi.model.Alumno;
import com.example.colegioapi.service.AlumnoService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/alumno")
@CrossOrigin
public class AlumnoController {

    private AlumnoService alumnoService;

    @GetMapping
    public List<Alumno> getAlumnos(
            @RequestParam(value = "size",defaultValue = "10") int size,
            @RequestParam(value = "page",defaultValue = "0") int page){
        return alumnoService.findAllAlumno(PageRequest.of(page,size));
    }

    @GetMapping("{id}")
    public Alumno getAlumno(@PathVariable("id") Long id){
        return alumnoService.findAlumnoById(id);
    }

    @PostMapping
    public Alumno createAlumno(@RequestBody Alumno alumno){
        return alumnoService.createAlumno(alumno);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAlumno(@PathVariable("id") Long id){
        alumnoService.deleteAlumno(id);
    }

    @PutMapping("{id}")
    public Alumno updateAlumno(@PathVariable("id") Long id,@RequestBody Alumno alumno){
        return alumnoService.updateAlumno(id,alumno);
    }
}
