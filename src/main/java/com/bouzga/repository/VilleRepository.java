package com.bouzga.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bouzga.entity.Ville;

public interface VilleRepository extends MongoRepository<Ville, String>{

}
