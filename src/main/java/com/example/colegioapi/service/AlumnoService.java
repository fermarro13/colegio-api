package com.example.colegioapi.service;

import com.example.colegioapi.model.Alumno;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface AlumnoService {
    List<Alumno> findAllAlumno(PageRequest pageRequest);

    Alumno findAlumnoById(Long id);

    Alumno createAlumno(Alumno alumno);

    void deleteAlumno(Long id);

    Alumno updateAlumno(Long id, Alumno alumno);
}
