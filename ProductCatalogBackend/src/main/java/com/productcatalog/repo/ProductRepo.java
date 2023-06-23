package com.productcatalog.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productcatalog.entities.Product;

public interface ProductRepo extends JpaRepository<Product, String> {

	public List<Product> findByCode(String code);
	public List<Product> findByName(String name);
	public List<Product> findByBrand(String brand);
	public List<Product> findByPriceLessThanEqual(double price);
	
	
}
