package org.sid.inventoryservice;

import org.sid.inventoryservice.entities.Product;
import org.sid.inventoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ProductRepository productRepository){
			return args -> {
				productRepository.save(new Product(null, "Lenovo L13", 7500));
				productRepository.save(new Product(null, "Samsung S22", 9000));
				productRepository.save(new Product(null, "Keyboard", 1200));
				productRepository.findAll().forEach(product -> {
					System.out.println(product.getName());
					System.out.println(product.getPrice());
				});
			};
	};
}