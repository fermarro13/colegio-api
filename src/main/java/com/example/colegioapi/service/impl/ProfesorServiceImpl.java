package com.example.colegioapi.service.impl;

import com.example.colegioapi.exception.EntityNotFoundException;
import com.example.colegioapi.model.Profesor;
import com.example.colegioapi.repository.ProfesorRepository;
import com.example.colegioapi.service.ProfesorService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProfesorServiceImpl implements ProfesorService {

    private ProfesorRepository profesorRepository;

    @Override
    public List<Profesor> findAllProfesor(PageRequest pageRequest) {
        return profesorRepository.findAll(pageRequest).toList();
    }

    @Override
    public List<Profesor> findAllAvailableProfesor() {
        return profesorRepository.findAllAvailableProfesor();
    }

    @Override
    public Profesor findProfesorById(Long id) {
        Optional<Profesor> optionalProfesor = profesorRepository.findById(id);
        if(optionalProfesor.isEmpty()) throw new EntityNotFoundException("Profesor no encontrado.");
        return optionalProfesor.get();
    }

    @Override
    public Profesor createProfesor(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    @Override
    public void deleteProfesor(Long id) {
        profesorRepository.deleteById(id);
    }

    @Override
    public Profesor updateProfesor(Long id, Profesor profesor) {
        Optional<Profesor> optionalProfesorDb = profesorRepository.findById(id);
        if(optionalProfesorDb.isEmpty()) throw new EntityNotFoundException("Profesor a actualizar no existe");
        Profesor profesorDb = optionalProfesorDb.get();
        profesorDb.setApellidos(profesor.getApellidos());
        profesorDb.setNombres(profesor.getNombres());
        profesorDb.setGenero(profesor.getGenero());
        return profesorRepository.save(profesorDb);
    }
}
