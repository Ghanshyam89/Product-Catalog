package com.productcatalog.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	@Id
	@Column(name = "code")
	String code;
	@Column(name = "name")
	String name;
	@Column(name = "brand")
	String brand;
	@Column(name = "price")
	double price;
	@Column(name = "image")
	String product_img;
	@Column(name = "description", length = 500)
	String product_desc;

	public Product() {
		super();
	}

	public Product(String product_code, String name, String brand, double price, String product_img,
			String product_desc) {
		super();
		this.code = product_code;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.product_img = product_img;
		this.product_desc = product_desc;
	}

	public String getProduct_code() {
		return code;
	}

	public void setProduct_code(String product_code) {
		this.code = product_code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getProduct_img() {
		return product_img;
	}

	public void setProduct_img(String product_img) {
		this.product_img = product_img;
	}

	public String getProduct_desc() {
		return product_desc;
	}

	public void setProduct_desc(String product_desc) {
		this.product_desc = product_desc;
	}

	@Override
	public String toString() {
		return "Product [product_code=" + code + ", name=" + name + ", brand=" + brand + ", price=" + price
				+ ", product_img=" + product_img + ", product_desc=" + product_desc + "]";
	}

}
