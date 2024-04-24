package com.example.colegioapi.service;

import com.example.colegioapi.model.Grado;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface GradoService {
    List<Grado> findAllGrado(PageRequest pageRequest);

    Grado findGradoById(Long id);

    Grado createGrado(Grado grado);

    void deleteGrado(Long id);

    Grado updateGrado(Long id, Grado grado);
}
