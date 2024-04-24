package com.example.colegioapi.service.impl;

import com.example.colegioapi.exception.EntityNotFoundException;
import com.example.colegioapi.model.Grado;
import com.example.colegioapi.repository.GradoRepository;
import com.example.colegioapi.service.GradoService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
@AllArgsConstructor
public class GradoServiceImpl implements GradoService {

    private final Logger logger = Logger.getLogger(GradoServiceImpl.class.getName());

    private GradoRepository gradoRepository;

    @Override
    public List<Grado> findAllGrado(PageRequest pageRequest){
        logger.info("Grados existentes: "+gradoRepository.findAll(pageRequest).toList().size());
        return gradoRepository.findAll(pageRequest).toList();
    }

    @Override
    public Grado findGradoById(Long id) {
        Optional<Grado> optionalGrado = gradoRepository.findById(id);
        if(optionalGrado.isEmpty()) throw new EntityNotFoundException("Grado no encontrado.");
        return optionalGrado.get();
    }

    @Override
    public Grado createGrado(Grado grado){
        return gradoRepository.save(grado);
    }
    @Override
    public void deleteGrado(Long id){
        gradoRepository.deleteById(id);
    }

    @Override
    public Grado updateGrado(Long id, Grado grado) {
        Optional<Grado> optionalGradoDb = gradoRepository.findById(id);
        if(optionalGradoDb.isEmpty()) throw new EntityNotFoundException("Grado a actualizar no existe");
        Grado gradoDb = optionalGradoDb.get();
        gradoDb.setProfesor(grado.getProfesor());
        gradoDb.setNombre(grado.getNombre());
        return gradoRepository.save(gradoDb);
    }
}
