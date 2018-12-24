package com.bouzga.test;

import org.bson.Document;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.bouzga.TestMongoDbApplicationTests;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

@RunWith(SpringRunner.class)
public class MediaTest extends TestMongoDbApplicationTests{

	private MongoClient mongoClient;
	private MongoDatabase database;
	private MongoCollection<Document> mediaCollection;
	@Before
	public void setup() {
		this.mongoClient = new MongoClient("localhost", 27017);
		this.database = mongoClient.getDatabase("my_db");
	}
	
	@Test
	public void testMediaAll() {
		mediaCollection = database.getCollection("media");
		MongoCursor<Document> cursorMedia = mediaCollection.find().iterator();
		 
		while (cursorMedia.hasNext()) {
		    System.out.println(cursorMedia.next());
		}
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
}
