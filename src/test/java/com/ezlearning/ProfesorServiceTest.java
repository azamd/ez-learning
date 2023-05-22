package com.ezlearning.platform;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import com.ezlearning.platform.model;
import com.ezlearning.platform.repositories;

@RunWith(SpringRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProfesorServiceTest {

@InjectMocks
static ProfesorService profServiceImpl;
@Mock
static ProfesorRepository profRepository;
static List<Profesor> profs;



    @BeforeEach
    void init() {
		MockitoAnnotations.openMocks(this);
		profs =  new ArrayList<>();
		when(profRepository.findAll()).thenReturn(profs);
	}

    @Test
    @Order(2)
	void testGetAll(){
		assertTrue(profServiceImpl.getAll().isEmpty());
		
		profs.add(mock(Profesor.class));
		
		assertFalse(profServiceImpl.getAll().isEmpty());

		
	}
	
	@Test
	@Order(1)
	void testCreate(){
		
		profServiceImpl.create(mock(Profesor.class));

		verify(profRepository).save(any());
		

		
	}
	
	@Test
	@Order(3)
	void testUpdate(){
		
		profServiceImpl.update(mock(Profesor.class));

		verify(profRepository).save(any());
		

		
	}

    @Test
	@Order(4)
	void testDelete(){
		
		profServiceImpl.delete(mock(Profesor.class));

		verify(profRepository).save(any());
		

		
	}








}