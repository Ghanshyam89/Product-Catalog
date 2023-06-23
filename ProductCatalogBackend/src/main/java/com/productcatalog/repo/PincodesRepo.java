package com.productcatalog.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productcatalog.entities.Pincodes;

public interface PincodesRepo extends JpaRepository<Pincodes, Integer> {
	List<Pincodes> findByProcodeAndPincode(String procode, int pincode);
}
