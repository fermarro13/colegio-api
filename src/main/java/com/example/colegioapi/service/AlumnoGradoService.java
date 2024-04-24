package com.example.colegioapi.service;

import com.example.colegioapi.model.AlumnoGrado;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface AlumnoGradoService {
    List<AlumnoGrado> findAllAlumnoGrado(PageRequest pageRequest);

    AlumnoGrado findAlumnoGradoById(Long id);

    AlumnoGrado createAlumnoGrado(AlumnoGrado alumnoGrado);

    void deleteAlumnoGrado(Long id);

    AlumnoGrado updateAlumnoGrado(Long id, AlumnoGrado alumnoGrado);
}
