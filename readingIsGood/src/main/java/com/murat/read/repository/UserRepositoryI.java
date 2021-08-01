package com.murat.read.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.murat.read.model.User;


public interface UserRepositoryI extends MongoRepository<User, String> {

	Optional<User> findByUsername(String userName);

	Boolean existsByUsername(String userName);

	Boolean existsByEmail(String email);

}
