package com.bouzga;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bouzga.entity.Customer;
import com.bouzga.entity.Pays;
import com.bouzga.entity.Ville;
import com.bouzga.repository.CustomerRepository;
import com.bouzga.repository.PaysRepository;

@SpringBootApplication
public class TestMongoDbApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository repository;
	
	@Autowired
	private PaysRepository paysRepository;

	public static void main(String[] args) {
		SpringApplication.run(TestMongoDbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		repository.deleteAll();
		
		//testCustomer();
		testPays();
	}

	private void testCustomer() {
		// save a couple of customers
		repository.save(new Customer("Alice", "Smith"));
		repository.save(new Customer("Bob", "Smith"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : repository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByFirstName("Alice"));

		System.out.println("Customers found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (Customer customer : repository.findByLastName("Smith")) {
			System.out.println(customer);
		}
	}
	

	private void testPays(){
		paysRepository.deleteAll();
		Ville oujda = new Ville("1","Oujda", 500000, "Est");
		Ville tanger = new Ville("2","Tanger", 1000000, "Nord");
		Ville rabat = new Ville("3","Rabat", 1500000, "Ouest");
		Ville agadir = new Ville("4","Agadir", 1200000, "Sud");
		List<Ville> villes = new ArrayList<>();
		villes.add(oujda);villes.add(tanger);villes.add(rabat);villes.add(agadir);
		
		Pays maroc = new Pays("1", "Maroc", villes);
		Pays paysSaved = paysRepository.save(maroc);
		System.out.println(paysSaved);
	}
}
