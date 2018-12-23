package com.bouzga.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bouzga.entity.Pays;
import com.bouzga.entity.Ville;

public interface PaysRepository extends MongoRepository<Pays, String>{
	public Pays getPaysById(String id);
	public Ville getVilleById(String id);
}
