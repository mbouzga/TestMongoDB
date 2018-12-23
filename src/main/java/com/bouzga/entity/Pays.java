package com.bouzga.entity;

import java.util.List;

import org.springframework.data.annotation.Id;

public class Pays {

	@Id
	private String id;
	
	private String nom;
	private List<Ville> villes;
	
	public Pays(String id, String nom, List<Ville> villes) {
		super();
		this.id = id;
		this.nom = nom;
		this.villes = villes;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Ville> getVilles() {
		return villes;
	}

	public void setVilles(List<Ville> villes) {
		this.villes = villes;
	}
	
}
