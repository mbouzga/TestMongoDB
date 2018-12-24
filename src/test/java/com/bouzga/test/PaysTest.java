package com.bouzga.test;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.bouzga.TestMongoDbApplicationTests;
import com.bouzga.entity.Pays;
import com.bouzga.entity.Ville;
import com.bouzga.repository.PaysRepository;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

@RunWith(SpringRunner.class)
public class PaysTest extends TestMongoDbApplicationTests{

	@Autowired
	private PaysRepository paysRepo;
	
	private MongoClient mongoClient;
	private MongoDatabase database;
	private MongoCollection<Document> paysCollection;
	
	@Before
	public void setup() {
		this.mongoClient = new MongoClient("localhost", 27017);
		this.database = mongoClient.getDatabase("my_db");
		this.paysCollection = database.getCollection("pays");
		
		System.out.println("--- CLEAR PAYS ---");
		paysRepo.deleteAll();
		System.out.println("--- SAVE PAYS ---");
		Ville oujda = new Ville("1","Oujda", 500000, "Est");
		Ville tanger = new Ville("2","Tanger", 1000000, "Nord");
		Ville rabat = new Ville("3","Rabat", 1500000, "Ouest");
		Ville agadir = new Ville("4","Agadir", 1200000, "Sud");
		List<Ville> villes = new ArrayList<>();
		villes.add(oujda);villes.add(tanger);villes.add(rabat);villes.add(agadir);
		
		Pays maroc = new Pays("1", "Maroc", villes);
		paysRepo.save(maroc);
	}
	
	@Test
	public void savePays() {

	}

	@Test
	public void getPaysParCritere() {
		Bson critere = Filters.and(Filters.eq("_id","1"),Filters.eq("nom", "Maroc"));
		Document pays = paysCollection.find(critere).first();
		assertEquals(pays.get("nom"), "Maroc");
	}
	
	public MongoClient getMongoClient() {
		return mongoClient;
	}

	public void setMongoClient(MongoClient mongoClient) {
		this.mongoClient = mongoClient;
	}

	public MongoDatabase getDatabase() {
		return database;
	}

	public void setDatabase(MongoDatabase database) {
		this.database = database;
	}

	public MongoCollection<Document> getPaysCollection() {
		return paysCollection;
	}

	public void setPaysCollection(MongoCollection<Document> paysCollection) {
		this.paysCollection = paysCollection;
	}
	
}
