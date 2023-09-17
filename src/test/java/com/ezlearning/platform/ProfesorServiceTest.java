package com.ezlearning.platform;


import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.junit4.SpringRunner;

import com.ezlearning.platform.dto.ProfesotDto;
import com.ezlearning.platform.model.Profesor;
import com.ezlearning.platform.repositories.ProfesorRepository;
import com.ezlearning.platform.services.core.impl.ProfesorService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProfesorServiceTest {

@InjectMocks
private ProfesorService profesorService;

@Mock
private ProfesorRepository profesorRepository;


@Before
public void setUp() {
			MockitoAnnotations.initMocks(this);
		}
	
	@Test
	@Order(1)
	public void testCreate() {
			// Arrange
			ProfesotDto profesotDto = new ProfesotDto();
			when(profesorRepository.save(any(Profesor.class))).thenReturn(new Profesor());
	
			profesorService.create(profesotDto);
			verify(profesorRepository, times(1)).save(any(Profesor.class));
		}
	
	@Test
	@Order(2)
	public void testGetAll() {
			
			List<Profesor> profesores = new ArrayList<>();
			when(profesorRepository.findAll()).thenReturn(profesores);
	
			List<Profesor> result = profesorService.getAll();
			verify(profesorRepository, times(1)).findAll();
		}
	
	@Test
	@Order(3)
		public void testUpdate() {

			Profesor updatedProfesor = new Profesor();
			updatedProfesor.setId_profesor(1L);
			when(profesorRepository.findById(1L)).thenReturn(Optional.of(new Profesor()));
	
			profesorService.update(updatedProfesor);
	
			verify(profesorRepository, times(1)).findById(1L);
			verify(profesorRepository, times(1)).save(any(Profesor.class));
		}
	
	@Test
	@Order(4)
	public void testPatch() {
			Profesor patchedProfesor = new Profesor();
			patchedProfesor.setId_profesor(1L);
			when(profesorRepository.findById(1L)).thenReturn(Optional.of(new Profesor()));
	
			profesorService.patch(patchedProfesor);
			verify(profesorRepository, times(1)).findById(1L);
			verify(profesorRepository, times(1)).save(any(Profesor.class));
		}
	
	@Test
	@Order(5)
	public void testDelete() {
			Profesor profesor = new Profesor();
			profesorService.delete(profesor);
			verify(profesorRepository, times(1)).delete(profesor);
		}

	
}