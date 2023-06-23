package com.productcatalog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.productcatalog.entities.Product;
import com.productcatalog.repo.ProductRepo;

@RestController
@CrossOrigin
public class ProductController {

	@Autowired
	private ProductRepo repo;

	// method to get all the products.
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getProducts() {
		List<Product> products = repo.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(products);
	}
	
	@GetMapping("/products/code/{code}")
	public ResponseEntity<List<Product>> getProductsByCode(@PathVariable("code") String code) {
		List<Product> products = repo.findByCode(code);
		if (!products.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body(products);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

	@GetMapping("/products/name/{name}")
	public ResponseEntity<List<Product>> getProductsByName(@PathVariable("name") String name) {
		List<Product> products = repo.findByName(name);
		if (!products.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body(products);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

	@GetMapping("/products/brand/{brand}")
	public ResponseEntity<List<Product>> getProductsByBrand(@PathVariable("brand") String brand) {
		List<Product> products = repo.findByBrand(brand);
		if (!products.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body(products);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

	@GetMapping("/products/price/{price}")
	public ResponseEntity<List<Product>> getProductsByPrice(@PathVariable("price") double price) {
		List<Product> products = repo.findByPriceLessThanEqual(price);
		if (!products.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body(products);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

}
