package com.example.colegioapi.service.impl;

import com.example.colegioapi.exception.EntityNotFoundException;
import com.example.colegioapi.model.Alumno;
import com.example.colegioapi.model.AlumnoGrado;
import com.example.colegioapi.repository.AlumnoGradoRepository;
import com.example.colegioapi.service.AlumnoGradoService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AlumnoGradoServiceImpl implements AlumnoGradoService {

    private AlumnoGradoRepository alumnoGradoRepository;

    @Override
    public List<AlumnoGrado> findAllAlumnoGrado(PageRequest pageRequest) {
        return alumnoGradoRepository.findAll(pageRequest).toList();
    }

    @Override
    public AlumnoGrado findAlumnoGradoById(Long id) {
        Optional<AlumnoGrado> optionalAlumnoGrado = alumnoGradoRepository.findById(id);
        if(optionalAlumnoGrado.isEmpty()) throw new EntityNotFoundException("AlumnoGrado no encontrado.");
        return optionalAlumnoGrado.get();
    }

    @Override
    public AlumnoGrado createAlumnoGrado(AlumnoGrado alumnoGrado) {
        return alumnoGradoRepository.save(alumnoGrado);
    }

    @Override
    public void deleteAlumnoGrado(Long id) {
        alumnoGradoRepository.deleteById(id);
    }

    @Override
    public AlumnoGrado updateAlumnoGrado(Long id, AlumnoGrado alumnoGrado) {
        Optional<AlumnoGrado> optionalAlumnoGradoDb = alumnoGradoRepository.findById(id);
        if(optionalAlumnoGradoDb.isEmpty()) throw new EntityNotFoundException("AlumnoGrado a actualizar no existe");
        AlumnoGrado alumnoGradoDb = optionalAlumnoGradoDb.get();
        alumnoGradoDb.setAlumno(alumnoGrado.getAlumno());
        alumnoGradoDb.setProfesor(alumnoGrado.getProfesor());
        alumnoGradoDb.setSeccion(alumnoGrado.getSeccion());
        return alumnoGradoRepository.save(alumnoGradoDb);
    }
}
