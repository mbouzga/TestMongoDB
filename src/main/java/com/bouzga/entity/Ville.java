package com.bouzga.entity;

import org.springframework.data.annotation.Id;

public class Ville {

	@Id
	private String id;
	private String nom;
	private Integer population;
	private String departement;
	
	public Ville(String id, String nom, Integer population, String departement) {
		super();
		this.id = id;
		this.nom = nom;
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
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	@Override
    public String toString() {
        return String.format(
                "Ville_[id=%s, nom=%s, population='%s', departement='%s']",
                id, nom, population, departement);
    }
}
