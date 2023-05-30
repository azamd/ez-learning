package com.ezlearning.platform;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.mockito.ArgumentMatchers.*;
import org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;


import org.mockito.*;

import com.ezlearning.platform.model;
import com.ezlearning.platform.services.core;
import com.ezlearning.platform.repositories;

@RunWith(SpringRunner.class)
@SpringBootTest
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