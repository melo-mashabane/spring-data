package com.example.boot;

import com.example.Application;
import com.example.model.Product;
import com.example.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class DataLoader implements CommandLineRunner {

    private ProductRepository productRepository;

    private Logger LOG = LoggerFactory.getLogger(Application.class);


    @Autowired
    public void productRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Product product1 = new Product();

        product1.setName("Tester Product");
        product1.setDescription("This is a tester product");
        product1.setCategory("TEST");
        product1.setType("General");
        product1.setPrice(0.0);

        Product product2 = new Product();
        product2.setName("Another Tester Product");
        product2.setDescription("This is a tester product");
        product2.setCategory("TEST");
        product2.setType("CUSTOM");
        product2.setPrice(15.0);

        productRepository.save(product1);
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