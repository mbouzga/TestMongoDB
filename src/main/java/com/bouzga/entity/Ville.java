package com.bouzga.entity;

import org.springframework.data.annotation.Id;

public class Ville {

	@Id
	private String id;
	private Integer population;
	private String departement;
	
	
	public Ville(String id, Integer population, String departement) {
		super();
		this.id = id;
		this.population = population;
		this.departement = departement;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getPopulation() {
		return population;
	}
	public void setPopulation(Integer population) {
		this.population = population;
	}
	public String getDepartement() {
		return departement;
	}
	public void setDepartement(String departement) {
		this.departement = departement;
	}
	
	
}
