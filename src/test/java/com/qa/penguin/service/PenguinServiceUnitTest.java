package com.qa.penguin.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.penguin.model.Penguin;
import com.qa.penguin.repo.PengRepo;

@SpringBootTest
public class PenguinServiceUnitTest {

	@Autowired
	private PengService service;
	
	@MockBean
	private PengRepo repo;
	
	Penguin penguin = new Penguin("test_name", "test_colour", true, 10);
	Penguin penguinWithID = new Penguin(1l, "test_name", "test_colour", true, 10);
	
	Penguin updatedPenguin = new Penguin("new_name", "new_colour", false, 20);
	Penguin updatedPenguinID = new Penguin(1l, "new_name", "new_colour", false, 20);
	
	Long id = 1l;
	
	@Test
	void testCreate() {
		
		// Given
		
		// When
		Mockito.when(this.repo.save(penguin)).thenReturn(penguinWithID);
		
		// Then
		System.out.println(this.service.createPenguin(penguin));
		assertThat(this.service.createPenguin(penguin)).isEqualTo(penguinWithID);
		
	}
	
	@Test
	void testRead() {
		
		// Given
		List<Penguin> penguinList = new ArrayList<>();
		penguinList.add(penguinWithID);
		
		// When
		Mockito.when(this.repo.findAll()).thenReturn(penguinList);
		
		// Then
		assertThat(this.service.getAllPenguins()).isEqualTo(penguinList);
	}
	
	@Test
	void testUpdate() {
		
		// Given
		
		// When
		
		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(penguinWithID));
		Mockito.when(this.repo.save(updatedPenguin)).thenReturn(updatedPenguin);
		
		// Then
		System.out.println(this.service.updatePenguin(updatedPenguin, id));
		System.out.println(updatedPenguinID);
		assertThat(this.service.updatePenguin(updatedPenguin, id)).isEqualTo("penguin id: " + id + " updated :)");
		
	}
	
	@Test
	void testDelete() {
		
		// Given
		boolean found = true;
		
		// When
		Mockito.when(this.repo.existsById(id)).thenReturn(found);
		
		// Then
		assertThat(this.service.deletePenguin(id)).isEqualTo(found);
	}
	
	
}
