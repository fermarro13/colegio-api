package com.example.colegioapi.controller;

import com.example.colegioapi.model.Grado;
import com.example.colegioapi.service.GradoService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/grado")
public class GradoController {

    private GradoService gradoService;

    @GetMapping
    public List<Grado> getGrados(
            @RequestParam(value = "size",defaultValue = "10") int size,
            @RequestParam(value = "page",defaultValue = "0") int page){
        return gradoService.findAllGrado(PageRequest.of(page,size));
    }

    @GetMapping("{id}")
    public Grado getGrado(@PathVariable("id") Long id){
        return gradoService.findGradoById(id);
    }

    @PostMapping
    public Grado createGrado(@RequestBody Grado grado){
        return gradoService.createGrado(grado);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGrado(@PathVariable("id") Long id){
        gradoService.deleteGrado(id);
    }

    @PutMapping("{id}")
    public Grado updateGrado(@PathVariable("id") Long id,@RequestBody Grado grado){
        return gradoService.updateGrado(id,grado);
    }
}
