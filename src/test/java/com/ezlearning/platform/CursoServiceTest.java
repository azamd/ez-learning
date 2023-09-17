package com.ezlearning.platform;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.annotation.Order;

import com.ezlearning.platform.model.Curso;
import com.ezlearning.platform.repositories.CursoRepository;
import com.ezlearning.platform.services.core.impl.CursoService;

public class CursoServiceTest {

    @InjectMocks
    private CursoService cursoService;

    @Mock
    private CursoRepository cursoRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @Order(2)
    public void testUpdate() {
        Curso curso = new Curso();
        Long id = 1L;
        when(cursoRepository.findById(id)).thenReturn(Optional.of(new Curso()));
        cursoService.update(curso, id);

        verify(cursoRepository, times(1)).findById(id);
        verify(cursoRepository, times(1)).save(any(Curso.class));
    }

    @Test
    @Order(3)
    public void testDelete() {
        Curso curso = new Curso();
        cursoService.delete(curso);
        verify(cursoRepository, times(1)).delete(curso);
    }

    @Test
    @Order(1)
    public void testGetAll() {
        List<Curso> cursos = new ArrayList<>();
        when(cursoRepository.findAll()).thenReturn(cursos);
        List<Curso> result = cursoService.getAll();

        verify(cursoRepository, times(1)).findAll();
    }
}
