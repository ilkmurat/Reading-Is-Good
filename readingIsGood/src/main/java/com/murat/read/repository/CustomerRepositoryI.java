package com.murat.read.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.murat.read.model.Customer;


public interface CustomerRepositoryI extends MongoRepository<Customer, String>{

}
