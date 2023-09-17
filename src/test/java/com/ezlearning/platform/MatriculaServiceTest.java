package com.ezlearning.platform;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.annotation.Order;

import com.ezlearning.platform.auth.User;
import com.ezlearning.platform.auth.UserRepository;
import com.ezlearning.platform.model.Curso;
import com.ezlearning.platform.model.Matricula;
import com.ezlearning.platform.repositories.CursoRepository;
import com.ezlearning.platform.repositories.MatriculaRepository;
import com.ezlearning.platform.services.core.impl.MatriculaService;

public class MatriculaServiceTest {

    @InjectMocks
    private MatriculaService matriculaService;

    @Mock
    private MatriculaRepository matriculaRepository;

    @Mock
    private CursoRepository cursoRepository;

    @Mock
    private UserRepository userRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @Order(1)
    public void testCreateMatricula() throws Exception {
        Long courseId = 1L;
        String username = "testuser";

        Curso curso = new Curso();
        User user = new User();
        LocalDate currentDate = LocalDate.now();

        when(cursoRepository.findById(courseId)).thenReturn(Optional.of(curso));
        when(userRepository.findByUsername(username)).thenReturn(user);
        when(matriculaRepository.findByCursoAndUsuario(curso, user)).thenReturn(null);

        matriculaService.createMatricula(courseId, username);

        verify(cursoRepository, times(1)).findById(courseId);
        verify(userRepository, times(1)).findByUsername(username);
        verify(matriculaRepository, times(1)).findByCursoAndUsuario(curso, user);

        verify(matriculaRepository, times(1)).save(any(Matricula.class));
    }

    @Test(expected = Exception.class)
    @Order(2)
    public void testCreateMatriculaAlreadyEnrolled() throws Exception {
        Long courseId = 1L;
        String username = "testuser";

        Curso curso = new Curso();
        User user = new User();

        when(cursoRepository.findById(courseId)).thenReturn(Optional.of(curso));
        when(userRepository.findByUsername(username)).thenReturn(user);
        when(matriculaRepository.findByCursoAndUsuario(curso, user)).thenReturn(new Matricula());

        matriculaService.createMatricula(courseId, username);
    }
}
