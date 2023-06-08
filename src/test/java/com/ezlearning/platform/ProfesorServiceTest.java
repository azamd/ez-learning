package com.ezlearning.platform;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import com.ezlearning.platform.dto.ProfesotDto;
import com.ezlearning.platform.model.Profesor;
import com.ezlearning.platform.services.core.impl.*;
import com.ezlearning.platform.repositories.ProfesorRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProfesorServiceTest {

@InjectMocks
static ProfesorService profServiceImpl;
@Mock
static ProfesorRepository profRepository;
static List<Profesor> profs;



    @Before
    public void init() {
		MockitoAnnotations.initMocks(profRepository);
		profs =  new ArrayList<>();
		when(profRepository.findAll()).thenReturn(profs);
	}

    @Test
    @Order(1)
	public void testGetAll(){
		assertTrue(profServiceImpl.getAll().isEmpty());
		
		profs.add(mock(Profesor.class));
		
		assertFalse(profServiceImpl.getAll().isEmpty());

		
	}
	
	@Test
	@Order(2)
	public void testCreate(){
		
		profServiceImpl.create(mock(ProfesotDto.class));

		verify(profRepository).save(any());
		

		
	}
	
	/*@Test
	@Order(3)
	public void testUpdate(){
		
		profServiceImpl.update(mock(Profesor.class));

		verify(profRepository).save(any());
		

		
	}

    @Test
	@Order(4)
	public void testDelete(){
		
		profServiceImpl.delete(mock(Profesor.class));

		verify(profRepository).save(any());
		

		
	}*/

}