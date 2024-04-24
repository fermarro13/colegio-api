package com.example.colegioapi.repository;

import com.example.colegioapi.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProfesorRepository extends JpaRepository<Profesor,Long> {

    @Query(value = "select p.* from profesor p left join grado g on g.profesor_id = p.id where g.id is null",nativeQuery = true)
    List<Profesor> findAllAvailableProfesor();
}
