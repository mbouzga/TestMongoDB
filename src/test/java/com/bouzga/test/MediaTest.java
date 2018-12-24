package com.bouzga.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.bouzga.TestMongoDbApplicationTests;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

@RunWith(SpringRunner.class)
public class MediaTest extends TestMongoDbApplicationTests {

	private MongoClient mongoClient;
	private MongoDatabase database;
	private MongoCollection<Document> mediaCollection;

	@Before
	public void setup() {
		this.mongoClient = new MongoClient("localhost", 27017);
		this.database = mongoClient.getDatabase("my_db");
		this.mediaCollection = database.getCollection("media");
	}

	@Test
	public void testMediaAll() {
		mediaCollection = database.getCollection("media");
		MongoCursor<Document> cursorMedia = mediaCollection.find().iterator();

		while (cursorMedia.hasNext()) {
			System.out.println(cursorMedia.next());
		}
	}

	@Test
	public void testInsertMedia() {
		Document media = new Document();
		List<BasicDBObject> array = new ArrayList<BasicDBObject>();
		array.add(new BasicDBObject("0", 12.3D));
		array.add(new BasicDBObject("1", 32.1D));
		media.put("city", "OUJDA");
		media.put("loc", array);
		media.put("pop", 1987);
		media.put("state", "MA");

		mediaCollection.insertOne(media);
	}

	@Test
	public void testFindMediaById() {
		Bson critere = Filters.eq("_id", "99950");
		Document media = mediaCollection.find(critere).first();
		assertEquals(media.get("city"), "KETCHIKAN");
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
