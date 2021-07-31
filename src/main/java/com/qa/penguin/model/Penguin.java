package com.qa.penguin.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Penguin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String colour;
	private boolean hasHappyFeet;
	private int fishEaten;
	
	
	public Penguin() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Penguin(String name, String colour, boolean hasHappyFeet, int fishEaten) {
		super();
		this.name = name;
		this.colour = colour;
		this.hasHappyFeet = hasHappyFeet;
		this.fishEaten = fishEaten;
	}


	public Penguin(Long id, String name, String colour, boolean hasHappyFeet, int fishEaten) {
		super();
		this.id = id;
		this.name = name;
		this.colour = colour;
		this.hasHappyFeet = hasHappyFeet;
		this.fishEaten = fishEaten;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getColour() {
		return colour;
	}


	public void setColour(String colour) {
		this.colour = colour;
	}


	public boolean isHasHappyFeet() {
		return hasHappyFeet;
	}


	public void setHasHappyFeet(boolean hasHappyFeet) {
		this.hasHappyFeet = hasHappyFeet;
	}


	public int getFishEaten() {
		return fishEaten;
	}


	public void setFishEaten(int fishEaten) {
		this.fishEaten = fishEaten;
	}
	
	
	
	

}
