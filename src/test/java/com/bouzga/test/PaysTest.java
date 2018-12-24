package com.bouzga.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.bouzga.TestMongoDbApplicationTests;
import com.bouzga.entity.Pays;
import com.bouzga.entity.Ville;
import com.bouzga.repository.PaysRepository;

@RunWith(SpringRunner.class)
public class PaysTest extends TestMongoDbApplicationTests{

	@Autowired
	private PaysRepository paysRepo;
	
	@Before
	public void setup() {
		System.out.println("--- CLEAR PAYS ---");
		paysRepo.deleteAll();
	}
	
	@Test
	public void savePays() {
		System.out.println("--- SAVE PAYS ---");
		Ville oujda = new Ville("1","Oujda", 500000, "Est");
		Ville tanger = new Ville("2","Tanger", 1000000, "Nord");
		Ville rabat = new Ville("3","Rabat", 1500000, "Ouest");
		Ville agadir = new Ville("4","Agadir", 1200000, "Sud");
		List<Ville> villes = new ArrayList<>();
		villes.add(oujda);villes.add(tanger);villes.add(rabat);villes.add(agadir);
		
		Pays maroc = new Pays("1", "Maroc", villes);
		Pays paysSaved = paysRepo.save(maroc);
		System.out.println(paysSaved);
	}
}
