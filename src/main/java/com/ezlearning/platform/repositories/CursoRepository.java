package com.ezlearning.platform.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ezlearning.platform.model.Curso;
import com.ezlearning.platform.model.Profesor;

public interface CursoRepository extends JpaRepository<Curso, Long> {

    Curso findByNomCurso(String nombre);
    List<Curso> findAllByProfesor(Profesor profesor);
}
