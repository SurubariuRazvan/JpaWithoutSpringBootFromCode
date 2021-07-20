package org.example;

import org.example.config.PersistenceJPAConfig;
import org.example.model.Product;
import org.example.service.ProductService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class SpringDataJPAMain {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(PersistenceJPAConfig.class);
		ProductService productService = appContext.getBean(ProductService.class);
		
		productService.add(new Product(1, "Television"));
		productService.add(new Product(2, "Phone"));
		productService.addAll(Arrays.asList(
				new Product(3, "Peach"),
				new Product(4, "Strawberry"),
				new Product(5, "Melone"),
				new Product(6, "Onion")
		));
		
		System.out.println("findAll=" + productService.findAll());
		System.out.println("findByName is 'Peach': " + productService.findByNameIs("Peach"));
		System.out.println("findByNameContainingIgnoreCase 'on': " + productService.findByNameContainingIgnoreCase("on"));
	}
}
