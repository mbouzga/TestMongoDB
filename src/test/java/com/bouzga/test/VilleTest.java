package com.bouzga.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.bouzga.TestMongoDbApplicationTests;
import com.bouzga.entity.Ville;
import com.bouzga.repository.VilleRepository;

@RunWith(SpringRunner.class)
public class VilleTest extends TestMongoDbApplicationTests{

	@Autowired
	private VilleRepository villeRepo;
	
	@Before
	public void setup() {
		villeRepo.deleteAll();
	}
	
	@Test
	public void saveVille() {
		Ville oujda = new Ville("1","Oujda", 500000, "Est");
		villeRepo.save(oujda);
	}
	
	@Test
	public void saveVilleList() {
		Ville tanger = new Ville("2","Tanger", 1000000, "Nord");
		Ville rabat = new Ville("3","Rabat", 1500000, "Ouest");
		Ville agadir = new Ville("4","Agadir", 1200000, "Sud");
		List<Ville> villes = new ArrayList<>();
		villes.add(tanger);villes.add(rabat);villes.add(agadir);
		
		villeRepo.saveAll(villes);
	}
}
