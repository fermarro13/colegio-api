package com.example.colegioapi.service;

import com.example.colegioapi.model.Profesor;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface ProfesorService {

    List<Profesor> findAllProfesor(PageRequest pageRequest);

    List<Profesor> findAllAvailableProfesor();

    Profesor findProfesorById(Long id);

    Profesor createProfesor(Profesor profesor);

    void deleteProfesor(Long id);

    Profesor updateProfesor(Long id, Profesor profesor);
}
