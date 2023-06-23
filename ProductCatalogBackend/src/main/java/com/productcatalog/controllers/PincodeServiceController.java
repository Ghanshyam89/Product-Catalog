package com.productcatalog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.productcatalog.entities.Pincodes;
import com.productcatalog.repo.PincodesRepo;

@RestController
@CrossOrigin
public class PincodeServiceController {
	
	@Autowired
	private PincodesRepo repo;
	
	@GetMapping("/serviceability/{procode}/{pincode}")
	public ResponseEntity<List<Pincodes>> getServiceability(@PathVariable("procode") String procode,
			@PathVariable("pincode") int pincode) {
		List<Pincodes> serviceability = repo.findByProcodeAndPincode(procode, pincode);
		if (!serviceability.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body(serviceability);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
}
