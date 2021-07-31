package com.qa.penguin.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.penguin.model.Penguin;
import com.qa.penguin.service.PengService;

@RestController
@CrossOrigin
public class PengController {
	
private PengService service;

public PengController(PengService service) {
	super();
	this.service = service;
}

@PostMapping("/create")
public ResponseEntity<String> createPenguin(@RequestBody Penguin penguin){
	this.service.createPenguin(penguin);
	return new ResponseEntity<String>(penguin.getName() + " has been created :)", HttpStatus.CREATED);
}

@GetMapping("/getAll")
public ResponseEntity<List<Penguin>> getAllPenguins() {
	return ResponseEntity.ok(this.service.getAllPenguins());
}

@PutMapping("/update/{id}")
public ResponseEntity<String> updatePenguin(@RequestBody Penguin penguin, @PathVariable Long id){
	this.service.updatePenguin(penguin, id);
	return new ResponseEntity<String>("Penguin " + penguin.getName() + " has been updated :) ", HttpStatus.ACCEPTED);
}

@DeleteMapping("/delete/{id}")
public ResponseEntity<String> deletePenguin(@PathVariable Long id){
	if(!this.service.deletePenguin(id)) {
		return new ResponseEntity<String>("Penguin id: " + id + " has been deleted!", HttpStatus.OK);
	} else {
		return new ResponseEntity<String>("Penguin id: " + id + " can't be deleted :(", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}



}
