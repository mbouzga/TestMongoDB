package com.bouzga.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Pays {

	@Id
	private String id;
	
	private String nom;
	
	@DBRef
	private List<Ville> villes;
	
	@PersistenceConstructor
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
	
	@Override
    public String toString() {
        return String.format(
                "Pays_[id=%s, nom='%s', Villes_='%s']",
                id, nom, villes);
    }
	
}
