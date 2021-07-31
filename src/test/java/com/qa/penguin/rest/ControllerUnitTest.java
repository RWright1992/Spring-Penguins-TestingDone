package com.qa.penguin.rest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.qa.penguin.model.Penguin;
import com.qa.penguin.service.PengService;

@SpringBootTest
public class ControllerUnitTest {

	@Autowired
	private PengController controller;
	
	@MockBean
	private PengService service;
	
	Penguin penguin = new Penguin("test_name", "test_colour", true, 10);
	Penguin penguinWithID = new Penguin(1l, "test_name", "test_colour", true, 10);
	
	Penguin updatedPenguin = new Penguin("new_name", "new_colour", false, 20);
	Penguin updatedPenguinID = new Penguin(1l, "new_name", "new_colour", false, 20);
	
	Long id = 1l;
	
	@Test
	void testCreate() {
		
		// Given
		
		// When
		Mockito.when(this.service.createPenguin(penguin)).thenReturn(penguinWithID);
		
		// Then
		assertThat(this.controller.createPenguin(penguin)).isEqualTo(new ResponseEntity<String>(penguinWithID.getName() + " has been created :)", HttpStatus.CREATED));
	}
	
	@Test
	void testRead() {
		
		// Given
		List<Penguin> penguinList = new ArrayList<>();
		penguinList.add(penguinWithID);
		
		// When
		Mockito.when(this.service.getAllPenguins()).thenReturn(penguinList);
		
		// Then
		assertThat(this.controller.getAllPenguins()).isEqualTo(ResponseEntity.ok(penguinList));
	}
	
	@Test
	void testUpdate() {
		
		// Given
		
		// When
		Mockito.when(this.service.updatePenguin(updatedPenguin, id)).thenReturn("penguin id: " + id + " updated :)");
		
		// Then
		assertThat(this.controller.updatePenguin(updatedPenguin, id)).isEqualTo(new ResponseEntity<String>("Penguin " + updatedPenguin.getName() + " has been updated :) ", HttpStatus.ACCEPTED));
	}
	
	@Test
	void testDeletePass() {
		
		// Given
		
		// When
		Mockito.when(this.service.deletePenguin(id)).thenReturn(false);
		
		// Then
		assertThat(this.controller.deletePenguin(id)).isEqualTo(new ResponseEntity<String>("Penguin id: " + id + " has been deleted!", HttpStatus.OK));
		
	}
	
	@Test
	void testDeleteFails() {
		
		// Given
		
		// When
		Mockito.when(this.service.deletePenguin(id)).thenReturn(true);
		
		// Then
		assertThat(this.controller.deletePenguin(id)).isEqualTo(new ResponseEntity<String>("Penguin id: " + id + " can't be deleted :(", HttpStatus.INTERNAL_SERVER_ERROR));
		
	}
	
}
