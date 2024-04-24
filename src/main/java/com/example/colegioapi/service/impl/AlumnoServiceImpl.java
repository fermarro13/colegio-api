package com.example.colegioapi.service.impl;

import com.example.colegioapi.exception.EntityNotFoundException;
import com.example.colegioapi.model.Alumno;
import com.example.colegioapi.repository.AlumnoRepository;
import com.example.colegioapi.service.AlumnoService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class AlumnoServiceImpl implements AlumnoService {

    private AlumnoRepository alumnoRepository;

    @Override
    public List<Alumno> findAllAlumno(PageRequest pageRequest){
        return alumnoRepository.findAll(pageRequest).toList();
    }

    @Override
    public Alumno findAlumnoById(Long id) {
        Optional<Alumno> optionalAlumno = alumnoRepository.findById(id);
        if(optionalAlumno.isEmpty()) throw new EntityNotFoundException("Alumno no encontrado.");
        return optionalAlumno.get();
    }

    @Override
    public Alumno createAlumno(Alumno alumno){
        return alumnoRepository.save(alumno);
    }
    @Override
    public void deleteAlumno(Long id){
        alumnoRepository.deleteById(id);
    }

    @Override
    public Alumno updateAlumno(Long id, Alumno alumno) {
        Optional<Alumno> optionalAlumnoDb = alumnoRepository.findById(id);
        if(optionalAlumnoDb.isEmpty()) throw new EntityNotFoundException("Alumno a actualizar no existe");
        Alumno alumnoDb = optionalAlumnoDb.get();
        alumnoDb.setApellidos(alumno.getApellidos());
        alumnoDb.setNombres(alumno.getNombres());
        alumnoDb.setGenero(alumno.getGenero());
        alumnoDb.setFecNac(alumno.getFecNac());
        return alumnoRepository.save(alumnoDb);
    }
}
