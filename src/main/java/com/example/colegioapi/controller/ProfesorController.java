package com.example.colegioapi.controller;

import com.example.colegioapi.model.Profesor;
import com.example.colegioapi.service.ProfesorService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/profesor")
public class ProfesorController {
    
    private ProfesorService profesorService;

    @GetMapping
    public List<Profesor> getProfesors(
            @RequestParam(value = "size",defaultValue = "10") int size,
            @RequestParam(value = "page",defaultValue = "0") int page){
        return profesorService.findAllProfesor(PageRequest.of(page,size));
    }

    @GetMapping("/available")
    public List<Profesor> getAvailableProfesors(){
        return profesorService.findAllAvailableProfesor();
    }

    @GetMapping("{id}")
    public Profesor getProfesor(@PathVariable("id") Long id){
        return profesorService.findProfesorById(id);
    }

    @PostMapping
    public Profesor createProfesor(@RequestBody Profesor profesor){
        return profesorService.createProfesor(profesor);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProfesor(@PathVariable("id") Long id){
        profesorService.deleteProfesor(id);
    }

    @PutMapping("{id}")
    public Profesor updateProfesor(@PathVariable("id") Long id,@RequestBody Profesor profesor){
        return profesorService.updateProfesor(id,profesor);
    }


}
