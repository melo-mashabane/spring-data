package com.example.repository.repository;

import com.example.repository.repository.model.Product;
import com.example.repository.repository.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@SpringBootApplication
public class RepositoryApplication implements CommandLineRunner{

	private ProductRepository productRepository;

	private Logger LOG = LoggerFactory.getLogger(RepositoryApplication.class);


	@Autowired
	public void productRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(RepositoryApplication.class, args);
	}


	@Override
	public void run(String... strings) throws Exception {

		Product product1 = new Product();

		product1.setName("Tester Product");
		product1.setDescription("This is a tester product");
		product1.setCategory("TEST");
		product1.setType("General");
		product1.setPrice(0.0);

		productRepository.save(product1);

		Product product2 = new Product();
		product2.setName("Another Tester Product");
		product2.setDescription("This is a tester product");
		product2.setCategory("TEST");
		product2.setType("CUSTOM");
		product2.setPrice(15.0);

		productRepository.save(product2);



		/*

		// Delete product3 from H2
		productRepository.delete(product2);


		// Find products
		List<Product> products = productRepository.findAll();

		for (Product product : products) {
			LOG.info("Products found: " + product.toString());
		}

		List<Product> results = productRepository.findByDescriptionAndCategory("This is a tester product", "TEST");

		for (Product product : results) {
			LOG.info("Matching results are:" + product.toString());
		}

		*/


	}
}
