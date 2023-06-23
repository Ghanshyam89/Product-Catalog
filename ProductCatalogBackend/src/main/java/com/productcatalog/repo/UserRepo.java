package com.productcatalog.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productcatalog.entities.User;

public interface UserRepo extends JpaRepository<User, String> {

}
